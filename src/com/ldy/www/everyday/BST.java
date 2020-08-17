package com.ldy.www.everyday;

/**
 * 平衡二叉树
 *
 * @author JackLi
 * @date 2020/8/17 15:54
 */
public class BST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        return balance(root) >= 0;
    }

    public int balance(TreeNode node) {
        if (null == node) return 0;
        int leftHeight, rightHeight;
        if ((leftHeight = balance(node.left)) == -1 || (rightHeight = balance(node.right)) == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


}
