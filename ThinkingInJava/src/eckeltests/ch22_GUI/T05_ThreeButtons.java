/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class T05_ThreeButtons extends JFrame{
    private JButton
            btn1 = new JButton("Num1"),
            btn2 = new JButton("Num2"),
            btn3 = new JButton("Num3");
    private JTextField txt = new JTextField(10);
    private ActionListener btListen=new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
      String text=((JButton)ae.getSource()).getText();
      txt.setText(text);
        }
    };

    public T05_ThreeButtons(){
        btn1.addActionListener(btListen);
        btn2.addActionListener(btListen);
        btn3.addActionListener(btListen);
        setLayout(new FlowLayout());
        add(btn1);
        add(btn2);
        add(btn3);
        add(txt);
    }
    
    public static void main(String[] args) {
        run(new T05_ThreeButtons(),200,200);
    }
            
}
