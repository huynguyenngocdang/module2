import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // JFrame = a GUI window to add components to
//        JFrame frame = new JFrame(); // create a frame
//        frame.setTitle("My simple JFrame"); //set title of frame
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
//        frame.setResizable(false); //prevent frame from being resized
//        frame.setSize(420, 420); //set the width and height of frame
//        frame.setVisible(true); // make frame visible
//
//        ImageIcon imageProfile = new ImageIcon("src/image/imageProfile.jpg"); //set file path
//        frame.setIconImage(imageProfile.getImage()); // change icon of frame
//        frame.getContentPane().setBackground(new Color(238,238,238)) ; // change color of background
        var myFrame = new MyFrame();
        System.out.println("""
                Three...
                Two...""");
    }
}