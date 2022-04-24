package com.test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * untitled：
 * leetcode
 *
 * @author 44380
 * @date 2022~04~18~14:55
 */
public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(Arrays.toString(test3.plusOne(new int[]{9,9,9})));
    }
    public int[] plusOne(int[] digits) {
        boolean j=true;
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i]+1 == 10 && j){
                list.push(0);
            }else {
                list.push(digits[i]+1);
                j = false;
                i--;
                while (i>=0){
                    list.push(digits[i]);
                    i--;
                }
            }
        }
        if (j){
            list.push(1);
        }
        int[] x=new int[list.size()];
        for (int i = 0; i < x.length; i++) {
            x[i]=list.pop();
        }
        return x;
    }
}
