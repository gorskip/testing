package pl.ui.pg.boar.testdata.provider.predicate;

import com.eclipsesource.json.JsonObject.Member;
import com.google.common.base.Predicate;
import pl.ui.pg.boar.testdata.provider.json.JsonDataProvider;
import pl.ui.pg.boar.testdata.provider.json.JsonUserProvider;
import pl.ui.pg.boar.utils.TextUtils;

/**
 *
 * @author gorskip
 */
public class UserParamsPredicate implements Predicate<Member> {

    @Override
    public boolean apply(Member t) {
        return !TextUtils.equalsAny(
                t.getName(),
                JsonUserProvider.LOGIN,
                JsonUserProvider.PASSWORD,
                JsonUserProvider.NAME,
                JsonDataProvider.USER_ROLES);
    }

}
