package jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author saijun.yang
 * @date 2021/1/21 13:42
 * @description 代理处理类，需实现
 */
public class Handle implements InvocationHandler {
    private Object needProxy;
    public Handle(Object needProxy) {
        this.needProxy = needProxy;
    }
    /**
     * @param proxy 调用该方法的代理实例
     * @param method 所述方法对应于调用代理实例上的接口方法的实例。 方法对象的声明类将是该方法声明的接口，它可以是代理类继承该方法的代理接口的超级接口。
     * @param args 包含的方法调用传递代理实例的参数值的对象的阵列，或null如果接口方法没有参数。
     *      * 原始类型的参数包含在适当的原始包装器类的实例中，例如java.lang.Integer或java.lang.Boolean 。
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强方法");
        System.out.println(method.invoke(needProxy,args));
        return "增强类返回值";
    }
}
