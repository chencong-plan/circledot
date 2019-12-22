package cc.ccoder.circledot.service;

import cc.ccoder.circledot.core.dal.entity.ArticleTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 16:02
 */
public interface IArticleTagService extends IService<ArticleTag> {

    List<ArticleTag> selectByArticleId(Long articleId);
}
