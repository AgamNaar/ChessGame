package Logic.Piece;

import Logic.Board.PieceMove;

import java.util.LinkedList;

// A class that represent a pawn in chess game
public class Pawn extends Piece {

    private final int moveDirection;

    // Builder
    public Pawn(int color, int x, int y) {
        super(color, x, y);

        // if It's white, it goes down the board, if its black, it goes up
        this.moveDirection = color == WHITE ? -1 : 1;
    }


    @Override
    // Return the type of the piece
    public int getType() {
        return PAWN;
    }


    @Override
    // Return a list of all the legal moves this piece can do
    public LinkedList<PieceMove> getLegalMoves(Piece[][] board) {
        LinkedList<PieceMove> list = new LinkedList<>();
        int x = getX(), y = getY();

        pawnAdvance(x, y, list, board);
        pawnCapture(x, y, list, board);

        return list;
    }

    // Check what captures moves this pawn can do, and add them to the list
    private void pawnCapture(int x, int y, LinkedList<PieceMove> list, Piece[][] board) {

        // Check right
        if (x < 7 && board[x+1][y+ moveDirection] != null && board[x+1][y+ moveDirection].getColor() != this.getColor())
            list.add(new PieceMove(x+1, y + moveDirection));

        // Check left
        if (x > 0 && board[x-1][y+ moveDirection] != null && board[x-1][y+ moveDirection].getColor() != this.getColor())
            list.add(new PieceMove(x-1, y + moveDirection));

        //TODO: add unpusuent
    }

    // Check what advance moves this pawn can do, and add them to the list
    private void pawnAdvance(int x, int y, LinkedList<PieceMove> list, Piece[][] board) {
        // Check if the pawn has moved
        boolean didNotMoved = (getColor() == WHITE && y == 6) || (getColor() == BLACK && y == 1);

        // Check pawn advanced option
        if (board[x][y + moveDirection] == null) {
            list.add(new PieceMove(x, y + moveDirection));
            if (didNotMoved && board[x][y + (2 * moveDirection)] == null) // if piece didn't moveDirection it can advance twice
                list.add(new PieceMove(x, y + (2 * moveDirection)));
        }
    }


}

