/**
 * Entry Screen
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class EntryScreen {

	public EntryScreen() {}

	public ArrayList<Promoter> managePromoters(Scanner scan,ArrayList<Promoter> proms, Ministry min, ArrayList<Venue> vens) throws NumberFormatException
	{
		/**
		 * Method provides Promoter menu to the user.
		 * from different menu options the user will be able
		 * to add,update,list or edit the
		 * current list of promoters
		 * @param Input stream from the keyboard
		 * @param Arraylist of type Promoter
		 * @param Ministry class
		 * @param Arraylist of type Venue
		 * @return Arraylist of type Promoter
		 */
		ReportScreen r = new ReportScreen();
		char mchoice = 'c';
		String menu="";
		while (mchoice!='X')
		{
			String menuOptions = "[A]dd/Create promoter\n[E]dit/Update promoter\n";
			menuOptions+="[L]ist/Read promoters\n[D]elete promoter\nE[x]it\n";
			System.out.println(menuOptions);
			menu = scan.next().toUpperCase();
			mchoice = menu.charAt(0);
			switch(mchoice)
			{
			case 'A':{
				Promoter p = createPromoter(scan, min, vens);
				if (p!=null)
					proms.add(p);
				break;
			}
			case 'L':{
				Collections.sort(proms); 
				r.listPromoters(proms, System.out);
				break;
			}
			case 'E':{
				System.out.println("Please enter the ID of the promoter to be updated:");
				int pid = Integer.parseInt(scan.next());
				int pdx = findPromoter(proms,pid);
				if (pdx>=0)
					proms.get(pdx).updateLocalData(scan);
				else
					System.out.println("Promoter with id "+pid+ " not found.");
				break;
			}
			case 'D':{
				System.out.println("Please enter the ID of the promoter to be deleted:");
				int pid = Integer.parseInt(scan.next());
				int pdx = findPromoter(proms,pid);

				if (pdx>=0)
					proms.remove(pdx);
				else
					System.out.println("Promoter with id "+pid+ " not found.");
				break;
			}


			}

		}
		return proms;
	}



	public Promoter createPromoter( Scanner scan, Ministry min, ArrayList<Venue> vens)
	{
		/**
		 * Method provides functionality to the Add Promoter menu.
		 * This will allow a promoter to created after the
		 * information is entered by the user
		 * to create a promoter to be added to Arraylist on return
		 * @param Input stream from the keyboard
		 * @param Ministry class
		 * @param Arraylist of type Venue
		 * @return Promoter
		 */
		Promoter p = null;
		try
		{
		System.out.println("Please enter Promoter Name:");
		String name = scan.next();
		System.out.println("Please enter Promoter Budget:");
		double budget = Double.parseDouble(scan.next());
		p = new Promoter(name, budget, min, vens);
		}
		catch(NumberFormatException nfe)
		{}
		return p;
	}


	public int findPromoter(ArrayList<Promoter> proms, int pid)
	{
		/**
		 * Method provides functionality to the Edit Promoter Menu.
		 * The user is asked to enter an id of the Promter they want
		 * to edit.
		 * Method searches for Promoter with matching id fom the user
		 * and returns the id or an indication that no Promoter is found
		 * @param Arraylist of Promoters
		 * @param ID of promoter to be found enteredby the user
		 * @return ID of promoter or indication number that id was not found
		 */

		int pdx =-1;
		int currdx=0;
		while ((currdx<proms.size())&&(pdx==-1))
		{
			if (proms.get(currdx).getId()==pid)
				pdx = currdx;
			currdx++;

		}

		return pdx;

	}

	public ArrayList<Venue> manageVenues(Scanner scan, ArrayList<Venue> vens)
	{
		/**
		 * Method provides Venue menu to the user.
		 * From different menu options the user will be able
		 * to add,update,list or edit the
		 * current list of venues
		 * @param Input stream from the keyboard
		 * @param Arraylist of type Venue
		 * @return Arraylist of type Venue
		 */
		ReportScreen r = new ReportScreen();
		char mchoice = 'c';
		String menu="";
		String menuOne = "[A]dd/Create venue\n" +
						 "[E]dit/Update venue\n" +
						 "[L]ist/Read Venues\n" +
						 "[D]elete venue\n" +
						 "E[x]it";



		while (mchoice!='X')
		{
			System.out.println(menuOne);
			menu = scan.next().toUpperCase();
			mchoice = menu.charAt(0);

			switch(mchoice)
			{
				case 'A':{

					Venue v = this.createVenue(scan);
					if (v!=null)
						vens.add(v);
					break;
				}
				case 'L':{
					Collections.sort(vens);
					r.listVenues(vens, System.out);
					break;
				}
				case 'E':{
					System.out.println("Please enter the ID of the venue to be updated:");
					int vid = Integer.parseInt(scan.next());
					int vdx = findVenue(vens,vid);
					if (vdx>=0)
						vens.get(vdx).updateLocalData(scan);
					else
						System.out.println("Venue with id "+vid+ " not found.");
					break;

				}
				case 'D':{

					break;
				}


			}
		}
		//code required here to implement a venue management screen
		return vens;
	}



	public Venue createVenue( Scanner scan)
	{
		/**
		 * Method provides functionality to the Add Venue menu and
		 * asks provides a Menu that asks the user which venue to create.
		 * This will allow a venue to created after the user selects which type of menu and
		 * the necessary information is entered by the user
		 * to create a promoter to be added to Arraylist on return
		 * @param Input stream from the keyboard
		 * @return Venue
		 */
		Venue v = null;
		char mchoice = 'c';
		String menu="";

	    //code needed to obtain the information required to represent a venue and create an appropriate venue object
		String addVenueMenue = "General Purpose [V]enue\n" +
				"[P]arty venue\n" +
				"[S]ports venue\n" +
				"[T]raining Venue\n" +
				"E[x]it to previous menu\n";


		// Declaring Venue parameter variables
		String venName = "Something went Wrong";

		//Creating Sizes for different venues
		double sizeA1 , sizeA2 , sizeA3 ;
		//End

		double price;
		int numSecurity;
		int level;
		// End

		// Initializing Redundant Menu Prompts
		String priceReq = "Enter Venue Price";
		String levReq = "Enter Venue level";
		String secReq = "Enter number of Security";
		//End

		System.out.println(addVenueMenue);
		menu = scan.next().toUpperCase();
		mchoice = menu.charAt(0);

		while(mchoice != 'X')
		{

			System.out.println("Enter Venue Name");
			//scan.next(); // Consuming rest of input stream to avoid skipping of next input
			venName = scan.next();
			System.out.println("VenueName " + venName);

			switch(mchoice)
			{
				case'V': // Generic Venue

					// sizeA1 - Generic Venue Size

					System.out.println("Enter Venue Size");
					sizeA1 = Double.parseDouble(scan.next()); // Size for Generuc Venue
					System.out.println(priceReq);
					price = Double.parseDouble(scan.next());
					System.out.println(levReq);
					level = Integer.parseInt(scan.next());
					v = new Venue(venName,sizeA1,price,level);
					break;

				case 'P': // Party Venue

					//sizeA1 - StageArea
					//sizeA2 - FoodArea
					// sizeA3 - BarArea


					System.out.println("Enter Venue Stage Area size");
					sizeA1 = Double.parseDouble(scan.next());
					System.out.println("Enter Venue Food Area size");
					sizeA2 = Double.parseDouble(scan.next());
					System.out.println("Enter Venue Bar Area size");
					sizeA3 = Double.parseDouble(scan.next());
					System.out.println(secReq);
					numSecurity = Integer.parseInt(scan.next());
					System.out.println(priceReq);
					price = Double.parseDouble(scan.next());
					System.out.println(levReq);
					level = Integer.parseInt(scan.next());
					v = new PartyVenue(venName,sizeA1,sizeA3,
							sizeA2,numSecurity,price,level);
					break;

				case 'S': // Sports Venue

					// sizeA1 - Competitor Area
					// sizeA2 - Spectator Area
					System.out.println("Enter Venue Competitor Area size");
					sizeA1 = Double.parseDouble(scan.next());
					System.out.println("Enter Venue Spectator Area size");
					sizeA2 = Double.parseDouble(scan.next());
					System.out.println(secReq);
					numSecurity = Integer.parseInt(scan.next());
					System.out.println(priceReq);
					price = Double.parseDouble(scan.next());
					System.out.println(levReq);
					level = Integer.parseInt(scan.next());
					v= new SportsVenue(venName,sizeA1,sizeA2,numSecurity,price,level);
					break;

				case'T': // Training Venue

					// sizeA1 - Instructor Area
					// sizeA2 - Other Area
					System.out.println("Enter Venue Instructor Area size");
					sizeA1 = Double.parseDouble(scan.next());
					System.out.println("Enter Venue Other Area size");
					sizeA2 = Double.parseDouble(scan.next());
					System.out.println(priceReq);
					price = Double.parseDouble(scan.next());
					System.out.println(levReq);
					level = Integer.parseInt(scan.next());
					v = new TrainingVenue(venName,sizeA1,sizeA2,price,level);
					break;
				case'X':
					break;
			}

			System.out.println(addVenueMenue);
			menu = scan.next().toUpperCase();
			mchoice = menu.charAt(0);
		}
		return v;
	}



	public int findVenue(ArrayList<Venue> vens, int vid)
	{
		/**
		 * Method provides functionality to the Edit Venue Menu.
		 * The user is asked to enter an id of the Venue they want
		 * to edit.
		 * Method searches for Venue with matching id fom the user
		 * and returns the id or an indication that no Venue is found
		 * @param Arraylist of Venue
		 * @param ID of venue to be found entered by the user
		 * @return ID of venue or indication number that id was not found
		 */
		int vdx=-1;
		////code needed here to find venue with id VID in arraylist of venues
		for(Venue venue: vens)
		{
			vdx = venue.getId();
			if( vdx == vid)
			{
				return vdx;
			}
		}
		return vdx;

	}



}

