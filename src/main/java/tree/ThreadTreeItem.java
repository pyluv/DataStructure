package tree;

/**
 * @Classname TreeItem
 * @Description TODO
 * @Date 4/8/2020 9:37 AM
 * @Created by Administrator
 */
public class ThreadTreeItem<E> {

    private ThreadTreeItem left;
    private ThreadTreeItem right;
    private ThreadTreeItem parent;
    private int leftType = 0;
    private int rightType = 0;
    private E e;

    public ThreadTreeItem(E e) {
        this.e = e;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public ThreadTreeItem getLeft() {
        return left;
    }

    public void setLeft(ThreadTreeItem left) {
        this.left = left;
    }

    public ThreadTreeItem getRight() {
        return right;
    }

    public void setRight(ThreadTreeItem right) {
        this.right = right;
    }

    public ThreadTreeItem getParent() {
        return parent;
    }

    public void setParent(ThreadTreeItem parent) {
        this.parent = parent;
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

    public ThreadTreeItem preOrderSearch(E no) {

        if (this.getE().equals(no)) {
            return this;
        }
        ThreadTreeItem result = null;
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

    public ThreadTreeItem infixOrderSearch(E no) {
        ThreadTreeItem result = null;
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

    public ThreadTreeItem postOrderSearch(E no) {
        ThreadTreeItem result = null;
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
