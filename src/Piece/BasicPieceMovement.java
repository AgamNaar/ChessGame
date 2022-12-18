package Piece;

import Board.PieceMove;

import java.util.LinkedList;

// An interface that represent a basic piece movement
public interface BasicPieceMovement {

    // Given a position (x,y), check if it's a legal move, if yes add to the list
    default boolean basicPieceMovement(LinkedList<PieceMove> legalPieceMoveList, Piece[][] board, int x, int y, int pieceColorOfThePlayer) {
        PieceMove newMove = new PieceMove(x, y);
        // Check if the move is in range
        if (moveInRangeOfBoard(x, y)) {
            // check if it's an empty square
            if (board[x][y] == null) {
                legalPieceMoveList.add(newMove);
                return false;
            } else  // not empty
                // check if it's an enemy piece, if yes you can eat it (go to that square)
                if (board[x][y].getPieceColorOfThePlayer() != pieceColorOfThePlayer)
                    legalPieceMoveList.add(newMove);
        }
        return true;
    }

    // Return true if x and y in range of the board
    private boolean moveInRangeOfBoard(int x, int y) {
        return x > -1 && y > -1 && x < 8 && y < 8;
    }

}
