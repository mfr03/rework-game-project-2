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
    boolean isPepsi;
    public boolean finished;

    public PlayerSprite(GameScreen gameScreen, InputHandler inputHandler)
    {
        this.gameScreen = gameScreen;
        this.inputHandler = inputHandler;

        screenX = (GameScreen.SCREEN_WIDTH / 2) - (GameScreen.TILE_SIZE / 2);
        screenY = (gameScreen.SCREEN_HEIGHT / 2) - (GameScreen.TILE_SIZE / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
    }

    public void setDefaultValues()
    {
//        worldX = GameScreen.TILE_SIZE * 2;
//        worldY = GameScreen.TILE_SIZE * 2;
        speed = 4;
        spriteFiles = Util.loadFileToHashMap();
        isPepsi = false;
        finished = false;
        direction = "down";

        //map33
        worldX = GameScreen.TILE_SIZE * 2;
        worldY = GameScreen.TILE_SIZE * 17;
    }

    public void update()
    {
        if((inputHandler.isUp || inputHandler.isDown || inputHandler.isLeft || inputHandler.isRight) && !isPepsi)
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

            int objIndex = gameScreen.checkCollision.checkObject(this,true);
            if(objIndex == 999 && !isPepsi)
            {
                movePlayer();
            }
            else
            {
                System.out.println("collided mopve");
                deathSequence();
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
            if(direction.equals("down") )
            {
                direction = "idle";
            }
            else if(direction.equals("up"))
            {
                direction = "idleTop";
            }
            else if(direction.equals("right"))
            {
                direction = "idleRight";
            }
            else if(direction.equals("left"))
            {
                direction = "idleLeft";
            }


            int objIndex = gameScreen.checkCollision.checkObjectIdle(this,true);
            System.out.println(objIndex);
            if(objIndex != 999)
            {
                System.out.println("collided");
                deathSequence();
            }

            spriteCounter++;
            if(spriteCounter > 20) // for every 20 frames (1/3 s)
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
        if(finished)
        {
            System.out.println("finish");
        }
    }

    private void movePlayer()
    {
        if(collisionOn == false)
        {
            switch (direction)
            {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "right" -> worldX += speed;
                case "left" -> worldX -= speed;
            }
        }
    }
//    private void movePlayer(int objectIndex)
//    {
//        if(collisionOn)
//        {
//            switch (direction)
//            {
//                case "idleTop", "up" ->
//                {
//                    if (inputHandler.fKey || inputHandler.upArrow)
//                    {
//                        worldY -= speed;
//                        gameScreen.obj[objectIndex].worldY -= GameScreen.TILE_SIZE;
//                    }
//                }
//                case "idle", "down" ->
//                {
//                    if (inputHandler.fKey || inputHandler.downArrow)
//                    {
//                        worldY += speed;
//                        gameScreen.obj[objectIndex].worldY += GameScreen.TILE_SIZE;
//                    }
//                }
//                case "idleRight", "right" ->
//                {
//                    if (inputHandler.fKey || inputHandler.rightArrow)
//                    {
//                        worldX += speed;
//                        gameScreen.obj[objectIndex].worldX += GameScreen.TILE_SIZE;
//                    }
//                }
//                case "idleLeft", "left" ->
//                {
//                    if (inputHandler.fKey || inputHandler.leftArrow)
//                    {
//                        worldX -= speed;
//                        gameScreen.obj[objectIndex].worldX -= GameScreen.TILE_SIZE;
//                    }
//                }
//            }
//        }
//    }
//    private void objectInteraction(int objectIndex)
//    {
//        if(objectIndex != 999)
//        {
//            movePlayer(objectIndex);
//        }
//    }

    private void deathSequence()
    {
        isPepsi = true;
        direction = "Die";
        spriteNum = 0;
    }

    private void respawnPlayer()
    {
//        worldX = GameScreen.TILE_SIZE * 2;
//        worldY = GameScreen.TILE_SIZE * 2;
        isPepsi = false;

        //map33
        worldX = GameScreen.TILE_SIZE * 2;
        worldY = GameScreen.TILE_SIZE * 17;
    }


    public void draw(Graphics2D g2d)
    {
        Image image = null;
        ArrayList<Image> temp = getSpritesFromDirections(Util.loadFileToHashMap(),direction);
        int x = screenX;
        int y = screenY;
        if(screenX > worldX)
        {
            x  = worldX;
        }
        if(screenY > worldY)
        {
            y = worldY;
        }
        int rightWorldBorder = GameScreen.SCREEN_WIDTH - screenX;
        if(rightWorldBorder > gameScreen.worldWidth - worldX)
        {
            x = GameScreen.SCREEN_WIDTH - (gameScreen.worldWidth - worldX);
        }
        int bottomWorldBorder = GameScreen.SCREEN_HEIGHT - screenY;
        if(bottomWorldBorder > gameScreen.worldWidth - worldY)
        {
            y = GameScreen.SCREEN_HEIGHT - (gameScreen.worldHeight - worldY);
        }

        if((direction == "idle" || direction == "idleTop" || direction == "idleRight" || direction == "idleLeft") && spriteNum > 3)
        {
            spriteNum = 0;
            g2d.drawImage(temp.get(spriteNum), x, y,GameScreen.TILE_SIZE,GameScreen.TILE_SIZE,null);
        }
        else if(!isPepsi)
        {
            g2d.drawImage(temp.get(spriteNum), x, y,GameScreen.TILE_SIZE,GameScreen.TILE_SIZE,null);
        } else
        {
            g2d.drawImage(temp.get(spriteNum), x, y,GameScreen.TILE_SIZE,GameScreen.TILE_SIZE,null);
            if(spriteNum == 3)
            {
                direction = "idle";
                spriteNum = 0;
                respawnPlayer();
            }
        }
    }

    private ArrayList<Image> getSpritesFromDirections(Map<String, ArrayList<Image>> spriteFiles, String direction)
    {
        return switch (direction)
                {
                    case "up" -> spriteFiles.get("WalkUp");
                    case "down" -> spriteFiles.get("Walk");
                    case "right" -> spriteFiles.get("WalkRight");
                    case "left" -> spriteFiles.get("WalkLeft");
                    case "idle" -> spriteFiles.get("Idle");
                    case "idleTop" -> spriteFiles.get("IdleTop");
                    case "idleRight" -> spriteFiles.get("IdleRight");
                    case "idleLeft" -> spriteFiles.get("IdleLeft");
                    case "Die" -> spriteFiles.get("Die");
                    default -> null;
                };
    }
}
