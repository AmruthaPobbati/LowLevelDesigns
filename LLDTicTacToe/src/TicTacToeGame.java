import model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    private Player currentPlayer;
    private Deque<Player> players;
    private Board board;
    private boolean noWinner;

    public TicTacToeGame() {
        initializeGame();
    }

    private void initializeGame() {
        PlayingPiece crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPiece naughtPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", naughtPiece);

        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        board = new Board(3);

        noWinner = true;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean positionAccepted = false;
        while (noWinner) {
            board.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = board.getFreeSpaces();

            // check if there are spaces left in board to play
            if(freeSpaces.isEmpty()) {
                System.out.println("Booo...Tied ! try again ");
                noWinner = false;
                continue;
            }
            // continue game
            currentPlayer = players.poll();
            assert currentPlayer != null;

            System.out.printf("\n %s: place your piece at position : ", currentPlayer.getName());
            Pair<Integer, Integer> playAtSpace = new Pair<>(scanner.nextInt(), scanner.nextInt());
            positionAccepted = board.assignPiece(currentPlayer.getAssignedPiece(), playAtSpace);

            if (!positionAccepted) {
                System.out.println("\n Space Taken ! try again !");
                players.addFirst(currentPlayer);
                continue;
            }
            boolean winner = isThereWinner(playAtSpace);
            if(winner) System.out.printf("Winner is: %s \n", currentPlayer.getName());
            noWinner = !winner;
            players.addLast(currentPlayer);
        }
    }

    public boolean isThereWinner(Pair<Integer, Integer> pair) {
        return board.isPieceRow(currentPlayer.getAssignedPiece(), pair.key())
                || board.isPieceColumn(currentPlayer.getAssignedPiece(), pair.value())
                || board.isPieceDiagonal(currentPlayer.getAssignedPiece());
    }

    private String getWinner() {
        return currentPlayer.getName();
    }

    public void clear() {
        initializeGame();
    }


}
