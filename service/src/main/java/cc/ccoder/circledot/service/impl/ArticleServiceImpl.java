package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.common.enums.CommonStatus;
import cc.ccoder.circledot.core.common.enums.LikeType;
import cc.ccoder.circledot.core.common.enums.OrderByType;
import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.common.util.DateUtil;
import cc.ccoder.circledot.core.common.util.StringUtils;
import cc.ccoder.circledot.core.dal.config.IdGenerator;
import cc.ccoder.circledot.core.dal.entity.*;
import cc.ccoder.circledot.core.dal.mapper.ArticleMapper;
import cc.ccoder.circledot.core.sequence.IdKey;
import cc.ccoder.circledot.service.*;
import cc.ccoder.circledot.service.converter.TagConverter;
import cc.ccoder.circledot.service.request.ArticleRequest;
import cc.ccoder.circledot.service.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: chencong
 * @date: 2019/12/19 17:47
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private IUserService userService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private ILikeService likeService;

    @Autowired
    private IArticleTagService articleTagService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IReplyService replyService;

    @Autowired
    private ITagService tagService;

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public List<Article> listArticle() {
        return list();
    }

    @Override
    public List<Article> selectArticleByUserId(long userId) {
        return this.list(new LambdaQueryWrapper<Article>().eq(Article::getUserId, userId));
    }

    @Override
    public Page<Article> selectByPage(Long userId, String orderBy, Page<Article> page, String order) {
        if (OrderByType.TIME.getCode().equals(orderBy)) {
            if (OrderByType.ORDER.asc.equals(order)) {
                page.setOrders(Collections.singletonList(OrderItem.asc("gmt_create")));
            }
            if (OrderByType.ORDER.desc.equals(order)) {
                page.setOrders(Collections.singletonList(OrderItem.desc("gmt_create")));
            }
        }
        if (OrderByType.VIEW.getCode().equals(orderBy)) {
            if (OrderByType.ORDER.asc.equals(order)) {
                page.setOrders(Collections.singletonList(OrderItem.asc("view_count")));
            }
            if (OrderByType.ORDER.desc.equals(order)) {
                page.setOrders(Collections.singletonList(OrderItem.desc("view_count")));
            }
        }
        return this.page(page, new LambdaQueryWrapper<Article>()
                .eq(!StringUtils.isNullOrEmpty(userId), Article::getUserId, userId));
    }

    @Override
    public ServerResponse articleDetail(Long articleId) {
        Article article = this.getById(articleId);
        if (article == null) {
            return ServerResponse.errorValidate("该编号文章不存在");
        }
        ServerResponse userResponse = userService.getUserInfo(article.getUserId());
        UserInfoVo userInfoVo = new UserInfoVo();
        if (userResponse.isSuccess() && userResponse.dataNotNull()) {
            userInfoVo = (UserInfoVo) userResponse.getData();
        }
        Category category = categoryService.getById(article.getCategoryId());
        List<ArticleTag> articleTagList = articleTagService.selectByArticleId(articleId);
        ArticleDetailVo articleDetailVo = new ArticleDetailVo();
        BeanUtils.copyProperties(article, articleDetailVo);
        articleDetailVo.setUser(userInfoVo);
        articleDetailVo.setCommentCount(commentService.countByArticleId(articleId));
        articleDetailVo.setLikeCount(likeService.countBySourceId(articleId, LikeType.ARTICLE));
        if (category != null) {
            articleDetailVo.setCategoryName(category.getName());
        }
        articleDetailVo.setTagList(TagConverter.converterTagVo(articleTagList));

        return ServerResponse.success(articleDetailVo);
    }

    @Override
    public List<TagVo> articleTagList(Long articleId) {
        List<ArticleTag> articleTagList = articleTagService.selectByArticleId(articleId);
        return TagConverter.converterTagVo(articleTagList);
    }

    @Override
    public ServerResponse listCommentVo(Long articleId, Page<Comment> page) {
        Article article = this.getById(articleId);
        if (article == null) {
            return ServerResponse.errorValidate("该文章标号对应文章不存在");
        }
        Page<Comment> commentPage = commentService.page(page, new LambdaQueryWrapper<Comment>().eq(Comment::getArticleId, articleId));
        List<ArticleCommentVo> commentVoList = new ArrayList<>();
        commentPage.getRecords().forEach(x -> {
            ArticleCommentVo vo = new ArticleCommentVo();
            BeanUtils.copyProperties(x, vo);
            commentVoList.add(vo);
        });
        Page<ArticleCommentVo> articleCommentVoPage = new Page<>();
        BeanUtils.copyProperties(commentPage, articleCommentVoPage);
        articleCommentVoPage.setRecords(commentVoList);
        return ServerResponse.success(articleCommentVoPage);
    }

    @Override
    public ServerResponse listCommentReply(Long commentId) {
        List<Reply> replyList = replyService.list();
        if (replyList.isEmpty()) {
            return ServerResponse.success("该评论暂无回复");
        }
        List<ReplyVo> replyVoList = new ArrayList<>();
        replyList.forEach(x -> {
            ReplyVo vo = new ReplyVo();
            BeanUtils.copyProperties(x, vo);
            replyVoList.add(vo);
        });
        return ServerResponse.success(replyVoList);
    }


    private List<ArticleVo> handleArticleVo(Page<Article> articlePage) {
        List<Article> articleList = articlePage.getRecords();
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article x : articleList) {
            ArticleVo articleVo = new ArticleVo();
            articleVo.setArticleId(x.getArticleId());
            articleVo.setUserId(x.getUserId());
            User user = userService.getById(x.getUserId());
            articleVo.setNickname(user == null ? "" : user.getNickname());
            articleVo.setCategoryId(x.getCategoryId());
            Category category = categoryService.getById(x.getCategoryId());
            articleVo.setCategoryName(category == null ? "" : category.getName());
            articleVo.setTitle(x.getTitle());
            List<ArticleTag> articleTagList = articleTagService.selectByArticleId(x.getArticleId());
            Map<Long, String> tags = articleTagList.stream().collect(Collectors.toMap(ArticleTag::getTagId, ArticleTag::getTagName));
            articleVo.setTags(tags);
            int likeCount = likeService.countBySourceId(x.getArticleId(), LikeType.ARTICLE);
            int commentCount = commentService.countByArticleId(x.getArticleId());
            articleVo.setLike(likeCount);
            articleVo.setComment(commentCount);
            articleVoList.add(articleVo);
        }
        return articleVoList;
    }

    @Override
    public ServerResponse selectArticle(Long userId, String orderBy, Page<Article> page, String order) {
        Page<Article> articlePage = this.selectByPage(userId, orderBy, page, order);
        List<ArticleVo> articleVoList = this.handleArticleVo(articlePage);
        Page<ArticleVo> articleVoPage = new Page<>();
        BeanUtils.copyProperties(articlePage, articleVoList);
        articleVoPage.setRecords(articleVoList);
        articleVoPage.setTotal(articlePage.getTotal());
        articleVoPage.setSize(articlePage.getSize());
        articleVoPage.setCurrent(articlePage.getCurrent());
        articleVoPage.setOrders(articlePage.getOrders());
        articleVoPage.setSearchCount(articlePage.isSearchCount());
        articleVoPage.setPages(articlePage.getPages());
        return ServerResponse.success(articleVoPage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerResponse pushArticle(ArticleRequest request) {
        Long articleId = idGenerator.get(IdKey.SEQ_ID);
        List<Tag> tags = tagService.listByIds(request.getTags());
        //组装articleTag
        List<ArticleTag> articleTagList = new ArrayList<>();
        tags.forEach(x -> {
            ArticleTag articleTag = new ArticleTag();
            articleTag.setArticleId(articleId);
            articleTag.setTagId(x.getTagId());
            articleTag.setTagName(x.getTagName());
            articleTagList.add(articleTag);
        });
        articleTagService.saveBatch(articleTagList);

        //更新tag中文章数
        tags.forEach(x -> tagService.update(new UpdateWrapper<Tag>().setSql("article_count = article_count + 1").eq("tag_id", x.getTagId())));

        //组装Article
        Article article = handleArticle(request);
        article.setArticleId(articleId);
        this.save(article);

        //组装Like
        Like like = new Like();
        like.setLikeType(LikeType.ARTICLE.getCode());
        like.setSourceId(articleId);
        like.setUserId(request.getUserId());
        like.setStatus(CommonStatus.YES.getCode());
        like.setGmtCreate(DateUtil.getCurrentTS());
        likeService.save(like);
        //返回结果
        Map<String, Long> map = new HashMap<>();
        map.put("id", articleId);
        return ServerResponse.success(map);
    }

    private Article handleArticle(ArticleRequest request) {
        Article article = new Article();
        article.setUserId(request.getUserId());
        article.setCategoryId(request.getCategoryId());
        article.setTitle(request.getTitle());
        article.setContent(request.getContext());
        article.setStatus(CommonStatus.YES.getCode());
        article.setViewCount(0);
        article.setViewCount(0);
        article.setGmtCreate(DateUtil.getCurrentTS());
        article.setGmtModified(DateUtil.getCurrentTS());
        return article;
    }


}
