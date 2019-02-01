import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI{
    public static void main(String[] args) {
       JFrame f = new JFrame();
       EastPanel e = new EastPanel();

       f.setLayout(new BorderLayout());
       f.add(e, BorderLayout.EAST);

       f.setSize(800, 600);
       f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       f.setVisible(true);

    }


}
