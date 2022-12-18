package Piece;

import Board.PieceMove;

import java.util.LinkedList;

// A Class that represent a king in chess game, extend piece
public class King extends Piece implements BasicPieceMovement {

    private static final int TYPE = KING_PIECE_TYPE;

    // Builder
    public King(int color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public int getPieceType() {
        return TYPE;
    }

    @Override
    // Return a list with all the legal moves that the piece can do
    public LinkedList<PieceMove> getLegalMoves(Piece[][] board) {
        LinkedList<PieceMove> legalPieceMoveList = new LinkedList<>();
        int x = getX(), y = getY();

        // Calculate all the possible king moves
        for (int i = -1; i < 2; i = i + 2) {
            basicPieceMovement(legalPieceMoveList, board, x + i, y, getPieceColorOfThePlayer());
            basicPieceMovement(legalPieceMoveList, board, x, y + i, getPieceColorOfThePlayer());
            basicPieceMovement(legalPieceMoveList, board, x + i, y + i, getPieceColorOfThePlayer());
            basicPieceMovement(legalPieceMoveList, board, x + i, y - i, getPieceColorOfThePlayer());
        }

        return legalPieceMoveList;
    }
}
