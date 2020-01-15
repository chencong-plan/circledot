package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.common.response.ResponseCode;
import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.common.util.DateUtil;
import cc.ccoder.circledot.core.dal.config.IdGenerator;
import cc.ccoder.circledot.core.dal.entity.Tag;
import cc.ccoder.circledot.core.dal.mapper.TagMapper;
import cc.ccoder.circledot.core.sequence.IdKey;
import cc.ccoder.circledot.service.ITagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 16:39
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public ServerResponse pushTag(String name) {
        List<Tag> tagList = this.list(new QueryWrapper<Tag>().eq("tag_name", name));
        if (!tagList.isEmpty()) {
            return ServerResponse.success(tagList.get(0));
        }
        Tag tag = new Tag();
        Long tagId = idGenerator.get(IdKey.SEQ_ID);
        tag.setTagId(tagId);
        tag.setTagName(name);
        tag.setArticleCount(0);
        tag.setGmtCreate(DateUtil.getCurrentTS());
        boolean save = this.save(tag);
        return save ? ServerResponse.success(tag) : ServerResponse.error(ResponseCode.HTTP_METHOD_NOT_SUPPORT, "添加失败");
    }
}
