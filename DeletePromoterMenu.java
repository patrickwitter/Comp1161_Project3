import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeletePromoterMenu extends JFrame implements ActionListener {

    // Adding Panels
    JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
    JPanel command = new JPanel(new FlowLayout());
    JPanel display = new JPanel(new GridLayout(1,2,0,10) );

    //Adding reference frame
    JFrame thisForm;

    //Setting Icon
    ImageIcon imageIcon = new ImageIcon(getClass().getResource("Icons/DeletePromoterIcon.png"));

    // Adding Buttons
    JButton delete = new JButton("Delete Promoter");
    JButton cancel = new JButton("Cancel");

    // Adding JLabel
    JLabel delLabel = new JLabel("Enter id of Promoter to delete");
    JLabel titleTag = new JLabel("Delete Promoter Menu");
    // Adding Textfield
    JTextField idDel = new JTextField(5);

    // Previous Menu
    PromoterMenu promoterMenu;

    public DeletePromoterMenu(PromoterMenu prom)
    {
        this.promoterMenu = prom;

        thisForm = this;

        //Configuring Frame
        thisForm.setSize(400,230);
        thisForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisForm.setLayout(new BorderLayout());

        //Setting Icon
        thisForm.setIconImage(imageIcon.getImage());

        // Adding Actions to buttons
        delete.addActionListener(this);
        cancel.addActionListener(this);


        //Adding component to title panel
        title.add(titleTag);

        //Adding component to display panel
        display.add(delLabel);
        display.add(idDel);

        // Adding command Panel
        command.add(delete);
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

        command.setBackground(Color.WHITE);
            delete.setBackground(Color.ORANGE); delete.setFont(regFont);
            cancel.setBackground(Color.ORANGE); cancel.setFont(regFont);

        display.setBackground(Color.WHITE);
            delLabel.setFont(regFont); idDel.setFont(regFont);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete)
        {
            try {
                EntryScreen entryscreen = promoterMenu.mainMenu.getEntryScreen();

                ArrayList<Promoter> promList = promoterMenu.mainMenu.getPromList();

                int id = Integer.parseInt(idDel.getText());

                int pidx = entryscreen.findPromoter(promList,id);

                if(pidx >= 0)
                {
                    promoterMenu.mainMenu.deleteProm(pidx);

                    new Message("Promoter was successfully deleted",this.promoterMenu);

                    this.dispose();
                }
                else
                {
                    new Message("Promoter not found please enter valid promoter");
                }
            }
           catch (NumberFormatException ex)
           {
               new Message("Incorrect format for ID please try again");
           }
        }
        else if(e.getSource() == cancel)
        {
            this.dispose();

            promoterMenu.setVisible(true);
        }
    }
}
