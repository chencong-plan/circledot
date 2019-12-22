package cc.ccoder.circledot.core.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: chencong
 * @date: 2019/12/20 14:34
 */
@Data
@TableName(value = "t_article_tag")
public class ArticleTag implements Serializable {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @TableField(value = "article_id")
    private Long articleId;

    @TableField(value = "tag_id")
    private Long tagId;

    @TableField(value = "tag_name")
    private String tagName;

}
