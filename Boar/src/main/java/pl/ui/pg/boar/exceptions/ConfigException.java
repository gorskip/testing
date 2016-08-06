package pl.ui.pg.boar.exceptions;

/**
 *
 * @author gorskip
 */
public class ConfigException extends RuntimeException {

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

}
