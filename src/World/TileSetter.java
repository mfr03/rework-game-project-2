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

        tiles = new Tile[30];
        mapTileNum = new int[GameScreen.MAX_WORLD_COL][GameScreen.MAX_WORLD_ROW];
        getTileImages();
        loadMap(gameScreen.currentLevel);
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
        tiles[3] = new Tile();
        tiles[3].image = new ImageIcon("assets/2770921.png").getImage();
        tiles[3].collision = true;
        tiles[14] = new Tile();
        tiles[14].image = new ImageIcon("assets/backgrounds/floor_2.png").getImage();
        tiles[15] = new Tile();
        tiles[15].image = new ImageIcon("assets/backgrounds/floor_1.png").getImage();
        tiles[16] = new Tile();
        tiles[16].image = new ImageIcon("assets/backgrounds/wall_left_corner.png").getImage();
        tiles[16].collision = true;
        tiles[17] = new Tile();
        tiles[17].image = new ImageIcon("assets/backgrounds/wall_right_corner.png").getImage();
        tiles[17].collision = true;
        tiles[18] = new Tile();
        tiles[18].image = new ImageIcon("assets/backgrounds/floor_ladder.png").getImage();
        tiles[18].collision = true;
        tiles[19] = new Tile();
        tiles[19].image = new ImageIcon("assets/backgrounds/wall_mid_broken.png").getImage();
        tiles[19].collision = true;
        tiles[20] = new Tile();
        tiles[20].image = new ImageIcon("assets/backgrounds/wall_left_end.png").getImage();
        tiles[20].collision = true;
        tiles[21] = new Tile();
        tiles[21].image = new ImageIcon("assets/backgrounds/wall_mid.png").getImage();
        tiles[21].collision = true;
        tiles[22] = new Tile();
        tiles[22].image = new ImageIcon("assets/backgrounds/wall_right_end.png").getImage();
        tiles[22].collision = true;
        tiles[23] = new Tile();
        tiles[23].image = new ImageIcon("assets/backgrounds/wall_right_side.png").getImage();
        tiles[23].collision = true;
        tiles[24] = new Tile();
        tiles[24].image = new ImageIcon("assets/backgrounds/wall_left_side.png").getImage();
        tiles[24].collision = true;
        tiles[25] = new Tile();
        tiles[25].image = new ImageIcon("assets/backgrounds/wall_mid_left.png").getImage();
        tiles[25].collision = true;
        tiles[26] = new Tile();
        tiles[26].image = new ImageIcon("assets/backgrounds/wall_both_end.png").getImage();
        tiles[26].collision = true;
        tiles[27] = new Tile();
        tiles[27].image = new ImageIcon("assets/backgrounds/wall_mid_right.png").getImage();
        tiles[27].collision = true;
        tiles[28] = new Tile();
        tiles[28].image = new ImageIcon("assets/backgrounds/wall_both_side.png").getImage();
        tiles[28].collision = true;
        tiles[29] = new Tile();
        tiles[29].image = new ImageIcon("assets/backgrounds/void.png").getImage();
    }

    public void loadMap(String levelPath)
    {
        try
        {
            InputStream is =getClass().getResourceAsStream(levelPath + ".txt");

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

            if(gameScreen.playerSprite.screenX > gameScreen.playerSprite.worldX)
            {
                screenX = worldX;
            }
            if(gameScreen.playerSprite.screenY > gameScreen.playerSprite.worldY)
            {
                screenY = worldY;
            }
            int rightWorldBorder = GameScreen.SCREEN_WIDTH - gameScreen.playerSprite.screenX;
            if(rightWorldBorder > gameScreen.worldWidth - gameScreen.playerSprite.worldX)
            {
                screenX = GameScreen.SCREEN_WIDTH - (gameScreen.worldWidth - worldX);
            }
            int bottomWorldBorder = GameScreen.SCREEN_HEIGHT - gameScreen.playerSprite.screenY;
            if(bottomWorldBorder > gameScreen.worldWidth - gameScreen.playerSprite.worldY)
            {
                screenY = GameScreen.SCREEN_HEIGHT - (gameScreen.worldHeight - worldY);
            }

            if(worldX + GameScreen.TILE_SIZE > gameScreen.playerSprite.worldX - gameScreen.playerSprite.screenX &&
            worldX - GameScreen.TILE_SIZE < gameScreen.playerSprite.worldX + gameScreen.playerSprite.screenX &&
            worldY + GameScreen.TILE_SIZE > gameScreen.playerSprite.worldY - gameScreen.playerSprite.screenY &&
            worldY - GameScreen.TILE_SIZE < gameScreen.playerSprite.worldY + gameScreen.playerSprite.screenY)
            {
                g2d.drawImage(tiles[tileNum].image, screenX, screenY, GameScreen.TILE_SIZE, GameScreen.TILE_SIZE, null);
            }
            else if(gameScreen.playerSprite.screenX > gameScreen.playerSprite.worldX ||
                    gameScreen.playerSprite.screenY > gameScreen.playerSprite.worldY ||
                    rightWorldBorder > gameScreen.worldWidth - gameScreen.playerSprite.worldX ||
                    bottomWorldBorder > gameScreen.worldWidth - gameScreen.playerSprite.worldY)
            {
                g2d.drawImage(tiles[tileNum].image, screenX, screenY, GameScreen.TILE_SIZE, GameScreen.TILE_SIZE, null);
            }

            worldCol++;

            if(worldCol == GameScreen.MAX_WORLD_COL)
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
