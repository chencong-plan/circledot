package cc.ccoder.circledot.core.dal.repository.impl;

import cc.ccoder.circledot.core.dal.entity.Article;
import cc.ccoder.circledot.core.dal.mapper.ArticleMapper;
import cc.ccoder.circledot.core.dal.repository.IArticleRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: chencong
 * @date: 2019/12/19 17:43
 */
@Service
public class ArticleRepositoryImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleRepository {
}
