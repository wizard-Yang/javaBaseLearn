package jdk动态代理;

/**
 * @author saijun.yang
 * @date 2021/1/21 13:41
 * @description
 */
public class DynamicClassImpl implements DynamicInterface{
    @Override
    public String test(String name) {
        System.out.println("被代理实现类"+name);
        return "被代理实现类返回值";
    }
}
