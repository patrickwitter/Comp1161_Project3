import javax.swing.*;
import java.awt.*;

public class Message extends JFrame {


    JLabel notification;



    public Message(String message)
    {
        // Setting Frame Config
        this.setSize(300,300);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));

        //Config label will message
        this.notification = new JLabel(message);

        //Adding message to frame
        this.add(this.notification);


        this.setVisible(true);
    }

}
