package Object;

import GameLogic.GameScreen;

import javax.swing.*;
import java.awt.*;

public class MovingObstacles extends GameObject
{
    boolean reverse = true;
    public int destination;
    int num;
    public int range = 3;
    public double speed = 3;

    public MovingObstacles(int num)
    {
        name = "puzzle piece";
        String path = "./assets/objects/0";
        image = new ImageIcon(path + num + ".png").getImage();
        collision = true;
        this.num = num;

        if (num == 9 || num == 10 || num == 11) {
            solidAreaDefaultX = 15;
            solidAreaDefaultY = 9;
            solidArea.width = 13;
            solidArea.height = 21;

        }
    }

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

    public void moveObj(GameObject objs[], int i)
    {
        int destinationX = objs[i].worldX;
        int destinationY = objs[i].worldY;

        if(GameScreen.currentLevel.equals("dragan"))
        {
            if(i == 1 || i == 2)
            {

                if (objs[i].worldX == destinationX && objs[i].worldY == destinationY)
                {
                    // Musuh berada di posisi awal, tentukan tujuan berikutnya
                    if (destinationX < 12 * GameScreen.TILE_SIZE && destinationY <= 1 * GameScreen.TILE_SIZE)
                    {
                        // Bergerak ke kanan
                        destinationX += 4 * GameScreen.TILE_SIZE;
                    } else if (destinationY < 5 * GameScreen.TILE_SIZE && destinationX >= 12 * GameScreen.TILE_SIZE)
                    {
                        // Bergerak ke bawah
                        destinationY += 4 * GameScreen.TILE_SIZE;
                    } else if (destinationX >= 8 * GameScreen.TILE_SIZE && destinationY <= 9 * GameScreen.TILE_SIZE)
                    {
                        // Bergerak ke kiri
                        destinationX -= 4 * GameScreen.TILE_SIZE;
                    } else if (destinationY >= 1 * GameScreen.TILE_SIZE && destinationX <= 8 * GameScreen.TILE_SIZE)
                    {
                        // Bergerak ke atas
                        destinationY -= 4 * GameScreen.TILE_SIZE;
                    }
                }

                if (objs[i].worldX < destinationX) {
                    // Bergerak ke kanan
                    if (destinationX - objs[i].worldX >= 4 * GameScreen.TILE_SIZE) {
                        objs[i].worldX += 3;
                    } else {
                        objs[i].worldX = destinationX;
                    }
                } else if (objs[i].worldY < destinationY) {
                    // Bergerak ke bawah
                    if (destinationY - objs[i].worldY >= 4 * GameScreen.TILE_SIZE) {
                        objs[i].worldY += 3;
                    } else {
                        objs[i].worldY = destinationY;
                    }
                } else if (objs[i].worldX > destinationX) {
                    // Bergerak ke kiri
                    if (objs[i].worldX - destinationX >= 4 * GameScreen.TILE_SIZE) {
                        objs[i].worldX -= 3;
                    } else {
                        objs[i].worldX = destinationX;
                    }
                } else {
                    // Bergerak ke atas
                    if (objs[i].worldY - destinationY >= 4 * GameScreen.TILE_SIZE) {
                        objs[i].worldY -= 3;
                    } else {
                        objs[i].worldY = destinationY;
                    }
                }
            }

            else if(i == 3 || i == 4)
            {
                if (i == 3) {
                    if (objs[i].worldX == destinationX && objs[i].worldY == destinationY) {
                        if (reverse) {
                            // Bergerak ke bawah
                            destinationY = 8 * GameScreen.TILE_SIZE;
                        } else if (!reverse) {
                            // Bergerak ke atas
                            destinationY = 18 * GameScreen.TILE_SIZE;
                        }

                    }

                }
                if(i == 4)
                {
                    if (objs[i].worldX == destinationX && objs[i].worldY == destinationY) {
                        if (reverse) {
                            // Bergerak ke bawah
                            destinationY = 11 * GameScreen.TILE_SIZE;
                        } else if (!reverse) {
                            // Bergerak ke atas
                            destinationY = 7 * GameScreen.TILE_SIZE;
                        }

                    }
                }

                if(objs[i].worldY < destinationY)
                {
                    objs[i].worldY += 3;
                }
                else if(objs[i].worldY > destinationY)
                {
                    objs[i].worldY -=3;
                }
                else if(objs[i].worldY == destinationY)
                {
                    if(reverse)
                    {
                        reverse = false;
                    }
                    else
                    {
                        reverse = true;
                    }
                }
            }
        }
        else if(GameScreen.currentLevel.equals("viko"))
        {
            if(num == 9)
            {
                if(reverse)
                {
                    if(objs[i].worldY <= destination - (GameScreen.TILE_SIZE * range))
                    {
                        reverse = false;
                    } else
                    {
                        objs[i].worldY -= speed;
                    }
                }
                else
                {
                    if(objs[i].worldY >= destination)
                    {
                        reverse = true;
                    }
                    else
                    {
                        objs[i].worldY += speed;
                    }
                }
            }

            else if(num == 10)
            {
                if(reverse)
                {
                    if(objs[i].worldX <= destination - (GameScreen.TILE_SIZE * range))
                    {
                        reverse = false;
                    } else
                    {
                        objs[i].worldX -= speed;
                    }
                }
                else
                {
                    if(objs[i].worldX >= destination)
                    {
                        reverse = true;
                    }
                    else
                    {
                        objs[i].worldX += speed;
                    }
                }
            }
        }

    }
}
