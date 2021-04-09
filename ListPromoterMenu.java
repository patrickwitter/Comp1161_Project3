import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ListPromoterMenu extends JFrame implements ActionListener {

    JTable listProm;
    DefaultTableModel model;
    JScrollPane scrollPane;

    JPanel cmdPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
    JPanel display = new JPanel();
    JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));

    JButton SortbyName = new JButton("Sort by Name");
    JButton SortbyBud = new JButton("Sort by Budget");
    JButton close = new JButton("Close");

    JLabel titleTag = new JLabel("List Promoter Menu");
    JFrame thisform;

    ArrayList<Promoter> promlist;
    PromoterMenu promoterMenu;

    public ListPromoterMenu(PromoterMenu promoterMenu)
    {
        this.promlist = promoterMenu.mainMenu.getPromList();
        this.promoterMenu = promoterMenu;

        // Configuring Frame Notice that the layout is et before adding components
        thisform = this;

        thisform.setSize(400,400);
        thisform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisform.setLayout(new BorderLayout(5,5));


        // Adding background color to panels
        cmdPanel.setBackground(Color.blue);
        title.setBackground(Color.red);
        display.setBackground(Color.yellow);

        // Adding ActionListeners to buttons
        SortbyName.addActionListener(this);
        SortbyBud.addActionListener(this);
        close.addActionListener(this);

        // Adding compenents to title panel
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

        thisform.setVisible(true);
    }

    private void populatePromTable(ArrayList<Promoter> promList)
    {


        if(promList.size() > 0)
        {
            for(Promoter promoter: promList)
            {
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
