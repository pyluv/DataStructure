package linkList;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.util.Stack;

/**
 * @Classname SingleLinkList
 * @Description TODO
 * @Date 3/31/2020 5:58 PM
 * @Created by Administrator
 */
public class SingleLinkList {
    private Item head = new Item(0, "");

    public Item getHead() {
        return head;
    }

    public void addItem(Item item) {
        Item temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(item);
    }

    public void addItemByOrder(Item item) {
        Item temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > item.getNo()) {
                break;
            } else if (temp.getNo() == item.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            throw new RuntimeException("item number has already existed");
        } else {
            item.setNext(temp.getNext());
            temp.setNext(item);

        }

    }

    public void updateItem(Item item) {
        Item temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }

            if (temp.getNo() == item.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setContext(item.getContext());
        } else
            throw new RuntimeException("cannot find the item to update");
    }

    public void removeItem(Item item) {
        Item temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }

            if (temp.getNext().getNo() == item.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else
            throw new RuntimeException("cannot find the item to update");
    }


    public void showLinkList(SingleLinkList linkList) {
        Item temp = linkList.getHead();
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            System.out.println(temp.getNext());
            temp = temp.getNext();
        }

    }

    public int getWorkedItemCounts() {
        //獲取單鏈表有效節點的個數（不統計head）
        Item temp = head;
        int counts = 0;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            counts++;
            temp = temp.getNext();
        }
        return counts;
    }

    public Item getLastIndexItem(int index) {

        //获取单链表倒数第index个节点（不統計head）
        Item temp = head;
        int length = getWorkedItemCounts();
        if (head.getNext() == null) {
            throw new RuntimeException("linklist is empty");
        }
        if (index <= 1 || index > length) {
            throw new RuntimeException("over linklist size");
        }
        for (int i = 0; i <= length - index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public SingleLinkList revertLinkList(SingleLinkList linkList) {
        if (linkList.getWorkedItemCounts() < 2) {
            return linkList;
        }
        SingleLinkList reLinkList = new SingleLinkList();//new 一个新的空链表作为反转链表
        Item cur = linkList.getHead().getNext();//cur 初始值为原链表第一个有效元素，在循环过程中cur会后移
        Item next = null;
        Item reverseHead = new Item(0, "");// 反转后的头节点
        while (cur != null) {//因为cur逐个后移，当cur为空时，则原链表遍历结束
            next = cur.getNext();//记录原链表cur后一个元素
            cur.setNext(reverseHead.getNext());//将反转后链表的头元素的next设置为cur的next。注意，此时原链表断开。next作用体现
            reverseHead.setNext(cur);//将cur插入到反转链表的头节点的后一个元素，即第一个有效元素
            cur = next;//cur后移
        }
        reLinkList.addItem(reverseHead.getNext());//addItem方法里自带头节点。则直接加入有效元素即可
        return reLinkList;
    }

    public void printReverseLinkList(SingleLinkList linkList) {
        Stack<Item> stack = new Stack<Item>();
        Item cur = linkList.getHead().getNext();
        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public SingleLinkList  mergeTwoOrderLinkList (SingleLinkList srcLinkList, SingleLinkList tarLinkList) {
        Item cur = srcLinkList.getHead().getNext();
        Item next = null;
        if (tarLinkList.getWorkedItemCounts() == 0) {
            return srcLinkList;
        } else if (srcLinkList.getWorkedItemCounts() ==0) {
            return tarLinkList;
        }
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(null);
            tarLinkList.addItemByOrder(cur);
            cur = next;
        }
        return tarLinkList;
    }
}
