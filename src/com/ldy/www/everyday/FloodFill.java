package com.ldy.www.everyday;

import org.junit.Test;

/**
 * 深度优先
 *
 * @author JackLi
 * @date 2020/8/17 14:53
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        int currentColor = image[sr][sc];
        if (currentColor == newColor) return;
        image = flipsColor(image, sr, sc, currentColor, newColor);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] flipsColor(int[][] image, int sr, int sc, int currentColor, int newColor) {
        if (currentColor == image[sr][sc]) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                int ex = sr + dx[i], ey = sc + dy[i];
                if (ex >= 0 && ex < image.length && ey >= 0 && ey < image[0].length) {
                    flipsColor(image, ex, ey, currentColor, newColor);
                }
            }
        }
        return image;
    }

    @Test
    public void test() {
        int[][] arr = new int[3][4];
        arr[0][0] = 1;
        int m = arr.length;
        int n = arr[0].length;
        System.out.println(m);
        System.out.println(n);
    }


}
