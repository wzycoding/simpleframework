package org.simpleframework.util;

import java.util.Collection;

public class ValidationUtil {

    /**
     * 对集合进行判空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Collection<?> obj) {
        return obj == null || obj.isEmpty();
    }
}
