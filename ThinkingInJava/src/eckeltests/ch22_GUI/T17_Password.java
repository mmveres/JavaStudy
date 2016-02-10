/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class T17_Password extends JFrame {

    private JPasswordField jPasswordField = new JPasswordField(10);
    private JLabel jLabel = new JLabel("Best Canadian techno-metal band?");
    private String pwd = "voivod";

    T17_Password() {
//    jPasswordField.getDocument().addDocumentListener(new DocumentListener() {
//
//        @Override
//        public void insertUpdate(DocumentEvent de) {
//            verify();
//        }
//
//        @Override
//        public void removeUpdate(DocumentEvent de) {
//            verify();
//        }
//
//        @Override
//        public void changedUpdate(DocumentEvent de) {
//           verify();
//        }
//
//        private void verify() {
//            if(String.valueOf(jPasswordField.getPassword())=="voivod" ){
//                JOptionPane.showMessageDialog(null, "Yes!", "it's voivod!", JOptionPane.INFORMATION_MESSAGE);
//            }else{
//                JOptionPane.showMessageDialog(null, "Wrong!", "Try again!", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    });
        jPasswordField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                JOptionPane.showMessageDialog(null, "Yes!", String.valueOf(jPasswordField.getPassword()), JOptionPane.INFORMATION_MESSAGE);
                if (String.valueOf(jPasswordField.getPassword()).toLowerCase().equals(pwd)) {
                    JOptionPane.showMessageDialog(null, "it's voivod!","Yes!",  JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Try again!","Wrong!",  JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );
        setLayout(new FlowLayout());
        add(jLabel);

        add(jPasswordField);
    }

    public static void main(String[] args) {
        run(new T17_Password(), 200, 200);
    }
}
