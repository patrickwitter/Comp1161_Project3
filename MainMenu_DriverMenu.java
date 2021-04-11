import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class MainMenu_DriverMenu extends JFrame implements ActionListener {

    private FileManager fm = new FileManager();
    private EntryScreen entryScreen= new EntryScreen();
    private ReportScreen r= new ReportScreen();
    private WorkArea work = new WorkArea();



    JFrame thisform;

    JButton ManagePromoters = new JButton("Manage Promoters"); // Button to add promoters

    JButton Exit = new JButton("Exit"); // Exit Button

    JLabel MainMenuTag = new JLabel("Main Menu"); // Label
    JPanel MenuPanel = new JPanel();

    public MainMenu_DriverMenu()
    {

        //Calling initialize function to initialize all data from respective files
        // or create the required files
        initialize();

        // Configuring Frame
        thisform = this;
        thisform.setSize(400,400);
        thisform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisform.setLayout( new GridLayout(5,1,0,20));


        MenuPanel.setLayout(new BorderLayout());

        MenuPanel.add(MainMenuTag,BorderLayout.CENTER);

        ManagePromoters.setSize(50,50);

        // Setting Action Listeners for different buttons. Since the Main Menu implements


        ManagePromoters.addActionListener(this);

        Exit.addActionListener(this);

        // Adding panels to frame
        thisform.add(MenuPanel);
        thisform.add(ManagePromoters);

        thisform.add(Exit);

        //Setting  visibility of form to true
        thisform.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == ManagePromoters)
        {

            this.setVisible(false); // Hiding Main Menu

            PromoterMenu prom =  new PromoterMenu(this);
        }
        if(e.getSource() == Exit)
        {
            System.exit(0);
        }

    }



    public Ministry getMinistry()
    {
        return work.mny;
    }

    public ArrayList<Venue> getVenueList()
    {
        //Loads Venues from a file
        return fm.loadVenues();
    }


    // Called by addpromoter menu
    public void addProm(Promoter promoter)
    {

        //Adds to array and then writes the array to file
        //Then writes the new array to a file.
        
        work.promoters.add(promoter);

        fm.writeToPromoter(work.promoters);

    }

    public ArrayList<Promoter> getPromList()
    {
        return fm.loadPromoters(work.mny, getVenueList());
    }

    public EntryScreen getEntryScreen()
    {
        return this.entryScreen;
    }

    // Called by delete promoter menu when the id is valid and the delete button is pressed.
    //Should write to file immediately after.
    public void deleteProm(int idx)
    {

        //Loads promoters from a file to an arraylist, deletes from the arraylist.
        //Then writes the new array to a file.
        ArrayList<Promoter> proms = getPromList();

        proms.remove(idx);

        fm.writeToPromoter(proms);

    }

    // Called by edit promoter menu when id is valid and the save button is pressed
    //Should write to file immediately after.
    public void editProm(int pidx,String budText,String nameText) throws NumberFormatException
    {

        // Edits from the arraylist.
        //Then writes the new array to a file.
        if(!budText.equals(""))
        {
            work.promoters.get(pidx).setBudget(Double.parseDouble(budText));
        }
        if(!nameText.equals(""))
        {
            work.promoters.get(pidx).setName(nameText);
        }


        fm.writeToPromoter(work.promoters);

    }

    //Called by list promoter menu when sort by name button is pressed
    //Should write to file immediately after.
    public ArrayList<Promoter> sortByName()
    {
        ArrayList<Promoter> proms = getPromList();
        Collections.sort(proms, new sortByName());
        fm.writeToPromoter(proms);

        return getPromList();
    }

    //Called by the list promoter menu when sort by budget button is pressed
    //Should write to file immediately after.
    public ArrayList<Promoter> sortByBud()
    {
        ArrayList<Promoter> proms = getPromList();
        Collections.sort(proms, new sortByBudget());
        fm.writeToPromoter(proms);

        return getPromList();
    }

    public void initialize()
    {
        try {
            FileManager.initFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.work.promoters = fm.loadPromoters(work.mny, work.venues);


    }


}
