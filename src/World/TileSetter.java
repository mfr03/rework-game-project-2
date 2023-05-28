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
    Tile[] tiles;
    int mapTileNum[][];

    public TileSetter(GameScreen gameScreen)
    {
        this.gameScreen = gameScreen;

        tiles = new Tile[10];
        mapTileNum = new int[GameScreen.DEFAULT_TILE_SIZE][GameScreen.MAX_SCREEN_ROWS];
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
    }
    public void loadMap()
    {
        try
        {
            InputStream is =getClass().getResourceAsStream("tileArrangement.txt");

            BufferedReader br = new BufferedReader( new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < GameScreen.MAX_SCREEN_COLUMNS && row < GameScreen.MAX_SCREEN_ROWS)
            {
                String line = br.readLine();

                while(col < GameScreen.MAX_SCREEN_COLUMNS)
                {
                    String nums[] = line.split(" ");

                    int num = Integer.parseInt(nums[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if(col == GameScreen.MAX_SCREEN_COLUMNS)
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
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < GameScreen.MAX_SCREEN_COLUMNS && row < GameScreen.MAX_SCREEN_ROWS)
        {
            int tileNum = mapTileNum[col][row];
            g2d.drawImage(tiles[tileNum].image, x,y,GameScreen.TILE_SIZE, GameScreen.TILE_SIZE, null);
            col++;
            x += GameScreen.TILE_SIZE;

            if(col == GameScreen.MAX_SCREEN_COLUMNS)
            {
                row++;
                y += GameScreen.TILE_SIZE;
                col = 0;
                x = 0;
            }
        }
    }
}
