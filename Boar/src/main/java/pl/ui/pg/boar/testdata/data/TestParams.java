package pl.ui.pg.boar.testdata.data;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Przemo
 */
public class TestParams {

    private final String id;
    private final String group;
    private final String description;
    private final List<String> userRoles;
    private Map<String, String> params;

    public TestParams(String id, String group, String description, List<String> userRoles) {
        this.id = id;
        this.group = group;
        this.description = description;
        this.userRoles = userRoles;
    }

    public String getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getUserRoles() {
        return userRoles;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public String getParam(String paramName) {
        return params.get(paramName);
    }

    public void setParam(String paramName, String value) {
        params.put(paramName, value);
    }
}
