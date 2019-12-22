package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.common.enums.LikeType;
import cc.ccoder.circledot.core.dal.entity.Like;
import cc.ccoder.circledot.core.dal.mapper.LikeMapper;
import cc.ccoder.circledot.service.ILikeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 11:59
 */
@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements ILikeService {


    @Override
    public List<Like> selectLikeByUserId(long userId) {
        return list(new LambdaQueryWrapper<Like>().eq(Like::getUserId, userId));
    }

    @Override
    public int countBySourceId(long sourceId, LikeType likeType) {
        return count(new LambdaQueryWrapper<Like>().eq(Like::getSourceId, sourceId)
                .eq(Like::getLikeType, likeType.getCode()));
    }

}
