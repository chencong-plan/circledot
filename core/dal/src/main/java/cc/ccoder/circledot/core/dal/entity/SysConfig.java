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
 * @date: 2019/12/20 15:07
 */
@Data
@TableName(value = "t_sys_config")
public class SysConfig implements Serializable {

    @TableId(value = "config_id", type = IdType.ASSIGN_ID)
    private Long configId;

    @TableField(value = "param_key")
    private String paramKey;

    @TableField(value = "param_value")
    private String paramValue;

    @TableField(value = "memo")
    private String memo;

    @TableField(value = "status")
    private String status;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

}
