package Logic.Piece;

public enum PieceSettings {
    King(0,9999999),
    Queen(1,900),
    Bishop(2,300),
    Knight(3,300),
    Rook(4,500),
    Pawn(5,100);

    private final int type;
    private final int value;

    public static final int WHITE = 0;
    public static final int BLACK = 1;

    PieceSettings(int type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
