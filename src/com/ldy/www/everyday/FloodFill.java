package com.ldy.www.everyday;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1,sc = 1,newColor = 2;
        image = flipsColor(image,sr,sc,2);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] flipsColor(int[][] image,int sr,int sc,int newColor){
        int currentColor = image[sr][sc];
        if (currentColor == newColor)return image;
        image[sr][sc] = newColor;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{sr,sc});
        int m = image.length,n = image[0].length;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0],y = poll[1];
            for (int i = 0; i < 4; i++){
                int mx = x + dx[i],my = y + dy[i];
                if (mx >= 0 && mx < m && my >= 0 && my < n && image[mx][my] == currentColor){
                    queue.offer(new int[]{mx,my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }

    @Test
    public void test(){
        int[][] arr = new int[3][4];
        arr[0][0] = 1;
        int m = arr.length;
        int n = arr[0].length;
        System.out.println(m);
        System.out.println(n);
    }


}
