package queue;

import com.sun.glass.ui.ClipboardAssistance;

import java.util.Scanner;

/**
 * @Classname ArrayQueueDemo
 * @Description TODO
 * @Date 3/31/2020 2:37 PM
 * @Created by Administrator
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //ArrayQueue queue= new ArrayQueue(3);
        CycleArrayQueue queue = new CycleArrayQueue(4);
        char key = ' '; //接受用戶輸入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //輸出一個菜單
        while(loop) {
            System.out.println("s(show): 顯示隊列");
            System.out.println("e(exit): 推出程序");
            System.out.println("a(sdd): 添加數據到隊列");
            System.out.println("g(get): 從隊列取出數據");
            System.out.println("h(head): 查看隊列頭的數據");
            System.out.println("e(exit): 退出");
            key = scanner.next().charAt(0); //
            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'a':
                    System.out.println("輸入一個數");
                    int value = scanner.nextInt();
                    queue.addItem(value);
                    break;
                case  'g':
                   try {
                       int item = queue.getItem();
                       System.out.println("取出的數據是"+item);
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                    break;
                case 'h':
                    try {
                        int head = queue.getHeadItem();
                        System.out.println("隊列頭是"+head);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }
}
