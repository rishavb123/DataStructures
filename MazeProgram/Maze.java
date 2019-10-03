import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.nio.file.Files;
import java.util.List;

public class Maze {

    private GameObject[][] gameObjects;
    private Explorer explorer;
    private Location endPos;

    public static final int wMargin3d = (int) (0.05 * Application.screenWidth);
    public static final int hMargin3d = (int) (0.05 * Application.screenHeight);
    public static final int screenWidth3d = Application.screenWidth - 2 * wMargin3d;
    public static final int screenHeight3d = Application.screenHeight - 2 * hMargin3d;
    public static final Wall tempWall = new Wall(0, 0);

    public Maze(int w, int h) {

        gameObjects = new GameObject[w][h];

        explorer = new Explorer(0, 0);
        gameObjects[0][0] = explorer;
        explorer.setMaze(this);

    }

    public Maze(GameObject[][] gameObjects, int explorerX, int explorerY, Location endPos) {
        int w = gameObjects.length;
        int h = gameObjects[0].length;
        
        System.out.println(Application.screenWidth);
        Wall.width = Application.screenWidth / w > 30? 30 : Application.screenWidth / w;
        Wall.height = Application.screenHeight / h > 30? 30 : Application.screenHeight / h;

        this.gameObjects = gameObjects;
        explorer = (Explorer) gameObjects[explorerX][explorerY];
        explorer.setMaze(this);
        this.endPos = endPos;
    }

    public GameObject[][] getGameObjects() {
        return gameObjects;
    }

    public Explorer getExplorer() {
        return explorer;
    }

    public int getWidth() {
        return gameObjects.length;
    }

    public int getHeight() {
        return gameObjects[0].length;
    }

    public GameObject get(int x, int y) {
        if(!isValid(x, y))
            return tempWall;
        return gameObjects[x][y];
    }

    public boolean isValid(int x, int y) {
        return !(x >= getWidth() || x < 0 || y >= getHeight() || y < 0);
    }

    public boolean isValid(Location loc) {
        return isValid(loc.getX(), loc.getY());
    }

    public GameObject get(Location l) {
        return get(l.getX(), l.getY());
    }

    public void set(int x, int y, GameObject g) {
        gameObjects[x][y] = g;
    }

    public void set(Location l, GameObject g) {
        set(l.getX(), l.getY(), g);
    }

    public static Maze fromFile(String fileName) {
        try {
            File file = new File(fileName);
            List<String> list = Files.readAllLines(file.toPath());
            
            int w = list.get(0).length();
            int h = list.size();
            
            GameObject[][] gameObjects = new GameObject[w][h];
            
            int explorerX = 0;
            int explorerY = 0;

            Location endPos = new Location(0, 0);

            for(int y = 0; y < h; y++)
                for(int x = 0; x < w; x++)
                    switch(list.get(y).charAt(x)) {
                        case '#':
                            gameObjects[x][y] = new Wall(x, y);
                            break;
                        case '*':
                            gameObjects[x][y] = new Explorer(x, y);
                            explorerX = x;
                            explorerY = y;
                            break;
                        case 'E':
                            endPos = new Location(x, y);
                    }

            return new Maze(gameObjects, explorerX, explorerY, endPos);
        } catch(IOException e) {
            System.err.println("File error");
        }
        return null;
    }

    public void draw(Graphics g) {
        for(int x = 0; x < getWidth(); x++)
            for(int y = 0; y <  getHeight(); y++)
                if(get(x, y) != null)
                    get(x, y).draw(g);
    }

    public void draw3d(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(wMargin3d, hMargin3d, screenWidth3d, screenHeight3d);

        int x = wMargin3d;
        int y = hMargin3d;
        int y2 = hMargin3d + screenHeight3d;
        int w = screenWidth3d / 4;
        int h = screenHeight3d;

        double rw = 2.0 / 3.0;
        double rh = 2.0 / 3.0;

        Location location = explorer.getLocation();

        for(int i = 0; i < explorer.getVision(); i++) {
            Location left = Explorer.nextLocation(Explorer.turnLeft(explorer.getDirection()), location);
            Location right = Explorer.nextLocation(Explorer.turnRight(explorer.getDirection()), location);

            int nw = (int)(rw * w);
            int nh = (int)(rh * h);
            int nx = x + nw;
            int ny = y + (int)((1 - rh) / 2.0 * nh);
            int ny2 = y + (int)(((1 - rh) / 2.0 + 1) * nh);
            
            location = Explorer.nextLocation(explorer.getDirection(), location);

            if(get(left) instanceof Wall) {
                int[] xs = new int[]{x, nx, nx, x};
                int[] ys = new int[]{y, ny, ny2, y2};
                g.setColor(Color.GRAY);
                g.fillPolygon(xs, ys, 4);
                g.setColor(Color.RED);
                g.drawPolygon(xs, ys, 4);
            } else if(get(Explorer.nextLocation(explorer.getDirection(), left)) instanceof Wall){
                int[] xs = new int[]{x, nx, nx, x};
                int[] ys = new int[]{ny, ny, ny2, ny2};
                g.setColor(Color.GRAY);
                g.fillPolygon(xs, ys, 4);
                g.setColor(Color.RED);
                g.drawPolygon(xs, ys, 4);
            }

            if(get(right) instanceof Wall) {
                int[] xs = flipX(new int[]{x, nx, nx, x});
                int[] ys = new int[]{y, ny, ny2, y2};
                g.setColor(Color.GRAY);
                g.fillPolygon(xs, ys, 4);
                g.setColor(Color.RED);
                g.drawPolygon(xs, ys, 4);
            } else if(get(Explorer.nextLocation(explorer.getDirection(), right)) instanceof Wall){
                int[] xs = flipX(new int[]{x, nx, nx, x});
                int[] ys = new int[]{ny, ny, ny2, ny2};
                g.setColor(Color.GRAY);
                g.fillPolygon(xs, ys, 4);
                g.setColor(Color.RED);
                g.drawPolygon(xs, ys, 4);
            }

            if(get(location) instanceof Wall) {
                int[] xs = new int[]{nx, nx, flipX(nx), flipX(nx)};
                int[] ys = new int[]{ny, ny2, ny2, ny};
                g.setColor(Color.GRAY);
                g.fillPolygon(xs, ys, 4);
                g.setColor(Color.RED);
                g.drawPolygon(xs, ys, 4);
                break;
            } else if(location.equals(endPos)) {
                int[] xs = new int[]{nx, nx, flipX(nx), flipX(nx)};
                int[] ys = new int[]{ny, ny2, ny2, ny};
                g.setColor(Color.GREEN);
                g.fillPolygon(xs, ys, 4);
                g.setColor(Color.RED);
                g.drawPolygon(xs, ys, 4);
                break;
            }
            
            
            x = nx; y = ny; y2 = ny2; w = nw; h = nh;

        }

    }

    public void draw3dTest(Graphics g) {
        int[] curX = {0, 20, 20, 0};
        int[] curY = {0, 17, 83, 100};

        int width = 20;        

        int[] x = copy(curX);
        int[] y = copy(curY);
        int[] fx = flipX(x);
        g.setColor(Color.WHITE);
        g.fillRect(transformX(0), transformY(0), screenWidth3d, screenHeight3d);
        g.setColor(Color.GRAY);

        transformPoints(x, y, fx);
        // g.fillPolygon(x, y, 4);
        // g.fillPolygon(fx, y, 4);
        
        Location location = explorer.getLocation();
        while(true) {
            Location nextLocation = Explorer.nextLocation(explorer.getDirection(), location);
            width /= 2;
            if(get(nextLocation) instanceof Wall) {
                System.out.println("Wall infront");
                curX = new int[]{curX[2], curX[2], flipX(curX[2]), flipX(curX[2])};
                curY = new int[]{curY[1], curY[2], curY[2], curY[1]};
                int[] xc = copy(curX);
                int[] yc = copy(curY);

                transformPoints(xc, yc);
                g.fillPolygon(xc, yc, 4);
                break;
            } else {
                Location left = Explorer.nextLocation(Explorer.turnLeft(explorer.getDirection()), nextLocation);
                Location right = Explorer.nextLocation(Explorer.turnRight(explorer.getDirection()), nextLocation);
                curX = new int[]{curX[1], curX[1] + width, curX[1] + width, curX[1]};
                curY = copy(curY);
                x = copy(curX);
                y = copy(curY);
                fx = flipX(x);
                if(get(left) instanceof Wall) {
                    g.fillPolygon(x, y, 4);
                } else {
                    g.fillPolygon(fx, y, 4);
                }
            }
            location = nextLocation;
        }

    }

    public int[] copy(int[] arr) {
        int[] arr2 = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            arr2[i] = arr[i];
        return arr2;
    }

    public int transformX(int x) {
        return wMargin3d + screenWidth3d * x / 100;
    }

    public int transformY(int y) {
        return hMargin3d + screenHeight3d * y / 100;
    }

    public int flipX(int x) {
        return Application.screenWidth - x;
    }

    public int[] flipX(int[] x) {
        int[] x2 = new int[x.length];
        for(int i = 0; i < x.length; i++)
            x2[i] = flipX(x[i]);
        return x2;
    }

    public void transformPoints(int[] x, int[] y) {
        for(int i = 0; i < x.length; i++) {
            x[i] = transformX(x[i]);
            y[i] = transformY(y[i]);
        }
    }
    public void transformPoints(int[] x, int[] y, int[] fx) {
        for(int i = 0; i < x.length; i++) {
            x[i] = transformX(x[i]);
            y[i] = transformY(y[i]);
            fx[i] = transformX(fx[i]);
        }
    }

    public boolean isDone() {
        return getExplorer().getLocation().equals(endPos);
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < getHeight(); i++) {
            for(int j = 0; j < getWidth(); j++)
                if(get(j, i) == null)
                    s += "_";
                else if(get(j, i) instanceof Wall)
                    s += "#";
                else if(get(j, i) instanceof Explorer)
                    s += "*";
            s += "\n";
        }
        return s;
    }

}