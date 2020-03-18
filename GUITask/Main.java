import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

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
    private JButton resetButton;

    private ArrayList<String> menuList;

    private String fontName = "Arial";
    private int fontSize = 12;
    private int fontStyle = 0;

    private EmptyBorder border2 = new EmptyBorder(3,5,3,5);

    public Main() {
        frame = new JFrame("GUI Task");
        frame.setSize(1200, 800);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuList = new ArrayList<>();
        String colors = "Blue\tRed\tBlack\tGreen\tYellow\tWhite";
        menuList.add("Font\tArial\tTimes New Roman\tCourier New");
        menuList.add("Font Size\t12\t24\t36\t48");
        menuList.add("Font Style\tPlain\tBold\tItalic");
        menuList.add("Text Color\t" + colors);
        menuList.add("BG Color\t" + colors);
        menuList.add("Border Color\t" + colors + "\tNone");

        panel = new JPanel();
        buttonPanel = new JPanel();
        menuBar = new JMenuBar();

        textArea = new JTextArea();
        updateFont();

        for(String directionOrig: new String[] {"North", "South", "West", "East"}) {
            final String direction = directionOrig;
            JButton button = new JButton(direction);
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    switch(direction) {
                        case "North":
                        case "South":
                            panel.setLayout(new GridLayout(1, 2));
                            buttonPanel.setLayout(new GridLayout(1, 4));
                            menuBar.setLayout(new GridLayout(1, 0));
                            break;
                        case "West":
                        case "East":
                            panel.setLayout(new GridLayout(2, 1));
                            buttonPanel.setLayout(new GridLayout(4, 1));
                            menuBar.setLayout(new GridLayout(0, 1));
                            break;
                    }
                    frame.remove(panel);
                    frame.add(panel, direction);
                    frame.revalidate();
                }
                
            });
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
                        setParamFromMenu(arr[0], arr[j]);
                    }
                    
                });
                Color color = toColor(arr[j]);
                item.setForeground(color == null? Color.BLACK : color);
                menu.add(item);
            }
            JTextField textField = new JTextField("");
            textField.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    setParamFromMenu(arr[0], e.getActionCommand());
                    textField.setText("");
                }
                
            });
            menu.add(textField);
            menuBar.add(menu);
        }

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fontName = "Arial";
                fontSize = 12;
                fontStyle = 0;
                updateFont();
                textArea.setForeground(Color.BLACK);
                textArea.setBackground(Color.WHITE);
                textArea.setText("");
                panel.setLayout(new GridLayout(1, 2));
                buttonPanel.setLayout(new GridLayout(1, 4));
                menuBar.setLayout(new GridLayout(1, 0));
                frame.remove(panel);
                frame.add(panel, BorderLayout.NORTH);
                for(Component component: buttonPanel.getComponents()) {
                    ((JButton) component).setBorder(border2);
                }
                resetButton.setBorder(border2);
                frame.revalidate();
            }
            
        });

        for(Component component: buttonPanel.getComponents()) {
            ((JButton) component).setBorder(border2);
        }
        resetButton.setBorder(border2);

        menuBar.add(resetButton);
        
        panel.add(buttonPanel);
        panel.add(menuBar);
        
        frame.add(textArea, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 2));
        buttonPanel.setLayout(new GridLayout(1, 4));

        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);

    }

    public void setParamFromMenu(String key, String val) {
        switch(key) {
            case "Font":
                fontName = val;
                break;
            case "Font Size":
                if(val.matches("\\d+"))
                    fontSize = Integer.parseInt(val);
                break;
            case "Font Style":
                fontStyle = toFontStyle(val);
                break;
            case "Text Color":
                textArea.setForeground(toColor(val));
                break;
            case "BG Color":
                textArea.setBackground(toColor(val));
                break;
            case "Border Color":
                Border border;
                if(val.equals("None")) {
                    border = border2;
                } else {
                    LineBorder border1 = new LineBorder(toColor(val));
                    border = BorderFactory.createCompoundBorder(border1, border2);
                }
                for(Component component: buttonPanel.getComponents()) {
                    ((JButton) component).setBorder(border);
                }
                resetButton.setBorder(border);
                break;
        }
        updateFont();
    }

    public void updateFont() {
        textArea.setFont(new Font(fontName, fontStyle, fontSize));
    }

    public static Color toColor(String color) {
        try {
            return (Color) Class.forName("java.awt.Color").getField(color.toUpperCase()).get(null);
        } catch (Exception e) {
            return null;
        }
    }

    public static int toFontStyle(String style) {
        try {
            return (int) Class.forName("java.awt.Font").getField(style.toUpperCase()).get(null);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}