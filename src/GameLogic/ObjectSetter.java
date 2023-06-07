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

        gameScreen.obj[1] = new MovingObstacles(1);
        gameScreen.obj[1].worldX = 8 * GameScreen.TILE_SIZE;
        gameScreen.obj[1].worldY = 13 * GameScreen.TILE_SIZE;

        gameScreen.obj[2] = new MovingObstacles(2);
        gameScreen.obj[2].worldX = 7 * GameScreen.TILE_SIZE;
        gameScreen.obj[2].worldY = 11 * GameScreen.TILE_SIZE;


    }
}
