/*
    A class to translate FEN into game settings
 */
package Logic.Board;

import Logic.Piece.*;

import java.util.LinkedList;

public class FenTranslator {


    // FenType: 17 rook, 13 knight, 1 bishop, queen 16, king 10, pawn 15
    // FenType is the letter the piece represent - A/a depends on it color
    private static final int KING = 10;
    private static final int QUEEN = 16;
    private static final int ROOK = 17;
    private static final int KNIGHT = 13;
    private static final int BISHOP = 1;
    private static final int PAWN = 15;

    // Given a string that represent a FEN, return a list with all the piece of the board
    public LinkedList<Piece> translateFen(String fen) {
        LinkedList<Piece> list = getFenPieces(fen);
        //TODO: add other setting from fen


        return list;
    }

    // get from a FEN a list of all the pieces, return that list
    private LinkedList<Piece> getFenPieces(String fen) {
        LinkedList<Piece> list = new LinkedList<>();
        Piece piece;
        int x = 0, y = 0;
        int color, fenType;

        // Run on the entire fen string
        for (int i = 0; i < fen.length(); i++) {
            char curr = fen.charAt(i);

            // If it's a digit skip that amount of squares
            if (Character.isDigit(curr))
                x = x + Character.getNumericValue(curr);
            else if (curr == '/') {// End of a row, go to the next row
                x = 0;
                y++;
            } else { // It's a piece, get its "fen type, and if its upper case its white, lower is black
                if (Character.isUpperCase(curr)) {
                    color = PieceSettings.WHITE;
                    fenType = curr - 'A';
                } else {
                    color = PieceSettings.BLACK;
                    fenType = curr - 'a';
                }
                piece = createPieceFen(fenType, color, x, y);
                list.add(piece);
                x++;
            }
        }

        return list;
    }

    // Create a piece from fen translation, given a color and FEN type
    private Piece createPieceFen(int fenType, int color, int x, int y) {
        Piece piece = null;

        if (fenType == KING)
            piece = new King(color, x, y);

        if (fenType == QUEEN)
            piece = new Queen(color, x, y);

        if (fenType == BISHOP)
            piece = new Bishop(color, x, y);

        if (fenType == KNIGHT)
            piece = new Knight(color, x, y);

        if (fenType == ROOK)
            piece = new Rook(color, x, y);

        if (fenType == PAWN)
            piece = new Pawn(color, x, y);

        return piece;
    }
}
