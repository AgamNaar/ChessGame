package Piece;

import Board.PieceMove;

import java.util.LinkedList;

// A Class that represent a queen in chess game, extend piece
public class Queen extends Piece implements AdvancedPieceMovement {

    private static final int TYPE = QUEEN_PIECE_TYPE;

    // Builder
    public Queen(int color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public int getPieceType() {
        return TYPE;
    }


    @Override
    // Return a list with all the legal moves that the piece can do
    public LinkedList<PieceMove> getLegalMoves(Piece[][] board) {
        // A queen moves likes a diagonal piece and like a straight line piece
        LinkedList<PieceMove> moves1 = getDiagonalPieceLegalMoves(board, getX(), getY(), getPieceColorOfThePlayer());
        LinkedList<PieceMove> moves2 = getStraightLinePieceLegalMoves(board, getX(), getY(), getPieceColorOfThePlayer());

        moves1.addAll(moves2);
        return moves1;
    }
}
