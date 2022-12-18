package Piece;

import Board.PieceMove;

import java.util.LinkedList;

// An interface that represent an advanced piece movement
public interface AdvancedPieceMovement extends BasicPieceMovement {

    // Return a list with all the legal moves that a diagonal piece can do
    default LinkedList<PieceMove> getDiagonalPieceLegalMoves(Piece[][] board, int x, int y, int pieceColorOfThePlayer) {
        LinkedList<PieceMove> listOfMoves = new LinkedList<>();
        boolean end = false;

        // Check first diagonal
        for (int i = x + 1, j = y + 1; i < 8 && j < 8 && !end; i++, j++)
            end = basicPieceMovement(listOfMoves, board, i, j, pieceColorOfThePlayer);
        end = false;

        // Check second diagonal
        for (int i = x - 1, j = y - 1; i > -1 && j > -1 && !end; i--, j--)
            end = basicPieceMovement(listOfMoves, board, i, j, pieceColorOfThePlayer);
        end = false;

        // Check third diagonal
        for (int i = x + 1, j = y - 1; i < 8 && j > -1 && !end; i++, j--)
            end = basicPieceMovement(listOfMoves, board, i, j, pieceColorOfThePlayer);
        end = false;

        // Check forth diagonal
        for (int i = x - 1, j = y + 1; i > -1 && j < 8 && !end; i--, j++)
            end = basicPieceMovement(listOfMoves, board, i, j, pieceColorOfThePlayer);

        return listOfMoves;
    }

    // Return a list with all the legal moves that a straight line piece can do
    default LinkedList<PieceMove> getStraightLinePieceLegalMoves(Piece[][] board, int x, int y, int pieceColorOfThePlayer) {
        LinkedList<PieceMove> legalMoveList = new LinkedList<>();
        // Represent if we found a piece on the current line from piece position
        boolean end = false;

        // Check horizontal line, right to piece
        for (int i = y + 1; i < 8 && !end; i++)
            end = basicPieceMovement(legalMoveList, board, x, i,pieceColorOfThePlayer);
        end = false;

        // Check horizontal line, left to piece
        for (int i = y - 1; i > -1 && !end; i--)
            end = basicPieceMovement(legalMoveList, board, x, i,pieceColorOfThePlayer);
        end = false;

        // Check vertical line, upper to piece
        for (int i = x + 1; i < 8 && !end; i++)
            end = basicPieceMovement(legalMoveList, board, i, y,pieceColorOfThePlayer);
        end = false;

        // Check vertical line, under to piece
        for (int i = x - 1; i > -1 && !end; i--)
            end = basicPieceMovement(legalMoveList, board, i, y,pieceColorOfThePlayer);

        return legalMoveList;
    }
}
