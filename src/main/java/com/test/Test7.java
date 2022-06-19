package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * test
 *
 * @author 44380
 * @date 2022~06~19~19:39
 */
public class Test7 {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null){
                return new int[0];
            }
            HashMap<Integer,Integer> hashMap=new HashMap<>();
            dps(root,hashMap);
            Set<Integer> set = hashMap.keySet();
            int max=Integer.MIN_VALUE;
            for (int x:set){
                if (hashMap.get(x) > max){
                    max=hashMap.get(x);
                }
            }
            ArrayList<Integer> arrayList=new ArrayList<>();
            for (int x:set){
                if (hashMap.get(x) == max){
                    arrayList.add(x);
                }
            }
            int[] res=new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                res[i] = arrayList.get(i);
            }
            return res;
        }
        private int dps(TreeNode root,HashMap<Integer,Integer> hashMap){
            if (root == null){
                return 0;
            }
            int max= root.val + dps(root.left,hashMap) + dps(root.right,hashMap);
            if (hashMap.containsKey(max)) {
                hashMap.put(max, 1 + hashMap.get(max));
            }else {
                hashMap.put(max, 1);
            }
            return max;
        }
    }
}
