package cc.ccoder.circledot.service.vo;

import lombok.Data;

import java.util.Map;

/**
 * <p></p>
 *
 * @author chencong
 * @email cong.chen@topay.ae
 * @date ArticleVo.java v1.0  2020/1/15 11:15
 */
@Data
public class ArticleVo {

    private Long articleId;

    private Long userId;

    private String nickname;

    private Long categoryId;

    private String categoryName;

    private String title;

    private Map<Long, String> tags;

    private Integer like;

    private Integer comment;

}
