import javax.swing.*;

public class MyJFrame extends JFrame {
    private ImageIcon imageProfile = new ImageIcon("src/image/imageProfile.jpg");
    public MyJFrame() {
        this.setTitle("My simple label");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(imageProfile.getImage());
        JLabel label = new JLabel();
        label.setText("abc xyz");
        this.add(label);
    }


}
