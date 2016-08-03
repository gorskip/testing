package pl.ui.pg.boar.testdata.provider.json;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pl.ui.pg.boar.exceptions.ParseException;
import pl.ui.pg.boar.testdata.data.TestParams;
import pl.ui.pg.boar.testdata.provider.TestParamsProvider;
import pl.ui.pg.boar.testdata.provider.predicate.TestParamsPredicate;
import pl.ui.pg.boar.util.BoarFileUtil;

/**
 *
 * @author gorskip
 */
public class JsonTestParamsProvider extends JsonDataProvider implements TestParamsProvider {

    public static final String ID = "id";
    public static final String GROUP = "group";
    public static final String DESCRIPTION = "description";

    private final JsonObject root;

    public JsonTestParamsProvider(File file) {
        try {
            root = Json.parse(BoarFileUtil.readFile(file)).asObject();
        } catch (IOException ex) {
            throw new ParseException("Cannot parse file " + file.getAbsolutePath(), ex);
        }
    }

    @Override
    public List<TestParams> build() {
        List<TestParams> testParamsList = new ArrayList<>();
        for (JsonValue value : getParameters()) {
            TestParams testParams = buildTestParams(value);
            testParams.setParams(buildAdditionalParams(value.asObject(), new TestParamsPredicate()));
            testParamsList.add(testParams);
        }
        return testParamsList;
    }

    private JsonArray getParameters() {
        return root.get("testCase").asArray();
    }

    private TestParams buildTestParams(JsonValue jsonValue) {
        JsonObject testCase = jsonValue.asObject();
        String id = testCase.get(ID).asString();
        String group = testCase.get(GROUP).asString();
        String description = testCase.get(DESCRIPTION).asString();
        List<String> userRoles = getUserRoles(testCase);
        return new TestParams(id, group, description, userRoles);
    }

//    protected Map<String, Object> buildAdditionalParams(JsonObject jsonObject) {
//        Map<String, Object> args = new HashMap<>();
//        for (Member member : jsonObject) {
//            if (!TextUtils.equalsAny(member.getName(), ID, GROUP, DESCRIPTION, USER_ROLES)) {
//                appendMap(args, member);
//            }
//        }
//        return args;
//    }
}
