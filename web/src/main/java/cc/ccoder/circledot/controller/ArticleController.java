package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.core.common.enums.OrderByType;
import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.dal.entity.Article;
import cc.ccoder.circledot.service.IArticleService;
import cc.ccoder.circledot.service.request.ArticleRequest;
import cc.ccoder.circledot.service.vo.TagVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author: chencong
 * @date: 2019/12/19 17:46
 */
@RestController
@RequestMapping(value = "/article")
@Api(value = "文章接口(/article)", tags = {"article"})
public class ArticleController extends AbstractController {

    @Autowired
    private IArticleService articleService;


    @RequestMapping(value = "/list")
    @ApiOperation(value = "分页查询文章列表", httpMethod = "GET")
    public ServerResponse list(@ApiParam(value = "用户ID") @RequestParam(required = false) Long userId,
                               @ApiParam(value = "排序字段", allowableValues = "time,view", defaultValue = "time") @RequestParam(required = false, defaultValue = "time") String orderBy,
                               @ApiParam(value = "排序规则", allowableValues = "desc,asc", defaultValue = "asc") @RequestParam(required = false, defaultValue = "asc") String order,
                               @ApiParam(value = "当前页", allowableValues = "[1, infinity]") @RequestParam(required = false, defaultValue = "1") int pageNo,
                               @ApiParam(value = "每页大小", allowableValues = "[1, infinity]") @RequestParam(required = false, defaultValue = "10") int pageSize) {
        if (!OrderByType.checkIn(orderBy)) {
            return ServerResponse.errorValidate("暂不支持该排序字段:" + orderBy);
        }
        Page<Article> page = new Page<>(pageNo, pageSize);
        return articleService.selectArticle(userId, orderBy, page, order);
    }

    @RequestMapping(value = "/detail")
    @ApiOperation(value = "查询文章详情", httpMethod = "GET")
    public ServerResponse articleDetail(@ApiParam(value = "文章编号", required = true) @RequestParam Long articleId) {
        return articleService.articleDetail(articleId);
    }

    @RequestMapping(value = "/tag/list")
    @ApiOperation(value = "查询文章标签列表", httpMethod = "GET")
    public ServerResponse<List<TagVo>> articleTagList(@ApiParam(value = "文章编号", required = true) @RequestParam Long articleId) {
        List<TagVo> tagVoList = articleService.articleTagList(articleId);
        return ServerResponse.success(tagVoList);
    }

    @RequestMapping("/push")
    @ApiOperation(value = "发布文章", httpMethod = "POST")
    public ServerResponse pushArticle(@RequestBody ArticleRequest request) {
        return articleService.pushArticle(request);
    }


}
