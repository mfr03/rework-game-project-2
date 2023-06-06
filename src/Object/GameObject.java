package Object;

import GameLogic.GameScreen;

import java.awt.*;

public class GameObject
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

        if(gameScreen.playerSprite.worldX < gameScreen.playerSprite.screenX) {
            screenX = worldX;
        }
        if(gameScreen.playerSprite.worldY < gameScreen.playerSprite.screenY) {
            screenY = worldY;
        }
        int rightWorldBorder = GameScreen.SCREEN_WIDTH- gameScreen.playerSprite.screenX;
        if(rightWorldBorder > gameScreen.worldWidth - gameScreen.playerSprite.worldX) {
            screenX = GameScreen.SCREEN_WIDTH - (gameScreen.worldWidth - worldX);
        }
        int bottomWorldBorder = GameScreen.SCREEN_HEIGHT - gameScreen.playerSprite.screenY;
        if(bottomWorldBorder > gameScreen.worldHeight - gameScreen.playerSprite.worldY) {
            screenY = GameScreen.SCREEN_HEIGHT - (gameScreen.worldHeight - worldY);
        }

        if(worldX + GameScreen.TILE_SIZE > gameScreen.playerSprite.worldX - gameScreen.playerSprite.screenX &&
                worldX - GameScreen.TILE_SIZE < gameScreen.playerSprite.worldX + gameScreen.playerSprite.screenX &&
                worldY + GameScreen.TILE_SIZE > gameScreen.playerSprite.worldY - gameScreen.playerSprite.screenY &&
                worldY - GameScreen.TILE_SIZE < gameScreen.playerSprite.worldY + gameScreen.playerSprite.screenY
            )
        {
            g2d.drawImage(image, screenX, screenY, GameScreen.TILE_SIZE, GameScreen.TILE_SIZE, null);
        }
        else if(gameScreen.playerSprite.worldX < gameScreen.playerSprite.screenX ||
                gameScreen.playerSprite.worldY < gameScreen.playerSprite.screenY ||
                rightWorldBorder > gameScreen.worldWidth - gameScreen.playerSprite.worldX ||
                bottomWorldBorder > gameScreen.worldHeight - gameScreen.playerSprite.worldY
                )
        {
            g2d.drawImage(image, screenX, screenY, GameScreen.TILE_SIZE, GameScreen.TILE_SIZE, null);
        }
    }
}
