package com.ldy.www.everyday;

import org.junit.Test;

/**
 * 扫雷游戏
 *
 * @author JackLi
 * @date 2020/8/20 14:17
 */
public class UpdateBoard {

    @Test
    public void test() {
//        char[][] c = {
//                {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}
//        };
        char[][] c = {
                {'B', '1', 'E', '1', 'B'}, {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'}, {'B', 'B', 'B', 'B', 'B'}
        };
        int[] click = {1, 2};
        char[][] chars = updateBoard(c, click);
        System.out.printf("");
    }

    //上、右上、右、右下、下、左下、左、左上
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        } else {
            return dfs(board, r, c);
        }
    }

    public char[][] dfs(char[][] board, int row, int col) {
        int num = 0;
        for (int i = 0; i < 8; i++) {
            int cr = row + dx[i], cc = col + dy[i];
            if (cr < 0 || cr >= board.length || cc < 0 || cc >= board[0].length) continue;
            if (board[cr][cc] == 'M') num++;
        }
        if (num > 0) {
            board[row][col] = (char) (num + '0');
        } else {
            board[row][col] = 'B';
            for (int i = 0; i < 8; i++) {
                int cr = row + dx[i], cc = col + dy[i];
                if (cr < 0 || cr >= board.length || cc < 0 || cc >= board[0].length || board[cr][cc] != 'E' || board[cr][cc] == 'B') continue;
                dfs(board, cr, cc);
            }
        }
        return board;
    }

}