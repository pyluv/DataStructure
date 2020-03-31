package linkList;

/**
 * @Classname item
 * @Description TODO
 * @Date 3/31/2020 5:38 PM
 * @Created by Administrator
 */
public class Item {
    private int no;
    private String context;
    private Item next;

    public Item(int no, String context) {
        this.no = no;
        this.context = context;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Item{" +
                "no=" + no +
                ", context='" + context + '\'' +
                '}';
    }
}
