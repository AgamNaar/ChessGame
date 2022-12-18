package Board;

import Piece.Piece;
import Utils.FenTranslator;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class Board extends BoardGui implements MouseListener {

    private final BoardLogic boardLogic;
    private Piece prevSelectPiece;
    private FenTranslator fenTranslator;

    // Builder without a fen
    public Board(Color primaryColor, Color secondaryColor, int size) {
        super(primaryColor, secondaryColor, size);
        boardLogic = new BoardLogic();
        this.addMouseListener(this);
    }

    // Builder with a fen
    public Board(Color primaryColor, Color secondaryColor, int size, String fen) {
        super(primaryColor, secondaryColor, size);
        boardLogic = new BoardLogic(fen);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() / squerSize, y = e.getY() / squerSize;

        Piece piece = boardLogic.getBoard()[x][y];

        // first time selection, show legal move
        if (prevSelectPiece == null) {
            LinkedList<PieceMove> list = piece.getLegalMoves(boardLogic.getBoard());
            this.showLegalMoves(list);
            prevSelectPiece = piece;
        } else { // a piece has been already selected, check if it's a legal move
            LinkedList<PieceMove> list = prevSelectPiece.getLegalMoves(boardLogic.getBoard());
            for (PieceMove pieceMove : list)
                if (pieceMove.getX() == x && pieceMove.getY() == y) {
                    executeMove(prevSelectPiece, pieceMove);
                    break;
                }
            drawBoardWithPieces();
            prevSelectPiece = null;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX() / squerSize, y = e.getY() / squerSize;
        LinkedList<PieceMove> list = new LinkedList<>();
        if (prevSelectPiece != null)
            list = prevSelectPiece.getLegalMoves(boardLogic.getBoard());
        for (PieceMove pieceMove : list)
            if (pieceMove.getX() == x && pieceMove.getY() == y) {
                executeMove(prevSelectPiece, pieceMove);
                break;
            }
        drawBoardWithPieces();
        prevSelectPiece = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // given a piece and a move, execute the move
    private void executeMove(Piece pieceToMove, PieceMove pieceMove) {
        int x = pieceMove.getX(), y = pieceMove.getY();
        Piece piece = boardLogic.getBoard()[x][y];

        //if board at new move is empty, just move piece
        if (piece != null)
            boardLogic.getPiecesList().remove(piece);

        pieceToMove.setX(x);
        pieceToMove.setY(y);
        boardLogic.updateBoard();
    }

    // Return a piece that the mouse is currently on it
    private Piece getPieceFromMouseLocation() {
        int x, y;

        Point mouse = getMousePosition();
        x = (int) mouse.getX() / squerSize;
        y = (int) mouse.getY() / squerSize;

        return boardLogic.getBoard()[x][y];
    }

    // Draw the board with all of its pieces
    public void drawBoardWithPieces() {
        drawBoardWithPieces(getGraphics(), boardLogic.getPiecesList());
    }

}
