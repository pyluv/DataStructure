package linkList;

/**
 * @Classname CircleItem
 * @Description TODO
 * @Date 4/1/2020 4:17 PM
 * @Created by Administrator
 */
public class CircleItem {
    private int no;
    private String context;
    private CircleItem next;

    public CircleItem(int no, String context) {
        this.no = no;
        this.context = context;
        this.next = null;
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

    public CircleItem getNext() {
        return next;
    }

    public void setNext(CircleItem next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "CircleItem{" +
                "no=" + no +
                ", context='" + context + '\'' +
                '}';
    }
}
