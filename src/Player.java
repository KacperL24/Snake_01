public class Player {
    private int x;
    private int y;
    private int dx;
    private int dy;

    public Player() {
        x = 3;
        y = 5;
        dx = 0; //Where dx and dy is the current velocity/direction of snake.
        dy = 0;
    }

    //Set position/velocity methods.
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }

    //Get position/velocity methods.
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
}