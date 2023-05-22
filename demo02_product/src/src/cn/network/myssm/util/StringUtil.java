package src.cn.network.myssm.util;

/**
 * ClassName: StringUtil
 * Description:
 *
 * @Author wzy
 * @Create 2023/5/20 14:11
 * @Version 1.0
 */

public class StringUtil {
    //判断字符串是否为null或者""
    public static boolean isEmpty(String str){
        return str==null || "".equals(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
