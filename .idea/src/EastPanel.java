import javax.swing.*;
import java.awt.*;

public class EastPanel extends JPanel {

    JTextField enterText = new JTextField();
    JTextArea areaText = new JTextArea("Welcome to Backgammon");

    EastPanel(){
        this.setLayout(new BorderLayout());

        this.add(areaText, BorderLayout.CENTER);
        this.add(enterText, BorderLayout.SOUTH);
    }

}
