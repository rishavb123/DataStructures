import java.awt.GraphicsEnvironment;

public class PrintFonts {
    public static void main(String[] args) {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (String font: fonts)
        {
        System.out.println(font);
        }
    }
}