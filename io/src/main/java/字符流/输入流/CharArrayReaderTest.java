package main.java.字符流.输入流;

import java.io.CharArrayReader;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @author saijun.yang
 * @date 2021/1/11 10:13
 * @description 该类实现了一个字符缓冲区，可以用作字符输入流。
 */
public class CharArrayReaderTest {
    public static void main(String[] args) throws IOException {
        char[] chars = {'a','b','c','d','大'};
        CharArrayReader charArrayReader = new CharArrayReader(chars);
        System.out.println("判断流是否准备好被读"+charArrayReader.ready());
        int read = 0;
        System.out.println("第一种：一个字符一个字符读");
       /* while((read = charArrayReader.read()) != -1){
            System.out.println((char)read);
        }*/
        System.out.println("第二种读：读到一个新的字符数组中，可以指定被读的起始位置和长度");
        char[] tempCharArr = new char[chars.length];
        //i代表偏移量，指从tempCharArr哪个下表开始，i1：读取字符的长度，这里读2个
        charArrayReader.read(tempCharArr,0,2);
        System.out.println(tempCharArr.length);
        for (int i = 0; i < tempCharArr.length; i++) {
            System.out.println(tempCharArr[i]);
        }
        charArrayReader.close();
    }
}
