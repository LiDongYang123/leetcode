package com.jl.middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长回文子串
 * @author JackLi
 * @date 2021/3/15 10:03
 */
public class LongestSubString {


    /**
     * 动态规划
     * 时间复杂度:O(n^2)
     * 空间复杂度：O(n^2)
     * @author JackLi
     * @date 2021/3/15 15:29
     */
    @Test
    public void dynamicProgram(){
        String str = "aaaa";
        int length = str.length();
        boolean[][] dp = new boolean[length][length];
        String result = "";
        for (int k = 0; k < length; k++) {
            for (int i = 0; i+k < length; i++) {
                int j = i + k;
                if (k == 0) {
                    dp[i][j] = true;
                }else if (k == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                }else {
                    dp[i][j] = (dp[i+1][j-1] && str.charAt(i) == str.charAt(j));
                }
                //k+1>reuslt.length ：一次内循环遍历中，不重复设置最长回文子串（或者说是只选第一个找到的最长回文子串）
                if (dp[i][j] && j-i+1 > result.length()){
                    //substring：前闭后开，不包含尾索引，故要加1
                    result = str.substring(i,j+1);
                }
            }
        }
        System.out.println(result);
    }



    /**
     * 中心拓展法
     * 时间复杂度:O(n^2)
     * 空间复杂度：O(1)
     * @author JackLi
     * @date 2021/3/15 12:59
     */
    @Test
    public void centerExpand(){
        String content = "babad";
        int length = content.length();
        int start=0,end=0;
        if (null == content || content.length() == 0) System.out.println("");
        for (int i = 0; i < length-1; i++) {
            int lenOne = expand(content,i,i);
            int lenTwo = expand(content,i,i+1);
            int len = Math.max(lenOne,lenTwo);
            if (len > end-start+1){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        String result = content.substring(start, end + 1);
        System.out.println(result);
    }

    public int expand(String content,int i,int j){
        while (i>=0 && j<content.length() && content.charAt(i) == content.charAt(j)){
            --i;
            ++j;
        }
        return j-i+1-2;
    }







    /**
     * manacher算法
     * @author JackLi
     * @date 2021/3/15 13:51
     */
//    public String manacher(String s) {
//        int start = 0, end = -1;
//        StringBuffer t = new StringBuffer("#");
//        for (int i = 0; i < s.length(); ++i) {
//            t.append(s.charAt(i));
//            t.append('#');
//        }
//        t.append('#');
//        s = t.toString();
//
//        List<Integer> arm_len = new ArrayList<Integer>();
//        int right = -1, j = -1;
//        for (int i = 0; i < s.length(); ++i) {
//            int cur_arm_len;
//            if (right >= i) {
//                int i_sym = j * 2 - i;
//                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
//                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
//            } else {
//                cur_arm_len = expand(s, i, i);
//            }
//            arm_len.add(cur_arm_len);
//            if (i + cur_arm_len > right) {
//                j = i;
//                right = i + cur_arm_len;
//            }
//            if (cur_arm_len * 2 + 1 > end - start) {
//                start = i - cur_arm_len;
//                end = i + cur_arm_len;
//            }
//        }
//
//        StringBuffer ans = new StringBuffer();
//        for (int i = start; i <= end; ++i) {
//            if (s.charAt(i) != '#') {
//                ans.append(s.charAt(i));
//            }
//        }
//        return ans.toString();
//    }
//
//    public int expand(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            --left;
//            ++right;
//        }
//        return (right - left - 2) / 2;
//    }



}
