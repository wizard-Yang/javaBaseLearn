package jdk动态代理.代理生成的字节码文件;

import jdk动态代理.DynamicInterface;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author saijun.yang
 * @date 2021/1/21 14:52
 * @description 将jdk动态代理生成的class文件写出来文件
 */
public class WritePorxyClassToFile {
    public static void main(String[] args) throws IOException {
        createProxyClassFile();
    }
    //生成字节码文件保存到本地
    private static void createProxyClassFile() throws IOException {
        File file = new File("ProxyDefine.class");
        if(!file.exists()){
            file.createNewFile();
        }
        String name = "/ProxyDefine";
        byte[] data = ProxyGenerator.generateProxyClass(name,new Class[]{DynamicInterface.class});
        FileOutputStream out =null;
        try {
            out = new FileOutputStream(file);
            System.out.println((new File("money")).getAbsolutePath());
            out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null!=out) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
