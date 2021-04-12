

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *Work Area 
 **/
public class WorkArea {

	public WorkArea() {}

	ArrayList<Promoter> promoters = new ArrayList<Promoter>();
	ArrayList<Venue> venues = new ArrayList<Venue>();
	Ministry mny = new Ministry("HEALTH",2 );
	ReportScreen r= new ReportScreen();

	/**
	 *Method to clear data from the arrays of promoters and venues currently stored.
	 *Will also reset the ID of promoters and venues
	*/
    public void clearData()
    {
        promoters.clear();
        venues.clear();
        Promoter.resetId();
        Venue.resetId();
    }

	/**
	 * Method to read promoters from a file, instantiate each and add each one to an array of promoters.
	 * @param pfile name of the file containing promoters
	 * @param mny name of ministry
	 * @param vens array of venues
	 * @return an array list of promoters
	 */
	public ArrayList<Promoter> loadPromoters(String pfile, Ministry mny, ArrayList<Venue> vens )
	{
		Scanner pscan = null;
		ArrayList<Promoter> plist = new ArrayList<Promoter>();
		try
		{
			pscan  = new Scanner(new File(pfile));
			while(pscan.hasNext())
			{
				String [] nextLine = pscan.nextLine().split(" ");
				String name = nextLine[0];
				double budget = Integer.parseInt(nextLine[1]);
				Promoter p = new Promoter(name, budget,mny, vens);
				plist.add(p);
			}

			pscan.close();
		}
		catch(IOException e)
		{}
		catch(NumberFormatException nfe)
		{}

		return plist;

	}
	/**
	 * Function to read events from a file and add them to the relevant promoters
	 * @param plist array of promoters
	 * @param efile name of file containing events
	 * @return an array list of promoters
	 */
	public ArrayList<Promoter> loadEventsToPromoters(ArrayList<Promoter> plist, String efile)
	{
		Scanner escan = null;
		try
		{
			escan  = new Scanner(new File(efile));
			while(escan.hasNext())
			{
				String [] nextLine = escan.nextLine().split(" ");
				String name = nextLine[0];
				int numPatrons = Integer.parseInt(nextLine[1]);
				String etype = nextLine[2];
				Date day = new Date(Integer.parseInt(nextLine[3]));
				int pdx= findPromoterByName(plist, name);
				if (pdx>=0)
					plist.get(pdx).addPlan(new Plan(numPatrons, etype,day));
			}

			escan.close();
		}
		catch(IOException e)
		{}
		catch(NumberFormatException nfe)
		{}

		return plist;

	}


	/**
	 * Function to load venues from a file
	 * @param vfile name of the file containing venues
	 * @return an array list of venues
	 */
	public ArrayList<Venue> loadVenues(String vfile )
	{
		Scanner vscan = null;
		ArrayList<Venue> vlist = new ArrayList<Venue>();
		try
		{
			vscan  = new Scanner(new File(vfile));

			while(vscan.hasNext())
			{
				String [] nextLine = vscan.nextLine().split(" ");
				switch(nextLine.length)
				{
				case 4: //This is a regular venue
				{
					Venue v = new Venue(nextLine[0], Double.parseDouble(nextLine[1]),Double.parseDouble(nextLine[2]),Integer.parseInt(nextLine[3]));
					vlist.add(v);
					break;
				}
				case 5: //This is a training venue
				{
					Venue v = new TrainingVenue(nextLine[0], Double.parseDouble(nextLine[1]),Double.parseDouble(nextLine[2]),Double.parseDouble(nextLine[3]),Integer.parseInt(nextLine[4]));
					vlist.add(v);
					break;
				}
				case 6: //This is a sport venue
				{
					Venue v = new SportsVenue(nextLine[0], Double.parseDouble(nextLine[1]), Double.parseDouble(nextLine[2]),Integer.parseInt(nextLine[3]),Double.parseDouble(nextLine[4]),Integer.parseInt(nextLine[5]));
					vlist.add(v);
					break;
				}
				case 7: //This is a party venue
				{
					Venue v = new PartyVenue(nextLine[0], Double.parseDouble(nextLine[1]), Double.parseDouble(nextLine[2]),Double.parseDouble(nextLine[3]),Integer.parseInt(nextLine[4]),Double.parseDouble(nextLine[5]),Integer.parseInt(nextLine[6]));
					vlist.add(v);
					break;
				}

				}
			}
			vscan.close();
		}


		catch(IOException e)
		{
			//System.out.println("Something went wrong in WorkingArea -> loadVenues");
			//e.printStackTrace();
		}

		return vlist;

	}
	/**
	 * Method to load test case data based on user input
	 * @param caseNo number of test case 
	 * @param scan input scanner
	 */
	public void loadTestCase(int caseNo, Scanner scan )
	{
		loadData(caseNo);
		System.out.print("Test case " + caseNo+ " loaded: Show data?[y/n]");
		String response  = scan.next();
        if (response.toUpperCase().charAt(0)=='Y')
        {
    		ReportScreen r= new ReportScreen();
            r.listVenues(venues, System.out);
            r.listPromoters(promoters, System.out);
        	
        }
  
	}
	
	
	/**
	 * Method to load test case data
	 * @param caseNo number of test case
	 */
	public void loadData(int caseNo)
	{
		clearData();
		venues = loadVenues(getVenueFile(caseNo));
    	promoters  =  loadPromoters(getProFile(caseNo),  mny,  venues );
		promoters  =  loadEventsToPromoters(promoters, getEventFile(caseNo) );

		}
	

	/**
	 * Method to get promoter file based on test case number
	 * @param caseNo number of test case
	 * @return String representing the path to relevant promoter file
	 */
	private String getProFile(int caseNo)
	{
		return "cases/Promoter."+caseNo+".txt";
	}

	/**
	 * Method to get venue file based on test case number
	 * @param caseNo number of test case
	 * @return String representing the path to relevant venue file
	 */
	private String getVenueFile(int caseNo)
	{
		return "cases/Venue."+caseNo+".txt";
	}
	/**
	 * Method to get event file based on test case number
	 * @param caseNo number of test case
	 * @return String representing the path to relevant event file
	 */
	private String getEventFile(int caseNo)
	{
		return "cases/Event."+caseNo+".txt";
	}
	/**
	 * Method to locate a promoter from an array via the name.
	 * Searches through an array of promoters to determine the index position
	 * @param proms array of promoters
	 * @param name name of promoter
	 * @return index position of promoter
	 */
	public int findPromoterByName(ArrayList<Promoter> proms, String name)
	{
		int pdx =-1;
		int currdx=0;
		while ((currdx<proms.size())&&(pdx==-1))
		{
			if (proms.get(currdx).getName().equals(name))
				pdx = currdx;
			currdx++;
		

		}

		return pdx;

	}
}
