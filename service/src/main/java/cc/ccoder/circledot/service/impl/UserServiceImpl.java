package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.common.consts.Const;
import cc.ccoder.circledot.core.common.enums.IdentityType;
import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.dal.entity.*;
import cc.ccoder.circledot.core.dal.mapper.UserMapper;
import cc.ccoder.circledot.service.*;
import cc.ccoder.circledot.service.request.LoginRequest;
import cc.ccoder.circledot.service.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Collections2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.tools.java.Identifier;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: chencong
 * @date: 2019/12/22 11:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private ILikeService likeService;

    @Autowired
    private IUserAuthService userAuthService;

    @Override
    public ServerResponse getUserInfo(long userId) {
        User user = this.getById(userId);
        if (user == null) {
            return ServerResponse.errorValidate("用户不存在");
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(user, userInfoVo);
        userInfoVo.setViewCount(viewCount(userId));
        userInfoVo.setLikeCount(likeCount(userId));
        userInfoVo.setArticleCount(articleCount(userId));
        List<UserAuth> userAuthList = userAuthService.selectByUserId(userId);
        Map<String, String> identityMap = new HashMap<>();
        userAuthList.forEach(x -> identityMap.put(x.getIdentityType(), x.getIdentifier()));
        userInfoVo.setIdentity(identityMap);
        userInfoVo.setAvatar(Const.DOMAIN_IMAGE+user.getAvatar());
        return ServerResponse.success(userInfoVo);
    }

    @Override
    public Integer viewCount(long userId) {
        List<Article> articleList = articleList(userId);
        return articleList.stream().mapToInt(Article::getViewCount).sum();
    }

    @Override
    public Integer likeCount(long userId) {
        return likeList(userId).size();
    }

    @Override
    public Integer articleCount(long userId) {
        List<Article> articleList = articleList(userId);
        return articleList.size();
    }

    @Override
    public Integer commentCount(long userId) {
        return commentList(userId).size();
    }

    private List<Article> articleList(long userId) {
        return articleService.selectArticleByUserId(userId);
    }

    private List<Comment> commentList(long userId) {
        return commentService.selectCommentByUserId(userId);
    }

    private List<Like> likeList(long userId) {
        return likeService.selectLikeByUserId(userId);
    }

}
