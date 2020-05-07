package models.utils.Enums;

import java.util.Random;

public class EnumUtil {

    public static <E extends Enum<E>> E getRandomValueFromEnum(Class<E> e) {
        int x = new Random().nextInt(e.getEnumConstants().length);
        return e.getEnumConstants()[x];
    }


}
