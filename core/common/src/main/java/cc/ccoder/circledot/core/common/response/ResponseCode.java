package cc.ccoder.circledot.core.common.response;

/**
 * @author: chencong
 * @date: 2019/12/20 17:27
 */
public enum  ResponseCode {

    /**
     * success 成功
     */
    SUCCESS("200","success"),
    /**
     * 参数不合法
     */
    INVALID_PARAM("400","invalid_param"),

    /**
     * data_format_exception
     */
    DATA_FORMAT_EXCEPTION("401","data_format_exception"),

    /**
     * http_method_not_support
     */
    HTTP_METHOD_NOT_SUPPORT("300","http_method_not_support"),

    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION("500","system_exception"),


    /**
     * 重复提交
     */
    SUBMIT_DUPLICATE("601","submit_duplicate"),

    /**
     * 记录不存在
     */
    RECORD_NOT_EXIST("602", "record_not_exist");

    private String code;

    private String msg;

    ResponseCode(String code, String msg) {
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
