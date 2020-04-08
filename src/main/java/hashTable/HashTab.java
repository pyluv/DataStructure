package hashTable;

import linkList.Item;

/**
 * @Classname HashTab
 * @Description TODO
 * @Date 4/7/2020 10:24 AM
 * @Created by Administrator
 */
public class HashTab {
    private ItemLink[] itemLink;
    private int size;

    public HashTab(int size) {
        this.size = size;
        itemLink = new ItemLink[size];
        for (int i =0; i <size; i++) {//将每一个链表初始化
            itemLink[i] = new ItemLink();
        }
    }

    public void add(Item item) {
        itemLink[hashFun(item)].add(item);
    }

    public void list() {
        for (int i =0; i<size; i++) {
            itemLink[i].list(i);
        }
    }

    public void findItemByNo(Item item) {
        Item result = itemLink[hashFun(item)].find(item);
        if (result == null) {
            System.out.println("没有找到这个元素");
        }else {
            System.out.println(result);
        }

    }

    private int hashFun (Item item) {
        return item.getNo() % size;
    }

}
