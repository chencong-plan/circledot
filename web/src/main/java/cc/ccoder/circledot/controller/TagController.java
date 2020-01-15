package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.common.util.StringUtils;
import cc.ccoder.circledot.core.dal.entity.Tag;
import cc.ccoder.circledot.service.ITagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 16:37
 */
@RestController
@RequestMapping(value = "/tag")
@Api(value = "标签接口(/tag)", tags = {"tag"})
public class TagController extends AbstractController {

    @Autowired
    private ITagService tagService;


    @RequestMapping(value = "/list")
    @ApiOperation(value = "查询标签列表", httpMethod = "GET")
    public ServerResponse listTag(@RequestParam(required = false) String name) {
        List<Tag> tagList = tagService.list(new QueryWrapper<Tag>().like(StringUtils.isNotBlank(name),"tag_name", name));
        return ServerResponse.success(tagList);
    }

    @RequestMapping(value = "/push")
    @ApiOperation(value = "新增标签", httpMethod = "POST")
    public ServerResponse pushTag(@RequestParam String name) {
        return tagService.pushTag(name);
    }
}
