package per.sjyang.baseMethod;

/**
 * @author saijun.yang
 * @date 2021/3/26 11:04
 * @description 等待这个线程
 */
public class Join {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是第一个线程，我第一个执行");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是第二个线程，我第二个执行");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是第三个线程，我第三个执行");
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}
