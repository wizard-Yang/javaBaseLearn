package main.java.reflect;

import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author saijun.yang
 * @date 2021/1/20 15:51
 * @description 反射实现细节
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Object obj = new Object();
        /*********************************获取Class对象*************************************/
        //1.通过Object的getClass()方法
        Class clazz = obj.getClass();
        //2.数据类型或者类的静态属性
        Class clazz1 = Object.class;
        Class clazz2 = int.class;
        //Class的静态方法forName(String className);
        Class clazz3 = Class.forName("main.java.reflect.Source");

        /*********************************获取成员变量*************************************/
        Class clazzObj = Class.forName("main.java.reflect.Source");
        try {
            //获取默认的无参数构造方法，可以指定参数获取相应的构造方法
            //Constructor constructor = clazzObj.getConstructor();
            //有参构造方法，假设构造方法2个参数
            //Constructor constructor = clazzObj.getConstructor(String.class,String.class);
            //如果构造函数私有,那么需要设置可进入
            Constructor constructor = clazzObj.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            //创建对象
            //Source source = (Source)constructor.newInstance();
            //通过有参构造方法创建对象
            Source source = (Source)constructor.newInstance("杨赛军");
            Field field = clazzObj.getField("address");
            //获取私有属性
            Field fieldPrivate = clazzObj.getDeclaredField("name");
            Field fieldStatic = clazzObj.getField("body");
            field.set(source,"元宝");
            //私有属性使用需要设置为可进入
            fieldPrivate.setAccessible(true);
            //fieldPrivate.set(source,"军");
            System.out.println(source.toString());
            //获取所有的属性
            Field[] fieldArr = clazzObj.getDeclaredFields();
            for (int i = 0; i < fieldArr.length; i++) {
                fieldArr[i].setAccessible(true);
                System.out.println(fieldArr[i].getName() + fieldArr[i].get(source));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
