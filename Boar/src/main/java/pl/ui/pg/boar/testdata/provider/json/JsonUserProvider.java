package pl.ui.pg.boar.testdata.provider.json;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import pl.ui.pg.boar.exceptions.ParseException;
import pl.ui.pg.boar.testdata.provider.UserProvider;
import pl.ui.pg.boar.testdata.provider.predicate.UserParamsPredicate;
import pl.ui.pg.boar.testdata.user.User;
import pl.ui.pg.boar.utils.BoarFileUtils;

/**
 *
 * @author gorskip
 */
public class JsonUserProvider extends JsonDataProvider implements UserProvider {

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";

    private final JsonObject root;

    public JsonUserProvider(Path pathFile) {
        try {
            root = Json.parse(BoarFileUtils.readFile(pathFile.toFile())).asObject();
        } catch (IOException ex) {
            throw new ParseException("Cannot parse file " + pathFile.toString(), ex);
        }
    }

    @Override
    public List<User> build() {
        List<User> users = new ArrayList<>();
        for (JsonValue value : getUsers()) {
            users.add(buildUser(value));
        }
        return users;
    }

    private User buildUser(JsonValue jsonValue) {
        JsonObject userJson = jsonValue.asObject();
        String login = userJson.get(LOGIN).asString();
        String password = userJson.get(PASSWORD).asString();
        String name = userJson.get(NAME).asString();
        List<String> roles = getUserRoles(userJson);
        User user = new User(login, password, name, roles);
        user.setParams(buildAdditionalParams(root, new UserParamsPredicate()));
        return new User(login, password, name, roles);
    }

    private JsonArray getUsers() {
        return root.get("users").asArray();
    }
}
