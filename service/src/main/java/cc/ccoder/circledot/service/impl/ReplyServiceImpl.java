package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.dal.entity.Reply;
import cc.ccoder.circledot.core.dal.mapper.ReplyMapper;
import cc.ccoder.circledot.service.IReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: chencong
 * @date: 2019/12/22 18:00
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements IReplyService {
}
