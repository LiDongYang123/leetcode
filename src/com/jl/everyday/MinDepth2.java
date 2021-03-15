package com.jl.everyday;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先
 * @author JackLi
 * @date 2020/8/21 15:35
 */
public class MinDepth2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class QueueTreeNode{
        TreeNode treeNode;
        int depth;
        public QueueTreeNode(TreeNode treeNode,int depth){
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.left = new TreeNode(1);
        int i = minDepth(root);
        System.out.println(i);
    }


    public int minDepth(TreeNode root) {
        if (null == root)return 0;
        int minDepth = 0;
        Queue<QueueTreeNode> treeNodeQueue = new LinkedList();
        QueueTreeNode queueTreeNode = new QueueTreeNode(root,1);
        TreeNode treeNode;
        treeNodeQueue.offer(new QueueTreeNode(root,1));
        while (!treeNodeQueue.isEmpty()){
            queueTreeNode = treeNodeQueue.poll();
            treeNode = queueTreeNode.treeNode;
            minDepth = queueTreeNode.depth;
            if (null == treeNode.left && null == treeNode.right) return minDepth;
            if (null != treeNode.left)  treeNodeQueue.offer(new QueueTreeNode(treeNode.left,minDepth + 1));
            if (null != treeNode.right) treeNodeQueue.offer(new QueueTreeNode(treeNode.right,minDepth + 1));
        }
        return minDepth;
    }

}
