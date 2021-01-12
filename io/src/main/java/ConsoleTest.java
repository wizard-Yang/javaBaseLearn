package main.java;

import java.io.Console;
import java.io.PrintWriter;

/**
 * @author saijun.yang
 * @date 2021/1/12 14:48
 * @description 控制台类，只能在类似window的控制台或者linux的terminal上运行代码时使用直接读取
 */
public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();
        if(console != null){
            PrintWriter printWriter = console.writer();
            printWriter.write("input:");
            console.flush();
            String str1 = console.readLine();
            console.format("%s", str1);
        }
    }
}
