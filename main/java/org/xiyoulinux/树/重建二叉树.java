package org.xiyoulinux.树;

/**
 * @Author: spider_hgyi
 * @Date: Create in 9:38 2018/3/31
 * @Modified By:
 * @Description: 根据先序、中序 | 中序、后序进行二叉树的构建
 */
class Node {
    int data;
    Node leftNode;
    Node rightNode;
}

public class 重建二叉树 {
    public static void main(String[] args) throws Exception {
         int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
         int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
         int[] epiOrder = {7, 4, 2, 5, 8, 6, 3, 1};

         // 根据先序、中序进行二叉树的构建
//         Node root = construct(preOrder, inOrder, preOrder.length);

         // 根据中序、后序进行二叉树的创建
         Node root = construct(inOrder, epiOrder, inOrder.length);

         printTree(root);
    }

    // 根据先序、中序进行二叉树的构建
//    public static Node construct(int[] preOrder, int[] inOrder, int length) throws Exception {
//        if (preOrder == null || inOrder == null || length <= 0) {
//            throw new Exception("order is illegal");
//        }
//
//        // 重建二叉树的核心代码
//        return constructCore(preOrder, 0, length - 1, inOrder,
//                0, length -1);
//    }

    // 根据先序、中序进行二叉树的构建
//    public static Node constructCore(int[] preOrder, int startPreOrder, int endPreOrder,
//                                     int[] inOrder, int startInOrder, int endInOrder) throws Exception {
//        // 创建根节点
//        int rootValue = preOrder[startPreOrder];
//        Node root = new Node();
//        root.data = rootValue;
//
//        // 在中序序列中找到当前root节点，确定左右子树
//        int rootIndexAtInOrder = -1;
//        for (int i = startInOrder; i <= endInOrder; i++) {
//            if (rootValue == inOrder[i]) {
//                rootIndexAtInOrder = i;
//                break;
//            }
//        }
//
//        // 如果先序序列中的节点在中序序列中没有出现，则说明输入的节点有问题
//        if (rootIndexAtInOrder == -1) {
//            throw new Exception("order is illegal");
//        }
//
//        // 计算左子树的节点数 | 右子树的节点数
//        int leftNodeCount = rootIndexAtInOrder - startInOrder;
//        int rightNodeCount = endInOrder - rootIndexAtInOrder;
//
//        // 左子树的节点数大于0的时候递归创建左子树（递归退出条件）
//        if (leftNodeCount > 0) {
//            // 确定左子树先序序列的范围
//            int endPreOrderLeft = startPreOrder + leftNodeCount;
//            int startPreOrderLeft = startPreOrder + 1;
//
//            // 确定左子树中序序列的范围
//            int startInOrderLeft = rootIndexAtInOrder - leftNodeCount;
//            int endInOrderLeft = rootIndexAtInOrder - 1;
//            root.leftNode = constructCore(preOrder, startPreOrderLeft, endPreOrderLeft,
//                    inOrder, startInOrderLeft, endInOrderLeft);
//        }
//
//        // 右子树的节点数大于0的时候递归创建右子树（递归退出条件）
//        if (rightNodeCount > 0) {
//            // 确定右子树先序序列的范围
//            int startPreOrderRight = endPreOrder - rightNodeCount + 1;
//            int endPreOrderRight = startPreOrderRight + rightNodeCount - 1;
//
//            // 确定右子树中序序列的范围
//            int startInOrderRight = rootIndexAtInOrder + 1;
//            int endInOrderRight = rootIndexAtInOrder + rightNodeCount;
//            root.rightNode = constructCore(preOrder, startPreOrderRight, endPreOrderRight,
//                    inOrder, startInOrderRight, endInOrderRight);
//        }
//
//        return root;
//    }

    // 根据中序、后序进行二叉树的构建
    public static Node construct(int[] inOrder, int[] epiOrder, int length) throws Exception {
        if (inOrder == null || epiOrder == null || length <= 0) {
            throw new Exception("order is illegal");
        }

        // 重建二叉树的核心代码
        return constructCore(inOrder, 0, length - 1, epiOrder,
                0, length -1);
    }

    public static Node constructCore(int[] inOrder, int startInOrder, int endInOrder,
                                     int[] epiOrder, int startEpiOrder, int endEpiOrder) throws Exception {
        int rootValue = epiOrder[endEpiOrder];
        Node root = new Node();
        root.data = rootValue;

        int rootIndexAtInOrder = -1;
        for (int i = 0; i <= endInOrder; i++) {
            if (inOrder[i] == rootValue) {
                rootIndexAtInOrder = i;
                break;
            }
        }

        if (rootIndexAtInOrder == -1) {
            throw new Exception("order is illegal");
        }

        int leftNodeCount = rootIndexAtInOrder - startInOrder;
        int rightNodeCount = endInOrder - rootIndexAtInOrder;

        if (leftNodeCount > 0) {
            int endEpiOrderLeft = startEpiOrder + leftNodeCount - 1;
            int startInOrderLeft = rootIndexAtInOrder - leftNodeCount;
            int endInOrderLeft = startInOrderLeft + leftNodeCount - 1;

            root.leftNode = constructCore(inOrder, startInOrderLeft, endInOrderLeft, epiOrder, startEpiOrder, endEpiOrderLeft);
        }

        if (rightNodeCount > 0) {
            int startEpiOrderRight = endEpiOrder - rightNodeCount;
            int endEpiOrderRight = startEpiOrderRight + rightNodeCount - 1;
            int startInOrderRight = rootIndexAtInOrder + 1;
            int endInOrderRight = startInOrderRight + rightNodeCount - 1;

            root.rightNode = constructCore(inOrder, startInOrderRight, endInOrderRight, epiOrder, startEpiOrderRight, endEpiOrderRight);
        }

        return root;
    }

    public static void printTree(Node root) {
        if (root != null) {
            printTree(root, 1);
        }
    }

    public static void printTree(Node root, int h) {
        if (root != null) {
            printTree(root.rightNode, h + 1);
            for (int i = 0; i < h; i++) {
                System.out.print("   ");
            }
            System.out.println(root.data);
            printTree(root.leftNode, h + 1);
        }
    }
}