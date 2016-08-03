package pl.ui.pg.boar.testdata.provider.predicate;

import com.eclipsesource.json.JsonObject.Member;
import com.google.common.base.Predicate;
import pl.ui.pg.boar.testdata.provider.json.JsonDataProvider;
import pl.ui.pg.boar.testdata.provider.json.JsonTestParamsProvider;
import pl.ui.pg.boar.util.TextUtils;

/**
 *
 * @author gorskip
 */
public class TestParamsPredicate implements Predicate<Member> {

    @Override
    public boolean apply(Member t) {

        return !TextUtils.equalsAny(
                t.getName(),
                JsonTestParamsProvider.ID,
                JsonTestParamsProvider.GROUP,
                JsonTestParamsProvider.DESCRIPTION,
                JsonDataProvider.USER_ROLES);
    }

}
