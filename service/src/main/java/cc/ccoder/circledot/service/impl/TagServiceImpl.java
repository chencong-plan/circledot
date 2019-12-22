package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.dal.entity.Tag;
import cc.ccoder.circledot.core.dal.mapper.TagMapper;
import cc.ccoder.circledot.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: chencong
 * @date: 2019/12/22 16:39
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {
}
