package linkList;

/**
 * @Classname DoubleLinkListDemo
 * @Description TODO
 * @Date 4/1/2020 3:12 PM
 * @Created by Administrator
 */
public class DoubleLinkListDemo {
    public static void main(String[] args) {
        DoubleLinkList linkList = new DoubleLinkList();
        DoubleItem item1 = new DoubleItem(1,"aaa");
        DoubleItem item2 = new DoubleItem(2,"sss");
        DoubleItem item3 = new DoubleItem(3,"ddd");

        linkList.addItem(item1);
        linkList.addItem(item2);
        linkList.addItem(item3);

        linkList.showLinkList(linkList);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        linkList.removeItem(linkList,item2);
        linkList.showLinkList(linkList);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        DoubleItem item4 = new DoubleItem(3,"update");
        linkList.updateItem(linkList, item4);
        linkList.showLinkList(linkList);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        DoubleLinkList orderLinkList = new DoubleLinkList();
        orderLinkList.addItemByOrder(item2);
        orderLinkList.addItemByOrder(item1);
        orderLinkList.addItemByOrder(item3);
        //orderLinkList.addItemByOrder(item3);
        orderLinkList.showLinkList(orderLinkList);

    }
}
