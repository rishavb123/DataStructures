import java.awt.Graphics;

public class Explorer extends GameObject {

    public static final int LEFT = 0;
    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;

    private int direction;
    private Maze maze;

    public Explorer(int x, int y) {
        super(x, y);
        direction = RIGHT;
    }

    public void move() {
        Location nextLoc = new Location(location.getX(), location.getY());        
        switch(direction) {
            case LEFT:
                nextLoc.setX(nextLoc.getX() - 1);
                break;
            case RIGHT:
                nextLoc.setX(nextLoc.getX() + 1);
                break;
            case UP:
                nextLoc.setY(nextLoc.getY() - 1);
                break;
            case DOWN:
                nextLoc.setY(nextLoc.getY() + 1);
                break;
        }
        if(nextLoc.getX() >= 0 && nextLoc.getX() < maze.getWidth() && nextLoc.getY() >= 0 && nextLoc.getY() < maze.getHeight() && maze.get(nextLoc) == null) {
            maze.set(location, null);
            maze.set(nextLoc, this);
            location = nextLoc;
        }
    }

    public void turnLeft() {
        direction = direction == 0? DOWN: direction - 1;
    }

    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    public void draw(Graphics g) {
        int x = location.getX();
        int y = location.getY();
        g.drawOval(x * Wall.width, y * Wall.height, Wall.width, Wall.height);
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

}