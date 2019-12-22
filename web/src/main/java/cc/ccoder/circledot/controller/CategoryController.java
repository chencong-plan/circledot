package cc.ccoder.circledot.controller;

import cc.ccoder.circledot.core.common.response.ServerResponse;
import cc.ccoder.circledot.core.dal.entity.Category;
import cc.ccoder.circledot.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 17:10
 */
@RestController
@RequestMapping("/category")
@Api(value = "分类接口(/category)", tags = {"category"})
public class CategoryController extends AbstractController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/list")
    @ApiOperation(value = "分类列表")
    public ServerResponse listCategory() {
        List<Category> categoryList = categoryService.list();
        return ServerResponse.success(categoryList);
    }
}
