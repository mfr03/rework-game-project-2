package Object;

import GameLogic.GameScreen;

import javax.swing.*;

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

        if (num == 9 || num == 10) {
            solidAreaDefaultX = 15;
            solidAreaDefaultY = 9;
            solidArea.width = 13;
            solidArea.height = 21;

        }
    }

    public void moveObj(GameObject objs[], int i)
    {
//        if(i == 1 || i == 2)
//        {
//            destination = 14 * GameScreen.TILE_SIZE;
//        }
//
//        if(reverse)
//        {
//            if(objs[i].worldY <= destination - (GameScreen.TILE_SIZE * 3))
//            {
//                reverse = false;
//            } else
//            {
//                objs[i].worldY -= 3;
//            }
//        }
//        else
//        {
//            if(objs[i].worldY >= destination)
//            {
//                reverse = true;
//            }
//            else
//            {
//                objs[i].worldY += 3;
//            }
//        }

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

        if(num == 10)
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
