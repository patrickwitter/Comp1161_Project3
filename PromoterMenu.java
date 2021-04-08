import javax.swing.*;
import java.awt.*;

public class PromoterMenu extends JFrame {

    JFrame thisform;
    JButton AddPromoter = new JButton("Add/Create Promoter"); // Button to add promoters
    JButton UpdatePromoter = new JButton("Edit/Update Promoter"); // Buttom to add venue
    JButton ListPromoter = new JButton("List Promoter"); // button to manage interface
    JButton DeletePromoter = new JButton("Delete Promoter"); // Exit Button
    JLabel PromoterMenuTag = new JLabel("Manage Promoter"); // Label
    JPanel MenuPanel = new JPanel();
    JButton BackButton = new JButton("<");

    public PromoterMenu()
    {
        thisform = this;

        thisform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        thisform.setLayout( new GridLayout(5,1,0,20));

        MenuPanel.setLayout(new BorderLayout());

        MenuPanel.add(PromoterMenuTag,BorderLayout.EAST);
        MenuPanel.add(BackButton,BorderLayout.WEST);


        AddPromoter.setSize(50,50);
        thisform.add(MenuPanel);
        thisform.add(AddPromoter);
        thisform.add(UpdatePromoter);
        thisform.add(ListPromoter);
        thisform.add(DeletePromoter);

        thisform.setSize(400,400);
        thisform.setVisible(true);

    }
}
