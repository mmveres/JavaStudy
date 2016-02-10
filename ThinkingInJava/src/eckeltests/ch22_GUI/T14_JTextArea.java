/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class T14_JTextArea extends JFrame {

    private JButton b = new JButton("Add Text");
    private JTextArea jta = new JTextArea();
    private static Generator sg
            = new RandomGenerator.String(7);

    public T14_JTextArea() {
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i < 10; i++) {
                    jta.setText(jta.getText() + sg.next() + "\n");
                }
            }
        });
        add(new JScrollPane(jta));
        add(BorderLayout.SOUTH, b);
    }

    public static void main(String[] args) {
        run(new E18_TextPane(), 475, 425);
    }
}
