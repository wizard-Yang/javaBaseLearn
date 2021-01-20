package main.java.reflect;

/**
 * @author saijun.yang
 * @date 2021/1/20 16:14
 * @description 作为反射的资源类
 */
public class Source {
    private String name;
    public String address;
    public static String body = "body";
    private void function1(){
        System.out.println("私有方法");
    }
    public void function2(String name){
        System.out.println("有参公有带参数方法"+name);
    }

    String function3(){
        System.out.println("默认权限方法，有返回值");
        return "function3";
    }

    /**
     * 有参公有构造方法
     * @param name
     * @param address
     */
    public Source(String name, String address) {
        this.name = name;
        this.address = address;
    }

    private Source() {
    }

    private Source(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
