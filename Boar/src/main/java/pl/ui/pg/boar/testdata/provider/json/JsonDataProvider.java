package pl.ui.pg.boar.testdata.provider.json;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pl.ui.pg.boar.utils.JsonUtils;

/**
 *
 * @author gorskip
 */
public class JsonDataProvider {

    public static final String USER_ROLES = "userRoles";

    protected void appendMap(Map<String, Object> args, JsonObject.Member member) {
        final JsonValue memberValue = member.getValue();
        if (memberValue.isString()) {
            putStringArg(args, member);
        } else if (memberValue.isBoolean()) {
            putBooleanArg(args, member);
        } else if (memberValue.isNumber()) {
            putNumberArg(args, member);
        } else if (memberValue.isArray()) {
            putArrayArg(args, member);
        }
    }

    protected void putStringArg(Map<String, Object> map, JsonObject.Member member) {
        map.put(member.getName(), member.getValue().asString());
    }

    protected void putBooleanArg(Map<String, Object> map, JsonObject.Member member) {
        map.put(member.getName(), member.getValue().asBoolean());
    }

    protected void putNumberArg(Map<String, Object> map, JsonObject.Member member) {
        map.put(member.getName(), member.getValue());
    }

    protected void putArrayArg(Map<String, Object> map, JsonObject.Member member) {
        map.put(member.getName(), member.getValue());
    }

    protected List<String> getUserRoles(JsonObject testCase) {
        List<String> userRoles = JsonUtils.getListOfStrings(testCase, USER_ROLES);
        if (userRoles.isEmpty()) {
            return Arrays.asList("NONE");
        }
        return userRoles;
    }

    protected Map<String, Object> buildAdditionalParams(JsonObject jsonObject, Predicate predicate) {
        Map<String, Object> args = new HashMap<>();
        for (JsonObject.Member member : jsonObject) {
            if (predicate.apply(jsonObject)) {
                appendMap(args, member);
            }
        }
        return args;
    }
}
