package main.java.annotation.注解属性;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/**
 * 注解属性
 * 1.基本数据类型
 * 2.String
 * 3.枚举类型
 * 4.注解类型
 * 5.Class类型
 * 6.以上类型的一维数组类型
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
public @interface Attribute {
    int age() default 28;
    String name() default "杨赛军";
    PersonEnum body() default PersonEnum.THIN;
    AttributeType other();
    Class<Map> classMap() default Map.class;
    char[] charArr() default {'a','b'};
}