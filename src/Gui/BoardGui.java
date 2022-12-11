
package Gui;

import Logic.Piece.Piece;
import Logic.Board.PieceMove;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

// A class that handle all the gui aspects of the chess board
public class BoardGui extends JPanel {

    private static final String IMAGE_PATH = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Gui\\PiecesPicture.png";
    private final Color primaryColor;
    private final Color secondaryColor;
    protected final int squerSize;
    private final Image[][] piecesImages;

    // Builder, receive parameters for board and initialize them
    public BoardGui(Color primaryColor, Color secondaryColor, int size) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.squerSize = size / 8;
        this.piecesImages = new Image[2][6];
        getPictures();
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
    public void showLegalMoves(LinkedList<PieceMove> list) {
        Graphics graphics = getGraphics();
        int x, y;

        // For each legal move, draw it on the board
        for (PieceMove move : list) {
            x = move.getX();
            y = move.getY();
            graphics.setColor(Color.GRAY);
            graphics.fillOval(x * squerSize + (squerSize - squerSize / 4) / 2, y * squerSize + (squerSize - squerSize / 4) / 2, squerSize / 4, squerSize / 4);
        }
    }

    // Get the images of the pieces, save it on array, temp
    private void getPictures() {
        try {
            // Get Picture
            BufferedImage image = ImageIO.read(new File(IMAGE_PATH));

            // Crop from the image all the different pieces
            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 2; y++) {
                    piecesImages[y][x] = image.getSubimage(x * 200, y * 200, 200, 200)
                            .getScaledInstance(squerSize, squerSize, BufferedImage.SCALE_SMOOTH);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
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
        int x, y, color, type;
        x = piece.getX();
        y = piece.getY();
        color = piece.getColor();
        type = piece.getType();

        ImageIcon image = new ImageIcon(piecesImages[color][type]);

        graphics.drawImage(piecesImages[color][type], x * squerSize, y * squerSize, this);
    }

}
