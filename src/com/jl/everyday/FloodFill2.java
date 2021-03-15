package com.jl.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先
 *
 * @author JackLi
 * @date 2020/8/17 14:49
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * <p>
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 * <p>
 * 示例:
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 */
public class FloodFill2 {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        image = flipsColor(image, sr, sc, newColor);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] flipsColor(int[][] image, int sr, int sc, int newColor) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int currentColor = image[sr][sc];
        if (currentColor == newColor) return image;
        image[sr][sc] = newColor;
        int rows = image.length, cols = image[0].length;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int cx = cell[0], cy = cell[1];
            for (int i = 0; i < 4; i++) {
                int ex = cx + dx[i], ey = cy + dy[i];
                if (ex >= 0 && ex < rows && ey >= 0 && ey < cols && image[ex][ey] == currentColor) {
                    queue.offer(new int[]{ex, ey});
                    image[ex][ey] = newColor;
                }
            }
        }
        return image;
    }


}
