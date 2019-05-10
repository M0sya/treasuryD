package homeGame;

import javax.swing.*;
import java.io.IOException;

public class game {
    public static void main(String[] args){
        String rez = JOptionPane.showInputDialog(null, "Введите сложность игры от 1 до 7:", "Сложность игры",1);
        int complexity = rez.charAt(0)-'0';
        if((complexity>=1)&&(complexity<=7)) {
            window okno = new window(complexity);
        }
    }
}
