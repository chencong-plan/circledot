package cc.ccoder.circledot.service.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: chencong
 * @date: 2019/12/22 17:47
 */
@Data
public class ReplyVo implements Serializable {

    private Long replyId;

    private Long commentId;

    private String email;

    private String content;

    private String gmtCreate;

}
