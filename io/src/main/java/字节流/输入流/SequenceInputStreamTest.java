package main.java.字节流.输入流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author saijun.yang
 * @date 2021/1/8 16:11
 * @description 序列输入流
 */
public class SequenceInputStreamTest {
    public static void main(String[] args) throws IOException {
        stream();
        batchStream();
    }
    public static void stream() throws IOException {
        FileInputStream fileIn1 = new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\序列流1.txt");
        FileInputStream fileIn2 = new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\序列流2.txt");
        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileIn1,fileIn2);
        int b = 0;
        while((b = sequenceInputStream.read()) != -1){
            System.out.println((char)b);
        }
    }
    public static void batchStream() throws IOException {
        FileInputStream fileIn1 = new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\序列流1.txt");
        FileInputStream fileIn2 = new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\序列流2.txt");
        FileInputStream fileIn3 = new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\序列流3.txt");
        //超过两个输入流
        Vector<InputStream> v = new Vector<InputStream>();
        v.addElement(fileIn1);
        v.addElement(fileIn2);
        v.addElement(fileIn3);
        SequenceInputStream sequenceInputStreamMore = new SequenceInputStream(v.elements());
        int b = 0;
        while((b = sequenceInputStreamMore.read()) != -1){
            System.out.println((char)b);
        }
    }
}
