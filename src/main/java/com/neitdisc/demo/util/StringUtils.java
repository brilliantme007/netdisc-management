package com.neitdisc.demo.util;

/**
 * @author WHLiang
 * @date 2019/8/21 11:11
 */
public class StringUtils {

    /**
     * 字符串判空(null 或是 空字符串)
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return obj == null || obj.toString().isEmpty();
    }
}
