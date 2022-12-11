import Logic.Board.Board;

import javax.swing.*;
import java.awt.*;


public class Main {


    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Game");
        setFrame(jFrame);


        String fen = "r1b1k1nr/p2p1pNp/n2B4/1p1NP2P/6P1/3P1Q2/P1P1K3/q5b1";
        Board board1 = new Board(Color.white, Color.CYAN, 512,fen);
        jFrame.add(board1);
        jFrame.setVisible(true);
        board1.drawBoardWithPieces();


    }

    // set the frame
    private static void setFrame(JFrame frame) {
        frame.setTitle("ChessGame");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


}
