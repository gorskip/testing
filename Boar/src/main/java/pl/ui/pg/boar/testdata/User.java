package pl.ui.pg.boar.testdata;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Przemo
 */
public class User {

    private String login;
    private String password;
    private String name;
    private List<UserRole> roles;
    private Map<String, String> params;

    public User() {
    }

    public User(UserRole... roles) {
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

    public User(String login, String password, String name, UserRole... roles) {
        this(login, password, name);
        this.roles = Arrays.asList(roles);
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

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getParam(String paramName) {
        return params.get(paramName);
    }

}
