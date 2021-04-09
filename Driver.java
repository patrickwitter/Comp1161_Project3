
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
//import project.Tester;
public class Driver {

	/**
	 * Driver
	 */

	 // this serves no purpose just to make the functions work for now
	/**
	 *
	 * @author Patrick Witter,Kieran Jaggernauth, Peter-John Thompson
	 */
	public static void main(String[] args)
	{

		//region Original Command Line Commands
		/**
		 * The main function displays the main menu for the program.
		 * This menu displays the primary functions of the program.
		 * The program accepts user input
		 */
		/*
		//Tester.main(args);;
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//Venue[] venues = new ArrayList<Venue>();
		//populateVenues(mny);
		int selCase =-1;
		EntryScreen entryScreen= new EntryScreen();
		ReportScreen r= new ReportScreen();
		WorkArea work = new WorkArea();
		SystemInfo sys = new SystemInfo();


		char mchoice = 'c';
		boolean listdata = true;
		String menu="";
		String stuId="";
		
		while (mchoice!='X')
		{
			  try
              {
                  Scanner sc = new Scanner(new File("id.txt"));
                  stuId = sc.nextLine();
                  sc.close();
              }
              catch (IOException ioe){}

			String menuOptions = "-----User Data";
			if (selCase==-1)
				 menuOptions = "---"+menuOptions +"--------\n";

			else
				menuOptions+=" Case "+ selCase+"-----------\n";
			
			menuOptions+="[P]romoter data\n[V]enue management\n[M]inistry interface\n";
			menuOptions+="[L]oad test case\n[S]ave test case\n[T]est all cases\n";
			menuOptions+="-------System settings--------\n[I]D:";
			
            if (stuId.length()==0)
            	menuOptions+="Not yet set.\n";
            else
            	menuOptions+=stuId+"\n";

			menuOptions+="User directory:"+System.getProperty("user.dir")+"\n";
			menuOptions+="Test case folder:"+sys.getTestCaseFolder()+"\n";
			menuOptions+="Code folder:"+sys.getCodeFolder()+"\n";
			menuOptions+="Javadoc folder:"+sys.getJavaDocFolder()+"\n";
			menuOptions+="Update s[y]stem settings\n";
			menuOptions+="[A]utodetect system settings\n";
			menuOptions+="E[x]it";
			
			System.out.println(menuOptions);
			if (!(System.getProperty("user.dir")+"\\cases").equals(sys.getTestCaseFolder()))
			{
				System.out.println("WARNING:::POSSIBLE TEST CASE LOCATION MISMATCH:" );
				System.out.println("Please move the cases folder from ");
				System.out.println(sys.getTestCaseFolder()   + " to ");
				System.out.println(System.getProperty("user.dir")+ " then hit A+<Enter> to detect locations");
			}			
			
			menu = scan.next().toUpperCase();
			mchoice = menu.charAt(0);
			switch(mchoice)
			{
			case 'P':{
				work.promoters = entryScreen.managePromoters(scan,  work.promoters,  work.mny, work.venues);
				break;
			}
			case 'V':{
				work.venues = entryScreen.manageVenues(scan, work.venues);
				break;
			}
			case 'M':{
				work.mny.showPublicInfo(scan,work);
				break;

			}
			case 'L':{
				System.out.println("Please enter the number of the test case to be loaded[0..11]:");
				int caseNo = Integer.parseInt(scan.next());
				work.loadTestCase(caseNo,scan);
				break;

			}
			case 'T':{
				try {
					Tester.runCases(work,sys);
				}
				catch(Exception exception){}
				// s = entryScreen.editSystemInfo(s);
				break;

			}
			case 'S':{
				Tester.saveTest(scan, work);
				
				
				// s = entryScreen.editSystemInfo(s);
				break;

			}
			case 'Y':{
				 sys.readFromScreen(scan);
				break;

			}
            case 'I':
            {
                System.out.println("Please enter your student ID number:");
                String stuid = scan.next();
                
                try{    
                    PrintStream p=new PrintStream(new FileOutputStream("id.txt"));
                    p.println(stuid);
                    p.close();
                }
                catch(IOException ioe){}
                break;
            } 
            case 'A':
            {
                File f = new File("Sysinfo.txt");
                f.delete();
                sys = new SystemInfo();           }

			}


		}

		 */
//endregion

		MainMenu_DriverMenu mainMenu_driverMenu = new MainMenu_DriverMenu();
	}


//region Rest
		// When the user selects an option from the main menu.It will call this method to process the information.
		// Based on which button is pressed the menu action listener will call this function with the appropriate
		// string.
	/*
		public static void  ProcessMain(char userchoice)
		{

			char mchoice = 'c';
			//region Commented Code
			//boolean listdata = true;
			//String menu="";
			//String stuId="";
			//endregion

			//After the user
			mchoice = userchoice;

			while (mchoice!='X')
			{
				//region Commandline Commands not necessary for GUI interface
				/*
				try
				{
					Scanner sc = new Scanner(new File("id.txt"));
					stuId = sc.nextLine();
					sc.close();
				}
				catch (IOException ioe){}

				String menuOptions = "-----User Data";
				if (selCase==-1)
					menuOptions = "---"+menuOptions +"--------\n";

				else
					menuOptions+=" Case "+ selCase+"-----------\n";

				menuOptions+="[P]romoter data\n[V]enue management\n[M]inistry interface\n";
				menuOptions+="[L]oad test case\n[S]ave test case\n[T]est all cases\n";
				menuOptions+="-------System settings--------\n[I]D:";

				if (stuId.length()==0)
					menuOptions+="Not yet set.\n";
				else
					menuOptions+=stuId+"\n";

				menuOptions+="User directory:"+System.getProperty("user.dir")+"\n";
				menuOptions+="Test case folder:"+sys.getTestCaseFolder()+"\n";
				menuOptions+="Code folder:"+sys.getCodeFolder()+"\n";
				menuOptions+="Javadoc folder:"+sys.getJavaDocFolder()+"\n";
				menuOptions+="Update s[y]stem settings\n";
				menuOptions+="[A]utodetect system settings\n";
				menuOptions+="E[x]it";

				System.out.println(menuOptions);
				if (!(System.getProperty("user.dir")+"\\cases").equals(sys.getTestCaseFolder()))
				{
					System.out.println("WARNING:::POSSIBLE TEST CASE LOCATION MISMATCH:" );
					System.out.println("Please move the cases folder from ");
					System.out.println(sys.getTestCaseFolder()   + " to ");
					System.out.println(System.getProperty("user.dir")+ " then hit A+<Enter> to detect locations");
				}

				menu = scan.next().toUpperCase();
				mchoice = menu.charAt(0);
				*/

				//endregion

/*
				switch(mchoice)
				{
					case 'P':{ // Promoter Menu
						work.promoters = entryScreen.managePromoters(scan,  work.promoters,  work.mny, work.venues);
						break;
					}
					case 'V':{ // Venue Menu
						work.venues = entryScreen.manageVenues(scan, work.venues);
						break;
					}
					case 'M':{ // Menu Implementation Interface
						work.mny.showPublicInfo(scan,work);
						break;

					}
					case 'L':{ // load test case
						System.out.println("Please enter the number of the test case to be loaded[0..11]:");
						int caseNo = Integer.parseInt(scan.next());
						work.loadTestCase(caseNo,scan);
						break;

					}
					case 'T':{ // run test cases
						try {
							Tester.runCases(work,sys);
						}
						catch(Exception exception){}
						// s = entryScreen.editSystemInfo(s);
						break;

					}
					case 'S':{ // Save test cases
						Tester.saveTest(scan, work);


						// s = entryScreen.editSystemInfo(s);
						break;

					}
					case 'Y':{
						sys.readFromScreen(scan);
						break;

					}
					case 'I': // Enter ID
					{
						System.out.println("Please enter your student ID number:");
						String stuid = scan.next();

						try{
							PrintStream p=new PrintStream(new FileOutputStream("id.txt"));
							p.println(stuid);
							p.close();
						}
						catch(IOException ioe){}
						break;
					}
					case 'A': // Edit system information
					{
						File f = new File("Sysinfo.txt");
						f.delete();
						sys = new SystemInfo();           }

				} // End of Switch Statement
			} // End of While Lopp
			System.exit(0);
		}// End of Function
*/

}


	

