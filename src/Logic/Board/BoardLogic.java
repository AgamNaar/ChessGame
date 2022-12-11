/*
    Represent the board logic
 */
package Logic.Board;

import Logic.Piece.Piece;

import java.util.LinkedList;
import java.util.Arrays;

public class BoardLogic {

    private Piece[][] board;
    private final static Piece[][] emptyBoard = new Piece[8][8];
    private final LinkedList<Piece> piecesList;
    private final FenTranslator fenTranslator;

    private static final String CLASSIC_START_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    // Initialize the board with the normal settings
    public BoardLogic() {
        board = new Piece[8][8];
        fenTranslator = new FenTranslator();
        piecesList = fenTranslator.translateFen(CLASSIC_START_FEN);
        fillBoard(piecesList);
    }

    // Initialize the board with a given fen
    public BoardLogic(String fen) {
        board = new Piece[8][8];
        fenTranslator = new FenTranslator();
        piecesList = fenTranslator.translateFen(fen);
        fillBoard(piecesList);
    }


    // Clear the board, setting all squares to null
    private void clearBoard() {


    }

    // Given a list of pieces, fill the board with it
    private void fillBoard(LinkedList<Piece> list) {
        for (Piece piece : list)
            board[piece.getX()][piece.getY()] = piece;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public LinkedList<Piece> getPiecesList() {
        return piecesList;
    }

    public void updateBoard() {
        Arrays.stream(board).forEach(x -> Arrays.fill(x, null));
        fillBoard(piecesList);
    }
}
