package cc.ccoder.circledot.core.sequence.exception;

/**
 * @author: chencong
 * @date: 2019/12/20 10:49
 */
public class KeyNotExistsException extends RuntimeException {

    private static final long serialVersionUID = -1217789633760123918L;

    public KeyNotExistsException() {
    }

    public KeyNotExistsException(String message) {
        super(message);
    }

    public KeyNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeyNotExistsException(Throwable cause) {
        super(cause);
    }

    public KeyNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
