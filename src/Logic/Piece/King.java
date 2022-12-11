package Logic.Piece;

import Logic.Board.PieceMove;

import java.util.LinkedList;

// A Class that represent a king in chess game, extend piece
public class King extends Piece {

    private static final int TYPE = PieceSettings.King.getType();;

    // Builder
    public King(int color, int x, int y) {
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
        int x = getX(), y = getY();

        // check up
        if (x + 1 < 8) {
            checkMove(moves, board, x + 1, y);

            // check up right
            if (y + 1 < 8)
                checkMove(moves, board, x + 1, y + 1);

            // check up left
            if (y - 1 > -1)
                checkMove(moves, board, x + 1, y - 1);
        }

        // check down
        if (x - 1 > -1) {
            checkMove(moves, board, x - 1, y);

            // check up right
            if (y + 1 < 8)
                checkMove(moves, board, x - 1, y + 1);

            // check up left
            if (y - 1 > -1)
                checkMove(moves, board, x - 1, y - 1);
        }

        //check left
        if (y - 1 > -1)
            checkMove(moves, board, x, y - 1);

        //check left
        if (y + 1 < 8)
            checkMove(moves, board, x, y + 1);

        return moves;
    }
}
