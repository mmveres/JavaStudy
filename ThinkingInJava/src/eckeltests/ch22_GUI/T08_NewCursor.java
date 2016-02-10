/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class T08_NewCursor extends JFrame {

    private JComboBox<String> jComboBox = new JComboBox<>(new String[]{"a", "b", "c", "d"});

    T08_NewCursor() {
        jComboBox.setCursor(new Cursor(1));
        setLayout(new FlowLayout());
        add(jComboBox);
    }

    public static void main(String[] args) {
        run(new T08_NewCursor(), 100, 100);
    }

}

//    public static final int DEFAULT_CURSOR = 0;
//    public static final int CROSSHAIR_CURSOR = 1;
//    public static final int TEXT_CURSOR = 2;
//    public static final int WAIT_CURSOR = 3;
//    public static final int SW_RESIZE_CURSOR = 4;
//    public static final int SE_RESIZE_CURSOR = 5;
//    public static final int NW_RESIZE_CURSOR = 6;
//    public static final int NE_RESIZE_CURSOR = 7;
//    public static final int N_RESIZE_CURSOR = 8;
//    public static final int S_RESIZE_CURSOR = 9;
//    public static final int W_RESIZE_CURSOR = 10;
//    public static final int E_RESIZE_CURSOR = 11;
//    public static final int HAND_CURSOR = 12;
//    public static final int MOVE_CURSOR = 13;
