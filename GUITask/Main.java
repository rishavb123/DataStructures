import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main extends JPanel {

    private static final long serialVersionUID = 4648172894076113183L;

    private JFrame frame;

    private JPanel panel;

    private JPanel buttonPanel;
    private JMenuBar menuBar;

    public Main() {
        frame = new JFrame("GUI Task");
        frame.setSize(1000, 800);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        buttonPanel = new JPanel();
        menuBar = new JMenuBar();

        panel.setLayout(new GridLayout(2, 1));
        buttonPanel.setLayout(new GridLayout(1, 4));

        for(String direction: new String[] {"North", "South", "East", "West"}) {
            buttonPanel.add(new JButton(direction));
        }

        
        
        panel.add(buttonPanel);
        panel.add(menuBar);

        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }

}