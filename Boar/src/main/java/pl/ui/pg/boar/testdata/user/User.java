package pl.ui.pg.boar.testdata.user;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import pl.ui.pg.boar.testdata.TestData;

/**
 *
 * @author gorskip
 */
public class User extends TestData {

    private String login;
    private String password;
    private String name;
    private List<String> roles;
    private Map<String, Object> params;

    public User() {
    }

    public User(String... roles) {
        this.roles = Arrays.asList(roles);
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name) {
        this(login, password);
        this.name = name;
    }

    public User(String login, String password, String name, String... roles) {
        this(login, password, name);
        this.roles = Arrays.asList(roles);
    }

    public User(String login, String password, String name, List<String> roles) {
        this(login, password, name);
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Object getParam(String paramName) {
        return params.get(paramName);
    }
}
