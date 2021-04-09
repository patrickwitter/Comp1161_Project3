import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainMenu_DriverMenu extends JFrame implements ActionListener {

    private EntryScreen entryScreen= new EntryScreen();
    private ReportScreen r= new ReportScreen();
    private WorkArea work = new WorkArea();
    private SystemInfo sys = new SystemInfo();
    private Scanner scan = new Scanner(System.in);


    JFrame thisform;
    JButton ManagePromoters = new JButton("Manage Promoters"); // Button to add promoters
    JButton ManageVenue = new JButton("Manage Venues"); // Buttom to add venue
    JButton MinistryInterface = new JButton("Ministry Interface"); // button to manage interface
    JButton Exit = new JButton("Exit"); // Exit Button
    JLabel MainMenuTag = new JLabel("Main Menu"); // Label
    JPanel MenuPanel = new JPanel();

    public MainMenu_DriverMenu()
    {



        // Configuring Frame
        thisform = this;
        thisform.setSize(400,400);
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

        // Adding panels to frame
        thisform.add(MenuPanel);
        thisform.add(ManagePromoters);
        thisform.add(ManageVenue);
        thisform.add(MinistryInterface);
        thisform.add(Exit);

        //Setting  visibility of form to true
        thisform.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == ManagePromoters)
        {

            PromoterMenu prom =  new PromoterMenu(this);
        }

    }



    public Ministry getMinistry()
    {
        return work.mny;
    }

    public ArrayList<Venue> getVenueList()
    {
        return work.venues;
    }

    public void addProm(Promoter promoter)
    {
        System.out.println("Testing for addition of promoter");

        System.out.println(work.promoters); // -----------------------------Testing

        work.promoters.add(promoter);

        System.out.println(work.promoters); //----------------------------Testing
    }

    public ArrayList<Promoter> getPromList()
    {
        return work.promoters;
    }

    public EntryScreen getEntryScreen()
    {
        return this.entryScreen;
    }

    public void deleteProm(int idx)
    {
        System.out.println("Testing for deletion of promoter");

        System.out.println(work.promoters); // -----------------------------Testing

        work.promoters.remove(idx);

        System.out.println(work.promoters); //----------------------------Testing
    }

    public void editProm(int pidx,String budText,String nameText)
    {
        System.out.println("Testing for editing  of promoter");

        System.out.println(work.promoters); // -----------------------------Testing

        Promoter p = work.promoters.get(pidx);

        p.setBudget(Double.parseDouble(budText));

        p.setName(nameText);

        System.out.println(work.promoters); //----------------------------Testing
    }

    public ArrayList<Promoter> sortByName()
    {
        Collections.sort(work.promoters, new sortByName());

        return work.promoters;
    }

    public ArrayList<Promoter> sortByBud()
    {
        Collections.sort(work.promoters,new sortByBudget());

        return work.promoters;
    }

}
