package main.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author saijun.yang
 * @date 2021/1/20 17:37
 * @description 反射使用方法
 */
public class ClassForMethodTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazzObj = Class.forName("main.java.reflect.Source");
        Constructor constructor = clazzObj.getConstructor(String.class,String.class);
        Source source = (Source)constructor.newInstance("名称name","地址address");
        //参数解析：1方法名  2参数的class
        Method method = clazzObj.getMethod("function2",String.class);
        //调用时，把生成的对象作为第一个参数
        method.invoke(source,"name我复个制");
    }
}
