package mz;

public class MazeStarter {

	public static void main(String[] args) {
	    /* Collect command-line arguments specifying numbers of rows & columns. */
        if (args.length < 2) {
            throw new IllegalArgumentException("Two arguments are required.");
        }

        int Rows = 0;
        int Columns = 0;

        try {
            Rows = Integer.parseInt(args[0]);
            Columns = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Both arguments must be positive integers.");
        }
        
        if (Rows < 1 || Columns < 1) {
            throw new IllegalArgumentException("Both arguments must be positive integers.");
        }
        
        /* Create new Maze framework. */
        Maze maze = new Maze(Rows, Columns);
        
        /* Generate the maze. */
        maze.generateMaze();

        /* Display the generated maze . */
        maze.Setting();
        maze.ShowGUI();
    }

	

}
