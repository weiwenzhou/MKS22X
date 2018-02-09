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
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
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
    
    public boolean addQueen(int r, int c) {
        if (board[r][c] == 0) {
            board[r][c] = -1;
            return true;
        }
        return false;
    }
    
    public boolean removeQueen(int r, int c) {
        if (board[r][c] == -1) {
            board[r][c] = 0;
            return true;
        }
        return false;
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
        System.out.println(qb.addQueen(1,1));
        System.out.println(qb.addQueen(2,3));
        System.out.println(qb);
        System.out.println(qb.removeQueen(2,3));
        System.out.println(qb.removeQueen(2,0));
        System.out.println(qb);
        //System.out.println(qb);
    }
}