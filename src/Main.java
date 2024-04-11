import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static char[][] map;

    static final int MAP_SIZE = 3;
    static final char EMPTY_FIELD = '*';
    static final char X_FIELD = 'X';
    static final char O_FIELD = 'O';

    public static void main(String[] args) {
        init();
        printMap();

    }
    public static void humanTurn (){
        System.out.println("Введите координаты вашего хода X Y?");
        int x,y;
        x = scanner.nextInt();
        y = scanner.nextInt();
        System.out.println("Bu Beli " + x + " " + y);
    }

    public static void printMap(){
        // 0 1 2 3
        // 1 * * *
        // 2 * * *
        // 3 * * *
        //
        for (int i = 0; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void init(){
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY_FIELD;
            }
        }
       scanner = new Scanner(System.in);
    }
}