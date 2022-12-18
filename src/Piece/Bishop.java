package Piece;

import Board.PieceMove;

import java.util.LinkedList;


// A Class that represent a bishop in chess game, extend piece
public class Bishop extends Piece implements AdvancedPieceMovement {

    private static final int TYPE = BISHOP_PIECE_TYPE;

    // Builder
    public Bishop(int color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public int getPieceType() {
        return TYPE;
    }


    @Override
    // Return a list with all the legal moves that the piece can do
    public LinkedList<PieceMove> getLegalMoves(Piece[][] board) {
        return getDiagonalPieceLegalMoves(board,getX(),getY(),getPieceColorOfThePlayer());
    }


}
