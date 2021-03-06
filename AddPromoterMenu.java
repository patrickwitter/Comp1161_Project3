import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPromoterMenu extends JFrame implements ActionListener {

    //Configuring Content for Email
    String message = "Dear Sir/Ma'am\n \tWe are happy to inform you that you have been added to our promoter list!";
    String subject = "Ministry of Fun - Promoter Addition";

    //Setting Icon
    ImageIcon imageIcon = new ImageIcon(getClass().getResource("Icons/AddPromoterIcon.png"));

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
    JLabel name = new JLabel("Enter  Name");
    JLabel budget = new JLabel("Enter  Budget");
    JLabel notify = new JLabel("Send Notification email?");
    JLabel titleTag = new JLabel("Add Promoter Menu");

    // Adding Text fields
    JTextField nameText = new JTextField(10);
    JTextField budText = new JTextField(10);

    // Adding JCheckBox
    JCheckBox notifyCheck = new JCheckBox();

    PromoterMenu promoterMenu;

    public AddPromoterMenu(PromoterMenu prom)
    {
        this.promoterMenu = prom;

        thisForm = this;

        // Setting form configuration
        thisForm.setSize(340,220);
        thisForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisForm.setLayout(new BorderLayout());

        //Setting Icon
        thisForm.setIconImage(imageIcon.getImage());

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
        display.add(notify);
        display.add(notifyCheck);
        // Adding component to command panel
        command.add(save);
        command.add(cancel);

        //Adding panels to frame
        thisForm.add(title,BorderLayout.NORTH);
        thisForm.add(display,BorderLayout.CENTER);
        thisForm.add(command,BorderLayout.SOUTH);

        // Displaying frame
        thisForm.setLocationRelativeTo(null);
        thisForm.setVisible(true);

        //Formatting
        Font boldFont = new Font(Font.DIALOG_INPUT, Font.BOLD,  17);
        Font regFont = new Font(Font.DIALOG, Font.PLAIN,  15);

        title.setBackground(Color.WHITE);
        titleTag.setFont(boldFont);

        display.setBackground(Color.WHITE); notifyCheck.setBackground(Color.WHITE);
        name.setFont(regFont); nameText.setFont(regFont);
        budget.setFont(regFont); budText.setFont(regFont);
        notify.setFont(regFont);

        command.setBackground(Color.WHITE);
        save.setBackground(Color.ORANGE); save.setFont(regFont);
        cancel.setBackground(Color.ORANGE); save.setFont(regFont);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save)
        {
            try {
                String[] names  = nameText.getText().split(" ");

                Double budget = Double.parseDouble(budText.getText());

                String fullname = "";

                if(names.length == 2)
                {
                    fullname = names[0] + " " + names[1];

                    Ministry currMinistry = promoterMenu.mainMenu.getMinistry();

                    ArrayList<Venue> currVenue = promoterMenu.mainMenu.getVenueList();

                    Promoter p = new Promoter(fullname, budget ,currMinistry,currVenue);

                    promoterMenu.mainMenu.addProm(p);



                    if(notifyCheck.isSelected())
                    {
                        try {
                            PromoterEmail.sendMail(this.message,this.subject);

                            new Message("Promoter was added Successfully. " +
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
                        new Message("Promoter Added Successfully",this.promoterMenu);
                        this.dispose();
                    }








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

            promoterMenu.setVisible(true);
        }
    }
}
