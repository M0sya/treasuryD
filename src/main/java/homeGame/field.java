package homeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class field extends JPanel {
    private Image basket;
    private Image backGround;
    public int x =400;
    private int complexity;
    private drop[] gameDrops;
    private Image endGame;
    public Timer timerUpdate;
    public Timer timerDraw;

    public field(int complexity) {
        this.complexity=complexity;
        gameDrops = new drop[7];
        for (int i=0;i<7;i++){
            try{
                gameDrops[i] = new drop(ImageIO.read(new File("./drop"+i+".png")));
            } catch (IOException ex){}
        }

        try {
            basket = ImageIO.read(new File("./basketForGame.png"));
        }catch (IOException ex){}

        try {
            backGround = ImageIO.read(new File("./poleBackground.jpg"));
        }catch (IOException ex){}

        try {
            endGame = ImageIO.read(new File("./endGame.jpg"));
        }catch (IOException ex){}

        timerUpdate = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStart();
            }
        });
        timerUpdate.start();

        timerDraw = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerDraw.start();
    }

    public void paintComponent(Graphics gr){
        super.paintComponent(gr);
        gr.drawImage(backGround, 0, 0 , null);
        gr.drawImage(basket,x,465,null);
        for(int i=0;i<7;i++){
            gameDrops[i].draw(gr);
            if(gameDrops[i].action){
                if((gameDrops[i].y+gameDrops[i].image.getHeight(null))>=470){
                    if(Math.abs(gameDrops[i].x-x)>75){
                        gr.drawImage(endGame, 300,300,null);
                        timerDraw.stop();
                        timerUpdate.stop();
                        break;
                    }
                    else gameDrops[i].action=false;
                }
            }
        }
    }
    private void updateStart(){
        int count=0;
        for(int i=0;i<7;i++){
            if(!gameDrops[i].action){
                if(count<complexity){
                    gameDrops[i].start();
                    break;
                }
            }
            else count++;
        }
    }
}
