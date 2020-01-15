package cc.ccoder.circledot.core.common.enums;

/**
 * <p></p>
 *
 * @author chencong
 * @email cong.chen@topay.ae
 * @date CommonStatus.java v1.0  2020/1/15 15:23
 */
public enum CommonStatus {
    YES("Y", "正常"),
    NO("N", "异常");

    private String code;

    private String msg;


    CommonStatus(String code, String msg) {
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
