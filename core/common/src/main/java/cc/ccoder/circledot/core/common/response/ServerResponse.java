package cc.ccoder.circledot.core.common.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: chencong
 * @date: 2019/12/20 17:08
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {

    private T data;

    private String code;

    private String message;

    public boolean isSuccess() {
        return ResponseCode.SUCCESS.getCode().equals(this.code);
    }

    private ServerResponse() {
    }

    private ServerResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private ServerResponse(T data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }


    public static <T> ServerResponse success() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
    }

    public static <T> ServerResponse success(T data) {
        return new ServerResponse<T>(data, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
    }

    public static <T> ServerResponse success(String message) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ServerResponse success(T data, ResponseCode responseCode) {
        return new ServerResponse<T>(data, responseCode.getCode(), responseCode.getMsg());
    }

    public static <T> ServerResponse error(ResponseCode responseCode) {
        return new ServerResponse<T>(responseCode.getCode(), responseCode.getMsg());
    }

    public static <T> ServerResponse errorValidate(String message) {
        return new ServerResponse<T>(ResponseCode.INVALID_PARAM.getCode(), message);
    }


}
