package hashTable;

import linkList.Item;

import java.util.Currency;

/**
 * @Classname ItemLink
 * @Description TODO
 * @Date 4/7/2020 10:33 AM
 * @Created by Administrator
 */
public class ItemLink {

    private Item head;//默认头指针为空，意味着头指针会被替代，无头单链表；

    public void add(Item item) {
        if (head == null) {
            head = item;
            return;
        }
        Item cur = head;
        while (true) {

            if (cur.getNext() == null) {
                break;
            }
            cur = cur.getNext();
        }
        cur.setNext(item);
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第"+no+"个链表为空");
            return;
        }
        Item cur = head;
        while (true) {
            System.out.print(cur);
            if (cur.getNext() == null) {
                break;
            }
            cur = cur.getNext();
        }
    }

    public Item find(Item item) {
        if (head == null) {
            return null;
        }
        Item cur = head;
        while (true) {
            if (cur.getNo() == item.getNo()) {
                break;
            }
            if ((cur.getNext() == null)) {
                return null;
            }
            cur = cur.getNext();
        }
        return cur;
    }

    public void remove(Item item) {
        if (head == null) {
            return;
        }
        if (head.getNo() == item.getNo()) {
            head = head.getNext();
        }
        Item cur = head;
        while (cur.getNext() != null) {
            if (cur.getNext().getNo() == item.getNo()) {
                cur = cur.getNext();
                return;
            }
            cur = cur.getNext();
        }


    }
}
