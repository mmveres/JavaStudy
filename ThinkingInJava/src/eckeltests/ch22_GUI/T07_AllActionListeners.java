/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;


import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.jws.Oneway;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class T07_AllActionListeners extends JFrame implements ActionListener{
    private JButton jButton = new JButton("Button");
    private JToggleButton jToggleButton = new JToggleButton("Toggle");
//    private JList<String> jList=new JList<>(new String[]{"a1","b2","c2","d4"});
    private JMenuItem jMenuItem = new JMenuItem("Menu Item");
    private JComboBox<String> jComboBox = new JComboBox<>(new String[]{"a","b","c","d"});
    private JFileChooser jFileChooser=new JFileChooser();
    private JTextField jTextField=new JTextField("test", 20);

    
    T07_AllActionListeners(){
        jButton.addActionListener(this);
        jToggleButton.addActionListener(this);
        jMenuItem.addActionListener(this);
        jComboBox.addActionListener(this);
        jFileChooser.addActionListener(this);
        jTextField.addActionListener(this);

              
        setLayout(new FlowLayout());
        add(jButton);
        add(jToggleButton);
        add(jMenuItem);
        add(jComboBox);
        add(jFileChooser);
        add(jTextField);
    
    
    }
    
    public static void main(String[] args) {
        run(new T07_AllActionListeners(),100,300);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==jButton){
            jTextField.setText("Button");
        }else if (ae.getSource()==jToggleButton){
            jTextField.setText("Toggle");
        }else if (ae.getSource()==jMenuItem){
            jTextField.setText("Menu Item");
        }else if (ae.getSource()==jComboBox){
            jTextField.setText("Combo box");
        }else if (ae.getSource()==jFileChooser){
            jTextField.setText("File chooser");
        }else if (ae.getSource()==jTextField){
            jTextField.setText("Text field!");
        }
    }
            

}
