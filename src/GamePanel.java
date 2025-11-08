import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    private TileMap map = new TileMap();
    private Player snake = new Player();
    private KeyHandler keyH = new KeyHandler();
    private PointTile pTile = new PointTile();
    private boolean debounce = false;
    private boolean gameOver = false;
    private int score;
    final int rows = map.getRows();
    final int cols = map.getCols();
    final int sizeMul = 70; //Pixel size.
    final int width = cols * sizeMul;
    final int height = rows * sizeMul;
    final int intervalTime = 250;
    private Thread startLoop; //Game loop which will run while the programming is active.

    public GamePanel(GameWindow window) { //Constructer to set the preferred settings for window.
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        score = 0;

        map.getMap()[snake.getY()][snake.getX()] = 1;
        map.getMap()[pTile.getY()][pTile.getX()] = -1;
    }

    public void game() { //Initiate the game loop.
        startLoop = new Thread(this);
        startLoop.start();
    }

    @Override
    public void run() { //Start loop.
        long lastInterval = System.currentTimeMillis();
        while (this != null) {
            keys();
            long currentTime = System.currentTimeMillis(); //Short interval between each frame. The keys method is excluded from this interval.
            if (currentTime-lastInterval < intervalTime) {
                continue; //Continues throughout the loop.
            }
            debounce = false;
            lastInterval = System.currentTimeMillis();

            gameOver = update();
            repaint(); //This calls the paintComponent method to draw in the window.
            if (gameOver) break;
        } 
    }

    //Checks for input and validates.
    public void keys() {
        if (keyH.getW() && snake.getDy() == 0 && !debounce) {
            debounce = true;
            snake.setDy(-1);
            snake.setDx(0);
        }
        if (keyH.getS() && snake.getDy() == 0 && !debounce) {
            debounce = true;
            snake.setDy(1);
            snake.setDx(0);
        }
        if (keyH.getA() && snake.getDx() == 0 && !debounce) {
            debounce = true;
            snake.setDx(-1);
            snake.setDy(0);
        }
        if (keyH.getD() && snake.getDx() == 0 && !debounce) {
            debounce = true;
            snake.setDx(1);
            snake.setDy(0);
        }
    }

    public boolean update() { //The actual logic of the game.
        //Update the position.
        if (score == 89) return true;

        if (!(snake.getDx() == 0 && snake.getDy() == 0)) { //Start the game logic when the player begins.
            if (map.getMap()[snake.getY()+snake.getDy()][snake.getX()+snake.getDx()] == -2 || map.getMap()[snake.getY()+snake.getDy()][snake.getX()+snake.getDx()] > 0) return true;
            if (map.getMap()[snake.getY()+snake.getDy()][snake.getX()+snake.getDx()] == -1) {
                map.addAll();
                score += 1;
                pTile.setRespawn(true);
            }

            map.getMap()[snake.getY()+snake.getDy()][snake.getX()+snake.getDx()] = map.getMap()[snake.getY()][snake.getX()]+1;
            snake.setX(snake.getX()+snake.getDx());
            snake.setY(snake.getY()+snake.getDy());
            map.removeOne();

            if (pTile.getRespawn()) {
                int[] newPosition = pTile.getRandomPos(map.getMap(), score);
                map.getMap()[newPosition[0]][newPosition[1]] = -1;
                pTile.setRespawn(false);
            }
        }

        return false;
    }

    public void paintComponent(Graphics g) { //Method for painting on the frame.
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(sizeMul, sizeMul, width-sizeMul*2, height-sizeMul*2); //This creates the black background around the border.

        for (int i = 0; i < map.getRows(); i++) {
            for (int j = 0; j < map.getCols(); j++) {
                if (map.getMap()[i][j] > 0) {
                    g2.setColor(Color.green);
                    g2.fillRect(sizeMul*j, sizeMul*i, sizeMul, sizeMul);
                } else if (map.getMap()[i][j] == -1) {
                    g2.setColor(Color.red);
                    g2.fillRect(sizeMul*j, sizeMul*i, sizeMul, sizeMul);
                }
            }
        }
        g2.dispose();
    }
}