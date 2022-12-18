package Piece;

import Board.PieceMove;

import java.util.LinkedList;

// A Class that represent a knight in chess game, extend piece
public class Knight extends Piece implements BasicPieceMovement{

    private static final int TYPE = KNIGHT_PIECE_TYPE;

    // Builder
    public Knight(int color, int x, int y) {
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

        // Calculate all the possible knight moves
        for (int i = -2; i < 5; i = i + 4) {
            basicPieceMovement(legalPieceMoveList, board, x + i, y + 1,getPieceColorOfThePlayer());
            basicPieceMovement(legalPieceMoveList, board, x + 1, y + i,getPieceColorOfThePlayer());
            basicPieceMovement(legalPieceMoveList, board, x + i, y - 1,getPieceColorOfThePlayer());
            basicPieceMovement(legalPieceMoveList, board, x - 1, y + i,getPieceColorOfThePlayer());
        }

        return legalPieceMoveList;
    }
}
