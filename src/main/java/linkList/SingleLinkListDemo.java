package linkList;

/**
 * @Classname singleLinkList
 * @Description TODO
 * @Date 3/31/2020 5:37 PM
 * @Created by Administrator
 */
public class SingleLinkListDemo {
    public static void main(String[] args) {
        SingleLinkList singleLinkList = new SingleLinkList();
        Item item1 = new Item(1,"sss");
        Item item2 = new Item(2,"ddd");
        Item item3 = new Item(3,"fff");
        Item item4 = new Item(3,"fff");
//        singleLinkList.addItem(item1);
//        singleLinkList.addItem(item2);
//        singleLinkList.addItem(item3);
        singleLinkList.addItemByOrder(item1);
        singleLinkList.addItemByOrder(item3);
        singleLinkList.addItemByOrder(item2);

        singleLinkList.showLinkList();


    }
}


