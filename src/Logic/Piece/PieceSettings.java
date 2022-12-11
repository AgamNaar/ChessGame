package Logic.Piece;

import javax.swing.*;
import java.awt.*;

public enum PieceSettings {
    King(0,9999999),
    Queen(1,900),
    Bishop(2,300),
    Knight(3,300),
    Rook(4,500),
    Pawn(5,100);

    private final int type;
    private final int value;

    public final static String IMAGE_PATH_WKING = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\WKing.png";
    public final static String IMAGE_PATH_WQUEEN = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\WQueen.png";
    public final static String IMAGE_PATH_WBISHOP = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\WBishop.png";
    public final static String IMAGE_PATH_WKNIGHT = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\WKnight.png";
    public final static String IMAGE_PATH_WROOK = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\WRook.png";
    public final static String IMAGE_PATH_WPAWN = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\WPawn.png";
    public final static String IMAGE_PATH_BKING = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\BKing.png";
    public final static String IMAGE_PATH_BQUEEN = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\BQueen.png";
    public final static String IMAGE_PATH_BBISHOP = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\BBishop.png";
    public final static String IMAGE_PATH_BKNIGHT = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\BKnight.png";
    public final static String IMAGE_PATH_BROOK = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\BRook.png";
    public final static String IMAGE_PATH_BPAWN = "C:\\Users\\agam_\\IdeaProjects\\ChessGame\\src\\Logic\\Piece\\PieceImage\\BPawn.png";

    public static final String imagePath[][] = {
            {IMAGE_PATH_WKING,IMAGE_PATH_WQUEEN,IMAGE_PATH_WBISHOP,IMAGE_PATH_WKNIGHT,IMAGE_PATH_WROOK,IMAGE_PATH_WPAWN},
            {IMAGE_PATH_BKING,IMAGE_PATH_BQUEEN,IMAGE_PATH_BBISHOP,IMAGE_PATH_BKNIGHT,IMAGE_PATH_BROOK,IMAGE_PATH_BPAWN}};

    public static final int WHITE = 0;
    public static final int BLACK = 1;

    PieceSettings(int type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
