package cc.ccoder.circledot.service;

import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.dal.entity.User;
import cc.ccoder.circledot.service.request.LoginRequest;
import cc.ccoder.circledot.service.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author: chencong
 * @date: 2019/12/22 11:32
 */
public interface IUserService extends IService<User> {


    ServerResponse getUserInfo(long id);

    Integer viewCount(long userId);

    Integer likeCount(long userId);

    Integer articleCount(long userId);

    Integer commentCount(long userId);

}
