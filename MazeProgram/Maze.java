import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics;
import java.nio.file.Files;
import java.util.List;

public class Maze {

    private GameObject[][] gameObjects;
    private Explorer explorer;
    private Location endPos;

    public Maze(int w, int h) {
        Wall.width = Application.screenWidth / w;
        Wall.height = Application.screenHeight / h;

        gameObjects = new GameObject[w][h];

        explorer = new Explorer(0, 0);
        gameObjects[0][0] = explorer;
        explorer.setMaze(this);

    }

    public Maze(GameObject[][] gameObjects, int explorerX, int explorerY, Location endPos) {
        int w = gameObjects.length;
        int h = gameObjects[0].length;
        
        Wall.width = Application.screenWidth / w;
        Wall.height = Application.screenHeight / h;

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
        return gameObjects[x][y];
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