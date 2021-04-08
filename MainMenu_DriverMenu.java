import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu_DriverMenu extends JFrame implements ActionListener {

    JFrame thisform;
    JButton ManagePromoters = new JButton("Manage Promoters"); // Button to add promoters
    JButton ManageVenue = new JButton("Manage Venues"); // Buttom to add venue
    JButton MinistryInterface = new JButton("Ministry Interface"); // button to manage interface
    JButton Exit = new JButton("Exit"); // Exit Button
    JLabel MainMenuTag = new JLabel("Main Menu"); // Label
    JPanel MenuPanel = new JPanel();

    public MainMenu_DriverMenu()
    {
        thisform = this;


        thisform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        thisform.setLayout( new GridLayout(5,1,0,20));

        MenuPanel.setLayout(new BorderLayout());

        MenuPanel.add(MainMenuTag,BorderLayout.CENTER);

        ManagePromoters.setSize(50,50);

        // Setting Action Listeners for different buttons. Since the Main Menu implements
        // Action Listener IT IS A ACTION LISTENER. Therefore when passing in the action listener we pass 'this'

        ManagePromoters.addActionListener(this);
        ManageVenue.addActionListener(this);
        MinistryInterface.addActionListener(this);
        Exit.addActionListener(this);


        thisform.add(MenuPanel);
        thisform.add(ManagePromoters);
        thisform.add(ManageVenue);
        thisform.add(MinistryInterface);
        thisform.add(Exit);

        thisform.setSize(400,400);



        thisform.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
