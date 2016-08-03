package pl.ui.pg.boar.testdata.parser;

import com.eclipsesource.json.JsonArray;
import java.util.List;
import java.util.Map;
import pl.ui.pg.boar.exceptions.TestParamFormatException;
import pl.ui.pg.boar.util.JsonUtils;

/**
 *
 * @author gorskip
 */
public class JsonListParser {

    public int getIntParam(Map<String, Object> params, String memberName) {
        try {
            return (Integer) params.get(memberName);
        } catch (ClassCastException e) {
            throw new TestParamFormatException("Wrong format of param. Cannot cast to Integer", e);
        }
    }

    public List<String> getListOfStrings(Map<String, Object> params, String memberName) {
        try {
            return JsonUtils.getListOfStrings((JsonArray) params.get(memberName));
        } catch (ClassCastException e) {
            throw new TestParamFormatException("Wrong format of param. Cannot build list of Strings", e);
        }
    }

    public List<Double> getListOfDoubles(Map<String, Object> params, String memberName) {
        try {
            return JsonUtils.getListOfDoubles((JsonArray) params.get(memberName));
        } catch (ClassCastException e) {
            throw new TestParamFormatException("Wrong format of param. Cannot build list of Doubles", e);
        }
    }

    public List<Integer> getListOfIntegers(Map<String, Object> params, String memberName) {
        try {
            return JsonUtils.getListOfIntegers((JsonArray) params.get(memberName));
        } catch (ClassCastException e) {
            throw new TestParamFormatException("Wrong format of param. Cannot build list of Integers", e);
        }
    }

    public List<Long> getListOfLongs(Map<String, Object> params, String memberName) {
        try {
            return JsonUtils.getListOfLongs((JsonArray) params.get(memberName));
        } catch (ClassCastException e) {
            throw new TestParamFormatException("Wrong format of param. Cannot build list of Longs", e);
        }
    }

}
