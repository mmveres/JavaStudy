/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class T09_ShowMethodsGUI extends JFrame {

    private JTextField name = new JTextField(25);
    private JTextArea results = new JTextArea(40, 65);
    private Pattern p = Pattern.compile("\\w+\\.");
    private String usage
            = "put into search field:\n"
            + "qualified.class.name - "
            + "to show all methods in class\n"
            + " or: qualified.class.name word\n"
            + "To search for methods involving 'word'";

    class MethodL implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            String[] nm = name.getText().split(" ");
            if (nm.length < 1) {
                results.append(usage);
            } else {
                results.setText("");
//                int lines = 0;
                try {
                    Class<?> c = Class.forName(nm[0]);
                    Method[] methods = c.getMethods();
                    Constructor[] ctors = c.getConstructors();
                    if (nm.length == 1) {
                        for (Method method : methods) {
                            results.append(
                                    p.matcher(method.toString()).replaceAll("") + "\n");
                        }
                        for (Constructor ctor : ctors) {
                            results.append(p.matcher(ctor.toString()).replaceAll("") + "\n");
                        }
//                        lines = methods.length + ctors.length;
                    } else {
                        for (Method method : methods) {
                            if (method.toString().indexOf(nm[1]) != -1) {
                                results.append(
                                        p.matcher(method.toString()).replaceAll("") + "\n");
//                                lines++;
                            }
                        }
                        for (Constructor ctor : ctors) {
                            if (ctor.toString().indexOf(nm[1]) != -1) {
                                results.append(p.matcher(
                                        ctor.toString()).replaceAll("") + "\n");
//                                lines++;
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    results.append("No such class: " + e+ "\n");
                    results.append(usage);
                }
            }

        }
    }

    T09_ShowMethodsGUI() {
        MethodL mtdListener = new MethodL();
        name.addActionListener(mtdListener);
        setLayout(new FlowLayout());
        JPanel top = new JPanel();
        top.add(new JLabel("Swing class name (press Enter):"));
        top.add(name);
        
        add(top);
        add(new JScrollPane(results));
        // Initial data and test:
        name.setText("java.lang.Object notify");
        mtdListener.actionPerformed(
                new ActionEvent("", 0, ""));
    }

    public static void main(String[] args) {
        run(new T09_ShowMethodsGUI(), 400, 400);
    }

}
