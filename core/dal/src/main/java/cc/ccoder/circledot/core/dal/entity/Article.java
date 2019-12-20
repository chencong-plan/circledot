package cc.ccoder.circledot.core.dal.entity;

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

    @TableId(value = "article_id")
    private Long articleId;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "category_id")
    private Long categoryId;

    @TableField(value = "title")
    private String title;

    @TableField(value = "content")
    private String content;

    @TableField(value = "source_content")
    private String sourceContent;

    @TableField(value = "menu")
    private String menu;

    @TableField(value = "status")
    private String status;

    @TableField(value = "view_count")
    private Integer viewCount;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

}
