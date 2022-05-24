package com.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * untitled：
 * leetcode
 *
 * @author 44380
 * @date 2022~05~03~12:06
 */
public class Test4 {
    public static void main(String[] args) {

    }
    /**
     * com.test.Test4.merge():
     *  以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * @author 44380
     * @date 2022/5/24~13:59
     * @param intervals 若干个区间的集合
     * @return int[][]
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    /**
     * com.test.Test4.canJump():
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * @author 44380
     * @date 2022/5/24~0:58
     * @param nums 非负整数数组
     * @return boolean
     */
    public boolean canJump(int[] nums) {
        int x=nums.length;
        for (int i = 0; i < x; i++) {
            int t=i;
            while (true){
                if (t+1>=nums.length){
                    return true;
                }
                if (nums[t]==0){
                    x=t;
                    break;
                }
                t+=nums[t];
            }
        }
        return false;
    }


    /**
     * com.test.Test4.spiralOrder():
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * @author 44380
     * @date 2022/5/23~23:01
     * @param matrix 矩阵
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        if (m == 0){
            return new ArrayList<>();
        }
        int n=matrix[0].length;
        if (n == 0){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        int x=0;
        int y=0;
        m--;
        while (true){

            if (m==0){
                for (int i = 0; i < n; i++) {
                    list.add(matrix[x][y]);
                    y++;
                }
                break;
            }
            for (int i = 0; i < n; i++) {
                list.add(matrix[x][y]);
                y++;
            }
            y--;
            x++;
            n--;


            if (n==0){
                for (int i = 0; i < m; i++) {
                    list.add(matrix[x][y]);
                    x++;
                }
                break;
            }
            for (int i = 0; i < m; i++) {
                list.add(matrix[x][y]);
                x++;
            }
            x--;
            y--;
            m--;


            if (m==0){
                for (int i = 0; i < n; i++) {
                    list.add(matrix[x][y]);
                    y--;
                }
                break;
            }
            for (int i = 0; i < n; i++) {
                list.add(matrix[x][y]);
                y--;
            }
            y++;
            x--;
            n--;


            if (n==0){
                for (int i = 0; i < m; i++) {
                    list.add(matrix[x][y]);
                    x--;
                }
                break;
            }
            for (int i = 0; i < m; i++) {
                list.add(matrix[x][y]);
                x--;
            }
            x++;
            y++;
            m--;
        }
        return list;
    }











    /**
     * com.test.Test4.divide():
     *
     * @author 44380
     * @date 2022/5/9~10:52
     * @param dividend 被除数
     * @param divisor 除数
     * @return int 结果
     */
    public int divide(int dividend, int divisor) {
        long sum=0;
        boolean f=false;
        long a=dividend;
        long b=divisor;
        if (a<0){
            a=-a;
            f=!f;
        }
        if (b<0){
            b=-b;
            f=!f;
        }
        while(true){
            if (a>=b){
                a-=b;
                sum++;
            }else {
                if (f){
                    return (int)-sum;
                }
                return (int)sum;
            }
        }
    }
}