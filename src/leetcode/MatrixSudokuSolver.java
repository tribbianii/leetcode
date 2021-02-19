package leetcode;

import java.util.*;

public class MatrixSudokuSolver {
    public List<Set<Character>> rows = new ArrayList<Set<Character>>();
    public List<Set<Character>> cols = new ArrayList<Set<Character>>();
    public List<Set<Character>> boxes = new ArrayList<Set<Character>>();
    public boolean solved;
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            boxes.add(new HashSet<Character>());
        }
        int unfilled = 81;
        for (int row = 0; row < 9; row ++) {
            for (int col = 0; col < 9; col ++) {
                char c = board[row][col];
                if (c != '.') {
                    unfilled --;
                    rows.get(row).add(c);
                    cols.get(col).add(c);
                    boxes.get((row / 3) * 3 + (col / 3)).add(c);
                }
            }
        }
        dfs(board, 0, 0, unfilled);
    }
    public void dfs(char[][] board, int row, int col, int unfilled) {
        if (unfilled == 0) {
            solved = true;
            return;
        }
        if (board[row][col] != '.') {
            dfs(board, col == 8 ? row + 1 : row, col == 8 ? 0 : col + 1, unfilled);
        } else {
            Set<Character> rowSet = rows.get(row);
            Set<Character> colSet = cols.get(col);
            Set<Character> boxSet = boxes.get((row / 3) * 3 + (col / 3));
            List<Character> available = new ArrayList<>();
            for (char c = '1'; c <= '9'; c ++) {
                if (!rowSet.contains(c) && !colSet.contains(c) && !boxSet.contains(c)) {
                    available.add(c);
                }
            }
            for (int i = 0; i < available.size(); i ++) {
                char h = available.get(i);
                board[row][col] = h;
                rowSet.add(h);
                colSet.add(h);
                boxSet.add(h);
                dfs(board, col == 8 ? row + 1 : row, col == 8 ? 0 : col + 1, unfilled - 1);
                if (solved) {
                    return;
                }
                board[row][col] = '.';
                rowSet.remove(h);
                colSet.remove(h);
                boxSet.remove(h);
            }
        }
    }
}