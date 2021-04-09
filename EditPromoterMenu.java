import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditPromoterMenu extends JFrame implements ActionListener {

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
    JLabel id = new JLabel("Enter ID of promoter to edit");
    JLabel name = new JLabel("Enter New Name");
    JLabel budget = new JLabel("Enter New Budget");
    JLabel titleTag = new JLabel("Edit Promoter Menu");

    // Adding Text fields
    JTextField nameText = new JTextField(10);
    JTextField budText = new JTextField(10);
    JTextField idText = new JTextField(5);

    PromoterMenu promoterMenu;

    public EditPromoterMenu(PromoterMenu prom)
    {
        thisForm = this;

        promoterMenu = prom;

        // Setting form configuration
        thisForm.setSize(300,200);
        thisForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisForm.setLayout(new BorderLayout());

        // Adding Background Color to the panels
        title.setBackground(Color.red);
        command.setBackground(Color.cyan);
        display.setBackground(Color.green);

        // Adding Action Listener to Button
        save.addActionListener(this);

        // Adding component to title panel
        title.add(titleTag);


        // Adding component to display panel

        display.add(id);
        display.add(idText);

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
            EntryScreen entryscreen = promoterMenu.mainMenu.getEntryScreen();

            ArrayList<Promoter> promList = promoterMenu.mainMenu.getPromList();

            int id = Integer.parseInt(idText.getText());

            int pidx = entryscreen.findPromoter(promList,id);

            if(pidx >= 0)
            {
                promoterMenu.mainMenu.editProm(pidx,budText.getText(),nameText.getText());
            }
            else
            {
                idText.setText("Promoter not found please enter valid promoter");
            }

        }
    }
}
