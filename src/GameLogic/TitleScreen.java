package GameLogic;

import javax.swing.*;
import java.awt.*;

public class TitleScreen
{
    GameScreen gs;
    Image img, img2,img3;
    int imgWidth, imgHeight;
    int destinationX;
    int destinationY, startY;
    public TitleScreen(GameScreen gs)
    {
        this.gs = gs;
        img = new ImageIcon("assets/screens/super.png").getImage();
        img2 = new ImageIcon("assets/screens/4.png").getImage();
        img3 = new ImageIcon("assets/screens/5.png").getImage();
        imgWidth = 400;
        imgHeight = 400;
        destinationX = (GameScreen.SCREEN_WIDTH/2) - imgWidth/2;
        destinationY = (GameScreen.SCREEN_HEIGHT/2) - imgHeight/2 - 100;
        startY = -150;
    }

    public void startTitle(Graphics2D g2d)
    {
        if(startY <= destinationY)
        {
            g2d.drawImage(img,destinationX,startY,imgWidth,imgHeight,null);
            startY+=4;
        }
        else
        {
            g2d.drawImage(img2,destinationX - 200,startY + imgHeight - 100,imgWidth + 400,imgHeight - 100,null);
            g2d.drawImage( img,destinationX, startY, imgWidth, imgHeight, null);
        }
    }

    public void startEndTitle(Graphics2D g2d)
    {
        g2d.drawImage(img3,(GameScreen.SCREEN_WIDTH/2) - (600/2),
                (GameScreen.SCREEN_HEIGHT/2) - (480/2),600,480,null);
    }







}

