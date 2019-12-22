package cc.ccoder.circledot.service.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chencong
 * @date: 2019/12/22 17:30
 */
@Data
public class ArticleCommentVo implements Serializable {

    private Long commentId;

    private Long articleId;

    private String content;

    //TODO 目前这一版本评论
    private String email;

    private Date gmtCreate;

}
