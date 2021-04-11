import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditPromoterMenu extends JFrame implements ActionListener {

    //Configuring Email
    String message = "Dear Sir/Ma'am\n \t Your information has been edited by the Ministry as you have requested\n" +
            "If this was not you please contact us as soon as possible";
    String subject = "Ministry of Fun - Promoter Information Edited";


    // Adding panels
    JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
    JPanel command = new JPanel(new FlowLayout());
    JPanel display = new JPanel(new GridLayout(4,2,0,10) );
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
    JLabel willNotify = new JLabel("Notify Promoter");

    // Adding Text fields
    JTextField nameText = new JTextField(10);
    JTextField budText = new JTextField(10);
    JTextField idText = new JTextField(5);

    //Adding JCheckbox
    JCheckBox notify = new JCheckBox();
    PromoterMenu promoterMenu;

    public EditPromoterMenu(PromoterMenu prom)
    {
        thisForm = this;

        promoterMenu = prom;

        // Setting form configuration
        thisForm.setSize(300,200);
        thisForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisForm.setLayout(new BorderLayout());

        // Adding Background Color to the panels
        title.setBackground(Color.red);
        command.setBackground(Color.cyan);
        display.setBackground(Color.green);

        // Adding Action Listener to Button
        save.addActionListener(this);
        cancel.addActionListener(this);

        // Adding component to title panel
        title.add(titleTag);


        // Adding component to display panel

        display.add(id);
        display.add(idText);

        display.add(name);
        display.add(nameText);

        display.add(budget);
        display.add(budText);

        display.add(willNotify);
        display.add(notify);

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
            try{
                EntryScreen entryscreen = promoterMenu.mainMenu.getEntryScreen();

                ArrayList<Promoter> promList = promoterMenu.mainMenu.getPromList();

                String[] names = nameText.getText().split(" ");

                if(names.length == 2 || nameText.getText().equals("")) // Checking whether no name was entered or if First AND last name was entered
                {
                    int id = Integer.parseInt(idText.getText());

                    int pidx = entryscreen.findPromoter(promList,id);

                    if(pidx >= 0)
                    {
                        promoterMenu.mainMenu.editProm(pidx,budText.getText(),nameText.getText());

                        if(notify.isSelected())
                        {
                            try {
                                PromoterEmail.sendMail(this.message,this.subject);



                                new Message("Promoter was edited Successfully. " +
                                        "Email was sent successfully",this.promoterMenu);

                                this.dispose();
                            }
                            catch (Exception un)
                            {
                                new Message("Email was not sent successfully");
                            }
                        }
                        else
                        {
                            new Message("Promoter was edited successfully",this.promoterMenu);
                            this.dispose();

                        }
                    }
                    else
                    {
                        new Message("Promoter not found please enter valid promoter");
                    }
                }
                else
                {
                    new Message("Please Enter Firstname and Last Name");

                }

            }
            catch (NumberFormatException ex)
            {
                new Message("Incorrect value for ID or Budget. Please try again");
            }


        }
        else if(e.getSource() == cancel)
        {
            this.dispose();

            promoterMenu.setVisible(true);
        }
    }
}
