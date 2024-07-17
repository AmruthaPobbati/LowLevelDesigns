import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGame game = new TicTacToeGame();

        System.out.println("Welcome to Tic-Tac-Toe Game");
        System.out.println("Start Game Y/N ?");
        String startGame = scanner.next();
        while (startGame.equalsIgnoreCase("Y")) {
            game.clear();
            game.startGame();

            System.out.println("Start Game Y/N ?");
            startGame = scanner.next();
        }
        System.out.println("Ending Game ! Bye !");
    }
}