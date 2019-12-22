package cc.ccoder.circledot.service.vo;

import cc.ccoder.circledot.core.dal.entity.Comment;
import cc.ccoder.circledot.core.dal.entity.Tag;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/22 15:35
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleDetailVo implements Serializable {

    private Long articleId;

    private Long userId;

    private UserInfoVo user;

    private Long categoryId;

    private String categoryName;

    private String title;

    private String content;

    private String status;

    private String statusMsg;

    private Integer viewCount;

    private Integer likeCount;

    private Integer commentCount;

    private List<TagVo> tagList;

    private Date gmtCreate;
}
