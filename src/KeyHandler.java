import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    private boolean pressedW, pressedA, pressedS, pressedD;

    public KeyHandler() { //Set all the keys pressed to false.
        pressedW = false;
        pressedA = false;
        pressedS = false;
        pressedD = false;
    }

    @Override //Not important/used, still required for the code to run.
    public void keyTyped(KeyEvent e) {
    }

    @Override //When key is pressed.
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            pressedW = true;
        }else if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            pressedS = true;
        }

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            pressedA = true;
        }else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            pressedD = true;
        }
    }

    @Override //When key is released.
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            pressedW = false;
        }else if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            pressedS = false;
        }

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            pressedA = false;
        }else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            pressedD = false;
        }
    }

    //Return methods to get all inputs
    public boolean getW() {
        return pressedW;
    }
    public boolean getA() {
        return pressedA;
    }
    public boolean getS() {
        return pressedS;
    }
    public boolean getD() {
        return pressedD;
    }
}