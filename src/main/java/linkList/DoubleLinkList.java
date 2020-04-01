package linkList;

/**
 * @Classname DoubleLinkList
 * @Description TODO
 * @Date 4/1/2020 3:02 PM
 * @Created by Administrator
 */
public class DoubleLinkList {
    private DoubleItem head = new DoubleItem(0,"");
    public void addItem(DoubleItem item) {
        DoubleItem temp = head;

        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(item);
        item.setPre(temp);
    }

    public void addItemByOrder(DoubleItem item)  {
        DoubleItem temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == item.getNo()) {
                throw new RuntimeException("item has already existed");
            }
            if (temp.getNext().getNo() > item.getNo()) {
                break;
            }
            temp = temp.getNext();
        }
        item.setNext(temp.getNext());
        item.setPre(temp);
        temp.setNext(item);
    }

    public void removeItem (DoubleLinkList linkList, DoubleItem item) {
        if (getWorkedItemCounts(linkList) == 0) {
            throw new RuntimeException("the LinkList is empty");
        }
        boolean flag = false;
        DoubleItem temp = head.getNext();

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getNo() == item.getNo()) {
                temp.getPre().setNext(item.getNext());
                flag =true;
            }
            temp = temp.getNext();
        }
        if (!flag) {
            throw new RuntimeException("cannot find the item");
        }
    }

    public void updateItem (DoubleLinkList linkList, DoubleItem item) {
        if (getWorkedItemCounts(linkList) == 0) {
            throw new RuntimeException("the LinkList is empty");
        }
        boolean flag = false;
        DoubleItem temp = head.getNext();

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getNo() == item.getNo()) {
                temp.setContext(item.getContext());
                flag =true;
            }
            temp = temp.getNext();
        }
        if (!flag) {
            throw new RuntimeException("cannot find the item");
        }
    }

    public void showLinkList(DoubleLinkList linkList) {
        if (getWorkedItemCounts(linkList) == 0) {
            throw new RuntimeException("the LinkList is empty");
        }
        DoubleItem temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public int getWorkedItemCounts (DoubleLinkList linkList) {

        int counts = 0;
        DoubleItem temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            counts ++;
            temp = temp.getNext();
        }
        return counts;
    }
}
