package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author: chencong
 * @date: 2019/12/19 17:46
 */
@Controller
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;


}
