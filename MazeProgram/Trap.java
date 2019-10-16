import java.awt.Graphics;
import java.awt.Color;

public class Trap extends PhaseObject{

    public static int width;
    public static int height;

    public static int width3d = Application.screenWidth / 3;
    public static int height3d = Application.screenHeight;

    public Trap(int x, int y) {
        super(x, y);
    }

    @Override
    public void put(GameObject obj) {
        if(obj instanceof Explorer) {
            System.out.println("damage");
            ((Explorer) obj).damage(100);
        }
        super.put(obj);
    }

    // @Override
    // public void draw(Graphics g) {
    //     int x = location.getX();
    //     int y = location.getY();
    //     g.setColor(Color.RED);
    //     g.fillRect(x * width, y * height, width, height);
    //     g.setColor(Color.WHITE);
    //     g.drawRect(x * width, y * height, width, height);
    // }

}