package gui;

import constants.CommonConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGUI extends JFrame {
    private JPanel panel;

    private JTextField searchField;
    private JButton searchBtn;


    public WeatherAppGUI(){

        // FRAME
        super(CommonConstants.FRAME_NAME);
        this.setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        addGUIComponents();
    }

    private void addGUIComponents(){
        SpringLayout springLayout = new SpringLayout();

        // PANEL
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,600));
        panel.setBackground(CommonConstants.PRIMARY);
        panel.setLayout(springLayout);

        this.add(panel);

        // SEARCH ENGINE
        searchField = new JTextField();
        searchField.setFont(new Font("Dialog", Font.BOLD, 24));
        searchField.setPreferredSize(new Dimension(250,45));

        springLayout.putConstraint(SpringLayout.WEST, searchField, 45, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, searchField, 5, SpringLayout.NORTH, panel);

        searchBtn = new JButton(loadImage("src/assets/search.png"));
        searchBtn.setPreferredSize(new Dimension(47,45));
        searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchBtn.setFocusable(false);


        springLayout.putConstraint(SpringLayout.WEST, searchBtn, 300, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH,searchBtn, 5, SpringLayout.NORTH, panel);

        panel.add(searchField);
        panel.add(searchBtn);
    }

    private ImageIcon loadImage(String resoursePath){
        try{
            BufferedImage image = ImageIO.read(new File(resoursePath));

            return new ImageIcon((image));
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("System couldn't find the asset!");
        return null;
    }
}
