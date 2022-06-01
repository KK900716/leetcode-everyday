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
        int[] ints = {
                0, 0, 1, 1, 1, 2, 2, 3, 3, 4
        };
        int i = solution.removeDuplicates(ints);
        System.out.println(i);
        System.out.println(Arrays.toString(ints));
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
     * com.test.Solution.removeDuplicates():
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
     * 将最终结果插入 nums 的前 k 个位置后返回 k 。
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @author 44380
     * @date 2022/6/1~18:38
     * @param nums
     * @return int
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int t=nums[0];
        int sum=nums.length;
        int j=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==t){
                sum--;
            }else {
                nums[j++]=nums[i];
            }
            t=nums[i];
        }
        return sum;
    }
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