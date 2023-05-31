package GameLogic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener
{
    public boolean isUp, isDown, isLeft, isRight;
    public boolean fKey;
    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int eKey = e.getKeyCode();
        switch(eKey)
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
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

        int eKey = e.getKeyCode();

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
        }

    }
}
