package cc.ccoder.circledot.service;

import cc.ccoder.circledot.core.common.enums.LikeType;
import cc.ccoder.circledot.core.dal.entity.Like;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 11:58
 */
public interface ILikeService extends IService<Like> {


    List<Like> selectLikeByUserId(long userId);

    int countBySourceId(long sourceId, LikeType likeType);
}
