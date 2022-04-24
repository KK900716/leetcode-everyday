package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * untitled：
 * leetcode
 *
 * @author 44380
 * @date 2022~04~18~14:55
 */
public class Test3 {

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
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        int sum,i=0,t,ty,js;
        boolean p=true;
        while(i<words.length&&p){
            sum=0;
            js=0;
            while(sum-1<maxWidth&&i<words.length){
                sum+=words[i].length()+1;
                js++;
                i++;
            }
            sum-=words[i-1].length()+js;
            if (js-2!=0){
                t=(maxWidth-sum)/(js-2);
                ty=(maxWidth-sum)%(js-2);
                int j;
                for (j = i-js; j < i-2; j++) {
                    stringBuilder.append(words[j]);
                    if (ty>0){
                        stringBuilder.append(" ");
                        ty--;
                    }
                    stringBuilder.append(" ".repeat(Math.max(0, t)));
                }
                stringBuilder.append(words[j]);
            }else {
                stringBuilder.append(words[i-2]);
            }
            if (list.size()>0&&list.get(list.size()-1).trim().equals(stringBuilder.toString())){
                break;
            }
            if (stringBuilder.length()<maxWidth){
                js=maxWidth-stringBuilder.length();
                stringBuilder.append(" ".repeat(Math.max(0, js)));
            }
            list.add(stringBuilder.toString());
            stringBuilder.delete(0,stringBuilder.length());
            i--;
        }
        return list;
    }
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(test3.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16));
    }
}
