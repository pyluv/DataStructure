package linkList;

/**
 * @Classname CircleSingleLinkListDemo
 * @Description TODO
 * @Date 4/1/2020 4:28 PM
 * @Created by Administrator
 */
public class CircleSingleLinkListDemo {
    public static void main(String[] args) {
        CircleSingleLinkList linklist = new CircleSingleLinkList();
        CircleItem item1 = new CircleItem(1,"aaa");
        CircleItem item2 = new CircleItem(2,"ddd");
        CircleItem item3 = new CircleItem(3,"fff");
        CircleItem item4 = new CircleItem(4,"eee");
        CircleItem item5 = new CircleItem(5,"ggg");

        linklist.addItem(item1);
        linklist.addItem(item2);
        linklist.addItem(item3);
        linklist.addItem(item4);
        linklist.addItem(item5);
        linklist.showLinkList();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        linklist.josephCount(8,8,linklist);






    }
}
