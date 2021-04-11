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
        MenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT,40,0));
        MenuPanel.add(BackButton);
        MenuPanel.add(PromoterMenuTag);


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

        thisform.setLocationRelativeTo(null);
        thisform.setVisible(true);

        //Formatting
        Font boldFont = new Font(Font.DIALOG_INPUT, Font.BOLD,  20);
        Font regFont = new Font(Font.DIALOG, Font.PLAIN,  15);
        thisform.getContentPane().setBackground(Color.white); PromoterMenuTag.setFont(boldFont);
        BackButton.setBackground(Color.ORANGE);
        MenuPanel.setBackground(Color.WHITE);
        AddPromoter.setBackground(Color.ORANGE); AddPromoter.setFont(regFont);
        EditPromoter.setBackground(Color.ORANGE); EditPromoter.setFont(regFont);
        ListPromoter.setBackground(Color.ORANGE); ListPromoter.setFont(regFont);
        DeletePromoter.setBackground(Color.ORANGE); DeletePromoter.setFont(regFont);

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
