import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Add Venue Menu
 **/
public class AddVenueMenu extends JFrame {
    private static final long serialVersionUID = -650776966012594827L;

    private JComboBox<String> venComboBox;
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

    private JButton cmdAddVenue;
    private JButton cmdClose;

    private JPanel selectionPanel;
    private JPanel inputPanel;
    private JPanel cmdPanel;

    private String venType = null;// Type of venue that is currently active in the menu

    /**
     * Constructor for Add Venue Menu.
     */
    //Pass in null as the parameter when calling from a button
    public AddVenueMenu(String type) {
        setTypeVen(type);
        // Change title of menu depending on type
        if (venType != null) {
            setTitle("Add " + venType + " Venue Menu");
        } else {
            setTitle("Add Venue Menu");
        }

        // Initialize Panels
        selectionPanel = new JPanel();
        inputPanel = new JPanel();
        cmdPanel = new JPanel();

        // Create Combo Box and add a listener to receive selections
        selectionPanel.add(new JLabel("Select Venue to Add"));
        String[] venues = { "Regular Venue", "Party Venue", "Training Venue", "Sports Venue" };
        venComboBox = new JComboBox<String>(venues);
        venComboBox.addActionListener(new ComboBoxListener(this));
        selectionPanel.add(venComboBox);
        if (venType != null) {
            selectionPanel.add(new JLabel("Adding : " + venType + " Venue"));
        }

        // If no venue has been assigned yet do nothing
        if (venType != null) {
            // If the venue is assigned populate the menu with relevant data
            Integer[] levels = { 1, 2, 3 };// Ministry alert levels

            // Name
            inputPanel.add(new JLabel("Name"));
            name = new JTextField(20);
            inputPanel.add(name);

            if (venType.equals("Regular")) {
                System.out.println("Generating " + getTypeVen() + " menu");
                // Generate input for a regular venue
                // Size
                inputPanel.add(new JLabel("Size"));
                size = new JTextField(20);
                inputPanel.add(size);
            }

            if (venType.equals("Party")) {
                System.out.println("Generating " + getTypeVen() + " menu");
                // Generate input for a party venue
                // Stage Area
                inputPanel.add(new JLabel("Stage Area"));
                stageSize = new JTextField(20);
                inputPanel.add(stageSize);
                // Food Area
                inputPanel.add(new JLabel("Food Area"));
                foodSize = new JTextField(20);
                inputPanel.add(foodSize);
                // Bar Area
                inputPanel.add(new JLabel("Bar Area"));
                barSize = new JTextField(20);
                inputPanel.add(barSize);
            }

            if (venType.equals("Sports")) {
                System.out.println("Generating " + getTypeVen() + " menu");
                // Generate input for a sports venue
                // Competitor Area
                inputPanel.add(new JLabel("Competitor Area"));
                compSize = new JTextField(20);
                inputPanel.add(compSize);
                // Spectator Area
                inputPanel.add(new JLabel("Spectator Area"));
                specSize = new JTextField(20);
                inputPanel.add(specSize);
            }

            if (venType.equals("Party") || venType.equals("Sports")) {
                // Security
                inputPanel.add(new JLabel("Security"));
                numSecurity = new JTextField(20);
                inputPanel.add(numSecurity);
            }

            if (venType.equals("Training")) {
                System.out.println("Generating " + getTypeVen() + " menu");
                // Generate input for a training venue
                // Instructor Area
                inputPanel.add(new JLabel("Instructor Area"));
                instructSize = new JTextField(20);
                inputPanel.add(instructSize);
                // Other Area
                inputPanel.add(new JLabel("Other Area"));
                otherSize = new JTextField(20);
                inputPanel.add(otherSize);
            }

            // Price
            inputPanel.add(new JLabel("Price"));
            price = new JTextField(20);
            inputPanel.add(price);
            // Level
            inputPanel.add(new JLabel("Alert Level"));
            level = new JComboBox<Integer>(levels);
            inputPanel.add(level);

        }

        // Populate the command panel with buttons
        cmdAddVenue = new JButton("Add " + venType + " Venue");
        cmdClose = new JButton("Cancel");

        cmdClose.addActionListener(new CloseButtonListener(this));

        if (venType != null) {
            cmdAddVenue.addActionListener(new AddVenueListener(this));
            cmdPanel.add(cmdAddVenue);
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
     * Combo Box Listener
     **/
    private class ComboBoxListener implements ActionListener {
        AddVenueMenu addVenueMenu;

        /**
         * Constructor for the Combo Box Listener
         * 
         * @param currMenu takes in the current menu
         */
        public ComboBoxListener(AddVenueMenu currMenu) {
            this.addVenueMenu = currMenu;
        }

        /**
         * Method to execute action when combo box is selected. Disables the visibility
         * of the current menu then instantiates a new menu with the selected type
         */
        public void actionPerformed(ActionEvent e) {
            System.out.println(venComboBox.getSelectedItem().toString());
            addVenueMenu.setVisible(false);
            AddVenueMenu newMenu = new AddVenueMenu(venComboBox.getSelectedItem().toString().split(" ")[0]);
        }
    }

    /**
     * Add Venue Listener
     **/
    private class AddVenueListener implements ActionListener {
        AddVenueMenu addVenueMenu;

        /**
         * Constructor for the Add Venue Listener
         * 
         * @param currMenu takes in the current menu
         */
        public AddVenueListener(AddVenueMenu currMenu) {
            this.addVenueMenu = currMenu;
        }

        /**
         * Method to accept input
         */
        public void actionPerformed(ActionEvent e) {

            //All local variables are initialized to -1 until assignment
            String txtname = null;
            double txtsize = -1;
            double txtStageSize = -1;
            double txtFoodSize = -1;
            double txtBarSize = -1;
            double txtCompSize = -1;
            double txtSpecSize = -1;
            double txtInstSize = -1;
            double txtOtherSize = -1;
            double txtPrice = -1;
            int txtNumSecurity = -1;
            int txtlevel = -1;


            int errval = -1;

            // Name
            txtname = addVenueMenu.name.getText();
            // If statement block to validate data entered
            if (txtname.equals(" ")||txtname.equals("")) {
                errval = 1;
                JOptionPane.showMessageDialog(new JFrame(), "No name was entered", "Data Entry Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                //Getting Regular Venue properties
                if (venType.equals("Regular")) {
                    // Size
                    try {
                        txtsize = Double.parseDouble(addVenueMenu.size.getText());
                    } catch (NumberFormatException ex) {
                        errval = 1;
                        JOptionPane.showMessageDialog(new JFrame(), "Size must be a number", "Data Entry Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                //Getting Party Venue properties
                if (venType.equals("Party")) {
                    // Size/Area
                    try {
                        txtStageSize = Double.parseDouble(addVenueMenu.stageSize.getText());
                        txtFoodSize = Double.parseDouble(addVenueMenu.foodSize.getText());
                        txtBarSize = Double.parseDouble(addVenueMenu.barSize.getText());
                    } catch (NumberFormatException ex) {
                        errval = 1;
                        JOptionPane.showMessageDialog(new JFrame(), "Size must be a number", "Data Entry Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                //Getting Sport Venue properties
                if (venType.equals("Sports")) {
                    // Size/Area
                    try {
                        txtCompSize = Double.parseDouble(addVenueMenu.compSize.getText());
                        txtSpecSize = Double.parseDouble(addVenueMenu.specSize.getText());
                    } catch (NumberFormatException ex) {
                        errval = 1;
                        JOptionPane.showMessageDialog(new JFrame(), "Size must be a number", "Data Entry Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                //If venue type is party or sport then get security associated with them
                if (venType.equals("Party") || venType.equals("Sports")) {
                    // Security
                    try {
                        txtNumSecurity = Integer.parseInt(addVenueMenu.numSecurity.getText());
                    } catch (NumberFormatException ex) {
                        errval = 1;
                        JOptionPane.showMessageDialog(new JFrame(), "Security must be a number", "Data Entry Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                //Getting Training Venue properties
                if (venType.equals("Training")) {
                    // Size/Area
                    try {
                        txtInstSize = Double.parseDouble(addVenueMenu.instructSize.getText());
                        txtOtherSize = Double.parseDouble(addVenueMenu.otherSize.getText());
                    } catch (NumberFormatException ex) {
                        errval = 1;
                        JOptionPane.showMessageDialog(new JFrame(), "Size must be a number", "Data Entry Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                // Gets the price and level since all venues have both
                try {
                    txtPrice = Double.parseDouble(addVenueMenu.price.getText());
                    txtlevel = (int) addVenueMenu.level.getSelectedItem();
                } catch (NumberFormatException ex) {
                    errval = 1;
                    JOptionPane.showMessageDialog(new JFrame(), "Price must be a number", "Data Entry Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

            //Accept data if no errors were thrown
            if(errval==1){
                System.out.println("Errors detected aborting operation");
            } else {
                System.out.println("Type : "+getTypeVen()+"Name : "+txtname+"\nSize : "+txtsize+"\nStage Size : "+txtStageSize+"\nFood Size : "+txtFoodSize
                +"\nBar Size : "+txtBarSize+"\nCompetitor Size : "+txtCompSize+"\nSpectator Size : "+txtSpecSize+"\nInstructor Size : "+txtInstSize
                +"\nOther size : "+txtOtherSize+"\nPrice : "+txtPrice+"\nSecurity : "+txtNumSecurity+"\nAlert Level : "+txtlevel);
            }
        }

    }

    /**
     * Close Button Listener
     **/
    private class CloseButtonListener implements ActionListener {
        AddVenueMenu addVenueMenu;

        /**
         * Constructor for the close button listener
         * 
         * @param addVenueMenu takes in current menu
         */
        public CloseButtonListener(AddVenueMenu currMenu) {
            this.addVenueMenu = currMenu;
        }

        /**
         * Method to set visibility as false
         */
        public void actionPerformed(ActionEvent e) {
            addVenueMenu.setVisible(false);
        }
    }

}
