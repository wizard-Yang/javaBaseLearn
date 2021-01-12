package main.java.File;

import java.io.File;
import java.io.IOException;

/**
 * @author saijun.yang
 * @date 2021/1/12 14:59
 * @description 文件类
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = null;
        //file = byFileName();
        file = byParentFileName();
        //file = byURI();
        System.out.println(file.isFile());
        //返回此抽象路径名的绝对路径名字符串
        System.out.println(file.getAbsolutePath());
        //当且仅当具有该名称的文件尚不存在时，原子地创建一个由该抽象路径名命名的新的空文件。
        file.createNewFile();
        //在默认临时文件目录中创建一个空文件，使用给定的前缀和后缀生成其名称
        //File.createTempFile("pre","suffix");
        //删除由此抽象路径名表示的文件或目录。
        //file.delete();
        //测试此抽象路径名表示的文件或目录是否存在。
        file.exists();
        //返回由此抽象路径名表示的文件或目录的名称
        System.out.println(file.getName());
        //返回此抽象路径名的父 null的路径名字符串，如果此路径名未命名为父目录，则返回null。
        System.out.println(file.getParent());
        //构造一个表示此抽象路径名的 file: URI。
        System.out.println(file.toURI());

    }
    /**
     * 通过文件路径创建文件
     */
    public static File byFileName(){
        File file = new File("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\File类\\File类读取文件.txt");
        return file;
    }

    /**
     * 根据父文件创建
     */
    public static File byParentFileName(){
        File file = new File("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\File类","File类读取文件1.txt");
        return file;
    }

    /**
     * 根据URI创建
     */
    public static File byURI(){
        File file = new File("https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/js/lib/jquery-1-edb203c114.10.2.js");
        return file;
    }
}
