package main.java.字节流.输入流;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author saijun.yang
 * @date 2021/1/8 14:31
 * @description  FilterInputStream包含一些其他输入流，它使用作为其基本数据源，
 * 可能改变数据沿道路或提供额外的功能。这类 FilterInputStream本身只是重写
 * FilterInputStream是一个受保护的，因此只能使用其子类
 */
public class FilterInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\文件流读取文件2.txt");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        System.out.println("1.直接读取int");
        System.out.println(dataInputStream.readInt());
        System.out.println("2.直接读取str");
        System.out.println(dataInputStream.readUTF());
        System.out.println("3.读取boolean");
        System.out.println(dataInputStream.readBoolean());
    }
}
