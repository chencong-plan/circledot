package cc.ccoder.circledot.core.dal.entity;

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

    private Long articleId;

    private Long userId;

    private Long categoryId;

    private String title;

    private String content;

    private String sourceContent;

    private String menu;

    private String status;

    private Integer viewCount;

    private Date gmtCreate;

    private Date gmtModified;

}
