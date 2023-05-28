package GameLogic;

import Entity.Sprite;

public class CheckCollision
{

    GameScreen gameScreen;
    public CheckCollision(GameScreen gameScreen)
    {
        this.gameScreen = gameScreen;
    }

    public void checkTile(Sprite sprite)
    {
        int spriteLeftWorldX = sprite.worldX + sprite.solidArea.x;
        int spriteRightWorldX = sprite.worldX + sprite.solidArea.x + sprite.solidArea.width;
        int spriteTopWorldY = sprite.worldY + sprite.solidArea.y;
        int spriteBottomWorldY = sprite.worldY + sprite.solidArea.y + sprite.solidArea.height;

        int spriteLeftCol = spriteLeftWorldX / GameScreen.TILE_SIZE;
        int spriteRightCol = spriteRightWorldX / GameScreen.TILE_SIZE;
        int spriteTopRow = spriteTopWorldY / GameScreen.TILE_SIZE;
        int spriteBottomRow = spriteBottomWorldY / GameScreen.TILE_SIZE;

        int tileNum1, tileNum2;

        switch(sprite.direction)
        {
            case "up":
                spriteTopRow = (spriteTopWorldY - sprite.speed) / GameScreen.TILE_SIZE;
                tileNum1 = gameScreen.tileSetter.mapTileNum[spriteLeftCol][spriteTopRow];
                tileNum2 = gameScreen.tileSetter.mapTileNum[spriteRightCol][spriteTopRow];
                if(gameScreen.tileSetter.tiles[tileNum1].collision || gameScreen.tileSetter.tiles[tileNum2].collision)
                {
                    sprite.collisionOn = true;
                }
                break;
            case "down":
                spriteBottomRow = (spriteBottomWorldY + sprite.speed) / GameScreen.TILE_SIZE;
                tileNum1 = gameScreen.tileSetter.mapTileNum[spriteLeftCol][spriteBottomRow];
                tileNum2 = gameScreen.tileSetter.mapTileNum[spriteRightCol][spriteBottomRow];
                if(gameScreen.tileSetter.tiles[tileNum1].collision || gameScreen.tileSetter.tiles[tileNum2].collision)
                {
                    sprite.collisionOn = true;
                }
                break;
            case "left":
                spriteLeftCol = (spriteLeftWorldX - sprite.speed) / GameScreen.TILE_SIZE;
                tileNum1 = gameScreen.tileSetter.mapTileNum[spriteLeftCol][spriteTopRow];
                tileNum2 = gameScreen.tileSetter.mapTileNum[spriteLeftCol][spriteBottomRow];
                if(gameScreen.tileSetter.tiles[tileNum1].collision || gameScreen.tileSetter.tiles[tileNum2].collision)
                {
                    sprite.collisionOn = true;
                }
                break;
            case "right":
                spriteRightCol = (spriteRightWorldX + sprite.speed) / GameScreen.TILE_SIZE;
                tileNum1 = gameScreen.tileSetter.mapTileNum[spriteRightCol][spriteTopRow];
                tileNum2 = gameScreen.tileSetter.mapTileNum[spriteRightCol][spriteBottomRow];
                if(gameScreen.tileSetter.tiles[tileNum1].collision || gameScreen.tileSetter.tiles[tileNum2].collision)
                {
                    sprite.collisionOn = true;
                }
                break;
        }
    }
}
