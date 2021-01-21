package cglib动态代理;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author saijun.yang
 * @date 2021/1/21 15:44
 * @description 增强处理类，实现MethodInterceptor接口，实现拦截方法intercept
 */
public class Handle implements MethodInterceptor {
    /**
     * @param sub cglib生成的代理对象
     * @param method 被代理对象方法
     * @param objects 方法参数
     * @param methodProxy 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强方法");
        Object object = methodProxy.invokeSuper(sub,objects);
        return object;
    }
}
