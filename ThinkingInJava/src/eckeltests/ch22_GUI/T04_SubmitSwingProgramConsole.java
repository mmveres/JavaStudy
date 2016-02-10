/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import net.mindview.util.SwingConsole;

/**
 *
 * @author D2E
 */
public class T04_SubmitSwingProgramConsole extends JFrame{
    
    JLabel label;
    static T04_SubmitSwingProgramConsole ssp;

    T04_SubmitSwingProgramConsole() {
//        super("Hello Swing");
        label = new JLabel(" Init Contains");
        add(label);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(300, 100);
//        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        ssp=new T04_SubmitSwingProgramConsole();
        SwingConsole.run(ssp, 300, 100);
         TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ssp.label.setText(" Hey! This is Different!");
            }
        });
    }

}
