package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.dal.entity.ArticleTag;
import cc.ccoder.circledot.core.dal.mapper.ArticleTagMapper;
import cc.ccoder.circledot.service.IArticleTagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 16:02
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements IArticleTagService {

    @Override
    public List<ArticleTag> selectByArticleId(Long articleId) {
        return list(new LambdaQueryWrapper<ArticleTag>().eq(ArticleTag::getArticleId, articleId));
    }
}
