package acherie.marsrover.exception;

/**
 * @author wangjie
 * @date 2018/5/15
 */
public class RoverException extends RuntimeException {

    public RoverException() {
        super();
    }

    public RoverException(String message) {
        super(message);
    }

    public RoverException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoverException(Throwable cause) {
        super(cause);
    }

    public RoverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
