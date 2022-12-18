package Piece;

import Board.PieceMove;

import java.util.LinkedList;

// A class that represent a pawn in chess game
public class Pawn extends Piece {

    private final int moveDirection;
    private static final int TYPE = PAWN_PIECE_TYPE;

    private static final int WHITE_PAWN_STARTING_ROW = 6;
    private static final int BLACK_PAWN_STARTING_ROW = 1;

    // Builder
    public Pawn(int color, int x, int y) {
        super(color, x, y);

        // if It's white, it goes down the board, if its black, it goes up
        this.moveDirection = color == WHITE ? -1 : 1;
    }


    @Override
    // Return the type of the piece
    public int getPieceType() {
        return TYPE;
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
        // Get piece on left and right of the pawn, it's current row + move direction
        Piece pieceOnRight = x < 7 ? board[x + 1][y + moveDirection] : null;
        Piece pieceOnLeft = x > 0 ? board[x - 1][y + moveDirection] : null;

        // right eat check, check if piece is not null
        if (pieceOnRight != null)
            // Check if the piece is an enemy piece, if yes you can eat
            if (pieceOnRight.getPieceColorOfThePlayer() != this.getPieceColorOfThePlayer())
                list.add(new PieceMove(x + 1, y + moveDirection));

        // left eat check, check if piece is not null
        if (pieceOnLeft != null)
            // Check if the piece is an enemy piece, if yes you can eat
            if (pieceOnLeft.getPieceColorOfThePlayer() != this.getPieceColorOfThePlayer())
                list.add(new PieceMove(x - 1, y + moveDirection));

        //TODO: add unpusuent
    }

    // Check what advance moves this pawn can do, and add them to the list
    private void pawnAdvance(int x, int y, LinkedList<PieceMove> list, Piece[][] board) {
        boolean didNotMoved = didPieceMove(y);

        // Check pawn advanced option, if 1st square before it is empty
        if (board[x][y + moveDirection] == null) {
            list.add(new PieceMove(x, y + moveDirection));
            // if piece didn't move, and 2 square head of it are empty it can advance twice
            if (didNotMoved && board[x][y + (2 * moveDirection)] == null)
                list.add(new PieceMove(x, y + (2 * moveDirection)));
        }
    }

    // Return if the pawn has moved
    private boolean didPieceMove(int y) {
        // Check if the pawn has moved, if its white it needs to be on the 7th row, if it's black on the 1st row
        if (getPieceColorOfThePlayer() == WHITE)
            return y == WHITE_PAWN_STARTING_ROW;
        else
            return y == BLACK_PAWN_STARTING_ROW;
    }


}

