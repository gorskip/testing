package pl.ui.pg.boar.testdata.provider.json;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.File;
import java.io.IOException;
import java.util.List;
import pl.ui.pg.boar.exceptions.ParseException;
import pl.ui.pg.boar.testdata.provider.UserProvider;
import pl.ui.pg.boar.testdata.provider.predicate.UserParamsPredicate;
import pl.ui.pg.boar.testdata.user.User;
import pl.ui.pg.boar.util.BoarFileUtil;

/**
 *
 * @author gorskip
 */
public class JsonUserProvider extends JsonDataProvider implements UserProvider {

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";

    private final JsonObject root;

    public JsonUserProvider(File file) {
        try {
            root = Json.parse(BoarFileUtil.readFile(file)).asObject();
        } catch (IOException ex) {
            throw new ParseException("Cannot parse file " + file.getAbsolutePath(), ex);
        }
    }

    @Override
    public List<User> build() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
