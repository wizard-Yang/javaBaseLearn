package main.java.字节流.输入流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author saijun.yang
 * @date 2021/1/8 11:36
 * @description 文件输入流
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\文件流读取文件2.txt");
        byte[] bytes1 = new byte[fileInputStream.available()];
        byte[] bytes2 = new byte[fileInputStream.available()];
        //第一种正常读，读到结尾返回-1
        /*while(fileInputStream.read() != -1){
            System.out.println(fileInputStream.read());
        }*/

        System.out.println("第二种读，将文件流读到字节数组中");
        /*fileInputStream.read(bytes1);
        for (int i = 0; i < bytes1.length; i++) {
            System.out.print(bytes1[i]);
        }*/
        System.out.println("第三种读，将文件流指定起始位置和字节数读");
        fileInputStream.read(bytes2,1,3);
        for (int i = 0; i < bytes2.length; i++) {
            System.out.print(bytes2[i]);
        }
        fileInputStream.close();
    }
}
