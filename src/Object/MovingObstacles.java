package Object;

import GameLogic.GameScreen;

import javax.swing.*;

public class MovingObstacles extends GameObject
{
    boolean reverse = true;
    int destination = 13 * GameScreen.TILE_SIZE;

    public MovingObstacles(int num)
    {
        name = "puzzle piece";
        String path = "./assets/objects/0";
        image = new ImageIcon(path + num + ".jpg").getImage();
        collision = true;
    }

    public void moveObj(GameObject objs[], int i)
    {
        if(reverse)
        {
            if(objs[i].worldY <= destination - (GameScreen.TILE_SIZE * 4))
            {
                reverse = false;
            } else
            {
                objs[i].worldY -= 4;
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
                objs[i].worldY += 4;
            }
        }
    }
}
