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

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
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
