package tree;

/**
 * @Classname TreeItem
 * @Description TODO
 * @Date 4/8/2020 9:37 AM
 * @Created by Administrator
 */
public class TreeItem<E extends Comparable> {

    private TreeItem left;
    private TreeItem right;
    private Comparable e;

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

    public Comparable getE() {
        return e;
    }

    public void setE(Comparable e) {
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

    //Binary Sort Tree
    public void addItem(TreeItem item) {
        if (item == null) {
            return;
        }

        if (item.getE().compareTo(this.getE()) < 0) {
            if (this.getLeft() == null) {
                this.setLeft(item);
            } else {
                this.getLeft().addItem(item);
            }
        } else {
            if (this.getRight() == null) {
                this.setRight(item);
            } else {
                this.getRight().addItem(item);
            }
        }

        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if (this.getRight() != null && this.getRight().leftHeight() > this.getRight().rightHeight()) {
                //先对右子结点进行右旋转
                this.getRight().rightRotate();
                //然后在对当前结点进行左旋转
                this.leftRotate();
            } else {
                //直接进行左旋转即可
                this.leftRotate();
            }
            return;
        }

        //当添加完一个结点后，如果 (左子树的高度 - 右子树的高度) > 1, 右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树的高度
            if (this.getLeft() != null && this.getLeft().rightHeight() > this.getLeft().leftHeight()) {
                //先对当前结点的左结点(左子树)->左旋转
                this.getLeft().leftRotate();
                //再对当前结点进行右旋转
                this.rightRotate();
            } else {
                //直接进行右旋转即可
                this.rightRotate();
            }
            return;
        }
    }

    public TreeItem search(TreeItem item) {
        if (this.getE().equals(item.getE())) {
            return this;
        }
        if (this.getE().compareTo(item.getE()) > 0) {//如果查找的值小于当前结点，向左子树递归查找
            if (this.getLeft() == null) {//如果左子结点为空
                return null;
            }
            return this.getLeft().search(item);
        } else {//如果查找的值不小于当前结点，向右子树递归查找
            if (this.getRight() == null) {
                return null;
            }
            return this.getRight().search(item);
        }
    }

    public TreeItem searchParent(TreeItem item) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if (this.getLeft() != null && this.getLeft().getE().equals(item.getE())
                || this.getRight() != null && this.getRight().getE().equals(item.getE())) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if (this.getE().compareTo(item.getE()) > 0 && this.getLeft() != null) {
                return this.getLeft().searchParent(item);//向左子树递归查找
            } else if (this.getE().compareTo(item.getE()) <= 0 && this.getRight() != null) {
                return this.getRight().searchParent(item);//向右子树递归查找
            } else return null;// 没有找到父结点
        }
    }

    //AVL
    // 返回 以该结点为根结点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // 返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    // 返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public void leftRotate() {
        TreeItem newItem = new TreeItem(this.getE());//创建新的结点，以当前根结点的值
        newItem.setLeft(this.getLeft());//把新的结点的左子树设置成当前结点的左子树
        newItem.setRight(this.getRight().getLeft());//把新的结点的右子树设置成带你过去结点的右子树的左子树
        this.setE(this.right.getE());//把当前结点的值替换成右子结点的值
        this.setRight(this.getRight().getRight());//把当前结点的右子树设置成当前结点右子树的右子树
        this.setLeft(newItem);//把当前结点的左子树(左子结点)设置成新的结点
    }

    public void rightRotate() {
        TreeItem newItem = new TreeItem(this.getE());
        newItem.setRight(this.getRight());
        newItem.setLeft(this.getLeft().getRight());
        this.setE(this.getLeft().getE());
        this.setLeft(this.getLeft().getLeft());
        this.setRight(newItem);
    }
}
