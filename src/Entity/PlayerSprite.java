package Entity;


import GameLogic.GameScreen;
import GameLogic.InputHandler;
import Utilities.Util;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class PlayerSprite extends Sprite
{
    GameScreen gameScreen;
    InputHandler inputHandler;

    public final int screenX;
    public final int screenY;

    public PlayerSprite(GameScreen gameScreen, InputHandler inputHandler)
    {
        this.gameScreen = gameScreen;
        this.inputHandler = inputHandler;

        screenX = (GameScreen.SCREEN_WIDTH / 2) - (GameScreen.TILE_SIZE / 2);
        screenY = (gameScreen.SCREEN_HEIGHT / 2) - (GameScreen.TILE_SIZE / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
    }

    public void setDefaultValues()
    {
        worldX = GameScreen.TILE_SIZE * 10;
        worldY = GameScreen.TILE_SIZE * 10;
        speed = 3;
        spriteFiles = Util.loadFileToHashMap();
        direction = "down";
    }

    public void update()
    {
        if(inputHandler.isUp || inputHandler.isDown || inputHandler.isLeft || inputHandler.isRight)
        {
            if(inputHandler.isUp)
            {
                direction = "up";

            }
            else if(inputHandler.isDown)
            {
                direction = "down";
            }
            else if(inputHandler.isRight)
            {
                direction = "right";
            }
            else if(inputHandler.isLeft)
            {
                direction = "left";
            }

            collisionOn = false;
            gameScreen.checkCollision.checkTile(this);
            if(collisionOn == false)
            {
                switch (direction)
                {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                }
            }
            spriteCounter++;

            if(spriteCounter > 20) // for every 20 frames
            {
                if(spriteNum == 0)
                {
                    spriteNum = 1;
                }
                else if(spriteNum == 1)
                {
                    spriteNum = 2;
                }
                else if (spriteNum == 2)
                {
                    spriteNum = 3;
                }
                else if (spriteNum == 3)
                {
                    spriteNum = 4;
                }
                else if (spriteNum == 4)
                {
                    spriteNum = 5;
                }
                else if (spriteNum == 5)
                {
                    spriteNum = 0;
                }
                spriteCounter = 0;
            }
        }
        else
        {
            direction = "idle";
            spriteCounter++;
            if(spriteCounter > 20) // for every 20 frames
            {
                if(spriteNum == 0)
                {
                    spriteNum = 1;
                }
                else if(spriteNum == 1)
                {
                    spriteNum = 2;
                }
                else if (spriteNum == 2)
                {
                    spriteNum = 3;
                }
                else if (spriteNum == 3)
                {
                    spriteNum = 0;
                }

                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2d)
    {
        Image image = null;
        ArrayList<Image> temp = getSpritesFromDirections(Util.loadFileToHashMap(),direction);
        System.out.println(direction + " " + worldX + " " + worldY);
        if(direction == "idle" && spriteNum > 3)
        {
            spriteNum = 0;
            g2d.drawImage(temp.get(spriteNum), screenX, screenY,GameScreen.TILE_SIZE,GameScreen.TILE_SIZE,null);
        }
        else
        {
            g2d.drawImage(temp.get(spriteNum), screenX, screenY,GameScreen.TILE_SIZE,GameScreen.TILE_SIZE,null);
        }
    }

    private ArrayList<Image> getSpritesFromDirections(Map<String, ArrayList<Image>> spriteFiles, String direction)
    {
        switch (direction)
        {
            case "up":
                return spriteFiles.get("WalkUp");
            case "down":
                return spriteFiles.get("Walk");
            case "right":
                return spriteFiles.get("WalkRight");
            case "left":
                return spriteFiles.get("WalkLeft");
            case "idle":
                return spriteFiles.get("Idle");
        }
        return null;
    }
}
