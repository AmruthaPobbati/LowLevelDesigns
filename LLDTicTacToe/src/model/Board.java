package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Integer size;
    private PlayingPiece[][] board;

    public Board(Integer size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public Integer getSize() {
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public boolean assignPiece(PlayingPiece piece, Pair<Integer, Integer> playAtSpace) {
        if (isSpaceEmpty(playAtSpace)) {
            board[playAtSpace.key()][playAtSpace.value()] = piece;
            return true;
        } else {
            return false;
        }
    }

    public boolean isSpaceEmpty(Pair<Integer, Integer> cell) {
        return board[cell.key()][cell.value()] == null;
    }

    public void printBoard() {
        for (PlayingPiece[] playingPieces : board) {
            for (PlayingPiece playingPiece : playingPieces) {
                printSpace(playingPiece);
            }
            System.out.println();
        }
    }

    public List<Pair<Integer, Integer>> getFreeSpaces() {
        List<Pair<Integer, Integer>> freeSpaces = new ArrayList<>();
        for (int x=0; x < size; x++) {
            for (int y=0; y < size; y++) {
                if (isSpaceEmpty(new Pair<>(x, y))) {
                    freeSpaces.add(new Pair<>(x, y));
                }
            }
        }
        return freeSpaces;
    }

    public boolean isPieceRow(PlayingPiece piece, int row) {
        boolean isPieceRow = true;
        for (int col = 0; col < size; col++) {
            isPieceRow = isPieceRow && board[row][col] != null && board[row][col].equals(piece);
        }
        return isPieceRow;
    }

    public boolean isPieceColumn(PlayingPiece piece, int col) {
        boolean isPieceColumn = true;
        for (PlayingPiece[] playingPieces : board) {
            isPieceColumn = isPieceColumn && playingPieces[col] != null && playingPieces[col].equals(piece);
        }
        return isPieceColumn;
    }

    public boolean isPieceDiagonal(PlayingPiece piece) {
        boolean isPieceDiagonal = true;
        for (int row=0, col=0; row < size; row++, col++) {
            isPieceDiagonal = isPieceDiagonal && board[row][col] != null && board[row][col].equals(piece);
        }

        for (int row=size-1, col=0; row > 0; row--, col++) {
            isPieceDiagonal = isPieceDiagonal && board[row][col] != null && board[row][col].equals(piece);
        }
        return isPieceDiagonal;
    }

    public void clear() {
        this.board = new PlayingPiece[size][size];
    }

    public void printSpace(PlayingPiece piece) {
        if (piece == null) System.out.print(" ");
        else System.out.print(piece.getPiece().getValue());
        System.out.print(" | ");
    }
}
