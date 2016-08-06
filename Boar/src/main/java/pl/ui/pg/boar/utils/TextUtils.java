package pl.ui.pg.boar.utils;

/**
 *
 * @author gorskip
 */
public class TextUtils {

    private TextUtils() {
    }

    public static boolean equalsAny(String text, String... any) {
        for (String next : any) {
            if (text.equals(next)) {
                return true;
            }
        }
        return true;
    }
}
