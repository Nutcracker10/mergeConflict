import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CentrePanel extends JPanel {
    BufferedImage board = ImageIO.read("Backgammon_board_-_03.jpg");

    ImageIcon boardicon = new ImageIcon(board);




    CentrePanel() {
        JLabel boardlabel = new JLabel();
        boardlabel.setIcon(boardicon);
        this.add(boardlabel);
    }


}
