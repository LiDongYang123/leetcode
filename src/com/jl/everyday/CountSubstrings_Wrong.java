package com.jl.everyday;

import org.junit.Test;

public class CountSubstrings_Wrong {

    @Test
    public void test() {
        String alphaBet = "aba";
        int i = countSubstrings(alphaBet);
        System.out.println(i);
    }

    public int countSubstrings(String s) {
        int sum = s.length();
        if (sum > 1) {
            String str = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                str += s.charAt(i);
            }
            if (s.equals(str)) {
                sum++;
            }
        }
        for (int scale = 2; scale <= s.length(); scale++) {
            sum += countSubstrings(s, scale);
        }
        return sum;
    }

    public int countSubstrings(String s, int scale) {
        String currentStr, frontStr, backStr;
        int sum = 0;
        for (int i = scale - 1; i < s.length() - scale + 1; i++) {
            //currentStr = s.substring(i,scale - 1);
            frontStr = s.substring(i - 1, i);
            backStr = s.substring(i + 1, i + 2);
            if (frontStr.equals(backStr)) {
                sum ++;
            }
        }
        return sum;
    }

    @Test
    public void test2() {
        String a = "121";
        String substring1 = a.substring(0, 1);
        String substring2 = a.substring(2, 3);
        if (substring1.equals(substring2)) {
            System.out.println("1111");
        }
    }
}
