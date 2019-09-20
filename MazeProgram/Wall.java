import java.awt.Graphics;

public class Wall extends GameObject{

    public static int width;
    public static int height;

    public Wall(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics g) {
        int x = location.getX();
        int y = location.getY();
        g.drawRect(x * width, y * height, width, height);
    }

}