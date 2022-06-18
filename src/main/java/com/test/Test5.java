package com.test;

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
        System.out.println(solution.simplifyPath("/../"));
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
     * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
     * 请注意，返回的 规范路径 必须遵循下述格式：
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     * @author 44380
     * @date 2022/6/6~23:34
     * @param path 字符串
     * @return java.lang.String
     */
    public String simplifyPath(String path) {
        StringBuilder res=new StringBuilder();
        int deep=0;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)){
                case '/': {
                    if (i+1<path.length() && '/'==path.charAt(i+1)){
                        break;
                    }else{
                        res.append('/');
                        deep++;
                        break;
                    }
                }
                case '.':{
                    if (i+1<path.length() && '.'==path.charAt(i+1)){
                        if (deep!=1){

                        }
                        deep--;
                    }
                    break;
                }
                default:{
                    res.append(path.charAt(i));
                }
            }
        }
        if (res.charAt(res.length()-1) == '/'){
            res.replace(res.length()-1,res.length(),"");
        }
        return res.toString();
    }
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @author 44380
     * @date 2022/6/6~23:26
     * @param nums 数组
     * @param val 值
     * @return int
     */
    public int removeElement(int[] nums, int val) {
        int length=nums.length;
        int t=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==val){
                length--;
            }else {
                nums[t++]=nums[i];
            }
        }
        return length;
    }
    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     * @author 44380
     * @date 2022/6/3~11:06
     * @param nums1 整数数组nums1
     * @param m 整数m
     * @param nums2 整数数组nums2
     * @param n 整数n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @author 44380
     * @date 2022/6/2~1:21
     * @param n 阶
     * @return int
     */
    public int climbStairs(int n) {
        if (n==0 || n==1){
            return 1;
        }else if (n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * @author 44380
     * @date 2022/6/1~23:40
     * @param lists 升序排列链表
     * @return com.test.ListNode 合并后的链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=new ListNode();
        ListNode ope=res;
        // 创建一个标志当前和并的数组
        int i;
        while (true){
            for (i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    break;
                }
            }
            if (i==lists.length){
                return res.next;
            }
            // 找到这个下标
            int val = mergeKLists_find(lists);
            // 添加这个结果进入res
            ListNode process = new ListNode();
            process.val = val;
            ope.next = process;
            ope = process;
            // 判断是否该跳出
            for (i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    break;
                }
            }
        }
    }
    /**
     * 返回当前应该添加的那个链表的下标
     * @author 44380
     * @date 2022/6/1~23:54
     * @param lists lists
     * @return int 下标
     */
    private int mergeKLists_find(ListNode[] lists){
        int min = Integer.MAX_VALUE;
        int resi = 0;
        for (int i = 0; i < lists.length; i++) {
            // 获得当前最小值的下标
            if (lists[i]!=null && lists[i].val < min){
                resi = i;
                min=lists[i].val;
            }
        }
        // 坐标下移
        if (lists[resi]!=null){
            lists[resi] = lists[resi].next;
        }
        return min;
    }

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