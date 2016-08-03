package pl.ui.pg.boar.testdata.provider;

import java.util.List;
import pl.ui.pg.boar.testdata.user.User;

/**
 *
 * @author gorskip
 */
public interface UserProvider {

    List<User> build();
}
