import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PromoterMenu extends JFrame implements ActionListener {

    JFrame thisform;
    JButton AddPromoter = new JButton("Add/Create Promoter"); // Button to add promoters
    JButton EditPromoter = new JButton("Edit/Update Promoter"); // Buttom to add venue
    JButton ListPromoter = new JButton("List Promoter"); // button to manage interface
    JButton DeletePromoter = new JButton("Delete Promoter"); // Exit Button
    JLabel PromoterMenuTag = new JLabel("Manage Promoter"); // Label
    JPanel MenuPanel = new JPanel();
    JButton BackButton = new JButton("<");

    MainMenu_DriverMenu mainMenu;

    private ReportScreen reportScreen = new ReportScreen();

    public PromoterMenu(MainMenu_DriverMenu main)
    {
        this.mainMenu = main;

        // Form Configuration
        thisform = this;
        thisform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisform.setLayout( new GridLayout(5,1,0,20));
        thisform.setSize(400,400);

        // Menu Panel Configuration
        MenuPanel.setLayout(new BorderLayout());
        MenuPanel.add(PromoterMenuTag,BorderLayout.EAST);
        MenuPanel.add(BackButton,BorderLayout.WEST);

        // Adding Action Listeners
        AddPromoter.addActionListener(this);
        ListPromoter.addActionListener(this);
        DeletePromoter.addActionListener(this);
        EditPromoter.addActionListener(this);
        BackButton.addActionListener(this);

        // Adding components to frame
        thisform.add(MenuPanel);
        thisform.add(AddPromoter);
        thisform.add(EditPromoter);
        thisform.add(ListPromoter);
        thisform.add(DeletePromoter);


        thisform.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        thisform.setVisible(false);

        if(e.getSource() == AddPromoter)
        {
            AddPromoterMenu addPromoterMenu = new AddPromoterMenu(this);
        }
        else if(e.getSource() == ListPromoter)
        {
            ListPromoterMenu listPromoterMenu = new ListPromoterMenu(this);
        }
        else if(e.getSource() == EditPromoter)
        {
            EditPromoterMenu editPromoterMenu = new EditPromoterMenu(this);

        }
        else if(e.getSource() == DeletePromoter)
        {
            DeletePromoterMenu deletePromoterMenu = new DeletePromoterMenu(this);
        }
        else if(e.getSource() == BackButton)
        {

            this.mainMenu.setVisible(true);
        }
    }


}
