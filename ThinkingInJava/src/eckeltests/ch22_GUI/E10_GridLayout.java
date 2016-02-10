/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class E10_GridLayout extends JFrame {
  public E10_GridLayout() {
    setLayout(new GridLayout(7,3));
    for(int i = 0; i < 20; i++)
      add(new JButton("Button " + i));
  }
  public static void main(String[] args) {
    run(new E10_GridLayout(), 300, 300);
  }
}
