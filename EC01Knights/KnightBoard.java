import java.util.*;
public class KnightBoard {
    private int[][] board, behind, moveSet;
    private int[] count = {2,3,4,6,8};
    
    public KnightBoard(int rows, int cols) {
        moveSet = new int[2][8];
        
        int[] x = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] y = {-2, -1, 1, 2, 2, 1, -1, -2};
        
        moveSet[0] = x;
        moveSet[1] = y;
        try {
            board = new int[rows][cols];
            behind = new int[rows][cols];
        } catch (NegativeArraySizeException e) {
            throw new IllegalArgumentException();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = 0;
                int num = 0;
                for (int index = 0; index < moveSet[0].length; index++) {
                    try {
                        if (board[row + moveSet[0][index]][col + moveSet[1][index]] != -1) {}
                        num++;
                    } catch (IndexOutOfBoundsException e) {}
                }
                behind[row][col] = num;
            }
        }
        
        /*
        moveSet = { 
        {-1, -2}, 
        {1, -2}, 
        {-2, -1}, 
        {2, -1}, 
        {-2, 1}, 
        {2, 1}, 
        {-1, 2}, 
        {1, 2}
        }; 
        */
    }
    
    public boolean solveFast(int startingRow, int startingCol) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        try {
            if (board[startingRow][startingCol] == 0) {
                
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        return solveFast(startingRow, startingRow, 1);
    }
    
    private boolean solveFast(int startingRow, int startingCol, int knights) {
        if (knights == board.length * board[0].length) {
            if (board[startingRow][startingCol] == 0) {
                board[startingRow][startingCol] = knights;
            }
            return true;
        }
        for (int num = 0; num < count.length; num++) {
            for (int x = 0; x < moveSet[0].length; x++) {
                int r = startingRow + moveSet[0][x];
                int c = startingCol + moveSet[1][x];
                try {
                    if (behind[r][c] == count[num] && board[r][c] == 0) {
                        int temp = behind[startingRow][startingCol] + 0;
                        behind[startingRow][startingCol] = knights;
                        board[startingRow][startingCol] = knights;
                        //System.out.println(Text.go(1,1));
                        //Text.go(1,1);
                        System.out.println(this);
                        //Text.wait(10); //adjust this delay
                        if (solve(r, c, knights+1)) {
                            return true;
                        }
                        behind[startingRow][startingCol] = temp;
                        board[startingRow][startingCol] = 0;
                    }
                } catch (IndexOutOfBoundsException e) {}
            }
        }
        return false;
    }
    
    public boolean solve(int startingRow, int startingCol) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        try {
            if (board[startingRow][startingCol] == 0) {
                
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        return solve(startingRow, startingRow, 1);
    }
    
    private boolean solve(int startingRow, int startingCol, int knights) {
        if (knights == board.length * board[0].length) {
            if (board[startingRow][startingCol] == 0) {
                board[startingRow][startingCol] = knights;
            }
            return true;
        }
        for (int x = 0; x < moveSet[0].length; x++) {
            int r = startingRow + moveSet[0][x];
            int c = startingCol + moveSet[1][x];
            try {
                if (board[r][c] == 0) {
                    board[startingRow][startingCol] = knights;
                    //System.out.println(Text.go(1,1));
                    //Text.go(1,1);
                    //System.out.println(this);
                    //Text.wait(10); //adjust this delay
                    if (solve(r, c, knights+1)) {
                        return true;
                    }
                    board[startingRow][startingCol] = 0;
                }
            } catch (IndexOutOfBoundsException e) {}
        }
        return false;
    }
    
    public String toString() {
        String returnStr = "";
        String second = "";
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] < 10) {
                    if (board[row][col] == 0) {
                        returnStr += "__";
                    } else {
                        returnStr += "_" + board[row][col];
                    }
                } else {
                    returnStr += board[row][col];
                }
                returnStr += " ";
                second += behind[row][col]+" ";
            }
            returnStr += "\n";
            second += "\n";
        }
        System.out.println();
        System.out.println(second);
        return returnStr;
    }
    
    public int countSolutions(int startingRow, int startingCol) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        try {
            if (board[startingRow][startingCol] == 0) {
                
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        return countSolutions(startingRow, startingCol, 1);
    }
    
    private int countSolutions(int startingRow, int startingCol, int knights) {
        int total = 0;
        if (knights == board.length * board[0].length) {
            return 1;
        }
        for (int x = 0; x < moveSet[0].length; x++) {
            int r = startingRow + moveSet[0][x];
            int c = startingCol + moveSet[1][x];
            try {
                if (board[r][c] == 0) {
                    board[startingRow][startingCol] = knights;
                    total += countSolutions(r, c, knights+1);
                    board[startingRow][startingCol] = 0;
                }
            } catch (IndexOutOfBoundsException e) {}
        }
        return total;
    }
    
    public static void main(String[] args) {
        KnightBoard kb = new KnightBoard(5, 7);
        KnightBoard kb1 = new KnightBoard(5, 7);
        long start,end;
        System.out.println(kb);
        start = System.currentTimeMillis();
        System.out.println(kb.solve(3,3));
        end = System.currentTimeMillis();
		System.out.print(end-start+",Slow");
        System.out.println();
        
        start = System.currentTimeMillis();
        System.out.println(kb1.solveFast(3,3));
        end = System.currentTimeMillis();
		System.out.print(end-start+",Fast");
        System.out.println();
        
        //System.out.println(kb.countSolutions(0,0));
        System.out.println(kb1);
        
    }
}