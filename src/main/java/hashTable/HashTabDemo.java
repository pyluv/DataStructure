package hashTable;

import linkList.Item;

import java.util.Scanner;

/**
 * @Classname HashTabDemo
 * @Description TODO
 * @Date 4/7/2020 10:49 AM
 * @Created by Administrator
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            if ("add".equals(key)) {
                System.out.println("输入id");
                int id = scanner.nextInt();
                System.out.println("输入名字");
                String name = scanner.next();
                Item item = new Item(id, name);
                hashTab.add(item);
            } else if ("list".equals(key)) {
                hashTab.list();
            } else if ("exit".equals(key)) {
                scanner.close();
                System.exit(0);
            }
        }
    }
}
