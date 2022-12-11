
package Gui;

import Logic.Piece.Piece;
import Logic.Board.PieceMove;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

// A class that handle all the gui aspects of the chess board
public class BoardGui extends JPanel {

    private final Color primaryColor;
    private final Color secondaryColor;
    protected final int squerSize;

    // Builder, receive parameters for board and initialize them
    public BoardGui(Color primaryColor, Color secondaryColor, int size) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.squerSize = size / 8;
    }


    @Override
    public void paint(Graphics g) {
        drawBoard(g);
    }

    public void drawBoardWithPieces(Graphics g, LinkedList<Piece> list) {
        drawBoard(g);
        drawPieces(list);
    }

    // Given a list of all the pieces, draw them on the board
    public void drawPieces(LinkedList<Piece> list) {
        for (Piece piece : list)
            drawPiece(piece);
    }

    // Given a piece move list, draw all the legal moves on the board
    public void showLegalMoves(LinkedList<PieceMove> legalMoveList) {
        Graphics graphics = getGraphics();
        int x, y;

        // For each legal move, draw it on the board
        for (PieceMove move : legalMoveList) {
            x = move.getX();
            y = move.getY();
            graphics.setColor(Color.GRAY);

            // For each legal move, draw it on the board
            graphics.fillOval(x * squerSize + (squerSize - squerSize / 4) / 2, y * squerSize + (squerSize - squerSize / 4) / 2, squerSize / 4, squerSize / 4);
        }
    }

    // Draw the board of the game
    public void drawBoard(Graphics graphics) {
        boolean primary = true;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (primary)
                    graphics.setColor(primaryColor);
                else
                    graphics.setColor(secondaryColor);
                graphics.fillRect(x * squerSize, y * squerSize, squerSize, squerSize);
                primary = !primary;
            }
            primary = !primary;
        }
    }


    // Given a piece, draw it on the board
    public void drawPiece(Piece piece) {
        Graphics graphics = getGraphics();
        int x = piece.getX(), y = piece.getY();

        // Re-size the image to match the board
        Image image = piece.getPieceImage().getScaledInstance(squerSize, squerSize, 0);

        graphics.drawImage(image, x * squerSize, y * squerSize, this);
    }

}
