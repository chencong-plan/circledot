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
 * @date: 2019/12/19 17:35
 */

@Data
@TableName(value = "t_article")
public class Article implements Serializable {

    /**
     * 主键,使用ASSIGN_ID 自定义主键生成策略
     */
    @TableId(value = "article_id", type = IdType.ASSIGN_ID)
    private Long articleId;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "category_id")
    private Long categoryId;

    @TableField(value = "title")
    private String title;

    @TableField(value = "content")
    private String content;

    @TableField(value = "status")
    private String status;

    @TableField(value = "view_count")
    private Integer viewCount;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

}
