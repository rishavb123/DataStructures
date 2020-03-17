import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends JPanel {

    private static final long serialVersionUID = 4648172894076113183L;

    private JFrame frame;

    private JPanel panel;

    private JPanel buttonPanel;
    private JMenuBar menuBar;

    private JTextArea textArea;

    private ArrayList<String> menuList;

    public Main() {
        frame = new JFrame("GUI Task");
        frame.setSize(1000, 800);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuList = new ArrayList<>();
        menuList.add("Font\tArial\tTimes New Roman\tCourier New");
        menuList.add("Text Color\tBlue\tRed\tBlack\tGreen\tYellow");
        menuList.add("Background Color\tBlue\tRed\tBlack\tGreen\tYellow");
        menuList.add("Foreground Color\tBlue\tRed\tBlack\tGreen\tYellow");
        menuList.add("Outline Color\tBlue\tRed\tBlack\tGreen\tYellow");

        panel = new JPanel();
        buttonPanel = new JPanel();
        menuBar = new JMenuBar();

        textArea = new JTextArea();

        panel.setLayout(new GridLayout(1, 2));
        buttonPanel.setLayout(new GridLayout(1, 4));

        for(String direction: new String[] {"North", "South", "East", "West"}) {
            JButton button = new JButton(direction);
            buttonPanel.add(button);
        }

        for(String menuInfo: menuList) {
            String[] arr = menuInfo.split("\t");
            JMenu menu = new JMenu(arr[0]);
            for(int i = 1; i < arr.length; i++) {
                JMenuItem item = new JMenuItem(arr[i]);
                final int j = i;
                item.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch(arr[0]) {
                            case "Font":
                                textArea.setFont(new Font(arr[j], Font.PLAIN, 12));
                                break;
                        }
                    }
                    
                });
                menu.add(item);
            }
            menuBar.add(menu);
        }
        
        panel.add(buttonPanel);
        panel.add(menuBar);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public static Color toColor(String colorName) {
        Color color;
        try {
            Field field = Class.forName("java.awt.Color").getField("yellow");
            return (Color)field.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}