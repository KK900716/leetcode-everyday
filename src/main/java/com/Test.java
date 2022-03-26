package com;

import java.util.*;

public class Test {
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
    //无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0)
            return 0;
        HashSet<Character> hashSet=new HashSet<>();
        int i,j=0,sum=1;
        for ( i=0; i <s.length()-1 ; i++) {
            hashSet.add(s.charAt(i));
            for (j = i+1; j < s.length(); j++) {
                if (hashSet.contains(s.charAt(j))){
                    break;
                }else{
                    hashSet.add(s.charAt(j));
                }
            }
            if (hashSet.size()>sum){
                sum=hashSet.size();
            }
            hashSet.clear();
        }
        return sum;
    }
//    最长回文子串（动态规划）
    public static String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int start=0,length=1;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<3){
                        dp[i][j]=true;
                    }else {
                        if (dp[i+1][j-1]){
                            dp[i][j]=true;
                        }
                    }
                    if (dp[i][j]&&j-i+1>length){
                        start=i;
                        length=j-i+1;
                    }
                }

            }
        }
        return s.substring(start,start+length);
    }
//  Manacher算法
    public static String longestPalindrome2(String s) {
        return null;
    }
//    N字形变换
    public static String convert(String s, int numRows) {
        if (numRows==1)
            return s;
        StringBuffer stringBuffer=new StringBuffer();
        for (int j,i = 0; i < numRows; i++) {
            j=i;
            while (j<s.length()){
                stringBuffer.append(s.charAt(j));
                if (i!=numRows-1&&i!=0&&j+(numRows-2)*2+2-2*i<s.length())
                    stringBuffer.append(s.charAt(j+(numRows-2)*2+2-2*i));
                j+=(numRows-2)*2+2;
            }
        }
        return stringBuffer.toString();
    }
//    整数反转
    public static int reverse(int x) {
        int t;
        if (x<0){
            t=-x;
        }else
            t=x;
        StringBuffer s=new StringBuffer(String.valueOf(t));
        try {
            if (x<0){
                return -Integer.parseInt(String.valueOf(s.reverse()));
            }else
                return Integer.parseInt(String.valueOf(s.reverse()));
        } catch (NumberFormatException e) {
            return 0;
        }

    }
//    字符串转换整数 (atoi)
    public static int myAtoi(String s) {
        long result=0;
        int sign=1;
        boolean state=false;
        boolean state2=false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                if (state||state2)
                    break;
                else
                    continue;
            } else if (s.charAt(i)=='+'){
                if (state2||state)
                    return (int)result*sign;
                sign=1;
                state2=true;
            }
            else if (s.charAt(i)=='-'){
                if (state2||state)
                    return (int)result*sign;
                sign=-1;
                state2=true;
            }
            else if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                result=result*10+s.charAt(i)-48;
                if (sign==-1&&result>Integer.MIN_VALUE*-1L)
                    return Integer.MIN_VALUE;
                else if (sign==1&&result>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                state=true;
            }else
                break;
        }
        return (int)result*sign;
    }
//    回文数
    public static boolean isPalindrome(int x){
        if (x<0)
            return false;
        String s=String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
//    盛最多水的容器
    public static int maxArea(int[] height) {
        int t,area=0,i=0,j=height.length-1,il=i,jl=j;
        while (i<j){
            t=j-i;
            if (height[jl]>height[j]){
                j--;
                continue;
            }
            if (height[il]>height[i]){
                i++;
                continue;
            }
            if (height[i]>height[j]){
                if (t*height[j]>area){
                    area=t*height[j];
                    jl=j;
                }
                j--;
            }else {
                if (t*height[i]>area){
                    area=t*height[i];
                    il=i;
                }
                i++;
            }
        }
        return area;
    }
//    整数转罗马数字
    public static String intToRoman(int num) {
        StringBuffer s=new StringBuffer();
        int i;
        while(num!=0){
            if (num/1000>0){
                i=num/1000;
                for (int j = 0; j < i; j++) {
                    s.append("M");
                }
                num%=1000;
            }else if (num>=900){
                s.append("CM");
                num-=900;
            }else if (num/500>0){
                s.append("D");
                num-=500;
            }else if (num>=400){
                s.append("CD");
                num-=400;
            }else if (num/100>0){
                i=num/100;
                for (int j = 0; j < i; j++) {
                    s.append("C");
                }
                num%=100;
            }else if (num>=90){
                s.append("XC");
                num-=90;
            }else if (num/50>0){
                s.append("L");
                num-=50;
            }else if (num>=40){
                s.append("XL");
                num-=40;
            }else if (num/10>0){
                i=num/10;
                for (int j = 0; j < i; j++) {
                    s.append("X");
                }
                num%=10;
            }else if (num>=9){
                s.append("IX");
                num-=9;
            }else if (num/5>0){
                s.append("V");
                num-=5;
            }else if (num>=4){
                s.append("IV");
                num-=4;
            }else {
                for (int j = 0; j < num; j++) {
                    s.append("I");
                }
                num=0;
            }
        }
        return s.toString();
    }
//    罗马数字转整数
    public static int romanToInt(String s) {
        int x=0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'M':x+=1000;break;
                case 'D':x+=500;break;
                case 'C':
                    if (i+1==s.length()){
                        x+=100;
                        break;
                    }
                    if (s.charAt(i+1)=='M'){
                        x+=900;
                        i++;
                        break;
                    }else if (s.charAt(i+1)=='D'){
                        x+=400;
                        i++;
                        break;
                    }else {
                        x+=100;
                        break;
                    }
                case 'L':x+=50;break;
                case 'X':
                    if (i+1==s.length()){
                        x+=10;
                        break;
                    }
                    if (s.charAt(i+1)=='C'){
                        x+=90;
                        i++;
                        break;
                    }else if (s.charAt(i+1)=='L'){
                        x+=40;
                        i++;
                        break;
                    }else {
                        x+=10;
                        break;
                    }
                case 'V':x+=5;break;
                case 'I':
                    if (i+1==s.length()){
                        x+=1;
                        break;
                    }
                    if (s.charAt(i+1)=='X'){
                        x+=9;
                        i++;
                        break;
                    }else if (s.charAt(i+1)=='V'){
                        x+=4;
                        i++;
                        break;
                    }else {
                        x+=1;
                        break;
                    }
            }
        }
        return x;
    }
//    最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        int i=0,j;
        StringBuffer s=new StringBuffer();
        char t;
        while (true){
            if (i>=strs[0].length())
                return s.toString();
            t=strs[0].charAt(i);
            for (j = 1; j < strs.length; j++) {
                if (i>=strs[j].length())
                    return s.toString();
                if (strs[j].charAt(i)!=t)
                    return s.toString();
            }
            if (j==strs.length)
                s.append(t);
            i++;
        }
    }
//    三数之和
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int i,j,k,il=-1,jl,kl;
        for (i = 0; i < nums.length; i++) {
            if (il!=-1&&nums[il]==nums[i])
                continue;
            il=i;
            j=i+1;
            k=nums.length-1;
            jl=-1;kl=-1;
            while (j<k){
                if (jl!=-1&&nums[j]==nums[jl]&&jl!=j){
                    j++;continue;
                }else if (kl!=-1&&nums[k]==nums[kl]&&kl!=k){
                    k--;continue;
                }
                jl=j;kl=k;
                if (nums[i]+nums[j]+nums[k]==0){
                    ArrayList<Integer> arrayList=new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[j]);
                    arrayList.add(nums[k]);
                    list.add(arrayList);
                    j++;k--;
                }else if (nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else if (nums[i]+nums[j]+nums[k]>0){
                    k--;
                }

            }
        }
        return list;
    }
//    电话号码的字母组合
    public static List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if (digits.equals(""))
            return list;
        String[] strings=new String[]{
                "abc",//2
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz",
        };
        int i=0;
        fun2(strings,digits,i,null,list);
        return list;
    }
    public static String fun(String[] strings,char x){
        return strings[x-50];
    }
    public static void fun2(String[] strings, String digits, int i,StringBuffer s,List<String> list){
        if (i==digits.length()){
            list.add(s.toString());
            return;
        }
        String fun = fun(strings, digits.charAt(i));
        if (s==null)
            s=new StringBuffer();
        StringBuffer s2;
        for (int j = 0; j < fun.length(); j++) {
            s2=new StringBuffer(s);
            s2.append(fun.charAt(j));
            fun2(strings,digits,i+1,s2,list);
        }
    }
//    删除链表的倒数第 N 个结点
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l=head;
        int sum=0;
        while (l!=null){
            sum++;
            l=l.next;
        }
        l=head;
        int i;
        for (i = 0; i < sum - n-1; i++)
            l=l.next;
        if (sum - n-1<0)
            return head.next;
        if (l.next!=null)
            l.next=l.next.next;
        return head;
    }
//    括号生成
    public static List<String> generateParenthesis(int n) {
        int left=n,right=n;
        List<String> list=new ArrayList<>();
        generate(list,left,right,"");
        return list;
    }
    public static List<String> generate(List<String> list,int left,int right,String s){
        if (left==0&&right==0){
            list.add(s);
        }
        if (left>0){
            String s1="";
            s1=s+"(";
            generate(list,left-1,right,s1);
        }
        if (right>0){
            if (right-1<left)
                return list;
            String s1="";
            s1=s+")";
            generate(list,left,right-1,s1);
        }
        return list;
    }
//    括号匹配
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(')
                stack.push(i);
            else if (s.charAt(i)==')'){
                int pop = stack.pop();
                if (stack.size()==0)
                    stack.push(i);
                if (i-stack.peek()>max)
                    max=i-stack.peek();
            }
        }
        return max;
    }
//    二分查找
    public static int search(int[] nums, int target) {
        int min=0,max=nums.length;
        while (min<max){
            if (nums[(max+min)/2]<target){
                min=(max+min)/2+1;
            }else if (nums[(max+min)/2]>target){
                max=(max+min)/2;
            }else if (nums[(max+min)/2]==target){
                return (max+min)/2;
            }
        }
        return -1;
    }
//  第一个错误的版本
    public static boolean isBadVersion(int version){
        if (version<1702766719) return false;//1702766719
        return true;
    }
    public static int firstBadVersion(int n) {
        long x=n,min=0;
        while(x-min>1){
            if(isBadVersion((int)((min+x)/2))){
                x=(min+x)/2;
            }else{
                min=(min+x)/2+1;
            }
        }
        if(isBadVersion((int)min))
            return (int)min;
        return (int)min+1;
    }
//    搜索插入位置
    public static int searchInsert(int[] nums, int target) {
        int min=0,max=nums.length,mid=0;
        while (min<max){
            mid=(max+min)/2;
            if (nums[mid] > target) max = mid;
            else min = mid+1;
        }
        for (int i = min-1; i >= 0; i--) {
            if (nums[i]==target)
                min--;
        }
        return min;
    }
//    TODO 有效的数独
    public static boolean isValidSudoku(char[][] board) {
        int[] row = new int[9], col = new int[9];
        int[] v = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = 1 << (board[i][j] - '0');
                int b = (i / 3) * 3 + j / 3;
                if ((row[i] & num) != 0 || (col[j] & num) != 0 || (v[b] & num) != 0) return false;
                row[i] |= num;
                col[j] |= num;
                v[b] |= num;
            }
        }
        return true;
    }
//    外观数列
    public static String countAndSay(int n) {
        String s="1";
        StringBuilder s0=new StringBuilder();
        int sum;
        for (int i = 1; i < n; i++) {
            sum=1;
            char x= s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j)==x){
                    sum++;
                }else {
                    s0.append(sum);
                    s0.append(x);
                    sum=1;
                    x=s.charAt(j);
                }
            }
            s0.append(sum);
            s0.append(x);
            s=s0.toString();
            s0.delete(0,s0.length());
        }
        return s;
    }
    public static void main(String[] args){
        System.out.println(countAndSay(1));
    }
}
