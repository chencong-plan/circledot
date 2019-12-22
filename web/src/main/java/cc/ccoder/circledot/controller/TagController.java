package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.dal.entity.Tag;
import cc.ccoder.circledot.service.ITagService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 16:37
 */
@RestController
@RequestMapping(value = "/tag")
public class TagController extends AbstractController {

    @Autowired
    private ITagService tagService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "查询标签列表", httpMethod = "GET")
    public ServerResponse listTag() {
        List<Tag> tagList = tagService.list();
        return ServerResponse.success(tagList);
    }
}
