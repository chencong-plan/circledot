package cc.ccoder.circledot.service;

import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.dal.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author: chencong
 * @date: 2019/12/22 16:38
 */
public interface ITagService extends IService<Tag> {

    ServerResponse pushTag(String name);
}
