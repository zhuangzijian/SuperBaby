package LeetCode;

import java.util.Stack;

/*
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Stack<Character> stackd1=new Stack<>();
        Stack<Character> stackd2=new Stack<>();
        for (int i = 0; i <board.length ; i++) {
            Stack<Character> stackh=new Stack<>();
            Stack<Character> stackl=new Stack<>();
            for (int j = 0; j <board[0].length ; j++) {
                if (board[i][j] != '.') {
                    if (!stackh.contains(board[i][j])) {
                        stackd1.push(board[i][j]);
                    }else {
                        return false;
                    }
                    if (!stackl.contains(board[j][i])){
                        stackd1.push(board[j][i]);
                    }else {
                        return false;
                    }
                    if (i==j){
                        if (!stackd1.contains(board[i][j])){
                            stackd1.push(board[i][j]);
                        }else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
}
