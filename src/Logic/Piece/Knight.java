package Logic.Piece;

import Logic.Board.PieceMove;

import java.util.LinkedList;

// A Class that represent a knight in chess game, extend piece
public class Knight extends Piece {

    private static final int TYPE = PieceSettings.Knight.getType();

    // Builder
    public Knight(int color, int x, int y) {
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

        // for each of the possible knight move, check if its in range check the move
        if(y+2 < 8 && x+1 < 8)
            checkMove(moves,board,x+1,y+2);

        if(y+2 < 8 && x-1 > -1)
            checkMove(moves,board,x-1,y+2);

        if(y+1 < 8 && x+2 < 8)
            checkMove(moves,board,x+2,y+1);

        if(y+1 < 8 && x-2 > -1)
            checkMove(moves,board,x-2,y+1);

        if(y-2 > -1 && x+1 < 8)
            checkMove(moves,board,x+1,y-2);

        if(y-2 > -1 && x-1 > -1)
            checkMove(moves,board,x-1,y-2);

        if(y-1 > -1 && x+2 < 8)
            checkMove(moves,board,x+2,y-1);

        if(y-1 > -1 && x-2 > -1)
            checkMove(moves,board,x-2,y-1);

        return moves;
    }
}
