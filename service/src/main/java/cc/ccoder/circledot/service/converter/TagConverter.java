package cc.ccoder.circledot.service.converter;

import cc.ccoder.circledot.core.dal.entity.ArticleTag;
import cc.ccoder.circledot.service.vo.TagVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 16:08
 */
public class TagConverter {

    public static List<TagVo> converterTagVo(List<ArticleTag> articleTagList) {
        if (articleTagList != null) {
            List<TagVo> tagVoList = new ArrayList<>();
            articleTagList.forEach(x -> {
                TagVo vo = new TagVo();
                vo.setTagId(x.getTagId());
                vo.setTagName(x.getTagName());
                tagVoList.add(vo);
            });
            return tagVoList;
        }
        return null;
    }
}
