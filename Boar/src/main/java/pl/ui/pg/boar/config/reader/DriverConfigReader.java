package pl.ui.pg.boar.config.reader;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonObject.Member;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import pl.ui.pg.boar.utils.BoarFileUtils;

/**
 *
 * @author gorskip
 */
public class DriverConfigReader {

    private static final String DEFAULT_BROWSER = "Chrome";
    private JsonObject json;

    public DriverConfigReader(Path propFile) throws IOException {
        init(propFile);
    }

    private void init(Path propFile) throws IOException {
        String fileContent = BoarFileUtils.readFile(propFile.toFile());
        json = Json.parse(fileContent).asObject();
    }

    public String getBrowser() {
        return json.getString("browser", DEFAULT_BROWSER);
    }

    public int getImplicitWait() {
        return json.getInt("implicitWait", 10);
    }

    public Map<String, Long> getCustomWaits() {
        Map<String, Long> customWaits = new HashMap<>();
        JsonObject waits = json.get("customWaits").asObject();
        for (Member member : waits) {
            customWaits.put(member.getName(), member.getValue().asLong());
        }
        return customWaits;
    }

}
