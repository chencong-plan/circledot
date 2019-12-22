package cc.ccoder.circledot.core.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chencong
 * @date: 2019/12/20 14:35
 */
@Data
@TableName(value = "t_category")
public class Category implements Serializable {

    @TableId(value = "category_id", type = IdType.ASSIGN_ID)
    private Long categoryId;

    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "status")
    private String status;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

}
