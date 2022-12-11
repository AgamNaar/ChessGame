package Logic.Piece;

import Logic.Board.PieceMove;

import java.util.LinkedList;

// A Class that represent a rook in chess game, extend piece
public class Rook extends Piece {

    private static final int TYPE = PieceSettings.Rook.getType();
    private boolean moved;

    // Builder
    public Rook(int color, int x, int y) {
        super(color, x, y);
        this.moved = checkIfPieceMoved();
    }

    public Rook(int color, int x, int y, boolean moved) {
        super(color, x, y);
        this.moved = moved;
    }

    // Check if the rock has moved, checking if its in original set up for each color
    private boolean checkIfPieceMoved() {
        int x = getX(), y = getY();

        // Check for white
        if (getColor() == PieceSettings.WHITE)
            return y == 0 && (x == 0 || x == 1);

        // Check for black
        return y == 7 && (x == 0 || x == 1);
    }

    @Override
    public int getType() {
        return TYPE;
    }

    @Override
    // Return a list with all the legal moves that the piece can do
    public LinkedList<PieceMove> getLegalMoves(Piece[][] board) {
        LinkedList<PieceMove> moves = new LinkedList<>();
        boolean end = false;

        // Check horizontal line, right to piece
        for (int i = getY() + 1; i < 8 && !end; i++)
            end = checkMove(moves, board, getX(), i);
        end = false;

        // Check horizontal line, left to piece
        for (int i = getY() - 1; i > -1 && !end; i--)
            end = checkMove(moves, board, getX(), i);
        end = false;

        // Check vertical line, upper to piece
        for (int i = getX() + 1; i < 8 && !end; i++)
            end = checkMove(moves, board, i, getY());
        end = false;

        // Check vertical line, under to piece
        for (int i = getX() - 1; i > -1 && !end; i--)
            end = checkMove(moves, board, i, getY());

        return moves;
    }

    // Return if the piece has moved or no
    public boolean isMoved() {
        return moved;
    }
}
