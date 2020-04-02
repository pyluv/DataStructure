package stack;

import linkList.Item;
import linkList.SingleLinkList;

/**
 * @Classname SingleLinkListStack
 * @Description TODO
 * @Date 4/2/2020 9:57 AM
 * @Created by Administrator
 */
public class SingleLinkListStack {

    private Item top = null;
    private int size =0;

    public boolean isEmpty (){
        return top == null;
    }

    public void push (Item item) {
        Item value = new Item(item.getNo(),item.getContext());
        if (isEmpty()) {
            top = value;
        }else {
            value.setNext(top);
            top =value;
        }
        size ++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        Item value = top;
        top = top.getNext();
        size --;
        return value;
    }

    public void showStack() {
        while (!isEmpty()) {
            System.out.println(top);
            top = top.getNext();
        }
    }

}
