package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.common.enums.LikeType;
import cc.ccoder.circledot.core.common.enums.OrderByType;
import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.common.util.StringUtils;
import cc.ccoder.circledot.core.dal.entity.*;
import cc.ccoder.circledot.core.dal.mapper.ArticleMapper;
import cc.ccoder.circledot.service.*;
import cc.ccoder.circledot.service.converter.TagConverter;
import cc.ccoder.circledot.service.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        if(replyList.isEmpty()){
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

}
