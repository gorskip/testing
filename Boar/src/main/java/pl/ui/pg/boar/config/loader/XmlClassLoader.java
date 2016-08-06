package pl.ui.pg.boar.config.loader;

import com.google.common.reflect.ClassPath;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import org.testng.xml.XmlClass;
import pl.ui.pg.boar.exceptions.TestJarLoadingException;

/**
 *
 * @author gorskip
 */
public class XmlClassLoader {

    public List<XmlClass> load(String jarPath, String testPackage) {
        try {
            return executeLoad(jarPath, testPackage);
        } catch (IOException ex) {
            throw new TestJarLoadingException("Cannot read jar: " + jarPath, ex);
        }
    }

    private List<XmlClass> executeLoad(String jarPath, String testPackage) throws MalformedURLException, IOException {
        File tests = new File(jarPath);
        attachJar(tests.toURL());
        List<XmlClass> classes = new ArrayList<>();
        ClassPath cp = ClassPath.from(Thread.currentThread().getContextClassLoader());
        for (ClassPath.ClassInfo info : cp.getTopLevelClassesRecursive(testPackage)) {
            classes.add(new XmlClass(info.getName()));
        }
        return classes;
    }

    private void attachJar(URL jarUrl) {
        URL[] url = new URL[1];
        url[0] = jarUrl;
        URLClassLoader child = new URLClassLoader(url, this.getClass().getClassLoader());
        Thread.currentThread().setContextClassLoader(child);
    }

}
