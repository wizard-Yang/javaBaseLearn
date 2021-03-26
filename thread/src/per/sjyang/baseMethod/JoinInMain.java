package per.sjyang.baseMethod;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author saijun.yang
 * @date 2021/3/26 11:14
 * @description 在Main方法中使用join来实现线程顺序执行
 */
public class JoinInMain {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是第一个线程，我第一个执行");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是第二个线程，我第二个执行");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是第三个线程，我第三个执行");
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        System.out.println("主线程执行结束");
    }
}
