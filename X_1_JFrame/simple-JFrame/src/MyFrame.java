import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private int thisNum;
    MyFrame() {

        this.setTitle("My simple JFrame"); //set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false); //prevent frame from being resized
        this.setSize(420, 420); //set the width and height of frame
        this.setVisible(true); // make frame visible

        ImageIcon imageProfile = new ImageIcon("src/image/imageProfile.jpg"); //set file path
        this.setIconImage(imageProfile.getImage()); // change icon of frame
        this.getContentPane().setBackground(new Color(238,238,238)) ; // change color of background
        this.thisNum = 0;

    }
}
