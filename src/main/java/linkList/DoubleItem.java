package linkList;

/**
 * @Classname DoubleItem
 * @Description TODO
 * @Date 4/1/2020 3:00 PM
 * @Created by Administrator
 */
public class DoubleItem {
    private DoubleItem pre;
    private int no;
    private String context;
    private DoubleItem next;

    public DoubleItem(int no, String context) {
        this.pre = null;
        this.no = no;
        this.context = context;
        this.next = null;
    }

    public DoubleItem getPre() {
        return pre;
    }

    public void setPre(DoubleItem pre) {
        this.pre = pre;
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

    public DoubleItem getNext() {
        return next;
    }

    public void setNext(DoubleItem next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoubleItem{" +
                "no=" + no +
                ", context='" + context + '\'' +
                '}';
    }
}
