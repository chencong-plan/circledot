package cc.ccoder.circledot.handler;

import cc.ccoder.circledot.core.common.response.ResponseCode;
import cc.ccoder.circledot.core.common.response.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.zip.DataFormatException;

/**
 * @author: chencong
 * @date: 2019/12/22 16:44
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ServerResponse httpRequestMethodNotSupportExceptionHandler(HttpRequestMethodNotSupportedException e) {
        log.error("请求方法暂不支持,异常信息:", e);
        return ServerResponse.error(ResponseCode.HTTP_METHOD_NOT_SUPPORT);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ServerResponse missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        log.error("请求参数错误,异常信息:", e);
        return ServerResponse.error(ResponseCode.INVALID_PARAM);
    }

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public ServerResponse typeMismatchExceptionHandler(TypeMismatchException e) {
        log.error("请求参数类型不正确:", e);
        return ServerResponse.error(ResponseCode.INVALID_PARAM,e.getMessage());
    }

    @ExceptionHandler(DataFormatException.class)
    @ResponseBody
    public ServerResponse dataFormatExceptionHandler(DataFormatException e) {
        log.error("数据转化异常:", e);
        return ServerResponse.error(ResponseCode.DATA_FORMAT_EXCEPTION);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ServerResponse illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("参数错误:", e);
        return ServerResponse.error(ResponseCode.INVALID_PARAM);
    }

    @ExceptionHandler
    @ResponseBody
    public ServerResponse allExceptionHandler(Exception e) {
        log.error("其他异常:", e);
        return ServerResponse.error(ResponseCode.SYSTEM_EXCEPTION,e.getMessage());
    }

}
