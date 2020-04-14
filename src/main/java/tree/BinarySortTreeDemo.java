package tree;

/**
 * @Classname BinarySortTreeDemo
 * @Description TODO
 * @Date 4/14/2020 10:08 AM
 * @Created by Administrator
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();

        //循环的添加结点到二叉排序树
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.addItem(new TreeItem(arr[i]));
        }
        binarySortTree.getRoot().height();
        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12
        //binarySortTree.removeItem(new TreeItem(arr[7]));
        binarySortTree.removeItem(new TreeItem(arr[2]));
        System.out.println("~~~~~~~~~~");
        binarySortTree.infixOrder();

    }
}
