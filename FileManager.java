import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * File Manager 
 **/
public class FileManager {

    private static File pfile = new File("promoters.txt");
    private static File vfile = new File("venues.txt");
    private static File nextIDFile = new File("nextID.txt");
	private static File lastIDFile = new File("lastID.txt");

    public FileManager() {}

    /**
     * Method to initalize files and directories if they do not exist
     * 
     * @throws IOException
     */
    public static void initFiles() throws IOException {
            pfile.createNewFile();
            vfile.createNewFile();
            nextIDFile.createNewFile();
            lastIDFile.createNewFile();
    }

	//region Unnecessary Functions
    /*
    public static int getNextIDFromFile(){
    	Scanner scan = null;
    	try {
    		scan = new Scanner(nextIDFile);
    		return Integer.parseInt(scan.nextLine());
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	return 0;
	}

	public static void setNextIDtoFile(int ID){
		try {
			PrintWriter idWriter = new PrintWriter(new FileWriter(nextIDFile));
			idWriter.write(String.valueOf(ID));
			idWriter.close();
		} catch (IOException e) {
			System.out.println("Error setting ID");
		}
	}
*/
	//endregion

	public static int getLastIDFromFile(){
		Scanner scan = null;
		String[] id;
		try {

			scan = new Scanner(lastIDFile);
			id = scan.nextLine().split(" ");

			return Integer.parseInt(id[0]);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void writeLastIDtoFile(int ID){
		try {
			PrintWriter idWriter = new PrintWriter(new FileWriter(lastIDFile));
			idWriter.write(String.valueOf(ID));
			idWriter.close();
		} catch (IOException e) {
			System.out.println("Error setting ID");
		}
	}

    /**
     * Method to write an array of promoters to a file
     * @param proms arraylist of promoters
     */
    public void writeToPromoter(ArrayList<Promoter> proms) {


        try {
        	int lastid = Promoter.getNextId(); // This is the id of the next promoter to be created
												// when a new promoter is created the id is assigned and the
												// next id is incremented by one for the id of the next promoter
												// to be created

			//System.out.println("Last ID written to file  " + lastid); //-----------------------------------------------------------------------------Test

			writeLastIDtoFile(lastid); // Writing lastid to file

            PrintWriter promWriter = new PrintWriter(new FileWriter(pfile));
            for (Promoter prom : proms) {
                promWriter.write(prom.toString()+"\n");
            }
            promWriter.close(); 
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    /**
     * Method to write an array of venues to a file
     * @param vens arraylist of promoters
     */
    public void writeToVenue(ArrayList<Venue> vens) {

        try {
            PrintWriter venWriter = new PrintWriter(new FileWriter(vfile));
            for (Venue ven : vens) {
                //venWriter.write(ven.toString()+"\n");
                //If Regular Venue
                if(ven.getClass()==Venue.class){
                    venWriter.write(ven.getId()+";"+ven.getName()+";"+ven.getSize()+";"+ven.getPrice()+";"+ven.getLevel()+"\n");
                }
                //If Training Venue
                if(ven.getClass()==TrainingVenue.class){
					TrainingVenue tv = (TrainingVenue)ven;
					venWriter.write(ven.getId()+";"+ven.getName()+";"+tv.getInstructorArea()+";"
					+tv.getOtherArea()+";"+ven.getPrice()+";"+ven.getLevel()+"\n");
                }
                //If Sports Venue
                if(ven.getClass()==SportsVenue.class){
					SportsVenue sv = (SportsVenue)ven;
					venWriter.write(ven.getId()+";"+ven.getName()+";"+sv.getCompArea()+";"
					+sv.getSpecArea()+";"+sv.getNumSecurity()+";"+ven.getPrice()+";"+ven.getLevel()+"\n");
                }
                //If Party Venue
                if(ven.getClass()==PartyVenue.class){
					PartyVenue pv = (PartyVenue)ven;
					venWriter.write(ven.getId()+";"+ven.getName()+";"+pv.getCurrStage()+";"
					+pv.getFoodArea()+";"+pv.getBarArea()+";"+pv.getNumSecurity()+";"+ven.getPrice()+";"+ven.getLevel()+"\n");
                }
            }
            venWriter.close(); 
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

	/**
	 * Method to read promoters from a file, instantiate each and add each one to an array of promoters.
	 * @param mny name of ministry
	 * @param vens array of venues
	 * @return an array list of promoters
	 */
	public ArrayList<Promoter> loadPromoters(Ministry mny, ArrayList<Venue> vens )
	{
		Scanner pscan = null;
		Scanner nextIdscan = null;
		ArrayList<Promoter> plist = new ArrayList<Promoter>();
		try
		{

			if(pfile.length() != 0) // Checking if promoterfile is not empty
			{
				pscan  = new Scanner(pfile);

				int defId = getLastIDFromFile();

				//System.out.println("last id from file "+ defId); //--------------------------Test
				Promoter.setNextid(defId);

				while(pscan.hasNext())
				{
					String [] nextLine = pscan.nextLine().split(";");

					int  id = Integer.parseInt(nextLine[0]);
					String name = nextLine[1];
					double budget = Double.parseDouble(nextLine[2]);
					Promoter p = new Promoter(name, budget,mny, vens,id);
					plist.add(p);
				}
				pscan.close();
			}

		}
		catch(IOException e)
		{System.out.println("IO Exception");}
		catch(NumberFormatException nfe)
		{System.out.println("Number Format Exception");}

		return plist;

	}

	/**
	 * Function to load venues from a file
	 * @return an array list of venues
	 */
	public ArrayList<Venue> loadVenues()
	{

		Scanner vscan = null;
		ArrayList<Venue> vlist = new ArrayList<Venue>();
		try
		{
			vscan  = new Scanner(vfile);

			while(vscan.hasNext())
			{
				String [] nextLine = vscan.nextLine().split(";");
				switch(nextLine.length)
				{
				case 5: //This is a regular venue
				{
					Venue v = new Venue(nextLine[1], Double.parseDouble(nextLine[2]),Double.parseDouble(nextLine[3]),Integer.parseInt(nextLine[4]));
					vlist.add(v);
					break;
				}
				case 6: //This is a training venue
				{
					Venue v = new TrainingVenue(nextLine[1], Double.parseDouble(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Integer.parseInt(nextLine[5]));
					vlist.add(v);
					break;
				}
				case 7: //This is a sport venue
				{
					Venue v = new SportsVenue(nextLine[1], Double.parseDouble(nextLine[2]), Double.parseDouble(nextLine[3]),Integer.parseInt(nextLine[4]),Double.parseDouble(nextLine[5]),Integer.parseInt(nextLine[6]));
					vlist.add(v);
					break;
				}
				case 8: //This is a party venue
				{
					Venue v = new PartyVenue(nextLine[1], Double.parseDouble(nextLine[2]), Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Integer.parseInt(nextLine[5]),Double.parseDouble(nextLine[6]),Integer.parseInt(nextLine[7]));
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
}
