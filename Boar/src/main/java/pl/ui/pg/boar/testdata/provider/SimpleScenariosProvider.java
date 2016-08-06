package pl.ui.pg.boar.testdata.provider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import pl.ui.pg.boar.exceptions.ConfigException;
import pl.ui.pg.boar.utils.BoarFileUtils;

/**
 *
 * @author gorskip
 */
public class SimpleScenariosProvider implements ScenariosProvider {

    private final File scenarioFile;

    public SimpleScenariosProvider(Path scenarioListFilePath) {
        scenarioFile = scenarioListFilePath.toFile();
    }

    @Override
    public List<String> build() {
        try {
            return BoarFileUtils.readLines(scenarioFile);
        } catch (IOException ex) {
            throw new ConfigException("Cannot initialize scenarios");
        }
    }

}
