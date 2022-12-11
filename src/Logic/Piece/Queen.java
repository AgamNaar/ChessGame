package Logic.Piece;

import Logic.Board.PieceMove;

import java.util.LinkedList;

// A Class that represent a queen in chess game, extend piece
public class Queen extends Piece {

    private static final int TYPE = QUEEN;

    // Builder
    public Queen(int color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public int getType() {
        return TYPE;
    }


    @Override
    // Return a list with all the legal moves that the piece can do
    public LinkedList<PieceMove> getLegalMoves(Piece[][] board) {
        // A queen moves like a rook and like a bishop, so check what a rook and  bishop can do
        LinkedList<PieceMove> moves1;
        LinkedList<PieceMove> moves2;

        Bishop bishop = new Bishop(getColor(), getX(), getY());
        Rook rook = new Rook(getColor(), getX(), getY(), true);

        moves1 = bishop.getLegalMoves(board);
        moves2 = rook.getLegalMoves(board);

        moves1.addAll(moves2);
        return moves1;
    }
}
