package pl.ui.pg.boar.testdata.provider;

import java.util.List;
import pl.ui.pg.boar.testdata.data.TestParams;

/**
 *
 * @author gorskip
 */
public interface TestParamsProvider {

    List<TestParams> build();
}
