package cc.ccoder.circledot.core.common.enums;

/**
 * <p></p>
 *
 * @author chencong
 * @email cong.chen@topay.ae
 * @date IdentityType.java v1.0  2020/1/15 16:59
 */
public enum  IdentityType {

    WEI_CHAT("WeiChat","微信"),
    QQ("QQ","QQ"),
    USERNAME("U","用户名"),
    EMAIL("E","邮箱");

    private String code;

    private String msg;

    IdentityType(String code, String msg) {
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
