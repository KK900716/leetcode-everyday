package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 *
 * @author 44380
 * @date 2022~06~10~0:43
 */
public class Test6 {
    public static void main(String[] args) {

    }
}
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
class Solution0 {
    /**
     * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
     * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
     * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
     * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
     * @author 44380
     * @date 2022/6/18~22:46
     * @param head 任意一个顶点的指针
     * @param insertVal 插入一个新元素
     * @return 原先给定的节点
     */
    public Node insert(Node head, int insertVal) {
        if (head == null){
            head=new Node(insertVal);
            head.next=head;
            return head;
        }
        Node source=head;
        while(true){
            if (head.val <= insertVal){
                if (head.next.val >= insertVal){
                    head.next=new Node(insertVal,head.next);
                    return source;
                }
            }
            if (head.next.val < head.val){
                if (head.val < insertVal || head.next.val > insertVal){
                    head.next=new Node(insertVal,head.next);
                    return source;
                }
            }
            if (head.next == source){
                head.next=new Node(insertVal,head.next);
                return source;
            }
            head=head.next;
        }
    }


    /**
     * 中序遍历
     * @author 44380
     * @date 2022/6/10~12:23
     * @param root 二叉树
     * @return 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
    private List<Integer> list = new ArrayList<>();
}
