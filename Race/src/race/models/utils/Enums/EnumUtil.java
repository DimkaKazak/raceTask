package race.models.utils.Enums;

import java.util.Random;

/**
 * Util class for working with enums
 */
public class EnumUtil {

    /**
     * @param e - name of the Enum class, which field we want to get
     * @return random field from Enum class
     */
    public static <E extends Enum<E>> E getRandomValueFromEnum(Class<E> e) {
        int x = new Random().nextInt(e.getEnumConstants().length);
        return e.getEnumConstants()[x];
    }


}
