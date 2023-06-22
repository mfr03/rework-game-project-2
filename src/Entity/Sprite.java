package Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public abstract class Sprite
{
    public int worldX, worldY;
    public int speed;
    public Map<String, ArrayList<Image>> spriteFiles;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 0;
    public Rectangle solidArea;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public Boolean collisionOn = false;

    public abstract void draw(Graphics2D g2d);

}
