import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {

    private ArrayList<GameObject> gameObjects;

    public Maze(int w, int h) {
        Wall.width = Application.screenWidth / w;
        Wall.height = Application.screenHeight / h;

        gameObjects = new ArrayList<>();

    }
    
    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public static Maze fromFile(String fileName) {

        File file = new File(fileName);

        int w = 0;
        int h = 0;

        ArrayList<GameObject> gameObjects = new ArrayList<>();

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;
            while((text =  input.readLine()) != null) {
                for(int i = 0; i < text.length(); i++) {
                    if(text.charAt(i) == '#')
                        gameObjects.add(new Wall(w, i));
                }

                h = text.length();
                w++;
                                    
            }
        } catch(IOException io) {
            System.err.println("File error");
        }

        return new Maze(w, h);
    }

}