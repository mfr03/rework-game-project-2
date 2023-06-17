package GameLogic;
import Object.*;
public class ObjectSetter
{
    GameScreen gameScreen;

    public ObjectSetter(GameScreen gameScreen)
    {
        this.gameScreen = gameScreen;
    }

    public void setObject()
    {
        int row = 0;
        int col = 0;

//        gameScreen.obj[1] = new MovingObstacles(1);
//        gameScreen.obj[1].worldX = 8 * GameScreen.TILE_SIZE;
//        gameScreen.obj[1].worldY = 13 * GameScreen.TILE_SIZE;
//
//        gameScreen.obj[2] = new MovingObstacles(2);
//        gameScreen.obj[2].worldX = 7 * GameScreen.TILE_SIZE;
//        gameScreen.obj[2].worldY = 11 * GameScreen.TILE_SIZE;

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
}
