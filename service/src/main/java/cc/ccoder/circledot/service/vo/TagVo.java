package cc.ccoder.circledot.service.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author: chencong
 * @date: 2019/12/22 16:07
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagVo {

    private Long tagId;

    private String tagName;

    private Integer articleCount;
}
