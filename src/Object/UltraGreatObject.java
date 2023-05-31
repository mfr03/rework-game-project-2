package Object;

import GameLogic.GameScreen;

import java.awt.*;

public class UltraGreatObject
{
    public Image image;
    public String name;
    public boolean collision = false;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public int worldX, worldY;

    public void draw(Graphics2D g2d, GameScreen gameScreen)
    {
        int screenX = worldX -  gameScreen.playerSprite.worldX + gameScreen.playerSprite.screenX;
        int screenY = worldY -  gameScreen.playerSprite.worldY + gameScreen.playerSprite.screenY;

        if(worldX + GameScreen.TILE_SIZE > gameScreen.playerSprite.worldX - gameScreen.playerSprite.screenX &&
                worldX - GameScreen.TILE_SIZE < gameScreen.playerSprite.worldX + gameScreen.playerSprite.screenX &&
                worldY + GameScreen.TILE_SIZE > gameScreen.playerSprite.worldY - gameScreen.playerSprite.screenY &&
                worldY - GameScreen.TILE_SIZE < gameScreen.playerSprite.worldY + gameScreen.playerSprite.screenY)
        {
            g2d.drawImage(image, screenX, screenY, GameScreen.TILE_SIZE, GameScreen.TILE_SIZE, null);
        }
    }
}
