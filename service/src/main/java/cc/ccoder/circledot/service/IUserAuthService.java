package cc.ccoder.circledot.service;

import cc.ccoder.circledot.core.dal.entity.UserAuth;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 12:04
 */
public interface IUserAuthService extends IService<UserAuth> {

    List<UserAuth> selectByUserId(long userId);
}
