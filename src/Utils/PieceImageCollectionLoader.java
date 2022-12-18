package Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import static Piece.Piece.*;

// A class that represent an object that gets image of the pieces from the folders
public class PieceImageCollectionLoader {

    private static final String KING = "King";
    private static final String QUEEN = "Queen";
    private static final String ROOK = "Rook";
    private static final String BISHOP = "Bishop";
    private static final String KNIGHT = "Knight";
    private static final String PAWN = "Pawn";

    // File representing the folder that you select using a FileChooser
    private static final File dir = new File("src\\Piece\\PieceImage\\");

    // array of supported extensions
    private static final String[] EXTENSIONS = new String[]{"gif", "png", "bmp"};

    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = (dir, name) -> {
        for (final String ext : EXTENSIONS) {
            if (name.endsWith("." + ext)) {
                return (true);
            }
        }
        return (false);
    };

    private void insertImageToCollection(File f, Image[][] collection) throws IOException {
        int color, type = -1, indexOfPoint;

        // From file name get the name of the piece
        String fileName = f.getName();
        indexOfPoint = fileName.indexOf(".");
        String pieceTypeString = fileName.substring(1, indexOfPoint);

        switch (pieceTypeString) {
            case KING -> type = KING_PIECE_TYPE;
            case QUEEN -> type = QUEEN_PIECE_TYPE;
            case ROOK -> type = ROOK_PIECE_TYPE;
            case BISHOP -> type = BISHOP_PIECE_TYPE;
            case KNIGHT -> type = KNIGHT_PIECE_TYPE;
            case PAWN -> type = PAWN_PIECE_TYPE;
        }

        // from file name get the color of the piece
        color = fileName.charAt(0) == 'W' ? WHITE : BLACK;

        // Store it in the right place on collection
        collection[color][type] = ImageIO.read(f);


    }

    // return the collection of images from the file
    public Image[][] getCollection() {
        Image[][] piecesImagesCollection = new Image[2][6];

        // make sure it's a directory
        if (dir.isDirectory()) {
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                try {
                    // insert the image to the right place on the collection
                    insertImageToCollection(f, piecesImagesCollection);
                } catch (final IOException e) {
                    System.out.println("error test");
                }
            }
        }

        return piecesImagesCollection;
    }

}
