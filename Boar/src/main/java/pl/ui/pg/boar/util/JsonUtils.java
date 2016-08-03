package pl.ui.pg.boar.util;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gorskip
 */
public class JsonUtils {

    private JsonUtils() {

    }

    public static List<String> getListOfStrings(JsonObject testCase, String memberName) {
        return getListOfStrings(testCase.get(memberName).asArray());
    }

    public static List<String> getListOfStrings(JsonArray jsonArray) {
        List<String> list = new ArrayList<>();
        for (JsonValue value : jsonArray) {
            list.add(value.asString());
        }
        return list;
    }

    public static List<Double> getListOfDoubles(JsonArray jsonArray) {
        List<Double> list = new ArrayList<>();
        for (JsonValue value : jsonArray) {
            list.add(value.asDouble());
        }
        return list;
    }

    public static List<Integer> getListOfIntegers(JsonArray jsonArray) {
        List<Integer> list = new ArrayList<>();
        for (JsonValue value : jsonArray) {
            list.add(value.asInt());
        }
        return list;
    }

    public static List<Long> getListOfLongs(JsonArray jsonArray) {
        List<Long> list = new ArrayList<>();
        for (JsonValue value : jsonArray) {
            list.add(value.asLong());
        }
        return list;
    }

}
