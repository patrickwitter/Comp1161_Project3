import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Message extends JFrame implements ActionListener {


    JPanel display = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
    JPanel cmd = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
    JLabel notification;

    JButton Ok = new JButton("OK");


    public Message(String message)
    {
        // Setting Frame Config

        this.setSize(300,300);
        this.setLayout(new BorderLayout(0,30));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Adding ActionListener
        Ok.addActionListener(this);


        //Config label will message
        this.notification = new JLabel(message);

        //Adding message to display panel
        display.add(this.notification);

        //Adding button to command panel
        cmd.add(this.Ok);

        // Adding Panels to frame
        this.add(display,BorderLayout.CENTER);
        this.add(cmd,BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Ok)
        {
            this.dispose();
        }
    }
}
