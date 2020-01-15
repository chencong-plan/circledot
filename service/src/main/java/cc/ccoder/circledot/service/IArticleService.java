package cc.ccoder.circledot.service;

import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.dal.entity.Article;
import cc.ccoder.circledot.core.dal.entity.Comment;
import cc.ccoder.circledot.service.request.ArticleRequest;
import cc.ccoder.circledot.service.vo.ArticleCommentVo;
import cc.ccoder.circledot.service.vo.ArticleVo;
import cc.ccoder.circledot.service.vo.TagVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/19 17:47
 */
public interface IArticleService  extends IService<Article> {

    /**
     * list
     *
     * @return list
     */
    List<Article> listArticle();

    List<Article> selectArticleByUserId(long userId);

    Page<Article> selectByPage(Long userId, String orderBy, Page<Article> page,String order);

    ServerResponse articleDetail(Long articleId);

    List<TagVo> articleTagList(Long articleId);

    ServerResponse listCommentVo(Long articleId,Page<Comment> page);

    ServerResponse listCommentReply(Long commentId);


    ServerResponse selectArticle(Long userId, String orderBy, Page<Article> page, String order);

    ServerResponse pushArticle(ArticleRequest request);
}
