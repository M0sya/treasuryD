package homeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class drop {

    public Image image;
    public int x, y;
    public Boolean action;
    public Timer timerUpdate;

    public drop(Image image) {
        timerUpdate = new Timer(50,new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                down();
            }
        });

        this.image = image;
        action = false;
    }

    public  void start(){
        timerUpdate.start();
        y=0;
        x =(int)(Math.random()*700);
        action = true;
    }
    public void down(){
        if(action ==true) y+=6;
        if((y+image.getHeight((null))>=470)) timerUpdate.stop();
    }
    public void  draw(Graphics gr){
        if(action){
            gr.drawImage(image,x,y,null);
        }
    }
}