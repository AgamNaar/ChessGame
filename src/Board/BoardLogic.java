package Board;

import Piece.Piece;
import Utils.FenTranslator;


import java.util.LinkedList;
import java.util.Arrays;

// A class that represent the logic of the board
public class BoardLogic {

    private final Piece[][] board;
    private final LinkedList<Piece> piecesList;
    private final static FenTranslator fenTranslator = new FenTranslator();

    // Initialize the board with the normal settings
    public BoardLogic() {
        board = new Piece[8][8];
        piecesList = fenTranslator.translateFen();
        fillBoard(piecesList);
    }

    // Initialize the board with a given fen
    public BoardLogic(String fen) {
        board = new Piece[8][8];
        piecesList = fenTranslator.translateFen(fen);
        fillBoard(piecesList);
    }

    // get method of board
    public Piece[][] getBoard() {
        return board;
    }

    // get method of piece list
    public LinkedList<Piece> getPiecesList() {
        return piecesList;
    }


    // Clear the board, setting all squares to null
    private void clearBoard() {
        Arrays.stream(board).forEach(x -> Arrays.fill(x, null));
    }

    // Given a list of pieces, fill the board with it
    private void fillBoard(LinkedList<Piece> list) {
        for (Piece piece : list)
            board[piece.getX()][piece.getY()] = piece;
    }

    //TODO: better
    public void updateBoard() {
        clearBoard();
        fillBoard(piecesList);
    }

    // Check if the move is legal
    public void checkIfMoveIsLegal(PieceMove move, Piece piece) {

    }
}
