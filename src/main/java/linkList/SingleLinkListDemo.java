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
        SingleLinkList targetLinkList = new SingleLinkList();
        Item item1 = new Item(1,"sss");
        Item item2 = new Item(2,"ddd");
        Item item3 = new Item(3,"fff");
        Item item4 = new Item(4,"update");
        singleLinkList.addItem(item1);
        //singleLinkList.addItem(item2);
        singleLinkList.addItem(item3);
        targetLinkList.addItemByOrder(item2);
        targetLinkList.addItemByOrder(item4);
//        singleLinkList.addItemByOrder(item1);
//        singleLinkList.addItemByOrder(item3);
//        singleLinkList.addItemByOrder(item2);
//        singleLinkList.addItemByOrder(item4);
        //singleLinkList.updateItem(item4);
        //singleLinkList.removeItem(item2);

        singleLinkList.showLinkList(singleLinkList);
        System.out.println("===============================");
        singleLinkList.showLinkList(targetLinkList);
        System.out.println(singleLinkList.getWorkedItemCounts());
        //System.out.println(singleLinkList.getLastIndexItem(3));
//        SingleLinkList reverseSingleLinkList = singleLinkList.revertLinkList(singleLinkList);
//        reverseSingleLinkList.showLinkList(reverseSingleLinkList);
        //singleLinkList.printReverseLinkList(singleLinkList);
        System.out.println("===============================");

        singleLinkList.mergeTwoOrderLinkList(singleLinkList, targetLinkList);
        singleLinkList.showLinkList(targetLinkList);


    }
}


