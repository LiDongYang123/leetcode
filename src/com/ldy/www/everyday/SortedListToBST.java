package com.ldy.www.everyday;

import org.junit.Test;

/**
 * 有序列表转二叉搜索树
 *
 * @author JackLi
 * @date 2020/8/18 10:42
 */
public class SortedListToBST {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    ListNode globalNode;

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(-10);
        ListNode listNode2 = new ListNode(-3);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        TreeNode treeNode = sortedListToBST(listNode1);
        System.out.println(treeNode.val);
    }

    public TreeNode sortedListToBST(ListNode head) {
        globalNode = head;
        int length = getLength(head);
        TreeNode treeNode = buildTree(0, length - 1);
        return treeNode;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) return null;
        TreeNode treeNode = new TreeNode();
        int min = (left + right) >> 1;
        treeNode.left = buildTree(left, min - 1);
        treeNode.val = globalNode.val;
        globalNode = globalNode.next;
        treeNode.right = buildTree(min + 1, right);
        return treeNode;
    }

    public int getLength(ListNode listNode) {
        int length = 0;
        while (null != listNode) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }


}
