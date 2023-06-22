package GameLogic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class InputHandler implements KeyListener
{
    public boolean isUp, isDown, isLeft, isRight;
    public boolean xKey;
    public boolean mark;


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
        if(GameScreen.gameState != 0)
        {
            for(Integer key: keys)
            {
                switch(key)
                {
                    case KeyEvent.VK_W, KeyEvent.VK_UP:
                        isUp = true;
                        break;
                    case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                        isDown = true;
                        break;
                    case KeyEvent.VK_A, KeyEvent.VK_LEFT:
                        isLeft = true;
                        break;
                    case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                        isRight = true;
                        break;
                    case KeyEvent.VK_9:
                        mark = true;
                        break;
                }
            }
        }
        else
        {
            for(Integer key: keys)
            {
                if(key == KeyEvent.VK_X)
                {
                    GameScreen.gameState = 1;
                }
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
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                isUp = false;
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                isDown = false;
                break;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT:
                isLeft = false;
                break;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                isRight = false;
                break;
            case KeyEvent.VK_X:
                xKey = false;
                break;
            case KeyEvent.VK_9:
                mark = false;
                break;
        }

    }
}
