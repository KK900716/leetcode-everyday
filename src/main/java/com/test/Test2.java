package com.test;

import java.io.Serializable;
import java.util.*;

public class Test2 implements Serializable {
    public void test(){
        System.out.println("success!");
    }
//    二叉树的所有节点 TODO 这题有问题
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> strings=new ArrayList<>();
        deepFun(root,strings,new StringBuffer());
        return strings;
    }
    private void deepFun(TreeNode root,List<String> strings,StringBuffer s) {
        if (root!=null){
            s.append(root.val).append("->");
            if (root.left!=null&&root.right!=null){
                deepFun(root.left,strings,new StringBuffer(s));
                deepFun(root.right,strings,new StringBuffer(s));
            }else if (root.left==null&&root.right!=null){
                deepFun(root.right,strings,new StringBuffer(s));
            }else if (root.left!=null){
                deepFun(root.left,strings,new StringBuffer(s));
            }else {
                strings.add(s.substring(0,s.length()-2));
            }
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//    组合总和
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
//    缺失的正整数
    public static int firstMissingPositive(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i]<=0){
                nums[i]=nums.length+1;
            }
        }
        for (i = 0; i < nums.length; i++) {
            int t=Math.abs(nums[i]);
            if (t<=nums.length){
                nums[t-1]=-Math.abs(nums[t-1]);
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return i+1;
            }
        }
        return i+1;
    }
//    字符串相乘
    public String multiply(String num1, String num2) {
        int x,jw;
        StringBuilder s=new StringBuilder();
        StringBuilder sum=new StringBuilder();
        for (int i = num2.length()-1; i >= 0 ; i--) {
            jw=0;
            s.delete(0,s.length());
            s.append("0".repeat(num2.length()-i-1));
            for (int j = num1.length()-1; j >= 0 ; j--) {
                x=(num1.charAt(j)-48)*(num2.charAt(i)-48)+jw;
                jw=x/10;
                s.insert(0,x%10);
            }
            if (jw!=0){
                s.insert(0,jw);
                jw=0;
            }
            int a=sum.length();
            int t= Math.max(sum.length(), s.length())-1;
            for (int j = t; j >= 0; j--) {
                if (j>=a){
                    sum.insert(0,s.charAt(j)-48);
                }else {
                    if (j<s.length()){
                        x=s.charAt(j)+sum.charAt(j)+jw-96;
                    }else {
                        x=sum.charAt(j)+jw-48;
                    }
                    jw=x/10;
                    sum.replace(j,j+1, String.valueOf(x%10));
                }
            }
            if (jw!=0){
                sum.insert(0,jw);
            }
        }
        if (sum.length()==1)
            return sum.toString();
        while (sum.charAt(0)==48){
            sum.delete(0,1);
            if (sum.length()==1){
                break;
            }
        }
        return sum.toString();
    }
    public static void main(String[] args) {
        Test2 test2=new Test2();
        System.out.println(test2.multiply("237","284"));
    }
//    public static void main(String[] args) {
//        Test2 test2=new Test2();
//        TreeNode treeNode= new TreeNode();
//        treeNode.val=1;
//        treeNode.left= new TreeNode();
//        treeNode.left.val=2;
//        treeNode.right= new TreeNode();
//        treeNode.right.val=3;
//        treeNode.left.right= new TreeNode();
//        treeNode.left.right.val=5;
//        List<String> list = test2.binaryTreePaths(treeNode);
//        System.out.println(list);
//    }

}
