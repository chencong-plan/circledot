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
 * @date: 2019/12/20 14:38
 */
@Data
@TableName(value = "t_comment")
public class Comment implements Serializable {

    @TableId(value = "comment_id",type = IdType.ASSIGN_ID)
    private Long commentId;

    @TableField(value = "article_id")
    private Long articleId;

    @TableField(value = "content")
    private String content;

    @TableField(value = "from_user_id")
    private Long fromUserId;

    @TableField(value = "status")
    private String status;

    @TableField(value = "anonymous_status")
    private String anonymousStatus;

    @TableField(value = "email")
    private String email;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

}
