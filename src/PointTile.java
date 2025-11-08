import java.util.Random;

public class PointTile {
    private boolean respawn;
    private int x;
    private int y;

    public PointTile() {
        respawn = false;
        x = 8;
        y = 5;
    }

    //Method for getting the random position in the tile map and returning it.
    public int[] getRandomPos(int[][] map, int score) {
        int[] position = new int[2];
        int[][] availablePositions = new int[(10*9)-score][2];
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    availablePositions[count][0] = i;
                    availablePositions[count][1] = j;
                    count += 1;
                }
            }
        }

        Random rNumber = new Random();
        position = availablePositions[rNumber.nextInt(availablePositions.length-1)];

        return position;
    }

    //return methods to get position.
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getRespawn() {
        return respawn;
    }

    public void setRespawn(boolean respawn) {
        this.respawn = respawn;
    }
}