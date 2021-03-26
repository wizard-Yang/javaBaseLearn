package per.sjyang.baseMethod;

import java.util.concurrent.TimeUnit;

/**
 * @author saijun.yang
 * @date 2021/3/26 10:41
 * @description 使用Thread创建线程
 */
public class ThreadSource extends Thread{
    @Override
    public void run() {
        System.out.println("线程启动啦");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.dumpStack();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
