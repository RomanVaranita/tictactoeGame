public class Main {

    static char[][] map;

    static final int MAP_SIZE = 3;
    static final char EMPTY_FIELD = '*';

    public static void main(String[] args) {
        initMap();

    }

    public static void printMap(){

    }

    public static void initMap(){
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY_FIELD;
            }
        }

    }
}