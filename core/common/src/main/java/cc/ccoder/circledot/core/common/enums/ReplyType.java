package cc.ccoder.circledot.core.common.enums;

/**
 * @author: chencong
 * @date: 2019/12/22 17:49
 */
public enum ReplyType {
    PARENT("P", "parent"),
    CHILDREN("C", "children");

    private String code;

    private String msg;

    ReplyType(String code, String msg) {
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
