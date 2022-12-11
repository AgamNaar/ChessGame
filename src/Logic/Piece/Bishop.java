package Logic.Piece;

import Logic.Board.PieceMove;

import java.util.LinkedList;

// A Class that represent a bishop in chess game, extend piece
public class Bishop extends Piece {

    private static final int TYPE = BISHOP;

    // Builder
    public Bishop(int color, int x, int y) {
        super(color, x, y);
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

        // Check first diagonal
        for (int i = getX() + 1, j = getY() + 1; i < 8 && j < 8 && !end; i++, j++)
            end = checkMove(moves, board, i, j);
        end = false;

        // Check second diagonal
        for (int i = getX() - 1, j = getY() - 1; i > -1 && j > -1 && !end; i--, j--)
            end = checkMove(moves, board, i, j);
        end = false;

        // Check third diagonal
        for (int i = getX() + 1, j = getY() - 1; i < 8 && j > -1 && !end; i++, j--)
            end = checkMove(moves, board, i, j);
        end = false;

        // Check forth diagonal
        for (int i = getX() - 1, j = getY() + 1; i > -1 && j < 8 && !end; i--, j++)
            end = checkMove(moves, board, i, j);

        return moves;
    }


}
