package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.core.dal.entity.Article;
import cc.ccoder.circledot.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object list() {
        List<Article> list = iArticleService.list();
        return list;
    }


}
