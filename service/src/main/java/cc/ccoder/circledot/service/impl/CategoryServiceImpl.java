package cc.ccoder.circledot.service.impl;

import cc.ccoder.circledot.core.dal.entity.Category;
import cc.ccoder.circledot.core.dal.mapper.CategoryMapper;
import cc.ccoder.circledot.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: chencong
 * @date: 2019/12/22 16:01
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
}
