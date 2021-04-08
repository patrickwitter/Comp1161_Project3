import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListPromoterMenu extends JFrame {

    JTable listProm;
    DefaultTableModel model;
    JScrollPane scrollPane;

    JPanel cmdPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
    JPanel display = new JPanel();
    JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));

    JButton SortbyName = new JButton("Sort by Name");
    JButton SortbyBud = new JButton("Sort by Budget");

    JLabel titleTag = new JLabel("List Promoter Menu");
    JFrame thisform;

    public ListPromoterMenu()
    {
        // Configuring Frame Notice that the layout is et before adding components
        thisform = this;
        thisform.setSize(400,400);
        thisform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisform.setLayout(new BorderLayout(5,5));


        // Adding background color to panels
        cmdPanel.setBackground(Color.blue);
        title.setBackground(Color.red);
        display.setBackground(Color.yellow);



        // Adding compenents to title panel
        title.add(titleTag);

        // Adding components to command panel
        cmdPanel.add(SortbyName);
        cmdPanel.add(SortbyBud);

        // Creating Table
        String[] columnName = {"Promoter Name","Promoter Budget"};
        model = new DefaultTableModel(columnName,0);
        listProm = new JTable(model);
        listProm.setPreferredScrollableViewportSize(new Dimension(300,300) );
        listProm.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(listProm);

        // Adding components to display
        display.add(scrollPane);

        thisform.add(display,BorderLayout.CENTER);
        thisform.add(title,BorderLayout.NORTH);
        thisform.add(cmdPanel,BorderLayout.SOUTH);

        thisform.setVisible(true);
    }
}
