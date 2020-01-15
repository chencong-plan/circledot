package cc.ccoder.circledot.service.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p></p>
 *
 * @author chencong
 * @email cong.chen@topay.ae
 * @date LoginRequest.java v1.0  2020/1/15 16:56
 */
@Data
@ApiModel
public class LoginRequest {

    @ApiModelProperty(value = "type",name = "登录方式 email/username")
    private String identityType;

    @ApiModelProperty(value = "name",name = "标志 用户名/邮箱")
    private String identifier;

    @ApiModelProperty(value = "credential" ,name = "凭据 密码等")
    private String credential;
}
