package tree;

/**
 * @Classname ThreadBinaryTree
 * @Description TODO
 * @Date 4/9/2020 8:59 AM
 * @Created by Administrator
 */
public class ThreadBinaryTree {
    public ThreadTreeItem root;
    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private ThreadTreeItem pre = null;

    public ThreadTreeItem getRoot() {
        return root;
    }

    public void setRoot(ThreadTreeItem root) {
        this.root = root;
    }

    public ThreadBinaryTree(ThreadTreeItem root) {
        this.root = root;
    }

    public void infixOrderThreadItem() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        infixOrderThreadItem(root);
    }

    private void infixOrderThreadItem(ThreadTreeItem item) {
        if (item == null) {//不能线索化
            return;
        }
        //先线索化左子树
        infixOrderThreadItem(item.getLeft());

        //处理当前结点的前驱结点
        if (item.getLeft() == null) {
            item.setLeft(pre);//让当前结点的左指针指向前驱结点
            item.setLeftType(1);//修改当前结点的左指针的类型,指向前驱结点
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(item);//让前驱结点的右指针指向当前结点
            pre.setRightType(1);//修改前驱结点的右指针类型
        }
        pre = item;//!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        infixOrderThreadItem(item.getRight());
    }

    public void infixOrder() {
        ThreadTreeItem item = root;
        while (item != null) {
            while (item.getLeftType() == 0) {
                item = item.getLeft();
            }
            System.out.println(item);
            while (item.getRightType() ==1) {
                item = item.getRight();
                System.out.println(item);
            }

            item = item.getRight();
        }
    }

    public void preOrderThreadItem() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        preOrderThreadItem(root);
    }

    private void preOrderThreadItem(ThreadTreeItem item) {
        if (item == null) {//不能线索化
            return;
        }
        //左指针为空,将左指针指向前驱节点
        if (item.getLeft() == null) {
            item.setLeft(pre);//让当前结点的左指针指向前驱结点
            item.setLeftType(1);//修改当前结点的左指针的类型,指向前驱结点
        }
        //前一个节点的后继节点指向当前节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(item);
            pre.setRightType(1);
        }
        pre = item;
        //处理左子树
        if (item.getLeftType() == 0) {
            preOrderThreadItem(item.getLeft());
        }
        //处理右子树
        if (item.getRightType() == 0) {
            preOrderThreadItem(item.getRight());
        }

    }

    public void preOrder() {
        ThreadTreeItem item = root;
        while (item != null) {
            while (item.getLeftType() == 0) {
                System.out.println(item);
                item = item.getLeft();
            }
            System.out.println(item);
            item = item.getRight();
        }
    }

    public void postOrderThreadItem() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        postOrderThreadItem(root);
    }

    private void postOrderThreadItem(ThreadTreeItem item) {
        if (item == null) {//不能线索化
            return;
        }
        //处理左子树
        postOrderThreadItem(item.getLeft());
        //处理右子树
        postOrderThreadItem(item.getRight());
        //左指针为空,将左指针指向前驱节点
        if (item.getLeft() == null) {
            item.setLeft(pre);//让当前结点的左指针指向前驱结点
            item.setLeftType(1);//修改当前结点的左指针的类型,指向前驱结点
        }
        //前一个节点的后继节点指向当前节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(item);
            pre.setRightType(1);
        }
        pre = item;
    }

    public void postOrder() {
        ThreadTreeItem item = root;
        while (item != null && item.getLeftType() ==0) {
            item = item.getLeft();
        }
        while (item != null) {
            if (item.getRightType() == 1) {
                System.out.println(item);
                pre = item;
                item = item.getRight();
            }else {
                if (item.getRight() == pre) {
                    System.out.println(item);
                    if (item == root) {
                        return;
                    }
                    pre = item;
                    item = item.getParent();
                }else {
                    item = item.getRight();
                    while (item!= null && item.getLeftType() == 0) {
                        item = item.getLeft();
                    }
                }
            }
        }
    }
}
