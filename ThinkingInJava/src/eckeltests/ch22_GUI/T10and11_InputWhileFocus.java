/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch22_GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import static net.mindview.util.SwingConsole.run;

/**
 *
 * @author D2E
 */
public class T10and11_InputWhileFocus extends JFrame {

    MyButton myButton = new MyButton("Focus me");
    JTextField jTextField = new JTextField(20);
    JTextField jTextFieldTest = new JTextField(20);

    private String text;

    class MyButton extends JButton {

        private boolean focused = false;
        private Random rand = new Random();
        private Color color;
        private MouseListener mouseListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                

                color = new Color(rand.nextInt(0xFFFFFF));
                setBackground(color);
            }
            

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        };
        private KeyListener keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                jTextFieldTest.setText("key typed");

                if (myButton.isFocused()) {
                    text = text + ke.getKeyChar();
                    jTextField.setText(text);
                }

            }

            @Override
            public void keyPressed(KeyEvent ke) {
                jTextFieldTest.setText("key pressed");
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                jTextFieldTest.setText("key released");
            }
        };
        private FocusListener focusListener = new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                focused = true;
                jTextFieldTest.setText("focused");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                focused = false;
                jTextFieldTest.setText("unfocused");
            }
        };

        public boolean isFocused() {
            return focused;
        }

        public MyButton(String name) {
            super(name);
            addFocusListener(focusListener);
            addKeyListener(keyListener);
            addMouseListener(mouseListener);
        }

    }

    T10and11_InputWhileFocus() {
        
        setLayout(new FlowLayout());
        add(jTextField);
        add(jTextFieldTest);
        add(myButton);

    }

    public static void main(String[] args) {
        run(new T10and11_InputWhileFocus(), 300, 300);
    }
}
