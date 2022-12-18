package Piece;

import Board.PieceMove;

import java.util.LinkedList;

// A Class that represent a rook in chess game, extend piece
public class Rook extends Piece implements AdvancedPieceMovement {

    private static final int TYPE = ROOK_PIECE_TYPE;

    // Builder
    public Rook(int color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public int getPieceType() {
        return TYPE;
    }

    @Override
    // Return a list with all the legal moves that the piece can do
    public LinkedList<PieceMove> getLegalMoves(Piece[][] board) {
        return getStraightLinePieceLegalMoves(board,getX(),getY(),getPieceColorOfThePlayer());
    }

}
