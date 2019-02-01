import javax.swing.*;
import java.awt.*;

public class frame extends JFrame {

    public EastPanel east;

    frame() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(east, BorderLayout.EAST);
    }
}
