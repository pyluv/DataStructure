package tree;

/**
 * @Date 4/8/2020 9:14 AM
 * @Created by Administrator
 */
public class BinaryTree {
    private TreeItem root;

    public TreeItem getRoot() {
        return root;
    }

    public void setRoot(TreeItem root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    public TreeItem preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else return null;
    }

    public TreeItem infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else return null;
    }

    public TreeItem postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else return null;
    }

    public void removeItem(int no) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        if (root.getE().equals(no)) {
            root = null;
            return;
        }
        root.removeItem(no);


    }
}
