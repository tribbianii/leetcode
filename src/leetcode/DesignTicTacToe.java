package leetcode;

import java.util.Arrays;

public class DesignTicTacToe {

    static class Cell{
        int player;
        int vertical_num;
        int horizontal_num;
        int upRight_num;
        int upLeft_num;
        Cell(int player_id) {
            this.player = player_id;
        }
    }

    Cell[][] board;
    int length;

    public DesignTicTacToe(int n) {
        this.board = new Cell[n][n];
        this.length = n;
    }

    public boolean checkVertical(Cell cell, int row, int col, int player) {
        int up_num = (row - 1 >= 0 && board[row - 1][col] != null && board[row - 1][col].player == player) ? board[row - 1][col].vertical_num : 0;
        int down_num = (row + 1 < length && board[row + 1][col] != null && board[row + 1][col].player == player) ? board[row + 1][col].vertical_num : 0;
        cell.vertical_num = up_num + down_num + 1;
        return cell.vertical_num >= length;
    }

    public void updateVertical(Cell cell, int row, int col, int player) {
        int x = row;
        while ((x - 1) >= 0 && board[x - 1][col] != null && board[x - 1][col].player == player) {
            board[x - 1][col].vertical_num = cell.vertical_num;
            x --;
        }
        x = row;
        while ((x + 1) < length && board[x + 1][col] != null && board[x + 1][col].player == player) {
            board[x + 1][col].vertical_num = cell.vertical_num;
            x ++;
        }
    }

    public boolean checkHorizontal(Cell cell, int row, int col, int player) {
        int left_num = (col - 1 >=0 && board[row][col - 1] != null && board[row][col - 1].player == player) ? board[row][col - 1].horizontal_num : 0;
        int right_num = (col + 1 < length && board[row][col + 1] != null && board[row][col + 1].player == player) ? board[row][col + 1].horizontal_num : 0;
        cell.horizontal_num = left_num + right_num + 1;
        return cell.horizontal_num >= length;
    }

    public void updateHorizontal(Cell cell, int row, int col, int player) {
        int y = col;
        while ((y - 1) >= 0 && board[row][y - 1] != null && board[row][y - 1].player == player) {
            board[row][y - 1].horizontal_num = cell.horizontal_num;
            y --;
        }
        y = col;
        while ((y + 1) < length && board[row][y + 1] != null && board[row][y + 1].player == player) {
            board[row][y + 1].horizontal_num = cell.horizontal_num;
            y ++;
        }
    }

    public boolean checkUpRight(Cell cell, int row, int col, int player) {
        int upRight_num = (row - 1 >= 0 && col + 1 < length && board[row - 1][col + 1] != null && board[row - 1][col + 1].player == player) ? board[row - 1][col + 1].upRight_num : 0;
        int downLeft_num = (row + 1 < length && col - 1 >= 0 && board[row + 1][col - 1] != null && board[row + 1][col - 1].player == player) ? board[row + 1][col - 1].upRight_num : 0;
        cell.upRight_num = upRight_num + downLeft_num + 1;
        return cell.upRight_num >= length;
    }

    public void updateUpRight(Cell cell, int row, int col, int player) {
        int x = row;
        int y = col;
        while ((x - 1) >= 0 && y + 1 < length && board[x - 1][y + 1] != null && board[x - 1][y + 1].player == player) {
            board[x - 1][y + 1].upRight_num = cell.upRight_num;
            x --;
            y ++;
        }
        x = row;
        y = col;
        while ((x + 1) < length && y - 1 >= 0 && board[x + 1][y - 1] != null && board[x + 1][y - 1].player == player) {
            board[x + 1][y - 1].upRight_num = cell.upRight_num;
            x ++;
            y --;
        }
    }

    public boolean checkUpLeft(Cell cell, int row, int col, int player) {
        int upLeft_num = (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] != null && board[row - 1][col - 1].player == player) ? board[row - 1][col - 1].upLeft_num : 0;
        int downRight_num = (row + 1 < length && col + 1 < length && board[row + 1][col + 1] != null && board[row + 1][col + 1].player == player) ? board[row + 1][col + 1].upLeft_num : 0;
        cell.upLeft_num = upLeft_num + downRight_num + 1;
        return cell.upLeft_num >= length;
    }

    public void updateUpLeft(Cell cell, int row, int col, int player) {
        int x = row;
        int y = col;
        while ((x - 1) >= 0 && y - 1 >= 0 && board[x - 1][y - 1] != null && board[x - 1][y - 1].player == player) {
            board[x - 1][y - 1].upLeft_num = cell.upLeft_num;
            x --;
            y --;
        }
        x = row;
        y = col;
        while ((x + 1) < length && y + 1 < length && board[x + 1][y + 1] != null && board[x + 1][y + 1].player == player) {
            board[x + 1][y + 1].upLeft_num = cell.upLeft_num;
            x ++;
            y ++;
        }
    }

    public int move(int row, int col, int player) {
        board[row][col] = new Cell(player);
        Cell cell = board[row][col];
        if (checkVertical(cell, row, col, player) ||
                checkHorizontal(cell, row, col, player) ||
                checkUpRight(cell, row, col, player) ||
                checkUpLeft(cell, row, col, player)) {
            return player;
        }
        updateVertical(cell, row, col, player);
        updateHorizontal(cell, row, col, player);
        updateUpRight(cell, row, col, player);
        updateUpLeft(cell, row, col, player);
        return 0;
    }
}
