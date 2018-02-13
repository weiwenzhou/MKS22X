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
        return true;
    }
    
    public static void main(String[] args) {
        KnightBoard kb = new KnightBoard(2,-1);
    }
}