package main.java.annotation.元注解;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解
 * Retention:注解存在阶段
 * Target:作用位置
 * Documented：api文本标注
 * Inherited：子类继承该注解
 * Repeatable：可重复使用某个注解并赋值
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MetaAnnotation {
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MetaAnnotation1 {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@interface MetaAnnotation2 {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@interface MetaAnnotation3 {
    MetaAnnotation4[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@Repeatable(MetaAnnotation3.class)
@interface MetaAnnotation4 {
    String value() default "";
}

@MetaAnnotation4(value = "a")
@MetaAnnotation4(value = "b")
class My{}