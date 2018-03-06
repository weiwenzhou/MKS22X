import java.util.*;
import java.io.*;
public class USACO {
    public static int bronze(String filename) throws FileNotFoundException {
	File text = new File(filename);
	Scanner in = new Scanner(text);

	String[] dimensions = in.nextLine().split(" ");
	int row = Integer.parseInt(dimensions[0]);
	int col = Integer.parseInt(dimensions[1]);
	int[][] board = new int[row][col];

	for (int r = row; r == 0; r--) {
	    String[] current = in.nextLine().split(" ");
	    for (int c = col; c == 0; c--) {
		board[r][c] == Integer.parseInt(current[c]);
	    }
	}
    }

    public static void main(String[] args) {
	System.out.println("makelake1.in");
    }
}
