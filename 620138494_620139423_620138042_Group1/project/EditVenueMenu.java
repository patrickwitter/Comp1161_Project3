import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Edit Venue Menu
 **/
public class EditVenueMenu extends JFrame {
    private static final long serialVersionUID = 1873954694333581077L;

    private JComboBox<Integer> indxBox;
    private JTextField name;
    private JTextField size;
    private JTextField stageSize;
    private JTextField foodSize;
    private JTextField barSize;
    private JTextField specSize;
    private JTextField compSize;
    private JTextField instructSize;
    private JTextField otherSize;
    private JTextField numSecurity;
    private JTextField price;
    private JComboBox<Integer> level;

    private JPanel selectionPanel;
    private JPanel inputPanel;
    private JPanel cmdPanel;

    private JButton findButton;
    private JButton cmdEditVenue;
    private JButton cmdClose;

    private ArrayList<Venue> venues = new ArrayList<Venue>();
    private String venType = null;// Type of venue that is currently active in the menu
    private Integer indx = -1;

    //Pass in null as the parameters for indx and type but not vens when calling from a button
    public EditVenueMenu(Integer pIndx, String type, ArrayList<Venue> vens) {
        this.venues = vens;
        if(pIndx==null){
            this.indx = -1;
        }
        else{
            this.indx = pIndx;
        }

        // Change title of menu depending on type
        setTitle("Edit Venue Menu");

        // Initialize Panels
        selectionPanel = new JPanel();
        inputPanel = new JPanel();
        cmdPanel = new JPanel();

        // Generate the index selection screen
        selectionPanel.add(new JLabel("Select/Type Index of Venue to Find"));
        findButton = new JButton("Find");
        findButton.addActionListener(new FindButtonListener(this));
        ArrayList<Integer> indxList = new ArrayList<Integer>();
        int x = 0;
        while (x < venues.size()) {
            indxList.add(x);
            x++;
        }
        Integer[] indxListArray = indxList.toArray(new Integer[indxList.size()]);
        indxBox = new JComboBox<Integer>(indxListArray);
        indxBox.setEditable(true);
        selectionPanel.add(indxBox);
        selectionPanel.add(findButton);
        if (venType != null && indx != -1){
            selectionPanel.add(new JLabel("Currently Editing "+getTypeVen()+" Venue at Index : "+indx));
        }

        //Determine Type of Venue and Generate menu accordingly
        if(this.indx != -1 && this.indx>=0 && this.indx<this.venues.size()){
            // If the venue is assigned populate the menu with relevant data
            Integer[] levels = { 1, 2, 3 };// Ministry alert levels
            Venue v = this.venues.get(indx);

            //Editing Regular Venue
            if(v.getClass()==Venue.class){
                setTypeVen("Regular");
                selectionPanel.add(new JLabel("Editing "+getTypeVen()+" Venue at Index : "+indx));

                // Name
                inputPanel.add(new JLabel("Name"));
                name = new JTextField(20);
                name.setText(v.getName());
                inputPanel.add(name);

                // Size
                inputPanel.add(new JLabel("Size"));
                size = new JTextField(20);
                size.setText(String.valueOf(v.getSize()));
                inputPanel.add(size);

                // Price
                inputPanel.add(new JLabel("Price"));
                price = new JTextField(20);
                price.setText((String.valueOf(v.getPrice())));
                inputPanel.add(price);
                // Level
                inputPanel.add(new JLabel("Alert Level"));
                level = new JComboBox<Integer>(levels);
                level.setSelectedItem(v.getLevel());
                inputPanel.add(level);

            }

            //Editing Training Venue
            if(v.getClass()==TrainingVenue.class){
                setTypeVen("Training");
                selectionPanel.add(new JLabel("Editing "+getTypeVen()+" Venue at Index : "+indx));

                //Getting vars from toString
                String[] vals = v.toString().split(";");
                for (String val : vals) {
                    System.out.println(val);
                }

                // Name
                inputPanel.add(new JLabel("Name"));
                name = new JTextField(20);
                name.setText(v.getName());
                inputPanel.add(name);

                // Instructor Area
                inputPanel.add(new JLabel("Instructor Area"));
                instructSize = new JTextField(20);
                instructSize.setText(vals[3].split("a")[1]);
                inputPanel.add(instructSize);
                // Other Area
                inputPanel.add(new JLabel("Other Area"));
                otherSize = new JTextField(20);
                otherSize.setText(vals[4].split("a")[1]);
                inputPanel.add(otherSize);

                // Price
                inputPanel.add(new JLabel("Price"));
                price = new JTextField(20);
                price.setText((String.valueOf(v.getPrice())));
                inputPanel.add(price);
                // Level
                inputPanel.add(new JLabel("Alert Level"));
                level = new JComboBox<Integer>(levels);
                level.setSelectedItem(v.getLevel());
                inputPanel.add(level);

            }

            //Editing Sports Venue
            if(v.getClass()==SportsVenue.class){
                setTypeVen("Sports");
                selectionPanel.add(new JLabel("Editing "+getTypeVen()+" Venue at Index : "+indx));
            
                //Getting vars from toString
                String[] vals = v.toString().split(";");
                for (String val : vals) {
                    System.out.println(val);
                }

                // Name
                inputPanel.add(new JLabel("Name"));
                name = new JTextField(20);
                name.setText(v.getName());
                inputPanel.add(name);

                // Competitor Area
                inputPanel.add(new JLabel("Competitor Area"));
                compSize = new JTextField(20);
                compSize.setText(vals[3].split(":")[1]);
                inputPanel.add(compSize);
                // Spectator Area
                inputPanel.add(new JLabel("Spectator Area"));
                specSize = new JTextField(20);
                specSize.setText(vals[4].split(":")[1]);
                inputPanel.add(specSize);

                // Security
                inputPanel.add(new JLabel("Security"));
                numSecurity = new JTextField(20);
                numSecurity.setText(vals[5].split(":")[1]);
                inputPanel.add(numSecurity);

                // Price
                inputPanel.add(new JLabel("Price"));
                price = new JTextField(20);
                price.setText((String.valueOf(v.getPrice())));
                inputPanel.add(price);
                // Level
                inputPanel.add(new JLabel("Alert Level"));
                level = new JComboBox<Integer>(levels);
                level.setSelectedItem(v.getLevel());
                inputPanel.add(level);

            }

            //Editing Party Venue
            if(v.getClass()==PartyVenue.class){
                setTypeVen("Party");
                selectionPanel.add(new JLabel("Editing "+getTypeVen()+" Venue at Index : "+indx));

                //Getting vars from toString
                String[] vals = v.toString().split(";");
                for (String val : vals) {
                    System.out.println(val);
                }

                // Name
                inputPanel.add(new JLabel("Name"));
                name = new JTextField(20);
                name.setText(v.getName());
                inputPanel.add(name);

                // Stage Area
                inputPanel.add(new JLabel("Stage Area"));
                stageSize = new JTextField(20);
                stageSize.setText(vals[3].split(":")[1]);
                inputPanel.add(stageSize);
                // Food Area
                inputPanel.add(new JLabel("Food Area"));
                foodSize = new JTextField(20);
                foodSize.setText(vals[5].split(":")[1]);
                inputPanel.add(foodSize);
                // Bar Area
                inputPanel.add(new JLabel("Bar Area"));
                barSize = new JTextField(20);
                barSize.setText(vals[4].split(":")[1]);
                inputPanel.add(barSize);

                // Security
                inputPanel.add(new JLabel("Security"));
                numSecurity = new JTextField(20);
                numSecurity.setText(vals[6].split("c")[1]);
                inputPanel.add(numSecurity);

                // Price
                inputPanel.add(new JLabel("Price"));
                price = new JTextField(20);
                price.setText((String.valueOf(v.getPrice())));
                inputPanel.add(price);
                // Level
                inputPanel.add(new JLabel("Alert Level"));
                level = new JComboBox<Integer>(levels);
                level.setSelectedItem(v.getLevel());
                inputPanel.add(level);

            }

        }

        //Initalize command buttons
        cmdEditVenue = new JButton("Edit " + venType + " Venue");
        cmdClose = new JButton("Cancel");

        cmdClose.addActionListener(new CloseButtonListener(this));

        if (venType != null) {
            cmdEditVenue.addActionListener(new EditVenueListener(this));
            cmdPanel.add(cmdEditVenue);
        }
        cmdPanel.add(cmdClose);

        // Add panels and set layout
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.PAGE_AXIS));
        inputPanel.setLayout(new GridLayout(0, 2));
        add(selectionPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(cmdPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    /**
     * Method to set the type of venue
     * 
     * @param type type of venue
     */
    public void setTypeVen(String type) {
        this.venType = type;
    }

    /**
     * Method to get type of venue
     * 
     * @return String of the venue type
     */
    public String getTypeVen() {
        return this.venType;
    }

    /**
     * Edit Button Listener
     **/
    private class EditVenueListener implements ActionListener {
        EditVenueMenu editVenueMenu;

        /**
         * Constructor for the close button listener
         * 
         * @param editVenueMenu takes in current menu
         */
        public EditVenueListener(EditVenueMenu currMenu) {
            this.editVenueMenu = currMenu;
        }


        public void actionPerformed(ActionEvent e) {
            //TODO
        }
    }

    /**
     * Find Button Listener
     **/
    private class FindButtonListener implements ActionListener {
        EditVenueMenu editVenueMenu;

        /**
         * Constructor for the Find Button Listener
         * @param currMenu takes in the current menu
         */
        public FindButtonListener(EditVenueMenu currMenu) {
            this.editVenueMenu = currMenu;
        }

        /**
         * Method to execute action when combo box is selected. Disables the visibility
         * of the current menu then instantiates a new menu with the selected type
         */
        public void actionPerformed(ActionEvent e) {
            editVenueMenu.setVisible(false);
            try{
                System.out.println(Integer.parseInt(indxBox.getSelectedItem().toString())+" "+venues.get(Integer.parseInt(indxBox.getSelectedItem().toString())).toString());
            } catch(IndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(new JFrame(), "Venue not found", "Data Entry Error",
                JOptionPane.ERROR_MESSAGE);
            }
                EditVenueMenu newMenu = new EditVenueMenu(Integer.parseInt(indxBox.getSelectedItem().toString()), getTypeVen(), venues);
        }
    }

    /**
     * Close Button Listener
     **/
    private class CloseButtonListener implements ActionListener {
        EditVenueMenu editVenueMenu;

        /**
         * Constructor for the close button listener
         * 
         * @param editVenueMenu takes in current menu
         */
        public CloseButtonListener(EditVenueMenu currMenu) {
            this.editVenueMenu = currMenu;
        }

        /**
         * Method to set visibility as false
         */
        public void actionPerformed(ActionEvent e) {
            editVenueMenu.setVisible(false);
        }
    }

}