package stack;


import java.util.Scanner;

/**
 * @Classname ArrayStackDemo
 * @Description TODO
 * @Date 4/2/2020 9:46 AM
 * @Created by Administrator
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            if ("show".equals(key)) {
                try {
                    stack.showStack();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if ("push".equals(key)) {
                System.out.println("请输入一个数");
                int value = scanner.nextInt();
                try {
                    stack.push(value);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if ("pop".equals(key)) {
                try {
                    int res = stack.pop();
                    System.out.printf("出栈的数据是 %d\n", res);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if ("exit".equals(key)) {
                scanner.close();
                loop = false;
            }
        }

        System.out.println("程序退出~~~");

    }
}
