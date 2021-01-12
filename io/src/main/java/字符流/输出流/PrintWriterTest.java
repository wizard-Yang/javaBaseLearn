package main.java.字符流.输出流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author saijun.yang
 * @date 2021/1/11 17:31
 * @description
 */
public class PrintWriterTest {
    public static void main(String[] args) throws FileNotFoundException {
        testFile();
    }

    /**
     * 写入到文件中
     * @throws FileNotFoundException
     */
    public static void testFile() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\PrintWriter.txt"));
        printWriter.println(123);
        //printWriter.write(111);
        printWriter.print("我是杨111111111111111111111");
        printWriter.append("cjxikgfsdjgfdslkfjsdf");
        printWriter.append("fdogeiopwfriroguhjifousdgio");
        printWriter.close();
    }
}
