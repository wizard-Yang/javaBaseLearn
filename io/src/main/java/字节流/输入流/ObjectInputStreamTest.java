package main.java.字节流.输入流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author saijun.yang
 * @date 2021/1/8 15:07
 * @description 对象流
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       // serializableToText();
        //进行反序列化
        FileInputStream fileInputStream = new FileInputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\序列化文件.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Source source = (Source) objectInputStream.readObject();
        System.out.println(source.toString());
    }
    public static void serializableToText() throws IOException {
        //先将对象序列化到文件中
        Source source = new Source("张三",19);
        FileOutputStream fileInputStream = new FileOutputStream("E:\\gitWorkSpace\\javaBaseLearn\\io\\src\\main\\java\\文件包\\序列化文件.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
        objectOutputStream.writeObject(source);
        objectOutputStream.close();
    }
}

/**
 * 用于序列化的类
 */
class Source implements Serializable {
    private String name;
    private int age;
    //本类保存了该字段的状态，实际序列化是不会序列化静态字段的
    public static String address = "静态不需要序列化字段";
    //不需要序列化
    public transient char sex = 'M';

    public Source(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address=" + address +
                '}';
    }
}
