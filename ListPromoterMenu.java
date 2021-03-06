import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ListPromoterMenu extends JFrame implements ActionListener {

    //Configuring Table
    JTable listProm;
    DefaultTableModel model;
    JScrollPane scrollPane;

    //Configuring Panels
    JPanel cmdPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
    JPanel display = new JPanel();
    JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));

    // Adding Buttons
    JButton SortbyName = new JButton("Sort by Name");
    JButton SortbyBud = new JButton("Sort by Budget");
    JButton close = new JButton("Close");

    // Adding Label
    JLabel titleTag = new JLabel("List Promoter Menu");

    JFrame thisform;


    //Setting Icon
    ImageIcon imageIcon = new ImageIcon(getClass().getResource("Icons/ListPromoterIcon.jpg"));

    ArrayList<Promoter> promlist;

    //Previous Menu
    PromoterMenu promoterMenu;

    public ListPromoterMenu(PromoterMenu promoterMenu)
    {
        this.promlist = promoterMenu.mainMenu.getPromList();

        //System.out.println(promlist); // ---------------------------Testing

        this.promoterMenu = promoterMenu;


        // Configuring Frame
        thisform = this;
        thisform.setSize(400,400);
        thisform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisform.setLayout(new BorderLayout(5,5));

        //Setting Icon
        thisform.setIconImage(imageIcon.getImage());

        // Adding ActionListeners to buttons
        SortbyName.addActionListener(this);
        SortbyBud.addActionListener(this);
        close.addActionListener(this);

        // Adding components to title panel
        title.add(titleTag);

        // Adding components to command panel
        cmdPanel.add(SortbyName);
        cmdPanel.add(SortbyBud);
        cmdPanel.add(close);

        // Creating Table
        String[] columnName = {"Promoter Name","Promoter Budget","Promoter Id"};
        model = new DefaultTableModel(columnName,0);
        listProm = new JTable(model);
        listProm.setPreferredScrollableViewportSize(new Dimension(300,300) );
        listProm.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(listProm);

        //Populating Table
        this.populatePromTable(this.promlist);


        // Adding components to display
        display.add(scrollPane);
        thisform.add(display,BorderLayout.CENTER);
        thisform.add(title,BorderLayout.NORTH);
        thisform.add(cmdPanel,BorderLayout.SOUTH);
        thisform.setLocationRelativeTo(null);
        thisform.setVisible(true);

        //Formatting
        Font boldFont = new Font(Font.DIALOG_INPUT, Font.BOLD,  17);
        Font regFont = new Font(Font.DIALOG, Font.PLAIN,  15);

        cmdPanel.setBackground(Color.WHITE);
            SortbyBud.setBackground(Color.ORANGE); SortbyBud.setFont(regFont);
            SortbyName.setBackground(Color.ORANGE); SortbyName.setFont(regFont);
            close.setBackground(Color.ORANGE); close.setFont(regFont);

        title.setBackground(Color.WHITE);
            titleTag.setFont(boldFont);

        display.setBackground(Color.WHITE);
    }

    private void populatePromTable(ArrayList<Promoter> promList)
    {


        if(promList.size() > 0)
        {
            for(Promoter promoter: promList)
            {
              //  System.out.println(promoter);

                this.addToTable(promoter);
            }
        }

    }

    private void addToTable(Promoter p)
    {
        String[] name = p.getName().split(" " );

        Double budget = p.getBudget();

        int id = p.getId();

        String[] row = {name[0] + " " + name[1], budget.toString(), Integer.toString(id)};

        this.model.addRow(row);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ArrayList<Promoter> newPromList =  new ArrayList<>();

        if(e.getSource() == close)
        {
            this.dispose();

            promoterMenu.setVisible(true);
        }

        else if(e.getSource() == SortbyName)
        {
            newPromList = promoterMenu.mainMenu.sortByName();
        }
        else if(e.getSource() == SortbyBud)
        {
            newPromList = promoterMenu.mainMenu.sortByBud();
        }

        this.model.setRowCount(0);

        this.populatePromTable(newPromList);

    }
}
