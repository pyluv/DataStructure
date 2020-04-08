package tree;

/**
 * @Classname BinaryTreeDemo
 * @Description TODO
 * @Date 4/8/2020 9:50 AM
 * @Created by Administrator
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeItem root = new TreeItem(1);
        TreeItem item2 = new TreeItem(2);
        TreeItem item3 = new TreeItem(3);
        TreeItem item4 = new TreeItem(4);
        TreeItem item5 = new TreeItem(5);
        TreeItem item6 = new TreeItem(6);
        TreeItem item7 = new TreeItem(7);
        tree.setRoot(root);
        root.setLeft(item2);
        root.setRight(item3);
        item2.setLeft(item4);
        item2.setRight(item5);
        item3.setLeft(item6);
        item3.setRight(item7);

        tree.preOrder();
        //tree.infixOrder(root);
        //tree.postOrder(root);
        //TreeItem result = tree.preOrderSearch(root, 9);
//        tree.removeItem(2);
        System.out.println("~~~~~~~~~~");
        tree.infixOrder();
        System.out.println("~~~~~~~~~~");
        tree.postOrder();


    }
}
