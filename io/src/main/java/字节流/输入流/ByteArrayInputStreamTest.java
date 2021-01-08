package main.java.字节流.输入流;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author saijun.yang
 * @date 2021/1/8 11:03
 * @description 字节数组输入流
 */
public class ByteArrayInputStreamTest {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {1,2,3,4,5,6,7};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        System.out.println("1.返回从该输入流读取的剩余字节数"+byteArrayInputStream.available());

        System.out.println("2.从这个输入流读取下一个数据字节");
        /*while(byteArrayInputStream.available() > 0){
            System.out.print(byteArrayInputStream.read());
        }*/
        System.out.println("3.从输入流中读取最多len个字节到目标数组中，返回实际读取的字节数,第一个参数是偏移量1代表去下表为1");
        byte[] byteTem = new byte[5];
        System.out.println(byteArrayInputStream.read(byteTem, 1, 3));
        for (int i = 0; i < byteTem.length; i++) {
            System.out.print(byteTem[i]);
        }
        System.out.println();

        System.out.println("4.跳过 n字节的输入从输入流");
        long skip = byteArrayInputStream.skip(2);
        System.out.print(byteArrayInputStream.read());
        byteArrayInputStream.close();
    }
}
