package 静态代理;

/**
 * @author saijun.yang
 * @date 2021/1/21 13:04
 * @description 测试类
 */
public class Main {
    public static void main(String[] args) {
        StaticProxyProxyCLass staticProxyProxyCLass = new StaticProxyProxyCLass(new StaticProxyImpl());
        staticProxyProxyCLass.test();
    }
}
