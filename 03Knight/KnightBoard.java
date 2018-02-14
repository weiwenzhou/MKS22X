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
        // moveSet = new int[8][2];
        // moveSet[0] = {-1,-2};
        // moveSet = { {-1, -2}, {1, -2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}, {-1, 2}, {1, 2} }; 
    }
    
    public boolean solve(int startingRow, int startingCol) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        return solve(startingRow, startingRow, 0);
    }
    
    private boolean solve(int startingRow, int startingCol, int knights) {
        if (knights == board.length * board[0].length) {
            return true;
        }
    }
    
    public static void main(String[] args) {
        KnightBoard kb = new KnightBoard(2,-1);
    }
}