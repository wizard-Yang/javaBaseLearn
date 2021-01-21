package 静态代理;

/**
 * @author saijun.yang
 * @date 2021/1/21 11:40
 * @description 静态代理代理类
 */
public class StaticProxyProxyCLass implements StaticProxyInterface{
    private StaticProxyInterface staticProxyInterface;

    public StaticProxyProxyCLass(StaticProxyInterface staticProxyInterface) {
        this.staticProxyInterface = staticProxyInterface;
    }

    @Override
    public void test() {
        System.out.println("增强接口功能");
        staticProxyInterface.test();
    }
}
