import javax.swing.*;
import java.awt.*;

public class frame extends JFrame {

    EastPanel east = new EastPanel();

    frame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(east, BorderLayout.EAST);
    }
}
