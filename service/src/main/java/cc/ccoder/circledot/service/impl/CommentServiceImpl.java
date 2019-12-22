package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.dal.entity.Comment;
import cc.ccoder.circledot.core.dal.mapper.CommentMapper;
import cc.ccoder.circledot.service.ICommentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 11:56
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Override
    public List<Comment> selectCommentByUserId(long userId) {
        return list(new LambdaQueryWrapper<Comment>().eq(Comment::getFromUserId, userId));
    }

    @Override
    public List<Comment> selectCommentByArticleId(long articleId) {
        return list(new LambdaQueryWrapper<Comment>().eq(Comment::getArticleId, articleId));
    }

    @Override
    public int countByArticleId(long articleId) {
        return count(new LambdaQueryWrapper<Comment>()
                .eq(Comment::getArticleId, articleId));
    }
}
