/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class E05_Button1 extends JFrame{
  private JButton
          
        b1 = new JButton("Button 1"),
        b2 = new JButton("Button 2"),
        b3 = new JButton("Button 3"),
        b4 = new JButton("Button 4");
  private JLabel label = new JLabel("Test");
  

    public E05_Button1() {
        setLayout(new FlowLayout());
        add(label);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        
    }

    public static void main(String[] args) {
        run(new E05_Button1(), 200, 100);
    }

}
