import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public static void main() {
        JFrame.setDefaultLookAndFeelDecorated(false);
    }

    public GameWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("SNAKE");
        this.setIconImage(new ImageIcon("./src/Apple.png").getImage());
    } //Set the window options.
}
