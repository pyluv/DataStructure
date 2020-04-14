package tree;

/**
 * @Classname AVLTree
 * @Description TODO
 * @Date 4/14/2020 1:16 PM
 * @Created by Administrator
 */
public class AVLTree {
    private TreeItem root;

    public TreeItem getRoot() {
        return root;
    }

    public void setRoot(TreeItem root) {
        this.root = root;
    }

    public void addItem(TreeItem item) {
        if (root == null) {
            root = item;
        } else {
            root.addItem(item);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    public TreeItem search(TreeItem item) {
        if (root == null) {
            return null;
        } else return root.search(item);
    }

    public TreeItem searchParent(TreeItem item) {
        if (root == null) {
            return null;
        } else return root.searchParent(item);
    }

    public void removeItem(TreeItem item) {
        if (root == null) {
            return;
        } else {
            //1.需求先去找到要删除的结点  targetNode
            TreeItem target = search(item);
            //如果没有找到要删除的结点
            if (target == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }

            //去找到targetNode的父结点
            TreeItem parent = searchParent(item);
            //如果要删除的结点是叶子结点
            if (target.getLeft() == null && target.getRight() == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if (parent.getLeft() != null && parent.getLeft().getE().equals(item.getE())) { //是左子结点
                    parent.setLeft(null);
                } else if (parent.getRight() != null && parent.getRight().getE().equals(item.getE())) {//是由子结点
                    parent.setRight(null);
                }
            } else if (target.getLeft() != null && target.getRight() != null) { //删除有两颗子树的节点
                TreeItem minVal = removeRightTreeMin(target.getRight());
                target.setE(minVal.getE());

            } else { // 删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if (target.getLeft() != null) {
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.getLeft().getE().equals(item.getE())) {
                            parent.setLeft(target.getLeft());
                        } else { //  targetNode 是 parent 的右子结点
                            parent.setRight(target.getLeft());
                        }
                    } else {
                        root = target.getLeft();
                    }
                } else { //如果要删除的结点有右子结点
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.getLeft().getE().equals(item.getE())) {
                            parent.setLeft(target.getRight());
                        } else { //如果 targetNode 是 parent 的右子结点
                            parent.setRight(target.getRight());
                        }
                    } else {
                        root = target.getRight();
                    }
                }

            }

        }
    }

    public TreeItem removeRightTreeMin(TreeItem item) {
        TreeItem target = item;
        //循环的查找左子节点，就会找到最小值
        while(target.getLeft() != null) {
            target = target.getLeft();
        }
        //这时 target就指向了最小结点
        //删除最小结点
        removeItem(target);
        return target;
    }

}
