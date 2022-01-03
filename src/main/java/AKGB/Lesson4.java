package AKGB;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X, map)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn(DOT_X, map);
            printMap();
            if (checkWin(DOT_O, map)) {
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    /* public static int[] checkPreWinH(int[] ret) { //проверка предвыигрышной ситуации по горизонтали
        int[] checkPreWinH = new int[2];
        int elemPreWinH1 = 0;
        int elemPreWinH2 = 0;
        checkPreWinH[0] = elemPreWinH1;
        checkPreWinH[1] = elemPreWinH2;
        int countH = 0;
        int moveCount = 0;


        for (int i = 1; i <= ret.length-2; i++) {
            countH = 0;

        if (ret[i] == DOT_X) {
                moveCount = 0;
                for (int indRet = i; moveCount <= DOTS_TO_WIN; indRet++) {
                    moveCount++;
                    if (ret[indRet] == DOT_X)
                        countH++;
                    if (countH == DOTS_TO_WIN - 1)
                        elemPreWinH2 = i - 1;
                        if (ret[indRet] != DOT_X)
                            elemPreWinH1 = indRet;
                        moveCount = DOTS_TO_WIN+1;
                }
            }
        } return checkPreWinH;
    }

    public static int[] checkPreWinV(int[] ret) { //проверка по вертикали
        int[] checkPreWinV = new int[2];
        int elemPreWinV1 = 0;
        int elemPreWinV2 = 0;
        checkPreWinV[0] = elemPreWinV1;
        checkPreWinV[1] = elemPreWinV2;
        int countV = 0;
        int moveCount = 0;

        for (int i = 1; i <= ret.length; i++) {
            countV = 0;
            if (ret[i] == DOT_X) {
                moveCount = 0;
                for (int indRet = i; moveCount <= DOTS_TO_WIN; indRet = indRet + SIZE) {
                    moveCount++;
                    if (ret[indRet] == DOT_X)
                        countV++;
                    if (countV == DOTS_TO_WIN - 1)
                        elemPreWinV2 = i - SIZE;
                    if (ret[indRet] != DOT_X)
                        elemPreWinV1 = indRet;
                    moveCount = DOTS_TO_WIN;
                }
            }
        } return checkPreWinV;
    }

    public static int[] checkPreWinA(int[] ret) { //проверка по диаганали A "\"
        int[] checkPreWinA = new int[2];
        int elemPreWinA1 = 0;
        int elemPreWinA2 = 0;
        checkPreWinA[0] = elemPreWinA1;
        checkPreWinA[1] = elemPreWinA2;
        int countA = 0;
        int moveCount = 0;

        for (int i = 1; i <= ret.length; i++) {
            countA = 0;
            if (ret[i] == DOT_X) {
                moveCount = 0;
                for (int indRet = i; moveCount <= DOTS_TO_WIN; indRet = indRet + SIZE + 1) {
                    moveCount++;
                    if (ret[indRet] == DOT_X)
                        countA++;
                    if (countA == DOTS_TO_WIN - 1)
                        elemPreWinA2 = i - SIZE - 1;
                    if (ret[indRet] != DOT_X)
                        elemPreWinA1 = indRet;
                    moveCount = DOTS_TO_WIN;
                }
            }
        } return checkPreWinA;
    }

    public static int[] checkPreWinB(int[] ret) { //проверка по диаганали В "/"
        int[] checkPreWinB = new int[2];
        int elemPreWinB1 = 0;
        int elemPreWinB2 = 0;
        checkPreWinB[0] = elemPreWinB1;
        checkPreWinB[1] = elemPreWinB2;
        int countB = 0;
        int moveCount = 0;

        for (int i = 1; i <= ret.length; i++) {
            countB = 0;
            if (ret[i] == DOT_X) {
                moveCount = 0;
                for (int indRet = i; moveCount <= DOTS_TO_WIN; indRet = indRet + SIZE + 1) {
                    moveCount++;
                    if (ret[indRet] == DOT_X)
                        countB++;
                    if (countB == DOTS_TO_WIN - 1)
                        elemPreWinB2 = i - SIZE - 1;
                    if (ret[indRet] != DOT_X)
                        elemPreWinB1 = indRet;
                    moveCount = DOTS_TO_WIN;
                }
            }
        } return checkPreWinB;
    }
*/


/*
                //проверка по вертикали
                moveCount = 0;
                for (indRet = i; moveCount < DOTS_TO_WIN; indRet = (char) (indRet + SIZE)) {
                    moveCount++;
                    if (ret[indRet] == symbol)
                        countV++;
                    if (ret[indRet] != symbol)
                        elemPreWinV = indRet;
                    if (i + (SIZE * (DOTS_TO_WIN - 1)) >= ret.length)
                        moveCount = DOTS_TO_WIN;
                    if (countH == DOTS_TO_WIN - 1) return elemPreWinV;
                }


                //проверка по диаганали A "\"
                moveCount = 0;
                for (indRet = i; moveCount < DOTS_TO_WIN; indRet = (char) (indRet + (SIZE + 1))) {
                    moveCount++;
                    if (ret[indRet] == symbol)
                        countA++;
                    if (ret[indRet] != symbol)
                        elemPreWinA = indRet;
                    if (i + (SIZE * (DOTS_TO_WIN - 1)) >= ret.length)
                        moveCount = DOTS_TO_WIN;
                    if ((i + 1) % SIZE > DOTS_TO_WIN | (i + 1) % SIZE == 0)
                        moveCount = DOTS_TO_WIN;
                    if (countH == DOTS_TO_WIN - 1) return elemPreWinA;
                }

                //проверка диагонали B "/"
                moveCount = 0;
                for (indRet = i; moveCount < DOTS_TO_WIN; indRet = (char) (indRet + (SIZE - 1))) {
                    moveCount++;
                    if (ret[indRet] == symbol)
                        countB++;
                    if (ret[indRet] != symbol)
                        elemPreWinB = indRet;
                    if (i + (SIZE * (DOTS_TO_WIN - 1)) >= ret.length)
                        moveCount = DOTS_TO_WIN;
                    if ((i + 1) % SIZE < DOTS_TO_WIN && (i + 1) % SIZE > 0)
                        moveCount = DOTS_TO_WIN;
                    if (countH == DOTS_TO_WIN - 1) return elemPreWinB;
                }
            }

        } return noPreWin;
    }
*/

    static int preWin (char symbol, char[][] arr) {
        int countElem = 0;
        for (char[] tmpArr : arr)
            countElem += tmpArr.length;
        char[] ret = new char[countElem];
        int indRet = 0;
        for (char[] tmpArr : arr)
            for (char elemTmpArr : tmpArr)
                ret[indRet++] = elemTmpArr;


        for (indRet = 0; indRet < ret.length; indRet++) {
            int countPreWinH = 0;
            int preH = 0;
            int formula1 = (SIZE % (indRet + 1));
            if (ret[indRet] == symbol)
                if (formula1 >= DOTS_TO_WIN) {
                    char[] preWinH = new char[DOTS_TO_WIN];
                    System.arraycopy(ret, indRet, preWinH, 0, DOTS_TO_WIN);
                    for (int h = 0; countPreWinH < DOTS_TO_WIN - 1; h++) {
                    if (preWinH[h] == symbol)
                            countPreWinH++;
                        if (preWinH[h] != symbol)
                            preH = h;
                        if (countPreWinH == DOTS_TO_WIN - 1) return preH;
                    }
                }
        } return 0;
    }
    public static boolean checkWin(char symbol, char[][] matrix) {
        int countH = 0;
        int countV = 0;
        int countA = 0;
        int countB = 0;
        int moveCount = 0;
        int countElem = 0;
        for (char[] tmpArr : matrix)
            countElem += tmpArr.length;
        char[] ret = new char[countElem];
        int indRet = 0;
        for (char[] tmpArr : matrix)
            for (char elemTmpArr : tmpArr)
                ret[indRet++] = elemTmpArr;

        for (int i = 0; i < ret.length; i++) {
            countH = 0;
            countV = 0;
            countA = 0;
            countB = 0;
            //проверка по горизонтали
            if (ret[i] == symbol) {
                moveCount = 0;
                for (indRet = i; moveCount < DOTS_TO_WIN; indRet++) {
                    moveCount++;
                    if (ret[indRet] == symbol)
                        countH++;
                    if (ret[indRet] != symbol)
                        countH = 0;
                    if ((i + 1) % SIZE > DOTS_TO_WIN | (i + 1) % SIZE == 0)
                        moveCount = DOTS_TO_WIN;
                    if (countH == DOTS_TO_WIN) return true;
                }


                //проверка по вертикали
                moveCount = 0;
                for (indRet = i; moveCount < DOTS_TO_WIN; indRet = indRet + SIZE) {
                    moveCount++;
                    if (ret[indRet] == symbol)
                        countV++;
                    if (ret[indRet] != symbol)
                        countV = 0;
                    if (i + (SIZE*(DOTS_TO_WIN-1)) >= ret.length)
                        moveCount = DOTS_TO_WIN;
                    if (countV == DOTS_TO_WIN) return true;
                }


                //проверка по диаганали A "\"
                moveCount = 0;
                for (indRet = i; moveCount < DOTS_TO_WIN; indRet = indRet + (SIZE + 1)) {
                    moveCount++;
                    if (ret[indRet] == symbol)
                        countA++;
                    if (ret[indRet] != symbol)
                        countA = 0;
                    if (i + (SIZE*(DOTS_TO_WIN-1)) >= ret.length)
                        moveCount = DOTS_TO_WIN;
                    if ((i + 1) % SIZE > DOTS_TO_WIN | (i + 1) % SIZE == 0)
                        moveCount = DOTS_TO_WIN;
                    if (countA == DOTS_TO_WIN) return true;
                }

                //проверка диагонали B "/"
                moveCount = 0;
                for (indRet = i; moveCount < DOTS_TO_WIN; indRet = indRet + (SIZE - 1)) {
                    moveCount++;
                    if (ret[indRet] == symbol)
                        countB++;
                    if (ret[indRet] != symbol)
                        countB = 0;
                    if (i + (SIZE*(DOTS_TO_WIN-1)) >= ret.length)
                        moveCount = DOTS_TO_WIN;
                    if ((i + 1) % SIZE < DOTS_TO_WIN && (i + 1) % SIZE > 0)
                        moveCount = DOTS_TO_WIN;
                    if (countB == DOTS_TO_WIN) return true;
                }
            }
        } return false;
    }

    public static boolean isMapFull() {
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return  false;
            }
        } return true;
    }



    public static void aiTurn (char symbol, char[][] matrix) {
        int x;
        int y;
        if (preWin(symbol, matrix) > 0) {
            do {
                x = ((preWin(symbol, matrix)) % SIZE) + 1;
                y = Math.floorDiv(preWin(symbol, matrix), SIZE);
            } while (!isCellValid(x, y));
        }
        else {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }
        System.out.println("Компьютер сходил в точку " + (x+1) + " " + (y+1));
        map[y][x] = DOT_O;
    }




       /* if (preWin == -1) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
        else {
            y = Math.floorDiv(preWin, SIZE);
            x = (preWin % SIZE) + 1;
        }
        System.out.println("Компьютер сходил в точку " + (x+1) + " " + (y+1));
        map[y][x] = DOT_O; */

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Введите координаты в формате Х и У");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
            return  false;
        if (map[y][x] == DOT_EMPTY) return  true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i<=SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i<SIZE; i++) {
            System.out.print((i+1)+" ");
            for (int j=0; j<SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


