package GameLogic;
import Object.*;
public class ObjectSetter
{
    GameScreen gameScreen;

    public ObjectSetter(GameScreen gameScreen)
    {
        this.gameScreen = gameScreen;
    }

    public void setObject(String level)
    {
        gameScreen.obj = new MovingObstacles[20];
        if(level.equals("viko"))
        {
            gameScreen.obj[1] = new MovingObstacles(9);
            gameScreen.obj[1].worldX = 9 * GameScreen.TILE_SIZE;
            gameScreen.obj[1].worldY = 18 * GameScreen.TILE_SIZE;
            gameScreen.obj[1].destination = 18 * GameScreen.TILE_SIZE;

            gameScreen.obj[2] = new MovingObstacles(9);
            gameScreen.obj[2].worldX = 11 * GameScreen.TILE_SIZE;
            gameScreen.obj[2].worldY = 15 * GameScreen.TILE_SIZE;
            gameScreen.obj[2].destination = 18 * GameScreen.TILE_SIZE;

            gameScreen.obj[3] = new MovingObstacles(9);
            gameScreen.obj[3].worldX = 13 * GameScreen.TILE_SIZE;
            gameScreen.obj[3].worldY = 18 * GameScreen.TILE_SIZE;
            gameScreen.obj[3].destination = 18 * GameScreen.TILE_SIZE;

            gameScreen.obj[4] = new MovingObstacles(9);
            gameScreen.obj[4].worldX = 15 * GameScreen.TILE_SIZE;
            gameScreen.obj[4].worldY = 15 * GameScreen.TILE_SIZE;
            gameScreen.obj[4].destination = 18 * GameScreen.TILE_SIZE;

            gameScreen.obj[5] = new MovingObstacles(9);
            gameScreen.obj[5].worldX = 17 * GameScreen.TILE_SIZE;
            gameScreen.obj[5].worldY = 3 * GameScreen.TILE_SIZE;
            gameScreen.obj[5].destination = 17 * GameScreen.TILE_SIZE;
            gameScreen.obj[5].range = 14;
            gameScreen.obj[5].speed = 4.5;

            gameScreen.obj[6] = new MovingObstacles(10);
            gameScreen.obj[6].worldX = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[6].worldY = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[6].destination = 17 * GameScreen.TILE_SIZE;
            gameScreen.obj[6].range = 16;
            gameScreen.obj[6].speed = 4.5;

            gameScreen.obj[7] = new MovingObstacles(10);
            gameScreen.obj[7].worldX = 17 * GameScreen.TILE_SIZE;
            gameScreen.obj[7].worldY = 2 * GameScreen.TILE_SIZE;
            gameScreen.obj[7].destination = 17 * GameScreen.TILE_SIZE;
            gameScreen.obj[7].range = 16;
            gameScreen.obj[7].speed = 4.5;

            gameScreen.obj[8] = new MovingObstacles(10);
            gameScreen.obj[8].worldX = 5 * GameScreen.TILE_SIZE;
            gameScreen.obj[8].worldY = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[8].destination = 13 * GameScreen.TILE_SIZE;
            gameScreen.obj[8].range = 8;
            gameScreen.obj[8].speed = 4;

            gameScreen.obj[9] = new MovingObstacles(10);
            gameScreen.obj[9].worldX = 13 * GameScreen.TILE_SIZE;
            gameScreen.obj[9].worldY = 10 * GameScreen.TILE_SIZE;
            gameScreen.obj[9].destination = 13 * GameScreen.TILE_SIZE;
            gameScreen.obj[9].range = 8;
            gameScreen.obj[9].speed = 4;

            gameScreen.obj[10] = new MovingObstacles(9);
            gameScreen.obj[10].worldX = 11 * GameScreen.TILE_SIZE;
            gameScreen.obj[10].worldY = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[10].destination = 11 * GameScreen.TILE_SIZE;

            gameScreen.obj[11] = new MovingObstacles(9);
            gameScreen.obj[11].worldX = 9 * GameScreen.TILE_SIZE;
            gameScreen.obj[11].worldY = 11 * GameScreen.TILE_SIZE;
            gameScreen.obj[11].destination = 11 * GameScreen.TILE_SIZE;

            gameScreen.obj[12] = new MovingObstacles(9);
            gameScreen.obj[12].worldX = 7 * GameScreen.TILE_SIZE;
            gameScreen.obj[12].worldY = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[12].destination = 11 * GameScreen.TILE_SIZE;

        }
        else if(level.equals("dragan"))
        {
            gameScreen.obj[1] = new MovingObstacles(9);
            gameScreen.obj[1].worldX = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[1].worldY = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[2] = new MovingObstacles(9);
            gameScreen.obj[2].worldX = 12 * GameScreen.TILE_SIZE;
            gameScreen.obj[2].worldY = 5 * GameScreen.TILE_SIZE;
            gameScreen.obj[3]=new MovingObstacles(9);
            gameScreen.obj[3].worldX = 5 * GameScreen.TILE_SIZE;
            gameScreen.obj[3].worldY = 18 * GameScreen.TILE_SIZE;
            gameScreen.obj[4]=new MovingObstacles(9);
            gameScreen.obj[4].worldX = 4 * GameScreen.TILE_SIZE;
            gameScreen.obj[4].worldY = 7 * GameScreen.TILE_SIZE;
            gameScreen.obj[5]=new MovingObstacles(9);
            gameScreen.obj[5].worldY = 3 * GameScreen.TILE_SIZE;
            gameScreen.obj[5].worldX = 16 * GameScreen.TILE_SIZE;
            gameScreen.obj[6]=new MovingObstacles(9);
            gameScreen.obj[6].worldY = 7 * GameScreen.TILE_SIZE;
            gameScreen.obj[6].worldX = 16 * GameScreen.TILE_SIZE;
            gameScreen.obj[7]=new MovingObstacles(9);
            gameScreen.obj[7].worldY = 6 * GameScreen.TILE_SIZE;
            gameScreen.obj[7].worldX = 18 * GameScreen.TILE_SIZE;
            gameScreen.obj[8]=new MovingObstacles(9);
            gameScreen.obj[8].worldY = 10 * GameScreen.TILE_SIZE;
            gameScreen.obj[8].worldX = 18 * GameScreen.TILE_SIZE;
        }
        else if(level.equals("edi"))
        {
            gameScreen.obj[1] = new MovingObstacles(9);
            gameScreen.obj[1].worldX = 5 * GameScreen.TILE_SIZE;
            gameScreen.obj[1].worldY = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[1].destination = 2 * GameScreen.TILE_SIZE;
            gameScreen.obj[1].range = 1;
            gameScreen.obj[1].speed = 1;

            gameScreen.obj[2] = new MovingObstacles(9);
            gameScreen.obj[2].worldX = 9 * GameScreen.TILE_SIZE;
            gameScreen.obj[2].worldY = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[2].destination = 2 * GameScreen.TILE_SIZE;
            gameScreen.obj[2].range = 1;
            gameScreen.obj[2].speed = 1.5;

            gameScreen.obj[3] = new MovingObstacles(10);
            gameScreen.obj[3].worldX = 3 * GameScreen.TILE_SIZE;
            gameScreen.obj[3].worldY = 2 * GameScreen.TILE_SIZE;
            gameScreen.obj[3].destination = 17 * GameScreen.TILE_SIZE;
            gameScreen.obj[3].range = 12;
            gameScreen.obj[3].speed = 2;

            gameScreen.obj[4] = new MovingObstacles(10);
            gameScreen.obj[4].worldX = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[4].worldY = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[4].destination = 17 * GameScreen.TILE_SIZE;
            gameScreen.obj[4].range = 16;
            gameScreen.obj[4].speed = 3;



            gameScreen.obj[5] = new MovingObstacles(10);
            gameScreen.obj[5].worldX = 9 * GameScreen.TILE_SIZE;
            gameScreen.obj[5].worldY = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[5].destination = 16 * GameScreen.TILE_SIZE;
            gameScreen.obj[5].range = 12;
            gameScreen.obj[5].speed = 3;

            gameScreen.obj[6] = new MovingObstacles(9);
            gameScreen.obj[6].worldX = 14 * GameScreen.TILE_SIZE;
            gameScreen.obj[6].worldY = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[6].destination = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[6].range = 1;
            gameScreen.obj[6].speed = 1;

            gameScreen.obj[7] = new MovingObstacles(10);
            gameScreen.obj[7].worldX = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[7].worldY = 7 * GameScreen.TILE_SIZE;
            gameScreen.obj[7].destination = 16 * GameScreen.TILE_SIZE;
            gameScreen.obj[7].range = 12;
            gameScreen.obj[7].speed = 1;

            gameScreen.obj[8] = new MovingObstacles(9);
            gameScreen.obj[8].worldX = 5 * GameScreen.TILE_SIZE;
            gameScreen.obj[8].worldY = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[8].destination = 8 * GameScreen.TILE_SIZE;
            gameScreen.obj[8].range = 1;
            gameScreen.obj[8].speed = 1;
            gameScreen.obj[9] = new MovingObstacles(10);
            gameScreen.obj[9].worldX = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[9].worldY = 12 * GameScreen.TILE_SIZE;
            gameScreen.obj[9].destination = 3 * GameScreen.TILE_SIZE;
            gameScreen.obj[9].range = 2;
            gameScreen.obj[9].speed = 1;

            gameScreen.obj[10] = new MovingObstacles(10);
            gameScreen.obj[10].worldX = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[10].worldY = 13 * GameScreen.TILE_SIZE;
            gameScreen.obj[10].destination = 3 * GameScreen.TILE_SIZE;
            gameScreen.obj[10].range = 2;
            gameScreen.obj[10].speed = 1.5;

            gameScreen.obj[11] = new MovingObstacles(10);
            gameScreen.obj[11].worldX = 1 * GameScreen.TILE_SIZE;
            gameScreen.obj[11].worldY = 14 * GameScreen.TILE_SIZE;
            gameScreen.obj[11].destination = 3 * GameScreen.TILE_SIZE;
            gameScreen.obj[11].range = 2;
            gameScreen.obj[11].speed = 2;

            gameScreen.obj[12] = new MovingObstacles(10);
            gameScreen.obj[12].worldX = 2 * GameScreen.TILE_SIZE;
            gameScreen.obj[12].worldY = 14 * GameScreen.TILE_SIZE;
            gameScreen.obj[12].destination = 3 * GameScreen.TILE_SIZE;
            gameScreen.obj[12].range = 2;
            gameScreen.obj[12].speed = 3;
        }
    }
}
