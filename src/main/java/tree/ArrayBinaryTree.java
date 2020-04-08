package tree;

/**
 * @Classname ArrayBinaryTree
 * @Description TODO
 * @Date 4/8/2020 1:54 PM
 * @Created by Administrator
 */
public class ArrayBinaryTree {

    private int[] arr = null;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);
    }

    private void preOrder(int index) {
        if (arr.length == 0 || arr == null) {
            System.out.println("Tree is empty");
        }
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    private void infixOrder(int index) {
        if (arr.length == 0 || arr == null) {
            System.out.println("Tree is empty");
        }
        if (2 * index + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }
        System.out.println(arr[index]);

        if (2 * index + 2 < arr.length) {
            infixOrder(2 * index + 2);
        }
    }

    private void postOrder(int index) {
        if (arr.length == 0 || arr == null) {
            System.out.println("Tree is empty");
        }
        if (2 * index + 1 < arr.length) {
            postOrder(2 * index + 1);
        }

        if (2 * index + 2 < arr.length) {
            postOrder(2 * index + 2);
        }

        System.out.println(arr[index]);
    }
}
