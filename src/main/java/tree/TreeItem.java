package tree;

/**
 * @Classname TreeItem
 * @Description TODO
 * @Date 4/8/2020 9:37 AM
 * @Created by Administrator
 */
public class TreeItem<E> {

    private TreeItem left;
    private TreeItem right;
    private E e;

    public TreeItem(E e) {
        this.e = e;
    }


    public TreeItem getLeft() {
        return left;
    }

    public void setLeft(TreeItem left) {
        this.left = left;
    }

    public TreeItem getRight() {
        return right;
    }

    public void setRight(TreeItem right) {
        this.right = right;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "TreeItem{" +
                "e=" + e +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public TreeItem preOrderSearch(E no) {

        if (this.getE().equals(no)) {
            return this;
        }
        TreeItem result = null;
        if (this.getLeft() != null) {
            result = this.getLeft().preOrderSearch(no);
        }
        if (result != null) {
            return result;
        }
        if (this.getRight() != null) {
            result = this.getRight().preOrderSearch(no);
        }
        return result;
    }

    public TreeItem infixOrderSearch(E no) {
        TreeItem result = null;
        ;
        if (this.getLeft() != null) {
            result = this.getLeft().infixOrderSearch(no);
        }
        if (result != null) {
            return result;
        }
        if (this.getE().equals(no)) {
            return this;
        }
        if (this.getRight() != null) {
            result = this.getRight().infixOrderSearch(no);
        }
        return result;
    }

    public TreeItem postOrderSearch(E no) {
        TreeItem result = null;
        if (this.getLeft() != null) {
            result = this.getLeft().postOrderSearch(no);
        }
        if (result != null) {
            return result;
        }
        if (this.getRight() != null) {
            result = this.getRight().postOrderSearch(no);
        }

        if (this.getE().equals(no)) {
            return this;
        }
        return result;
    }

    public void removeItem(E no) {
        if (this.getLeft() != null && this.getLeft().getE().equals(no)) {
            this.setLeft(null);
        }
        if (this.getRight() != null && this.getRight().getE().equals(no)) {
            this.setRight(null);
        }
        if (this.getLeft() != null) {
            this.getLeft().removeItem(no);
        }
        if (this.getRight() != null) {
            this.getRight().removeItem(no);
        }

    }
}
