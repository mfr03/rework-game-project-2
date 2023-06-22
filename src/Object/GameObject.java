package Object;

import GameLogic.GameScreen;

import java.awt.*;

public abstract class GameObject
{
    public Image image;
    public String name;
    public boolean collision = false;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public int worldX, worldY;


    public abstract void draw(Graphics2D g2d, GameScreen gameScreen);
}
