package World;

import GameLogic.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileSetter
{
    GameScreen gameScreen;
    public Tile[] tiles;
    public int mapTileNum[][];

    public TileSetter(GameScreen gameScreen)
    {
        this.gameScreen = gameScreen;

        tiles = new Tile[10];
        mapTileNum = new int[GameScreen.MAX_WORLD_COL][GameScreen.MAX_WORLD_ROW];
        getTileImages();
        loadMap();
    }

    public void getTileImages()
    {
        tiles[0] = new Tile();
        tiles[0].image = new ImageIcon("assets/backgrounds/grass1.png").getImage();
        tiles[1] = new Tile();
        tiles[1].image = new ImageIcon("assets/backgrounds/grass2.png").getImage();
        tiles[2] = new Tile();
        tiles[2].image = new ImageIcon("assets/backgrounds/wall6.png").getImage();
        tiles[2].collision = true;
    }
    public void loadMap()
    {
        try
        {
            InputStream is =getClass().getResourceAsStream("tileArrangement.txt");

            BufferedReader br = new BufferedReader( new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < GameScreen.MAX_WORLD_COL && row < GameScreen.MAX_WORLD_ROW)
            {
                String line = br.readLine();

                while(col < GameScreen.MAX_WORLD_COL)
                {
                    String nums[] = line.split(" ");

                    int num = Integer.parseInt(nums[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if(col == GameScreen.MAX_WORLD_COL)
                {
                    row++;
                    col = 0;
                }
            }
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2d)
    {
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < GameScreen.MAX_WORLD_COL && worldRow < GameScreen.MAX_WORLD_ROW)
        {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * GameScreen.TILE_SIZE;
            int worldY = worldRow * GameScreen.TILE_SIZE;
            int screenX = worldX -  gameScreen.playerSprite.worldX + gameScreen.playerSprite.screenX;
            int screenY = worldY -  gameScreen.playerSprite.worldY + gameScreen.playerSprite.screenY;


            g2d.drawImage(tiles[tileNum].image, screenX, screenY, GameScreen.TILE_SIZE, GameScreen.TILE_SIZE, null);


            worldCol++;

            if(worldCol == GameScreen.MAX_WORLD_COL)
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
