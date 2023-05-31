package GameLogic;
import Object.PuzzlePiece;
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

        for(int i = 0; i < 8; i++)
        {
            gameScreen.obj[i] = new PuzzlePiece(i);
            gameScreen.obj[i].worldX = GameScreen.TILE_SIZE * (8 + row);
            gameScreen.obj[i].worldY = GameScreen.TILE_SIZE * (8 + col);
            row++;
            if(row == 1)
            {
                row = 0;
                col++;
            }
        }

    }
}
