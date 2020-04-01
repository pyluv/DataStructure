package linkList;

/**
 * @Classname CircleLinkList
 * @Description TODO
 * @Date 4/1/2020 4:16 PM
 * @Created by Administrator
 */
public class CircleSingleLinkList {
    CircleItem first = null;

    public void addItem(CircleItem item) {
        if (first == null) {
            first = item;
            first.setNext(first);
            return;
        }
        CircleItem current = first;
        while (true) {
            if (current.getNext().equals(first)) {
                break;
            }

            current = current.getNext();
        }
        current.setNext(item);
        item.setNext(first);
    }

    public void showLinkList() {
        if (first == null) {
            System.out.println("link list is empty");
            return;
        }
        CircleItem current = first;
        while (true) {
            System.out.println(current);
            if (current.getNext().equals(first)) {
                break;
            }
            current = current.getNext();
        }
    }

    public int getLinkListSize() {
        int sum = 0;
        if (first == null) {
            System.out.println("link list is empty");
            return sum;
        }
        CircleItem current = first;

        while (true) {
            sum++;
            if (current.getNext().equals(first)) {
                break;
            }
            current = current.getNext();
        }
        return sum;
    }

    public CircleItem getFirst() {
        return first;
    }

    public void josephCount(int startNo, int countNum, CircleSingleLinkList linkList) {
        //Josephu  问题为：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
        // 它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。

        if (startNo < 0 || startNo > linkList.getLinkListSize() || countNum < 0 || linkList.getFirst().getNext() == null) {
            throw new RuntimeException("parameter is illegal");
        }
        //将first 指向 startNo的位置
        boolean flag = false;
        CircleItem current = first;
        while (true) {
            if (current.getNo() == startNo) {
                flag = true;
                break;
            }
            current = current.getNext();

        }
        if (!flag) {
            throw new RuntimeException("cannot find start position");
        }
        first = current;
        //将helper指向first的前一个位置
        CircleItem helper = first;

        while (true) {
            if (helper.getNext().equals(first)) {
                break;
            }
            helper = helper.getNext();
        }
        //开始计数
        while (true) {
            if (helper.equals(first)) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first);
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(first);
    }
}
