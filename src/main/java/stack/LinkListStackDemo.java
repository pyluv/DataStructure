package stack;


import linkList.Item;

import java.util.Scanner;

/**
 * @Classname ArrayStackDemo
 * @Description TODO
 * @Date 4/2/2020 9:46 AM
 * @Created by Administrator
 */
public class LinkListStackDemo {
    public static void main(String[] args) {
        SingleLinkListStack stack = new SingleLinkListStack();
        Item item1 = new Item(1,"sss");
        Item item2 = new Item(2,"ddd");
        Item item3 = new Item(3,"fff");
        Item item4 = new Item(4,"update");
        stack.push(item1);
        stack.push(item2);
        stack.push(item3);
        stack.push(item1);
        stack.pop();
        stack.pop();
        stack.showStack();
    }
}
