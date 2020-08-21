package com.ldy.www.everyday;

import org.junit.Test;

public class CountSubstrings {

    @Test
    public void test() {
        String alphaBet = "aba";
        int i = countSubstrings(alphaBet);
        System.out.println(i);
    }

    public int countSubstrings(String s) {
        int sum = 0,sum1 = 0,sum2 = 0;
        for (int i = 0; i < s.length(); i++){
            //奇数长度的回文中心
            sum1 = countSubstrings(s,i,i);
            sum2 = countSubstrings(s,i,i+1);
            sum = sum + sum1 + sum2;
        }
        return sum;
    }


    public int countSubstrings(String s,int i,int j){
        int res = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            res++;
        }
        return res;
    }

    @Test
    public void test2(){
        int a = 10;
        char b = (char) (a - '0');
        char c = (char) (a + '0');
        System.out.println();
    }
}
