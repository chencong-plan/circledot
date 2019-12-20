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
 * @date: 2019/12/20 15:09
 */
@Data
@TableName(value = "t_tag")
public class Tag implements Serializable {

    @TableId(value = "tag_id",type = IdType.ASSIGN_ID)
    private Long tagId;

    @TableField(value = "category_id")
    private Long categoryId;

    @TableField(value = "tag_name")
    private String tagName;

    @TableField(value = "article_count")
    private Integer articleCount;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

}
