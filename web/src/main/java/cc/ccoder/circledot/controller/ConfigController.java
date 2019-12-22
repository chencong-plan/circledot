package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.core.common.response.ResponseCode;
import cc.ccoder.circledot.core.common.response.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: chencong
 * @date: 2019/12/22 17:17
 */
@RestController
@RequestMapping("/sys/config")
@Api(value = "系统参数(/sys/config)", tags = {"config"})
public class ConfigController extends AbstractController {

    @RequestMapping(value = "/responseCode/list", method = RequestMethod.GET)
    @ApiOperation(value = "查询ResponseCode映射信息")
    public ServerResponse listResponseCode() {
        Map<String, Object> responseCodeMap = ResponseCode.toMap();
        return ServerResponse.success(responseCodeMap);
    }

}
