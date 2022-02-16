import java.util.Random;
import java.util.Scanner;

public class mineSweeper {
    Scanner scanner = new Scanner(System.in);
    int map[][];
    int board [][];
    int rowNumber,colNumber,size;
    boolean isGame = true;


    Random rand = new Random();

    public mineSweeper( int row, int col) {
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.size = rowNumber* colNumber;

    }
    public  void  run(){
        int row, col,succes=0;
        prepareGame();
        print(map);
        System.out.println("==Oyun Başladı==");
        while (isGame == true) {
            print(board);
            System.out.println("Satir değeri :");
            row = scanner.nextInt();
            System.out.println("Sütun değeri :");
            col = scanner.nextInt();
            if(row<0 || row>rowNumber)
            {
                System.out.println("Geçersiz koordinat");
                continue;
            }
            if(col<0 || col>colNumber)
            {
                System.out.println("---Geçersiz koordinat--");
                continue;
            }
            if (map[row][col] == -1) {
                System.out.println("---Kaybettiniz ---");
                isGame = false;

            } else if (map[row][col] != -1) {
                succes++;
                if(succes==size-(size/4))
                {
                    System.out.println("--Kazandınız---");
                    break;
                }
                check(row, col);
            }

        }
    }
    public void  prepareGame(){
        int rowRand,colRand ;
        int count = 0;
        while (count! = (size/4)){
            rowRand  = rand.nextInt(rowNumber);
            colRand = rand.nextInt(colNumber);
            if (map[rowRand][colRand] != -1){
                map[rowRand][colRand] =-1;
                count ++;
            }
        }
    }
    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public void check(int r, int c) {
        if(map[r][c]==0){
            if ( c>0 && map[r][c - 1] == -1) {
                board[r][c]++;
            }
            if ( c<rowNumber -1 && map[r][c + 1] == -1) {
                board[r][c]++;
            }
            if (r>0&& map[r - 1][c] == -1) {
                board[r][c]++;
            }

            if (r<colNumber -1 && map[r + 1][c] == -1) {
                board[r][c]++;
            }
            if(board[r][c]==0)
            {
                board[r][c]=-2;
            }
        }

    }
}

