package model;

public class PlayingPieceO extends PlayingPiece{

    public PlayingPieceO() {
        super(PieceEnum.NAUGHTPIECE);
    }

    @Override
    public String toString() {
        return "PlayingPieceO{" +
                "piece=" + piece +
                '}';
    }
}
