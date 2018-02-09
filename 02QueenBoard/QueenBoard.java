public class QueenBoard {
    private int[][] board;

    public QueenBoard(int size) {
        board = new int[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                board[r][c] = 0;
            }
        }
    }
    
    public String toString() {
        String returnStr = "";
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                int num = board[r][c];
                if (num == -1) {
                    returnStr += "Q ";
                } else {
                    returnStr += "_ ";
                }
            }
            returnStr += "\n";
        }
        return returnStr;
    }
    
    private boolean addQueen(int r, int c) {
        return true;
    }
    
    private boolean removeQueen(int r, int c) {
        return true;
    }
    
    public boolean solve() {
        return true;
    }
    
    public int countSolutions() {
        return 0;
    }
    
    public static void main(String[] args) {
        QueenBoard qb = new QueenBoard(5);
        
        System.out.println(qb);
    }
}