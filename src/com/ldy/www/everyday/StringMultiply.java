package com.ldy.www.everyday;

import org.junit.Test;

import java.util.Stack;

/**
 * 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @author JackLi
 * @date 2020/8/13 15:24
 */
public class StringMultiply {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "45";
        if (num1.equals("0") || num2.equals("0")) System.out.printf("0");
        int m = num1.length();
        int n = num2.length();
        String result = "0";
        for (int i = n - 1; i >= 0; i--){
            StringBuilder sb = new StringBuilder();
            int add = 0,sum = 0;
            //除了第一个数，后面的数字末尾都要补零
            for (int j = n - 1; j > i; j--)sb.append(0);
            int y = num2.charAt(i) - '0';
            for (int k = m - 1; k >= 0; k--){
                int x = num1.charAt(k) - '0';
                sum = x * y + add;
                sb.append(sum % 10);
                add = sum / 10;
            }
            if (add != 0){
                sb.append(add);
            }
            result = addStrings(result,sb.reverse().toString());
        }
        System.out.println(result);
    }

    public static String addStrings(String num1,String num2){
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int add = 0,sum = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0 || add != 0){
            int x = m >= 0 ? num1.charAt(m) - '0' : 0;
            int y = n >= 0 ? num2.charAt(n) - '0' : 0;
            sum = x + y + add;
            sb.append(sum % 10);
            add = sum / 10;
            m--;
            n--;
        }
        sb.reverse();
        return sb.toString();
    }

    @Test
    public void test(){
        String a = "2";
        //不行
        //int b = Integer.parseInt(a.charAt(0));
        //System.out.println(b);
    }

}
