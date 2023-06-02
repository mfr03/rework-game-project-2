package GameLogic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class InputHandler implements KeyListener
{
    public boolean isUp, isDown, isLeft, isRight;
    public boolean fKey, gKey;

    public boolean upArrow, downArrow, rightArrow, leftArrow;

    public Set<Integer> keys = new HashSet<Integer>();
    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int eKey = e.getKeyCode();
        keys.add(eKey);
        multiKeys();
    }
    private void multiKeys()
    {
        for(Integer key: keys)
        {
            switch(key)
            {
                case KeyEvent.VK_W:
                    isUp = true;
                    break;
                case KeyEvent.VK_S:
                    isDown = true;
                    break;
                case KeyEvent.VK_A:
                    isLeft = true;
                    break;
                case KeyEvent.VK_D:
                    isRight = true;
                    break;
                case KeyEvent.VK_F:
                    fKey = true;
                    break;
                case KeyEvent.VK_G:
                    gKey = true;
                    break;
                case KeyEvent.VK_UP:
                    upArrow = true;
                    break;
                case KeyEvent.VK_DOWN:
                    downArrow = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightArrow = true;
                    break;
                case KeyEvent.VK_LEFT:
                    leftArrow = true;
                    break;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e)
    {

        int eKey = e.getKeyCode();
        keys.remove(eKey);
        switch(eKey)
        {
            case KeyEvent.VK_W:
                isUp = false;
                break;
            case KeyEvent.VK_S:
                isDown = false;
                break;
            case KeyEvent.VK_A:
                isLeft = false;
                break;
            case KeyEvent.VK_D:
                isRight = false;
                break;
            case KeyEvent.VK_F:
                fKey = false;
                break;
            case KeyEvent.VK_G:
                gKey = false;
                break;
            case KeyEvent.VK_UP:
                upArrow = false;
                break;
            case KeyEvent.VK_DOWN:
                downArrow = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightArrow = false;
                break;
            case KeyEvent.VK_LEFT:
                leftArrow = false;
                break;
        }

    }
}
