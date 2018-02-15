public class KnightBoard {
    private int[][] board, moveSet;
    
    public KnightBoard(int rows, int cols) {
        try {
            board = new int[rows][cols];
        } catch (NegativeArraySizeException e) {
            throw new IllegalArgumentException();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = 0;
            }
        }
        moveSet = new int[2][8];
        
        int[] x = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] y = {1, -1, 2, -2, 2, -2, 1, -1};
        
        moveSet[0] = x;
        moveSet[1] = y;
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
    
    public boolean solve(int startingRow, int startingCol) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        return solve(startingRow, startingRow, 1);
    }
    
    private boolean solve(int startingRow, int startingCol, int knights) {
        if (knights - 1 == board.length * board[0].length) {
            return true;
        }
        for (int x = 0; x < moveSet.length; x++) {
            int r = startingRow + moveSet[0][x];
            int c = startingCol + moveSet[1][x];
            if ( r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                if (board[r][c] == 0) {
                    board[r][c] = knights;
                    if (solve(r, c, knights+1)) {
                        return true;
                    }
                }
                board[r][c] = 0;
            }
        }
        return false;
    }
    
    public String toString() {
        String returnStr = "";
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] < 10) {
                    returnStr += "_" + board[row][col];
                } else {
                    returnStr += board[row][col];
                }
                returnStr += " ";
            }
            returnStr += "\n";
        }
    }
    
    public static void main(String[] args) {
        KnightBoard kb = new KnightBoard(7, 7);
    }
}