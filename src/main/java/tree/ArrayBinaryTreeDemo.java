package tree;

/**
 * @Classname ArrayBinaryTreeDemo
 * @Description TODO
 * @Date 4/8/2020 1:54 PM
 * @Created by Administrator
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.preOrder();
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        tree.infixOrder();
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        tree.postOrder();

    }
}
