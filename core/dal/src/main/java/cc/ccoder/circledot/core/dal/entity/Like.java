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
 * @date: 2019/12/20 14:55
 */
@Data
@TableName(value = "t_like")
public class Like implements Serializable {

    @TableId(value = "like_id", type = IdType.ASSIGN_ID)
    private Long likeId;

    @TableField(value = "like_type")
    private String likeType;

    @TableField(value = "source_id")
    private Long sourceId;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "status")
    private String status;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

}
