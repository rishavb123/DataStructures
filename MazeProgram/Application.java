import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;

public class Application extends JPanel {

    public static final String fileName = "./mazes/one.txt";
    public static final int screenWidth = 1000;
    public static final int screenHeight = 800;

    private static final long serialVersionUID = 1L;

    private JFrame frame;

    private Maze maze;

    public Application() {
        frame = new JFrame();

        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent event) {
                // System.out.println("Pressed: " + event.getKeyCode());
            }

            public void keyReleased(KeyEvent event) {
                System.out.println("Released: " + event.getKeyCode());
                switch(event.getKeyCode()) {
                    case 38:
                        maze.getExplorer().move();
                        break;
                    case 37:
                        maze.getExplorer().turnLeft();
                        break;
                    case 39:
                        maze.getExplorer().turnRight();
                        break;
                }
                repaint();
                if(maze.isDone())
                    System.out.println("Great Job ur done!");
            }

            public void keyTyped(KeyEvent event) {
                // System.out.println("Typed: " + event.getKeyCode());
            }

        });

        setBoard();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screenWidth, screenHeight);

        g.setColor(Color.WHITE);
        maze.draw(g);
        
    }

    public void setBoard() {
        maze = Maze.fromFile(fileName);
    }

    public static void main(String[] args) {
        Application app = new Application();
    }

}