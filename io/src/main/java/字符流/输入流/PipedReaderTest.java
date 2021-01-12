package main.java.字符流.输入流;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author saijun.yang
 * @date 2021/1/11 16:49
 * @description 管道输入流
 */
public class PipedReaderTest {
    public static void main(String[] args) throws IOException {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        out.connect(in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                try {
                    while (true){
                        TimeUnit.SECONDS.sleep(2);
                        int a = random.nextInt(500);
                        System.out.println("随机数"+a);
                        out.write(a);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        TimeUnit.SECONDS.sleep(1);
                        int a = in.read();
                        if(a != -1){
                            System.out.println((char)a);
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
