import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Welcome to MineSweeper----");
        System.out.println("Enter row");
        int row = scanner.nextInt();
        System.out.println("Enter col");
        int col = scanner.nextInt();

        mineSweeper mineSweeper = new mineSweeper(row,col);
        mineSweeper.run();


    }
}
