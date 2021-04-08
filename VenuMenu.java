import javax.swing.*;
import java.awt.*;

public class VenuMenu extends JFrame{

    JFrame thisform;
    JButton AddVenue = new JButton("Add/Create Venue"); // Button to add promoters
    JButton UpdateVenue = new JButton("Edit/Update Venue"); // Buttom to add venue
    JButton ListVenue = new JButton("List Venue"); // button to manage interface
    JButton DeleteVenue = new JButton("Delete Venue"); // Exit Button
    JLabel VenueMenuTag = new JLabel("Manage Venue"); // Label
    JPanel MenuPanel = new JPanel();
    JButton BackButton = new JButton("<");

    public VenuMenu()
    {
        thisform = this;

        thisform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        thisform.setLayout( new GridLayout(5,1,0,20));

        MenuPanel.setLayout(new BorderLayout());

        MenuPanel.add(VenueMenuTag,BorderLayout.EAST);
        MenuPanel.add(BackButton,BorderLayout.WEST);


        AddVenue.setSize(50,50);
        thisform.add(MenuPanel);
        thisform.add(AddVenue);
        thisform.add(UpdateVenue);
        thisform.add(ListVenue);
        thisform.add(DeleteVenue);

        thisform.setSize(400,400);
        thisform.setVisible(true);

    }
}
