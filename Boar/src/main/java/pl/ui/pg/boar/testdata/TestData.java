package pl.ui.pg.boar.testdata;

import java.util.List;
import java.util.Map;
import pl.ui.pg.boar.testdata.parser.JsonListParser;

/**
 *
 * @author gorskip
 */
public class TestData {

    private final JsonListParser testParamsJsonProvider;

    public TestData() {
        this.testParamsJsonProvider = new JsonListParser();
    }

    public int getIntParam(Map<String, Object> params, String memberName) {
        return testParamsJsonProvider.getIntParam(params, memberName);
    }

    public List<String> getListOfStrings(Map<String, Object> params, String memberName) {
        return testParamsJsonProvider.getListOfStrings(params, memberName);
    }

    public List<Double> getListOfDoubles(Map<String, Object> params, String memberName) {
        return testParamsJsonProvider.getListOfDoubles(params, memberName);
    }

    public List<Integer> getListOfIntegers(Map<String, Object> params, String memberName) {
        return testParamsJsonProvider.getListOfIntegers(params, memberName);
    }

    public List<Long> getListOfLongs(Map<String, Object> params, String memberName) {
        return testParamsJsonProvider.getListOfLongs(params, memberName);
    }
}
