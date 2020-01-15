package cc.ccoder.circledot.service.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

/**
 * <p></p>
 *
 * @author chencong
 * @email cong.chen@topay.ae
 * @date ArticleRequest.java v1.0  2020/1/15 15:01
 */
@Data
@ApiModel
public class ArticleRequest {

    @ApiModelProperty(value = "userId", name = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "categoryId", name = "类别编号")
    private Long categoryId;

    @ApiModelProperty(value = "tags", name = "变迁编号")
    private List<Long> tags;

    @ApiModelProperty(value = "title", name = "标题")
    private String title;

    @ApiModelProperty(value = "context",name = "内容")
    private String context;


}
