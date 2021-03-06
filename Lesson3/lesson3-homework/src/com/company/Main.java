package com.company;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static char[][] map5;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
        sc.close();
    }
    public static boolean checkWin(char symb) {
        int n=0,m=0,k=0,l=0;
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (map[i][j]==symb) n++;
                if (map[j][i]==symb) m++;
            }
            if (map[i][i]==symb)  k++;
            if (map[i][2-i]==symb) l++;
            if (n==3) return true;
            if (m==3) return true;
            n=0;
            m=0;
        }
        if (k==3) return true;
        if (l==3) return true;
        return false;
    }
    public static boolean checkWin5(char symb) {
        int n=0,m=0,k=0,l=0,a=0,b=0,c=0,d=0;
        for (int i=0;i<4;i++){
            if(map5[i][i]==symb) a++;
            if(map5[i][3-i]==symb) b++;
            if(map5[i+1][i+1]==symb) c++;
            if(map5[i+1][4-i]==symb) d++;
            if (map5[i+1][i]==symb) n++;
            if (map5[i+1][3-i]==symb) m++;
            if (map5[i][i+1]==symb) k++;
            if (map5[3-i][i+1]==symb) l++;
        }
        if(a==4) return true;
        if(b==4) return true;
        if(c==4) return true;
        if(d==4) return true;
        if (n==4) return true;
        if (m==4) return true;
        if (k==4) return true;
        if (l==4) return true;
        a=0;
        b=0;
        c=0;
        d=0;
        n=0;
        m=0;
        k=0;
        l=0;
        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if (map5[i][j]==symb) a++;
                if (map5[j][i]==symb) b++;
                if (map5[i+1][j]==symb) c++;
                if (map5[j+1][i]==symb) d++;
                if (map5[i][j+1]==symb) n++;
                if (map5[j][i+1]==symb) m++;
                if (map5[i+1][j+1]==symb) k++;
                if (map5[j+1][i+1]==symb) l++;
            }
            if(a==4) return true;
            if(b==4) return true;
            if(c==4) return true;
            if(d==4) return true;
            if (n==4) return true;
            if (m==4) return true;
            if (k==4) return true;
            if (l==4) return true;
            a=0;
            b=0;
            c=0;
            d=0;
            n=0;
            m=0;
            k=0;
            l=0;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
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
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int[][] SpiralArray(int x, int y){
        int a[][],b=1,i=0,j=0,x1=x,y1=y,x2=0,y2=0;
        if(x<=0||y<=0) throw new IllegalArgumentException();
        a=new int[x][y];
        while (b<x*y){

            for (;j<y1;j++){
                a[i][j]=b;
                b++;
            }

            j--;
            i++;
            if (b>=x*y) break;
            for (;i<x1;i++){
                a[i][j]=b;
                b++;
            }
            i--;
            j--;
            if (b>=x*y) break;
            for (;j>=y2;j--){
                a[i][j]=b;
                b++;
            }
            j++;
            i--;
            if (b>=x*y) break;
            for (;i>x2;i--){
                a[i][j]=b;
                b++;
            }

            i++;
            j++;
            x1--;
            y1--;
            x2++;
            y2++;

        }
        if (x%2!=0 && y%2!=0 && b==x*y) {a[x/2][y/2]=b;}
        return a;
    }
}

