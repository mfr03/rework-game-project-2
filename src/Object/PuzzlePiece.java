package Object;

import javax.swing.*;

public class PuzzlePiece extends GameObject
{
    public PuzzlePiece(int num)
    {
        name = "puzzle piece";
        String path = "./assets/objects/0";
        image = new ImageIcon(path + num + ".jpg").getImage();
        collision = true;
    }
}
