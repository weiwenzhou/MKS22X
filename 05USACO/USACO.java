import java.util.*;
import java.io.*;
public class USACO {
    public static int bronze(String filename) throws FileNotFoundException {
        File text = new File(filename);
        Scanner in = new Scanner(text);

        String[] dimensions = in.nextLine().split(" ");
        int row = Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);
        int elevation = Integer.parseInt(dimensions[2]);
        int direction = Integer.parseInt(dimensions[3]);
        int[][] board = new int[row][col];

        for (int r = 0; r < row; r++) {
                String[] current = in.nextLine().split(" ");
                for (int c = 0; c < col; c++) {
                    board[r][c] = Integer.parseInt(current[c]);
            }
        }
        while (direction != 0) {
            String[] current = in.nextLine().split(" ");
            int dRow = Integer.parseInt(current[0])-1;
            int dCol = Integer.parseInt(current[1])-1;
            int largest = board[dRow][dCol];
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (board[dRow+x][dCol+y] > largest) {
                        largest = board[dRow+x][dCol+y];
                    }
                }
            }
            int newValue = largest - Integer.parseInt(current[2]);
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (board[dRow+x][dCol+y] > newValue) {
                        board[dRow+x][dCol+y] = newValue;
                    }
                }
            }
            direction--;
        }
        
        int depth = 0;
        for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                int height = elevation - board[r][c];
                if (height > 0) {
                    depth += height;
                }
            }
        }
        return depth * 72 * 72;
    }
    
    public static int silver(String filename) throws FileNotFoundException {
        File text = new File(filename);
        Scanner in = new Scanner(text);

        String[] dimensions = in.nextLine().split(" ");
        int row = Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);
        int time = Integer.parseInt(dimensions[2]);
        char[][] board = new char[row][col];
	int[][] odd = new int[row][col];
	int[][] even = new int[row][col];

        for (int r = 0; r < row; r++) {
                String current = in.nextLine();
                for (int c = 0; c < col; c++) {
                    board[r][c] = current.charAt(c);
		    odd[r][c] = 0;
		    even[r][c] = 0;
            }
        }
        String[] coords = in.nextLine().split(" ");

	boolean swap = true; // true == even, false == odd
	
	for (int step = 0; step < time; step++) {
	    int sum = 0;
	    int[][] moveSet = { {0,1}, {0,-1}, {1,0}, {-1,0} };

	    if (swap) {
		int[][] viewing = odd;
		int[][] changing = even;
	    } else {

	    }
	    
	    for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
		    int sum = 0;

		    for (int x = 0; x < 4; x++) {
			try {
			    sum += viewing[r+moveSet[x][0]][c+moveSet[x][1]];
			} catch (IndexOutOfBoundsException e) {}
		    }

		    changing[r][c] = sum;
		}
            }
        }
    }

    
    public static void main(String[] args) {
        try {
            if (args.length == 1) {
                //System.out.println(bronze(args[0]));
                System.out.println(silver(args[0]));
            } else {
                //System.out.println(bronze("makelake.1.in"));
                System.out.println(silver("ctravel.1.in"));
            }
        } catch (FileNotFoundException e) {
            System.out.println("not found");
        }
    }
}
