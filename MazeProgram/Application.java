import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;

public class Application extends JPanel {

    public static final String fileName = "./mazes/one.txt";
    public static final int screenWidth = 1000;
    public static final int screenHeight = 700;

    private static final long serialVersionUID = 1L;

    private JFrame frame;

    private Maze maze;

    private boolean show3d = true;

    public Application() {
        frame = new JFrame();

        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenWidth*5/4, screenHeight*5/4);
        setBoard();
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent event) {
                // System.out.println("Pressed: " + event.getKeyCode());
                switch(event.getKeyCode()) {
                    case 38:
                        maze.getExplorer().move();
                        break;
                    case 37:
                        // maze.getExplorer().turnLeft();
                        break;
                    case 39:
                        // maze.getExplorer().turnRight();
                        break;
                    case 40:
                        maze.getExplorer().moveBack();
                        break;
                }
                repaint();
                if(maze.isDone())
                    System.out.println("Great Job ur done!");
            }

            @Override
            public void keyReleased(KeyEvent event) {
                System.out.println("Released: " + event.getKeyCode());
                switch(event.getKeyCode()) {
                    case 38:
                        // maze.getExplorer().move();
                        break;
                    case 37:
                        maze.getExplorer().turnLeft();
                        break;
                    case 39:
                        maze.getExplorer().turnRight();
                        break;
                    case 32:
                        show3d = !show3d;
                        break;
                }
                repaint();
                if(maze.isDone())
                    System.out.println("Great Job ur done!");
            }

            @Override
            public void keyTyped(KeyEvent event) {
                // System.out.println("Typed: " + event.getKeyCode());
            }

        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screenWidth, screenHeight);

        if(maze.isDone()) {
            g.setColor(Color.WHITE);
            g.drawString("Rishav is cool not", 20, 20);
        }
        else {
            maze.draw(g);
            if(show3d)
                maze.draw3d(g);
        }
        
    }

    public void setBoard() {
        maze = Maze.fromFile(fileName);
    }

    public static void main(String[] args) {
        Application app = new Application();
    }

}