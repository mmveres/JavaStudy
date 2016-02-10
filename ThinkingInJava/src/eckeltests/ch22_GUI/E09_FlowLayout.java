/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class E09_FlowLayout extends JFrame {

    public E09_FlowLayout() {
        setLayout(new FlowLayout());
        for (int i = 1; i <= 20; i++) {
            if (i < 10) {
                add(new JButton("Button 0" + i));
            } else {
                add(new JButton("Button " + i));
            }
        }
    }

    public static void main(String[] args) {
        run(new E09_FlowLayout(), 300, 300);
    }
}
