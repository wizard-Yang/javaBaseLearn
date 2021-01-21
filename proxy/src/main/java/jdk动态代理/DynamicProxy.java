package jdk动态代理;

import java.lang.reflect.Proxy;

/**
 * @author saijun.yang
 * @date 2021/1/21 13:55
 * @description 动态代理的使用
 */
public class DynamicProxy {
    public static void main(String[] args) {
        DynamicClassImpl dy = new DynamicClassImpl();
        //创建代理对象
        Object proxy = Proxy.newProxyInstance(DynamicClassImpl.class.getClassLoader(),DynamicClassImpl.class.getInterfaces(),new Handle(dy));
        System.out.println(proxy instanceof DynamicInterface);
        System.out.println(((DynamicInterface)proxy).test("name"));
    }
}
