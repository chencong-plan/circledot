package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.service.IUserService;
import cc.ccoder.circledot.service.request.LoginRequest;
import cc.ccoder.circledot.service.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chencong
 * @date: 2019/12/22 11:26
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口(/user)", tags = {"user"})
public class UserInfoController extends AbstractController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/info")
    @ApiOperation(value = "查询用户信息", httpMethod = "POST")
    public ServerResponse getUserInfo(@RequestParam String userId) {
        long id = Long.parseLong(userId);
        return iUserService.getUserInfo(id);
    }

}
