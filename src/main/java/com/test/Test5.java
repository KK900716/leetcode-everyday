package com.test;

import java.util.ArrayList;

/**
 * untitled：
 * leetcode
 * @author 44380
 * @date 2022~05~30~22:40
 */
public class Test5 {
    /**
     * com.test.Test5.main():
     * @author 44380
     * @date 2022/5/30~22:41
     * @param args args
     */
    public static void main(String[] args) {

    }
}
/**
 * untitled：
 * Solution
 * @author 44380
 * @date 2022~05~30~22:40
 */
class Solution {
    /**
     * com.test.Solution.rotateRight():
     * @author 44380
     * @date 2022/5/30~22:48
     * @param head 头结点
     * @param k 旋转度
     * @return com.test.ListNode
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode h=head;
        int length=0;
        while (h.next!=null){
            h=h.next;
            length++;
        }
        int p=k%(length+1);
        if (p==0){
            return head;
        }
        h.next=head;
        for (int i = 0; i < length-p; i++) {
            head=head.next;
        }
        h=head.next;
        head.next=null;
        return h;
    }
}
/**
 * untitled：
 * Definition for singly-linked list.
 * @author 44380
 * @date 2022~05~30~22:40
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}