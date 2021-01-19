package main.java.annotation.注解属性;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author saijun.yang
 * @date 2021/1/19 15:38
 * @description 测试注解类
 */
@Attribute(age = 25, name = "saijun.yang", body = PersonEnum.TALL, other = @AttributeType(other = "v"))
public class Main {
    @Attribute(other = @AttributeType(other = "field"))
    String att;
    @Attribute(other = @AttributeType(other = "function"))
    public void function(){

    }
    public static void main(String[] args) {
        //1.获取类注解属性
        Class<Main> clazz = Main.class;
        //如果此元素上 存在指定类型的注释，则返回true，否则返回false。
        boolean isAnnotationPresent = clazz.isAnnotationPresent(Attribute.class);
        if(isAnnotationPresent){
            //返回此元素上 存在的注释。
            Attribute attribute = clazz.getAnnotation(Attribute.class);
            System.out.println(attribute.age());
            System.out.println(attribute.name());
            System.out.println(attribute.body());
        }

        //2.获取属性注解属性
        try {
            Field att = clazz.getDeclaredField("att");
            boolean isPresent = att.isAnnotationPresent(Attribute.class);
            if(isPresent){
                Attribute attributeType = att.getAnnotation(Attribute.class);
                System.out.println(attributeType.other().other());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //3.获取方法注解属性
        try {
            Method function = clazz.getDeclaredMethod("function");
            boolean isPresent = function.isAnnotationPresent(Attribute.class);
            if(isPresent){
                Attribute attributeType = function.getAnnotation(Attribute.class);
                System.out.println(attributeType.other().other());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
