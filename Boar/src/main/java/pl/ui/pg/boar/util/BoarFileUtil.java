package pl.ui.pg.boar.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author gorskip
 */
public class BoarFileUtil {

    private static final String ENCODING = "UTF-8";

    private BoarFileUtil() {
    }

    public static String readFile(File file) throws IOException {
        return FileUtils.readFileToString(file, ENCODING);
    }
}
