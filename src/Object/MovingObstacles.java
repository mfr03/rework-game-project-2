package Object;

import GameLogic.GameScreen;

import javax.swing.*;

public class MovingObstacles extends GameObject
{
    boolean reverse = true;
    int destination;
    public MovingObstacles(int num)
    {
        name = "puzzle piece";
        String path = "./assets/objects/0";
        image = new ImageIcon(path + num + ".jpg").getImage();
        collision = true;
    }

    public void moveObj(GameObject objs[], int i)
    {
        if(i == 1 || i == 2)
        {
            destination = 14 * GameScreen.TILE_SIZE;
        }

        if(reverse)
        {
            if(objs[i].worldY <= destination - (GameScreen.TILE_SIZE * 3))
            {
                reverse = false;
            } else
            {
                objs[i].worldY -= 3;
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
                objs[i].worldY += 3;
            }
        }
    }
}
