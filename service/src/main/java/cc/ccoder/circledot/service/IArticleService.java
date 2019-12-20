package cc.ccoder.circledot.service;

import cc.ccoder.circledot.core.dal.entity.Article;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/19 17:47
 */
public interface IArticleService {

    /**
     * list
     *
     * @return list
     */
    List<Article> list();

}
