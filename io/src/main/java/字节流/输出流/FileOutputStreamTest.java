package main.java.字节流.输出流;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author saijun.yang
 * @date 2021/1/8 17:07
 * @description 文件输出流
 */
public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\输出流写文件.txt");
        for (int i = 0; i < 65535; i++) {
            fileOutputStream.write(i);
        }
    }
}
