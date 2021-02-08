package lable;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class lable {
    public static void main(String[] args) {
        // siehe Vorlesung

        ImageIcon icon = new ImageIcon("dude.png");
        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.red, 3);
        label.setText("Viel Spaß!!");
        label.setIcon(icon);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.green);
        label.setFont(new Font("MV Boli", Font.PLAIN,20));
        label.setIconTextGap(-20);
        label.setBackground(Color.black);
        label.setOpaque(true); // damit hintergrund durchscheint
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(100, 100, 250, 250);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.add(label);
        frame.setVisible(true);
        

    }
}
