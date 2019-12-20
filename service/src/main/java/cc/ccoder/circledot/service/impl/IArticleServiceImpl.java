package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.dal.entity.Article;
import cc.ccoder.circledot.core.dal.repository.IArticleRepository;
import cc.ccoder.circledot.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/19 17:47
 */
@Service
public class IArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleRepository iArticleRepository;


    @Override
    public List<Article> list() {
        return iArticleRepository.list();
    }
}
