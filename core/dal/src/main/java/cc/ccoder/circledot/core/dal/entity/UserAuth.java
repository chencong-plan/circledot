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
 * @date: 2019/12/20 15:14
 */
@Data
@TableName
public class UserAuth implements Serializable {

    @TableId(value = "auth_id", type = IdType.ASSIGN_ID)
    private Long authId;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "open_id")
    private Long openId;

    @TableField(value = "identity_type")
    private String identityType;

    @TableField(value = "identifier")
    private String identifier;

    @TableField(value = "credential")
    private String credential;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

}
