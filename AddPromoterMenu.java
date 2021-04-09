import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPromoterMenu extends JFrame implements ActionListener {

    // Adding panels
    JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
    JPanel command = new JPanel(new FlowLayout());
    JPanel display = new JPanel(new GridLayout(3,2,0,10) );
    //Adding reference frame
    JFrame thisForm;

    // Adding Buttons
    JButton save = new JButton("Save");
    JButton cancel = new JButton("Cancel");

    //Adding Label
    JLabel name = new JLabel("Enter  Name");
    JLabel budget = new JLabel("Enter  Budget");
    JLabel titleTag = new JLabel("Add Promoter Menu");

    // Adding Text fields
    JTextField nameText = new JTextField(10);
    JTextField budText = new JTextField(10);

    PromoterMenu promoterMenu;

    public AddPromoterMenu(PromoterMenu prom)
    {
        this.promoterMenu = prom;

        thisForm = this;

        // Setting form configuration
        thisForm.setSize(300,200);
        thisForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisForm.setLayout(new BorderLayout());

        // Adding Background Color to the panels
        title.setBackground(Color.red);
        command.setBackground(Color.cyan);
        display.setBackground(Color.green);

        //Adding ActionListners to buttons
        save.addActionListener(this);
        cancel.addActionListener(this);

        // Adding component to title panel
        title.add(titleTag);


        // Adding component to display panel
        display.add(name);
        display.add(nameText);
        display.add(budget);
        display.add(budText);

        // Adding component to command panel
        command.add(save);
        command.add(cancel);

        //Adding panels to frame
        thisForm.add(title,BorderLayout.NORTH);
        thisForm.add(display,BorderLayout.CENTER);
        thisForm.add(command,BorderLayout.SOUTH);

        // Displaying frame
        thisForm.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save)
        {
            try {
                String[] names  = nameText.getText().split(" ");

                if(names.length == 2)
                {
                    Ministry currMinistry = promoterMenu.mainMenu.getMinistry();

                    ArrayList<Venue> currVenue = promoterMenu.mainMenu.getVenueList();

                    Promoter p = new Promoter(names[0] + " " + names[1],Double.parseDouble(budText.getText()),currMinistry,currVenue);

                    promoterMenu.mainMenu.addProm(p);
                }
                else
                {
                    new Message("Please Enter First AND Lastname");
                    nameText.setText("");
                }
            }
            catch (NumberFormatException num)
            {
                new Message("Incorrect Type set for Budget. Please try again");
                budText.setText("");
            }

        }
        else if(e.getSource() == cancel)
        {
            this.dispose();
        }
    }
}
