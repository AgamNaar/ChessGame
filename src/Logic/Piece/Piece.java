package Logic.Piece;

import Logic.Board.PieceMove;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

// An abstract class that represent a piece in chess
public abstract class Piece {

    private final int color;
    private final Image image;
    private int x;
    private int y;

    // builder, x for x position on board and y for y position board for board, color of the piece, and image for the piece
    public Piece(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.image = getImage();
    }

    // Get image depending on the piece and its type
    private Image getImage() {
        String imagePath = PieceSettings.imagePath[getColor()][getType()];
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.out.println(PieceSettings.imagePath[getColor()][getType()]);
            e.printStackTrace();
        }
        return null;
    }

    public Image getPieceImage() {
        return this.image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public abstract int getType();

    public abstract LinkedList<PieceMove> getLegalMoves(Piece[][] board);

    // Check if the given TODO: finish description
    protected boolean checkMove(LinkedList<PieceMove> moves, Piece[][] board, int i, int j) {
        PieceMove newMove = new PieceMove(i, j);

        // check if it's an empty square
        if (board[i][j] == null) {
            moves.add(newMove);
            return false;
        }

        // Check if it's not empty, and it's not your piece
        if (board[i][j] != null && board[i][j].getColor() != getColor())
            moves.add(newMove);

        return true;
    }


}
