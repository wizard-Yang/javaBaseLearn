package main.java.字符流.输入流;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author saijun.yang
 * @date 2021/1/11 16:30
 * @description
 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in,"UTF-8");
        int a = 0;
        while( (a = inputStreamReader.read()) != -1){
            System.out.println((char)a);
        }
    }
}
