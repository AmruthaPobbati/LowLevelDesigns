package model;

public enum PieceEnum {
    NAUGHTPIECE("O"),
    CROSSPIECE("X");

    private final String value;

    PieceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
