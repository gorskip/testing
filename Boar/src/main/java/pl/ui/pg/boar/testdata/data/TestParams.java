package pl.ui.pg.boar.testdata.data;

import java.util.List;
import java.util.Map;
import pl.ui.pg.boar.testdata.TestData;

/**
 *
 * @author gorskip
 */
public class TestParams extends TestData {

    private final String id;
    private final String group;
    private final String description;
    private final List<String> userRoles;
    private Map<String, Object> params;

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

    public Map<String, Object> getParams() {
        return params;
    }

    public Object getParam(String paramName) {
        return params.get(paramName);
    }

    public void setParam(String paramName, Object value) {
        params.put(paramName, value);
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

}
