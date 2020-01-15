package cc.ccoder.circledot.service.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author: chencong
 * @date: 2019/12/22 11:29
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoVo implements Serializable {

    private Long userId;

    private Map<String, String> identity;

    private String nickname;

    private String avatar;

    private Date gmtCreate;

    private String sign;

    private Integer viewCount;

    private Integer likeCount;

    private Integer articleCount;

}
