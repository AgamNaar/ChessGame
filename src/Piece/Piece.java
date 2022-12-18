package Piece;

import Board.PieceMove;

import java.util.LinkedList;

// An abstract class that represent a piece in chess
public abstract class Piece {

    public static final int WHITE = 0;
    public static final int BLACK = 1;
    public static final int KING_PIECE_TYPE = 0;
    public static final int QUEEN_PIECE_TYPE = 1;
    public static final int BISHOP_PIECE_TYPE = 2;
    public static final int KNIGHT_PIECE_TYPE = 3;
    public static final int ROOK_PIECE_TYPE = 4;
    public static final int PAWN_PIECE_TYPE = 5;

    private final int pieceColorOfThePlayer;
    private int x;
    private int y;

    // builder, x for x position on board and y for y position board for board, pieceColorOfThePlayer of the piece, and image for the piece
    public Piece(int pieceColorOfThePlayer, int x, int y) {
        this.pieceColorOfThePlayer = pieceColorOfThePlayer;
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

    public int getPieceColorOfThePlayer() {
        return pieceColorOfThePlayer;
    }

    public abstract int getPieceType();

    public abstract LinkedList<PieceMove> getLegalMoves(Piece[][] board);


}
