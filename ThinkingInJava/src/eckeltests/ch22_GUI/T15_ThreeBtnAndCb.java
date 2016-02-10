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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class T15_ThreeBtnAndCb extends JFrame {

    private JButton btn1 = new JButton("Num1"),
            btn2 = new JButton("Num2"),
            btn3 = new JButton("Num3");
    private JTextField txt = new JTextField(20);
    private JCheckBox jcb1 = new JCheckBox("CheckBox");
    private ActionListener btListen = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            trace(ae);
        }

        private void trace(ActionEvent ae) {
            String text;
            if (ae.getSource() == jcb1) {
                text = ((JCheckBox) ae.getSource()).getText();
                if (jcb1.isSelected()) {
                    text = text + "is selected";
                } else {
                    text = text + "is unselected";
                }
                txt.setText(text);
            } else {
                text = ((JButton) ae.getSource()).getText();
                txt.setText(text + " pressed");
            }

        }
    };

    public T15_ThreeBtnAndCb() {
        btn1.addActionListener(btListen);
        btn2.addActionListener(btListen);
        btn3.addActionListener(btListen);
        jcb1.addActionListener(btListen);
        setLayout(new FlowLayout());
        add(btn1);
        add(btn2);
        add(btn3);
        add(jcb1);
        add(txt);
    }

    public static void main(String[] args) {
        run(new T15_ThreeBtnAndCb(), 200, 200);
    }

}
