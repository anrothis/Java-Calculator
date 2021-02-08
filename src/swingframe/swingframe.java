package swingframe;
import java.awt.Color;
import javax.swing.*;

public class swingframe {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setTitle("Mein Fenster");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(420,420);
        frame.setVisible(true);

        ImageIcon image = new  ImageIcon("computer-icon.png"); 
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(0x123456));
    }
}
