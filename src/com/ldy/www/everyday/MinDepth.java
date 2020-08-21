package com.ldy.www.everyday;

import org.junit.Test;

/**
 * 深度优先
 * @author JackLi
 * @date 2020/8/21 15:35
 */
public class MinDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);
        root.left = new TreeNode(1);

        int i = minDepth(root);
        System.out.println(i);
    }


    public int minDepth(TreeNode root) {

        if (null == root) return 0;
        if (null == root.left && null == root.right) return 1;

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;


    }

}
