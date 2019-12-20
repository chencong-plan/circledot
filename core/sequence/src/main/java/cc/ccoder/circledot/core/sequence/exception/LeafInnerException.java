package cc.ccoder.circledot.core.sequence.exception;

/**
 * @author: chencong
 * @date: 2019/12/20 10:49
 */
public class LeafInnerException extends RuntimeException {

    private static final long serialVersionUID = -6406358429150436602L;

    public LeafInnerException() {
    }

    public LeafInnerException(String message) {
        super(message);
    }

    public LeafInnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LeafInnerException(Throwable cause) {
        super(cause);
    }

    public LeafInnerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
