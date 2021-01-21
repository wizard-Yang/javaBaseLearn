package cglib动态代理;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author saijun.yang
 * @date 2021/1/21 15:48
 * @description 代理使用
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\gitWorkSpace\\javaBaseLearn\\proxy\\src\\main\\java\\cglib动态代理\\生成文件");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(CglibProxyClassImp.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new Handle());
        // 创建代理对象
        CglibProxyClassImp proxy= (CglibProxyClassImp)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.test();
    }
}
