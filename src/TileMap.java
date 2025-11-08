public class TileMap {
    private int[][] map;
    final int rows = 11;
    final int cols = 12;

    /* 
    Tile Map where:
    0 = Empty space
    -1 = Fruit
    -2 = Border
    0< = Snake
    */

    public TileMap() {
        map = new int[rows][cols];
        initiateMap();
    }

    public void initiateMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || j == 0 || i == map.length-1 || j == map[i].length-1) {
                    map[i][j] = -2;
                }
            }
        }
    }

    public void removeOne() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] > 0) {map[i][j] -= 1;}
            }
        }
    }

    public void addAll() { //Adds 1 to all snake tiles, called whenever a point tile is hit.
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] > 0) map[i][j] += 1;
            }
        }
    }

    //Methods for dimensions.
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getMap() {
        return map;
    }

    //Print details for tile map: TESTING PURPOSES ONLY.
    public void printDetails() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println(" ");
        }
    }
}