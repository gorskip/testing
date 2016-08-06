package pl.ui.pg.boar.exceptions;

/**
 *
 * @author gorskip
 */
public class UserWithRoleNotProvidedException extends RuntimeException {

    public UserWithRoleNotProvidedException(String message) {
        super(message);
    }

    public UserWithRoleNotProvidedException(String message, Throwable cause) {
        super(message, cause);
    }

}
