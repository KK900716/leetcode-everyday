package com.test;

import java.util.ArrayList;
import java.util.Arrays;

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
        Solution solution=new Solution();
        int[][] ints = solution.generateMatrix(5);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
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
     * com.test.Solution.generateMatrix():
     *  给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * @author 44380
     * @date 2022/5/30~23:45
     * @param n 正整数n
     * @return int[][] 正方形矩阵
     */
    public int[][] generateMatrix(int n) {
        if (n==1){
            return new int[][]{{1}};
        }
        int[][] res=new int[n][n];
        int x=1;
        int h=n,v=n-2;
        int i=0;
        int j=0;
        int k;
        while (true){
            if (res[i][j]!=0){
                return res;
            }
            for (k = 0; k < h; k++) {
                res[i][j++]=x++;
            }
            j--;
            i++;

            if (res[i][j]!=0){
                return res;
            }
            for (k = 0; k < v; k++) {
                res[i++][j]=x++;
            }

            if (res[i][j]!=0){
                return res;
            }
            for (k = 0; k < h; k++) {
                res[i][j--]=x++;
            }
            j++;
            i--;
            h-=2;

            if (res[i][j]!=0){
                return res;
            }
            for (k = 0; k < v; k++) {
                res[i--][j]=x++;
            }
            j++;
            i++;
            v-=2;
        }
    }
    /**
     * com.test.Solution.rotateRight():
     * 链表右移
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