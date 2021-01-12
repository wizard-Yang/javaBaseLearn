package main.java.字符流.输入流;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author saijun.yang
 * @date 2021/1/11 17:18
 * @description 缓冲输入流
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\文件读入字符流.txt"),"UTF-8"));
        String readLine = null;
        while((readLine = bufferedReader.readLine()) != null){
            System.out.println(readLine);
        }
    }
}
