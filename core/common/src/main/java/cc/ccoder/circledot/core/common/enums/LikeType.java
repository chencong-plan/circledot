package cc.ccoder.circledot.core.common.enums;

/**
 * @author: chencong
 * @date: 2019/12/22 15:09
 */
public enum LikeType {
    /**
     * 评论 comment
     */
    COMMENT("C", "comment"),
    /**
     * 回复 reply
     */
    REPLY("R", "reply"),
    /**
     * 文章 article
     */
    ARTICLE("A", "article");

    private String code;

    private String msg;

    LikeType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
