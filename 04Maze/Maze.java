import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private int[][] moveSet;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 
         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
        moveSet = new int[2][4];
        
        int[] x = {-1,0,0,1};
        int[] y = {0,-1,1,0};
        
        moveSet[0] = x;
        moveSet[1] = y;
        
        File text = new File(filename);
        Scanner in = new Scanner(text);
        String input = "";
        int row = 0;
        while(in.hasNextLine()){
            row++;
            input += in.nextLine() + "x";
        }
        if (input.indexOf("S") == -1 || input.indexOf("E") == -1) {
            throw new IllegalStateException();
        }
        if (input.indexOf("S") != input.lastIndexOf("S") || input.indexOf("E") != input.lastIndexOf("E")) {
            throw new IllegalStateException();
        }
        int col = input.indexOf("x");
        maze = new char[row][col];
        int r = 0;
        int c = 0;
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == 'x') {
                c = 0;
                r++;
            } else {
                maze[r][c] = input.charAt(index);
                c++;
            }
        }
    }
    

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
            catch (InterruptedException e) {
        }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

        //find the location of the S. 
        int r = -1;
        int c = -1;
        boolean found = true;
        for (int row = 0; found && row < maze.length; row++) {
            for (int col = 0; found && col < maze[row].length; col++) {
                if (maze[row][col] == 'S') {
                    r = row;
                    c = col;
                    found = false;
                }
            }
        }
        //erase the S
        maze[r][c] = ' ';

        //and start solving at the location of the s.
        
        //return solve(???,???);
        return solve(r, c, 0);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int count){ //you can add more parameters since this is private
        
        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);
            System.out.println("ROW:"+row+","+"COL:"+col+"count"+count);

            wait(400);
        }

        //COMPLETE SOLVE
        if (maze[row][col] == 'E') {
            return count;
        }
        
        for (int x = 0; x < moveSet[0].length; x++) {
            try {
                if (maze[row+moveSet[0][x]][col+moveSet[1][x]] == ' ' || maze[row+moveSet[0][x]][col+moveSet[1][x]] == 'E') {
                    maze[row][col] = '@';
                    int temp = solve(row+moveSet[0][x], col+moveSet[1][x], count+1);
                    if (temp != -1) {
                        return temp;
                    }
                    maze[row][col] = ' ';
                }
            } catch (IndexOutOfBoundsException e) {}
        }
        
        return -1; //so it compiles
    }

    public String toString() {
        String returnStr = "";
            for (int r = 0; r < maze.length; r++) {
                for (int c = 0; c < maze[r].length; c++) {
                    returnStr += maze[r][c];
                }
                returnStr += "\n";
            }
        return returnStr;
    }

    public static void main(String[] args) {
        try {
            Maze m = new Maze("data1.dat");
            System.out.println(m);
            m.setAnimate(true);
            System.out.println(m.solve());
            //System.out.println(m);
        } catch (FileNotFoundException e) {}
    }
}
