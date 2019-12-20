package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.dal.entity.Article;
import cc.ccoder.circledot.service.IArticleService;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/19 17:46
 */
@Controller
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;


    @RequestMapping("/list")
    @ResponseBody
    @ApiOperation(value = "list查询",httpMethod = "GET")
    public ServerResponse list() {
        Page<Article> page = new Page<>(1,3);
        page.setOrders(Arrays.asList(OrderItem.asc("article_id"),OrderItem.desc("gmt_create")));
        Page<Article> pageResult = iArticleService.page(page);
        return ServerResponse.success(pageResult);
    }


}
