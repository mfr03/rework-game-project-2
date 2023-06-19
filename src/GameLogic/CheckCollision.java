package GameLogic;

import Entity.Sprite;

public class CheckCollision
{

    GameScreen gameScreen;
    public CheckCollision(GameScreen gameScreen)
    {
        this.gameScreen = gameScreen;
    }

    public int checkObject(Sprite sprite, boolean player)
    {
        int index = 999;
        for(int i = 0; i < gameScreen.obj.length; i++)
        {
            if(gameScreen.obj[i] != null)
            {
                sprite.solidArea.x = sprite.worldX + sprite.solidArea.x;
                sprite.solidArea.y = sprite.worldY + sprite.solidArea.y;

                gameScreen.obj[i].solidArea.x = gameScreen.obj[i].worldX + gameScreen.obj[i].solidArea.x;
                gameScreen.obj[i].solidArea.y = gameScreen.obj[i].worldY + gameScreen.obj[i].solidArea.y;
                switch (sprite.direction)
                {
                    case "up":
                        sprite.solidArea.y -= sprite.speed;
                        if(sprite.solidArea.intersects(gameScreen.obj[i].solidArea))
                        {
                            System.out.println(sprite.direction);
                            if(gameScreen.obj[i].collision)
                            {
                                sprite.collisionOn = true;
                            }
                            if(player)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        sprite.solidArea.y += sprite.speed;
                        if(sprite.solidArea.intersects(gameScreen.obj[i].solidArea))
                        {
                            if(gameScreen.obj[i].collision)
                            {
                                sprite.collisionOn = true;
                            }
                            if(player)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        sprite.solidArea.x += sprite.speed;
                        if(sprite.solidArea.intersects(gameScreen.obj[i].solidArea))
                        {
                            if(gameScreen.obj[i].collision)
                            {
                                sprite.collisionOn = true;
                            }
                            if(player)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        sprite.solidArea.x -= sprite.speed;
                        if(sprite.solidArea.intersects(gameScreen.obj[i].solidArea))
                        {
                            if(gameScreen.obj[i].collision)
                            {
                                sprite.collisionOn = true;
                            }
                            if(player)
                            {
                                index = i;
                            }
                        }
                        break;
                }
                sprite.solidArea.x = sprite.solidAreaDefaultX;
                sprite.solidArea.y = sprite.solidAreaDefaultY;
                gameScreen.obj[i].solidArea.x = gameScreen.obj[i].solidAreaDefaultX;
                gameScreen.obj[i].solidArea.y = gameScreen.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }

    public int checkObjectIdle(Sprite sprite, Boolean player)
    {
        int index = 999;
        for(int i = 0; i < gameScreen.obj.length; i++)
        {
            if(gameScreen.obj[i] != null)
            {
                sprite.solidArea.x = sprite.worldX + sprite.solidArea.x;
                sprite.solidArea.y = sprite.worldY + sprite.solidArea.y;

                gameScreen.obj[i].solidArea.x = gameScreen.obj[i].worldX + gameScreen.obj[i].solidArea.x;
                gameScreen.obj[i].solidArea.y = gameScreen.obj[i].worldY + gameScreen.obj[i].solidArea.y;
                switch (sprite.direction)
                {
                    case "idleTop":
                        sprite.solidArea.y -= sprite.speed;
                        if(sprite.solidArea.intersects(gameScreen.obj[i].solidArea))
                        {
                            System.out.println(sprite.direction);
                            if(gameScreen.obj[i].collision)
                            {
                                sprite.collisionOn = true;
                            }
                            if(player)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "idle":
                        sprite.solidArea.y += sprite.speed;
                        if(sprite.solidArea.intersects(gameScreen.obj[i].solidArea))
                        {
                            if(gameScreen.obj[i].collision)
                            {
                                sprite.collisionOn = true;
                            }
                            if(player)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "idleRight":
                        sprite.solidArea.x += sprite.speed;
                        if(sprite.solidArea.intersects(gameScreen.obj[i].solidArea))
                        {
                            if(gameScreen.obj[i].collision)
                            {
                                sprite.collisionOn = true;
                            }
                            if(player)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "idleLeft":
                        sprite.solidArea.x -= sprite.speed;
                        if(sprite.solidArea.intersects(gameScreen.obj[i].solidArea))
                        {
                            if(gameScreen.obj[i].collision)
                            {
                                sprite.collisionOn = true;
                            }
                            if(player)
                            {
                                index = i;
                            }
                        }
                        break;
                }
                sprite.solidArea.x = sprite.solidAreaDefaultX;
                sprite.solidArea.y = sprite.solidAreaDefaultY;
                gameScreen.obj[i].solidArea.x = gameScreen.obj[i].solidAreaDefaultX;
                gameScreen.obj[i].solidArea.y = gameScreen.obj[i].solidAreaDefaultY;
            }
        }
        return index;
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
                    if(tileNum1 == 3 || tileNum2 == 3 || tileNum1 == 18 || tileNum2 == 18)
                    {
                        gameScreen.playerSprite.finished = true;
                    }
                }
                break;
            case "down":
                spriteBottomRow = (spriteBottomWorldY + sprite.speed) / GameScreen.TILE_SIZE;
                tileNum1 = gameScreen.tileSetter.mapTileNum[spriteLeftCol][spriteBottomRow];
                tileNum2 = gameScreen.tileSetter.mapTileNum[spriteRightCol][spriteBottomRow];
                if(gameScreen.tileSetter.tiles[tileNum1].collision || gameScreen.tileSetter.tiles[tileNum2].collision)
                {
                    sprite.collisionOn = true;
                    if(tileNum1 == 3 || tileNum2 == 3 || tileNum1 == 18 || tileNum2 == 18)
                    {
                        gameScreen.playerSprite.finished = true;
                    }
                }
                break;
            case "left":
                spriteLeftCol = (spriteLeftWorldX - sprite.speed) / GameScreen.TILE_SIZE;
                tileNum1 = gameScreen.tileSetter.mapTileNum[spriteLeftCol][spriteTopRow];
                tileNum2 = gameScreen.tileSetter.mapTileNum[spriteLeftCol][spriteBottomRow];
                if(gameScreen.tileSetter.tiles[tileNum1].collision || gameScreen.tileSetter.tiles[tileNum2].collision)
                {
                    sprite.collisionOn = true;
                    if(tileNum1 == 3 || tileNum2 == 3 || tileNum1 == 18 || tileNum2 == 18)
                    {
                        gameScreen.playerSprite.finished = true;
                    }
                }
                break;
            case "right":
                spriteRightCol = (spriteRightWorldX + sprite.speed) / GameScreen.TILE_SIZE;
                tileNum1 = gameScreen.tileSetter.mapTileNum[spriteRightCol][spriteTopRow];
                tileNum2 = gameScreen.tileSetter.mapTileNum[spriteRightCol][spriteBottomRow];
                if(gameScreen.tileSetter.tiles[tileNum1].collision || gameScreen.tileSetter.tiles[tileNum2].collision)
                {
                    sprite.collisionOn = true;
                    if(tileNum1 == 3 || tileNum2 == 3 || tileNum1 == 18 || tileNum2 == 18)
                    {
                        gameScreen.playerSprite.finished = true;
                    }
                }
                break;
        }
    }
}
