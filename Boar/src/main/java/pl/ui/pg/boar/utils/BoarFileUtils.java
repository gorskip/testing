package pl.ui.pg.boar.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author gorskip
 */
public class BoarFileUtils {

    private static final String ENCODING = "UTF-8";

    private BoarFileUtils() {
    }

    public static String readFile(File file) throws IOException {
        return FileUtils.readFileToString(file, ENCODING);
    }

    public static List<String> readLines(File file) throws IOException {
        return FileUtils.readLines(file, ENCODING);
    }
}
