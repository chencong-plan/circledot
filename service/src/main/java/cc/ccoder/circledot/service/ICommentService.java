package cc.ccoder.circledot.service;

import cc.ccoder.circledot.core.dal.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 11:54
 */
public interface ICommentService extends IService<Comment> {

    List<Comment> selectCommentByUserId(long userId);

    List<Comment> selectCommentByArticleId(long articleId);

    int countByArticleId(long articleId);
}
