import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private static File pfile = new File("promoters.txt");
    private static File vfile = new File("venues.txt");

    public FileManager() {
    }

    /**
     * Method to initalize files and directories if they do not exist
     * 
     * @throws IOException
     */
    public static void initFiles() throws IOException {
        if (pfile.exists() && vfile.exists()) {
            System.out.println("Files already exist");
        } else {
            System.out.println("Files do not exist");
            pfile.createNewFile();
            vfile.createNewFile();
        }
    }

    /**
     * Method to write an array of promoters to a file
     * @param proms arraylist of promoters
     */
    public void writeToPromoter(ArrayList<Promoter> proms) {
        System.out.println("Writing to promoter file");
        try {
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
     * @param proms arraylist of promoters
     */
    public void writeToVenue(ArrayList<Venue> vens) {
        System.out.println("Writing to venue file");
        try {
            PrintWriter venWriter = new PrintWriter(new FileWriter(vfile));
            for (Venue ven : vens) {
                venWriter.write(ven.toString()+"\n");
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
        System.out.println("Loading Promoters");
		Scanner pscan = null;
		ArrayList<Promoter> plist = new ArrayList<Promoter>();
		try
		{
			pscan  = new Scanner(pfile);
			while(pscan.hasNext())
			{
				String [] nextLine = pscan.nextLine().split(";");
				System.out.println(nextLine[1]+" "+nextLine[2]);
                String name = nextLine[1];
				double budget = Double.parseDouble(nextLine[2]);
				Promoter p = new Promoter(name, budget,mny, vens);
				plist.add(p);
			}

			pscan.close();
		}
		catch(IOException e)
		{System.out.println("IO Exception");}
		catch(NumberFormatException nfe)
		{System.out.println("Number Format Exception");}

		return plist;

	}
}
