package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.dal.entity.Comment;
import cc.ccoder.circledot.service.IArticleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author chencong
 * @email cong.chen@topay.ae
 * @date CommentController.java v1.0  2020/1/15 11:12
 */
@RestController
@RequestMapping("/comment/")
@Api(value = "评论接口(/comment)", tags = {"comment"})
public class CommentController extends AbstractController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping(value = "/list")
    @ApiOperation(value = "查询文章评论",httpMethod = "GET")
    public ServerResponse articleComment(@ApiParam(value = "文章编号", required = true) @RequestParam Long articleId,
                                         @ApiParam(value = "当前页", defaultValue = "1") @RequestParam(required = false, defaultValue = "1") int pageNo,
                                         @ApiParam(value = "每页大小", defaultValue = "10") @RequestParam(required = false, defaultValue = "10") int pageSize) {
        Page<Comment> page = new Page<>(pageNo, pageSize);
        return articleService.listCommentVo(articleId, page);
    }

    @RequestMapping(value = "/reply")
    @ApiOperation(value = "查询评论的回复",httpMethod = "GET")
    public ServerResponse commentReply(@ApiParam(value = "评论编号", required = true) @RequestParam Long commentId) {
        return articleService.listCommentReply(commentId);
    }

}
