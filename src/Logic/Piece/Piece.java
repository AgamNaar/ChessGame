package Logic.Piece;

import Logic.Board.PieceMove;

import javax.swing.*;
import java.util.LinkedList;

// An abstract class that represent a piece in chess
public abstract class Piece {

    private final int color;
    private int x;
    private int y;

    protected static final int KING = 0;
    protected static final int QUEEN = 1;
    protected static final int BISHOP = 2;
    protected static final int KNIGHT = 3;
    protected static final int ROOK = 4;
    protected static final int PAWN = 5;

    public static final int WHITE = 0;
    public static final int BLACK = 1;


    // builder, x for x position on board and y for y position board for board, and color of the piece
    public Piece(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public abstract int getType();

    public abstract LinkedList<PieceMove> getLegalMoves(Piece[][] board);

    // Check if the given TODO: finish description
    protected boolean checkMove(LinkedList<PieceMove> moves, Piece[][] board, int i, int j) {
        PieceMove newMove = new PieceMove(i, j);

        // check if it's an empty square
        if (board[i][j] == null) {
            moves.add(newMove);
            return false;
        }

        // Check if it's not empty, and it's not your piece
        if (board[i][j] != null && board[i][j].getColor() != getColor())
            moves.add(newMove);

        return true;
    }


}
