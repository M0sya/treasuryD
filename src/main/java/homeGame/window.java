package homeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class window extends JFrame {

    private  field gameField;

    private class myKey implements KeyListener{
        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            int _key = e.getKeyCode();
            switch (_key){
                case 27:{
                    System.exit(0);
                }
                case 37:{
                    if(gameField.x-30>-48) gameField.x -=30;
                    else  gameField.x = 752;
                    break;
                }
                case  39:{
                    if(gameField.x+30<752) gameField.x +=30;
                    else gameField.x = -48;
                    break;
                }
            }
        }

        public void keyReleased(KeyEvent e) {

        }
    }

    public window(int complexity){
        addKeyListener(new myKey());
        setFocusable(true);
        setBounds(0,0,800,600);
        setTitle("Игра: дождь");

        gameField = new field(complexity);
        Container con = getContentPane();
        con.add(gameField);
        setVisible(true);
    }

}
