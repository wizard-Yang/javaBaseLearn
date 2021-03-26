package per.sjyang.baseMethod;

import java.util.concurrent.TimeUnit;

/**
 * @author saijun.yang
 * @date 2021/3/26 10:40
 * @description 线程中的基本方法
 */
public class BaseMethod {
    public static void main(String[] args) {
        ThreadSource threadSource = new ThreadSource();
        threadSource.start();
        System.out.println(Thread.currentThread().isAlive());
    }
}
