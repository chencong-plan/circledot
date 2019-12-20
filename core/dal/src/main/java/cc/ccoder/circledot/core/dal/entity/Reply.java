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
 * @date: 2019/12/20 15:03
 */
@Data
@TableName(value = "t_reply")
public class Reply implements Serializable {

    @TableId(value = "reply_id",type = IdType.ASSIGN_ID)
    private Long replyId;

    @TableField(value = "comment_id")
    private Long commentId;

    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "reply_type")
    private String replyType;

    @TableField(value = "content")
    private String content;

    @TableField(value = "status")
    private String status;

    @TableField(value = "from_user_id")
    private Long fromUserId;

    @TableField(value = "target_user_id")
    private Long targetUserId;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

}
