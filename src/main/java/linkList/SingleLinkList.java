package linkList;

/**
 * @Classname SingleLinkList
 * @Description TODO
 * @Date 3/31/2020 5:58 PM
 * @Created by Administrator
 */
public class SingleLinkList {
    private Item head = new Item(0, "");

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
            } else if (temp.getNext().getNo() == item.getNo()) {
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

    public void showLinkList() {
        Item temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            System.out.println(temp.getNext());
            temp = temp.getNext();
        }

    }
}
