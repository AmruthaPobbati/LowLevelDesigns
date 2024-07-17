package model;

public abstract class PlayingPiece {
    PieceEnum piece;

    public PlayingPiece(PieceEnum piece) {
        this.piece = piece;
    }

    public PieceEnum getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return "PlayingPiece{" +
                "piece=" + piece +
                '}';
    }
}
