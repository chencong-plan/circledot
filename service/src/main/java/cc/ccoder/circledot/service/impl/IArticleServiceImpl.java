package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.dal.entity.Article;
import cc.ccoder.circledot.core.dal.mapper.ArticleMapper;
import cc.ccoder.circledot.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/19 17:47
 */
@Service
public class IArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements IArticleService {

    @Override
    public List<Article> listArticle() {
        return list();
    }
}
