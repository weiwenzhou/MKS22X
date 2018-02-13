public class KnightBoard {
    private int[][] board, moveSet;
    
    public KnightBoard(int rows, int cols) {
        board = new int[rows][cols];
        // moveSet = new int[8][2];
        // moveSet[0] = {-1,-2};
        // moveSet = { {-1, -2}, {1, -2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}, {-1, 2}, {1, 2} }; 
    }
}