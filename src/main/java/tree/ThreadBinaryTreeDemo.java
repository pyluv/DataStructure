package tree;

/**
 * @Classname ArrayBinaryTreeDemo
 * @Description TODO
 * @Date 4/8/2020 1:54 PM
 * @Created by Administrator
 */
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadTreeItem root = new ThreadTreeItem(1);
        ThreadTreeItem item2 = new ThreadTreeItem(3);
        ThreadTreeItem item3 = new ThreadTreeItem(6);
        ThreadTreeItem item4 = new ThreadTreeItem(8);
        ThreadTreeItem item5 = new ThreadTreeItem(10);
        ThreadTreeItem item6 = new ThreadTreeItem(14);
        ThreadTreeItem item7 = new ThreadTreeItem(7);
        root.setLeft(item2);
        root.setRight(item3);
        item2.setLeft(item4);
        item2.setRight(item5);
        item3.setLeft(item6);
        item2.setParent(root);
        item3.setParent(root);
        item4.setParent(item2);
        item5.setParent(item2);
        item6.setParent(item3);
        ThreadBinaryTree tree = new ThreadBinaryTree(root);
        tree.postOrderThreadItem();

        ThreadTreeItem leftItem = item5.getLeft();
        ThreadTreeItem rightItem = item5.getRight();
        System.out.println(leftItem);
        System.out.println(rightItem);
        System.out.println("~~~~~~~~~~~~~~");
        tree.postOrder();

    }
}
