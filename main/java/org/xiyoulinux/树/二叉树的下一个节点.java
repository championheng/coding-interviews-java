package org.xiyoulinux.树;
/**
 * @Author: spider_hgyi
 * @Date: Create in 20:28 2018/3/31
 * @Modified By:
 * @Description: 按中序遍历顺序查找一个树节点的下一个节点
 *
 * 实现思想：
 * 1. 先分两种情况：有右子树和无右子树的
 * 2. 再分开讨论有右子树与无右子树的情况
 * 3. 有右子树的只有一种情况：中序遍历结果中的下一个节点就是右子树中的最左子节点
 *
 * 4. 无右子树的有两种情况：
 * （1）当前节点是其父节点的左孩子，则下一个节点就是父节点
 * （2）当前节点是其父节点的右孩子，则下一个节点--向父节点上不断回溯，直到找到一个节点是
 *  其父节点的左孩子，则这个父节点就是下一个节点
 */

class TreeNode {
    int data;
    TreeNode parentNode;
    TreeNode leftNode;
    TreeNode rightNode;
}

public class 二叉树的下一个节点 {
    private static int index = -1;

    public static void main(String[] args) throws Exception {
        // 先序构建二叉树的测试用例
        int array[] = {1, 2, 4, -1, -1, 5, 8, -1, -1, 9, -1, -1, 3, 6, -1, -1, 7, -1, -1};

        TreeNode root = create(array);

        TreeNode node = getNextNode(root);

        System.out.println(node.data);
    }

    // 构建一颗带有指向父节点功能的二叉树
    public static TreeNode create(int[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }

        TreeNode root = create(null, array);

        return root;
    }

    public static TreeNode create(TreeNode parentNode, int[] array) {
        TreeNode root = null;

        index++;
        int data = array[index];
        if (data != -1) {
            root = new TreeNode();
            root.data = data;
            root.parentNode = parentNode;
            root.leftNode = create(root, array);
            root.rightNode = create(root, array);
        }

        return root;
    }

    // 得到二叉树的下一个节点
    public static TreeNode getNextNode(TreeNode currentNode) throws Exception {
        if (currentNode == null) {
            throw new Exception("currentNode is null");
        }

        TreeNode nextNode = null;
        TreeNode parentNode = null;

        // 有右子树
        if (currentNode.rightNode != null) {
            nextNode = currentNode.rightNode;
            while (nextNode.leftNode != null) {
                nextNode = nextNode.leftNode;
            }
        } else {
            parentNode = null;
            if (currentNode.parentNode != null) {
                parentNode = currentNode.parentNode;
                // 父节点的左孩子
                if (currentNode == parentNode.leftNode) {
                    nextNode = parentNode;
                } else {
                    // 回溯到父节点为空为止直到当前节点是父节点的左孩子
                    while (parentNode != null && currentNode != parentNode.leftNode) {
                        currentNode = parentNode;
                        parentNode = currentNode.parentNode;
                    }

                    // 下一个节点是其父节点
                    nextNode = parentNode;
                }
            }
        }

        return nextNode;
    }
}