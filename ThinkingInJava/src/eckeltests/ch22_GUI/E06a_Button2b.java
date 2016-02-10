/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.FlowLayout;
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
public class E06a_Button2b extends JFrame {
  private JButton
    b1 = new JButton("Button 1"),
    b2 = new JButton("Button 2");
  private JTextField txt = new JTextField(10);
  private ActionListener butListener = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent ae) {
          String text=((JButton)ae.getSource()).getText();
          txt.setText(text);
      }
  };
  public E06a_Button2b() {
    b1.addActionListener(butListener);
    b2.addActionListener(butListener);
    setLayout(new FlowLayout());
    add(b1);
    add(b2);
    add(txt);
  }
  public static void main(String[] args) {
    run(new E06a_Button2b(), 200, 150);
  }
}
