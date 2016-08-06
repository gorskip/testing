package pl.ui.pg.boar.exceptions;

/**
 *
 * @author gorskip
 */
public class TestJarLoadingException extends RuntimeException {

    public TestJarLoadingException(String message) {
        super(message);
    }

    public TestJarLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

}
