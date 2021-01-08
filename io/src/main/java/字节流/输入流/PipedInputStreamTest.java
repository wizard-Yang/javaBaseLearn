package main.java.字节流.输入流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author saijun.yang
 * @date 2021/1/8 15:39
 * @description 管道流，用于线程间通信.输入输出管道也是对应使用的
 */
public class PipedInputStreamTest {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipedIn = new PipedInputStream();
        PipedOutputStream pipedOut = new PipedOutputStream();
        pipedOut.connect(pipedIn);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fileIn = new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\管道流读取文件.txt");
                    int b = 0;
                    while(true){
                        b = fileIn.read();
                        pipedOut.write(b);
                        if(b == -1){
                            break;
                        }
                    }
                    System.out.println("文件写入成功");
                    fileIn.close();
                    pipedOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },"thread1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileOutputStream fileOut = new FileOutputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\管道流输出文件.txt");
                    int b = 0;
                    while((b = pipedIn.read()) != -1){
                        fileOut.write(b);
                    }
                    System.out.println("文件输出成功");
                    pipedOut.close();
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        },"thread2").start();
    }
}
