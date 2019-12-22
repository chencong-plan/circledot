package cc.ccoder.circledot.core.common.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author: chencong
 * @date: 2019/12/22 14:57
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null) return true;
        if (obj instanceof CharSequence) return ((CharSequence) obj).length() == 0;
        if (obj instanceof Collection) return ((Collection) obj).isEmpty();
        if (obj instanceof Map) return ((Map) obj).isEmpty();
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (Object o : object) {
                if (!isNullOrEmpty(o)) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }


}
