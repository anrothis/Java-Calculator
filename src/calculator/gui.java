package calculator;
import javax.swing.*;
import javax.swing.border.BevelBorder;


import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class gui implements ActionListener {

    Calculator calc;
    String temp = "";
    JLabel memory;
    JLabel eingabe;
    ArrayList <JButton> button;
    String [] buttonFunction = {"1","2","3","+","4","5","6","-","7","8","9","*",".","0","=","/"};
    ImageIcon i = new ImageIcon("src/Calculator/skull.png");
    ImageIcon j = new ImageIcon("src/Calculator/left.png");
    
    public gui() {
        
        calc = new Calculator();
        memory = new JLabel("");
        eingabe = new JLabel("");
        int border = 2;
        button = new ArrayList<>();

        JLabel label1= new JLabel();
        label1.setOpaque(true);// sonst Hintergrund nicht sichtbar
        label1.setBackground(Color.GRAY);// Label 1 ist rot
        label1.setBounds(-border,-border,50, 600);
        label1.setHorizontalAlignment(0);
        label1.setVerticalAlignment(0);
        label1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        label1.setLayout(new GridLayout(0,1));
        label1.add(new JButton(i));
        label1.add(new JButton(j));

        JLabel label2= new JLabel();
        label2.setLayout(new GridLayout(0,4,5,5));
        
        for(int i = 0; i < buttonFunction.length;i++)
        {
            button.add(new JButton(buttonFunction[i]));
            button.get(i).addActionListener(this);
            label2.add(button.get(i));
        }
        // label2.set;
        // label2.setForeground(Color.GREEN);
        // label2.setBackground(Color.GREEN);// Label 2 ist gr�n
        // label2.setOpaque(true);
        label2.setBounds(70,150,400,400);
        // label2.setBorder(BorderFactory.createLineBorder(Color.GRAY, border));
        
        JLabel label3= new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.DARK_GRAY);// Label 3 ist blau
        label3.setBounds(0,0,500,600);
        
        JLabel label4= new JLabel();
        label4.setLayout(new GridLayout(2,1,2,10));
        // label4.setLayout(new FlowLayout(FlowLayout.TRAILING,2,5));
        // label4.setHorizontalAlignment(SwingConstants.RIGHT);
        // label4.setHorizontalTextPosition(SwingConstants.RIGHT);
        label4.add(memory);
        label4.add(eingabe);
        label4.setOpaque(true);
        label4.setBackground(Color.GRAY);// Label 3 ist blau
        label4.setBounds(70,10,400,130);
        label4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,600);//so gro� wie das Fenster
        layeredPane.add(label3, JLayeredPane.DEFAULT_LAYER);
        //   layeredPane.add(label1, Integer.valueOf(0));       // 0 = unterste Ebene
        layeredPane.add(label2, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(label1, JLayeredPane.MODAL_LAYER);
        layeredPane.add(label4, JLayeredPane.MODAL_LAYER);
        
        JFrame frame = new JFrame("JLayeredPane Demo");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 600));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    public void actionPerformed(ActionEvent event) {
        
        String show = "";
        // System.out.println(event);
        if((event.getActionCommand() == "=")||(event.getActionCommand() == "*")||(event.getActionCommand() == "/")||(event.getActionCommand() == "-")||(event.getActionCommand() == "+"))
        {   
            calc.addOperation(temp);
            calc.addOperation(event.getActionCommand());
            
            if(event.getActionCommand() == "=")
            {
                show = Double.toString(calc.execInception(0));
                calc.clearMemory();
            }
            // else
            // {
            //     calc.addOperation(temp);
            // }
            
            temp = "";
            // calc.addOperation(event.getActionCommand());
        }
        else
        {
            temp += event.getActionCommand();
            show = temp;
        } 
        
        memory.setText(show);
        eingabe.setText(calc.getOperationListAsString());

    }
    
    
    public static void main(String[] args) {
        new gui();
    }
}

