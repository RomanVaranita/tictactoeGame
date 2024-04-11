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
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(X_FIELD)){
                System.out.println(" HUMAN WIN");
                break;
            }
            if (checkDraft()) {
                System.out.println("GAME DRAFT");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(O_FIELD)){
                System.out.println("AI WIN");
                break;
            }
            if (checkDraft()) {
                System.out.println("GAME DRAFT");
                break;
            }
        }
    }
    public static boolean checkWin(char xField) {
        // Проверка горизонталей и вертикалей
        for (int i = 0; i < MAP_SIZE; i++) {
            if ((map[i][0] == map[i][1] && map[i][0] == map[i][2] && map[i][0] != EMPTY_FIELD) ||
                    (map[0][i] == map[1][i] && map[0][i] == map[2][i] && map[0][i] != EMPTY_FIELD)) {
                return true;
            }
        }

        // Проверка диагоналей
        if ((map[0][0] == map[1][1] && map[0][0] == map[2][2] && map[0][0] != EMPTY_FIELD) ||
                (map[0][2] == map[1][1] && map[0][2] == map[2][0] && map[0][2] != EMPTY_FIELD)) {
            return true;
        }

        // Если никто не выиграл
        return false;
    }

    public static boolean checkDraft(){
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if(map[i][j] == EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isCellEmpty(int x, int y){
        if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) {
            return false;
        }
        if (map[y][x] != EMPTY_FIELD){
            return false;
        }
        return true;
    }
    public static void aiTurn (){
        int x,y;
        System.out.println(" AI TURN ");
        do {
            x = (int)(Math.random() * MAP_SIZE);
            y = (int)(Math.random() * MAP_SIZE);
        } while (!isCellEmpty(x,y));
        map[y][x] = O_FIELD;
    }

    public static void humanTurn (){
        int x,y;
        do {
            System.out.println(" HUMAN TURN X Y? ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellEmpty(x,y));
        map[y][x] = X_FIELD;
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