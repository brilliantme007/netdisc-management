package com.neitdisc.demo.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Map;

/**
 * @author WHLiang
 * @date 2019/8/22 9:07
 */
public class EntityUtils {

    /**
     * 将map转换成指定的实体对象
     * key值和对应实体中的setter上的MapToEntity.name相同
     *
     * @param params
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static Object mapToEntity(Map<String, Object> params, Class clazz) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Object o = clazz.newInstance();
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Annotation[] declaredAnnotations = declaredMethod.getDeclaredAnnotations();
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            boolean canSet = false;
            String mapToEntityName = "";
            if (declaredAnnotations != null && declaredAnnotations.length > 0) {
                for (Annotation declaredAnnotation : declaredAnnotations) {
                    Class<? extends Annotation> aClass = declaredAnnotation.annotationType();
                    if (aClass == MapToEntity.class) {
                        canSet = true;
                        mapToEntityName = ((MapToEntity) declaredAnnotation).name();
                        break;
                    }
                }
            }
            if (canSet) {
                Object o1 = params.get(mapToEntityName);
                String name = parameterTypes[0].getName();
                if (o1 != null) {
                    switch (name) {
                        case "java.lang.String":
                            declaredMethod.invoke(o, o1.toString());
                            break;
                        case "java.sql.Timestamp":
                            declaredMethod.invoke(o, Timestamp.valueOf(o1.toString()));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return o;
    }
}
