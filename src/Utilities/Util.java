package Utilities;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Util
{
    private static ArrayList<Image> loadFile(String path)
    {
        String tempPath;
        ArrayList<Image> frameImages = new ArrayList<>();
        for(int i = 1; i <= new File(path).listFiles().length; i++)
        {
            tempPath = path + "/" + "Girl" + i + ".png";
            ImageIcon ii = new ImageIcon(tempPath);
            frameImages.add(ii.getImage());
        }
        return frameImages;
    }

    public static Map<String, ArrayList<Image>> loadFileToHashMap()
    {
        String[] lists = {"Die", "Idle", "IdleLeft", "IdleRight", "IdleTop",
                "Walk", "WalkLeft", "WalkRight", "WalkUp"};
        Map<String, ArrayList<Image>> temp = new HashMap<>();
        String path = "assets/sprites/";
        for(String item : lists)
        {
            temp.put(item, loadFile(path + item));
        }
        return temp;
    }
}
