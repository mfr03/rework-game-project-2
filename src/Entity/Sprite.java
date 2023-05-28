package Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class Sprite
{
    public int worldX, worldY;
    public int speed;
    public Map<String, ArrayList<Image>> spriteFiles;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 0;
    public Rectangle solidArea;

    public Boolean collisionOn = false;

}
