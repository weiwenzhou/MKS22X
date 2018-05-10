public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
      maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
      if (mode == 0) {
        frontier = new FrontierQueue();
      }
      if (mode == 1) {
          frontier = new FrontierStack();
      }
      frontier.add(maze.start);
      while (frontier.hasNext()) {
          Location current = frontier.next();
          Location[] neighbors = maze.getNeighbors(current);
          if (! current.equals(maze.start) ) {
            maze.set(current.getX(), current.getY(), '.');
          }
          System.out.println(maze.toString());
          try {
            Thread.sleep(stop);
          } catch (InterruptedException e) {}
          for (Location l : neighbors) {
              if (l.equals(maze.end)) {
                  return true;
              } else {
                  frontier.add(l);
                  maze.set(l.getX(), l.getY(), '?');
              }
              System.out.println(maze.toString());
              try {
                Thread.sleep(stop);
              } catch (InterruptedException e) {}
          }
      }
    return false;
  }

  public String toString(){
    return maze.toString();
  }
  
  public static void main(String[] args) {
      MazeSolver a = new MazeSolver("data1.dat");
      a.solve();
  }
}

