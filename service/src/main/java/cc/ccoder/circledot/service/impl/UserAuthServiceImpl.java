package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.common.util.StringUtils;
import cc.ccoder.circledot.core.dal.entity.UserAuth;
import cc.ccoder.circledot.core.dal.mapper.UserAuthMapper;
import cc.ccoder.circledot.service.IUserAuthService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 12:05
 */
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthMapper, UserAuth> implements IUserAuthService {
    @Override
    public List<UserAuth> selectByUserId(long userId) {
        return list(new LambdaQueryWrapper<UserAuth>().eq(UserAuth::getUserId, userId));
    }

    @Override
    public List<UserAuth> listByIdentifier(String identifier) {
        LambdaQueryWrapper<UserAuth> wrapper = new LambdaQueryWrapper<UserAuth>()
                .eq(StringUtils.isNotBlank(identifier), UserAuth::getIdentifier, identifier);
        return this.list(wrapper);
    }
}
