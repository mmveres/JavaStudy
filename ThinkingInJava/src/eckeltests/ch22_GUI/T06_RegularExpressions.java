/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class T06_RegularExpressions  extends JFrame {

    private JTextArea jtaInput = new JTextArea(2, 30),
            jtaOutput = new JTextArea(15, 30);
    private JTextField jtfRegEx = new JTextField(20);
    private JButton jbAnalyze = new JButton("Analyze");

    public T06_RegularExpressions(){
        jbAnalyze.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String[] regExps;

                if (jtaInput.getText().length() == 0 || jtfRegEx.getText().length() == 0) {
                    jtaOutput.setText("Pls enter string in big field and RegEx in small!!!");
                } else {
                    regExps = jtfRegEx.getText().split(" ");
                    jtaOutput.setText("");
                    jtaOutput.append("Input: " + jtaInput.getText() + "\n");
                    for (String arg : regExps) {
                        jtaOutput.append("Regular expression: " + arg + "\n");
                        Pattern p = Pattern.compile(arg);
                        Matcher m = p.matcher(jtaInput.getText());
                        while (m.find()) {
                            jtaOutput.append("Match " + m.group() + " at positions "
                                    + m.start() + "-" + (m.end() - 1)+ "\n");
                        }
                    }
                }

            }
        });
        setLayout(new FlowLayout());
        add(jtaInput);
        add(jtfRegEx);
        add(new JScrollPane(jtaOutput));
        add(jbAnalyze);
    }

    public static void main(String[] args) {
        run(new T06_RegularExpressions(),400,400);
    }

}



