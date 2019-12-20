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
 * @date: 2019/12/20 15:12
 */
@Data
@TableName(value = "t_user")
public class User implements Serializable {

    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Long userId;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "salt")
    private String salt;

    @TableField(value = "sign")
    private String sign;

    @TableField(value = "avatar")
    private String avatar;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;
}
