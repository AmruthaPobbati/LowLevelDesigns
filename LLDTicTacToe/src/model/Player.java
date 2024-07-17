package model;

public class Player {
    private String name;
    private PlayingPiece assignedPiece;

    public Player(String name, PlayingPiece assignedPiece) {
        this.name = name;
        this.assignedPiece = assignedPiece;
    }

    public String getName() {
        return name;
    }

    public PlayingPiece getAssignedPiece() {
        return assignedPiece;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", assignedPiece=" + assignedPiece +
                '}';
    }
}
