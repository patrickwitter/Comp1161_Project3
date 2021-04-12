

import java.util.Scanner;
/**
 * Sports Venue
 **/
public class SportsVenue extends  Venue {
   private double competitorArea;
   private double spectatorArea;
   private int numSecurity;
   
	/**
	 *Sports Venue Constructor
	 *@param name  name associated with the venue
	 *@param competitorArea area for competitors
	 *@param spectatorArea area for spectators
	 *@param numSecurity number of security present
	 *@param basePrice price associated with the venue
	 *@param lev local alert level 
	 **/
   	public SportsVenue(String name, double competitorArea, double spectatorArea,
		              int numSecurity, double basePrice, int lev)
	{
	super(name, competitorArea +spectatorArea, basePrice,  lev);
	this.competitorArea = 	competitorArea;
	this.spectatorArea = spectatorArea;
	this.numSecurity=numSecurity;

	}
	/**
	 * Method to get size of the venue.
	 * Adds the competitorArea to the spectatorArea
	 * @return resulting double of competitor and spectator areas added
	 */
   public double getSize()
   {
	   return competitorArea+ spectatorArea;
   }
   /**
	* Method to determine the number of security assigned.
	* @return the number of security as an integer
    */
   public int countSecurity()
   {
	   return numSecurity;
   }
   
   
   /**
	* Method to get the competitor area.
	* @return the competitor area as a double
    */
	public double getCompArea()
	{
		return competitorArea;
	}
   /**
	* Method to get the spectator area.
	* @return the spectator area as a double
    */
	public double getSpecArea()
	{
		return spectatorArea;
				
	}
	

   /**
	* Method to get the number of security.
	* @return the security as an integer
    */
	public int getNumSecurity()
	{
		return numSecurity;
	}
	
   /**
	* Method to set the competitor area
	*@param competitorArea takes a competitor area
    */
	public void setCompArea(double competitorArea)
	{
		
		this.competitorArea =competitorArea;
	}
   /**
	* Method to set the spectator area
	*@param spectatorArea takes a spectator area
    */
	public void setSpecArea(double spectatorArea)
	{
		
		this.spectatorArea =spectatorArea;
	}
	

   /**
	* Method to set the number of security
	*@param numSecurity takes the number of security
    */
	public void setNumSecurity(int numSecurity)
	{
		
		this.numSecurity =numSecurity;
	}

   /**
	* Method to get the estimated price based on the type of event
	* @param type type of event
	* @return estimated price as double 
    */
	public double getEstimate(String type)
	{
		double price = basePrice;
		if (type.equals("PARTY"))
			price += partyPrep;
		if (type.equals("TRAINING"))
			price += trainPrep;
	
		
		//System.out.println(this.getName()+":estimate  to hold a "+type +" is "+ price);
		return price;

	}
   /**
	* toString method
	* @return string representation of the sport venue
    */
	   public String toString()
	   {
	   	return "ID:"+this.getId()+";"+this.getName() +";#Events:"+this.getApprovedEvents().size()+";Compet Area:"+competitorArea+";Spec Area:"+spectatorArea+";#Sec:"+numSecurity;
	   	
	   }
   /**
	* toFile method 
	* @return string representation of sport venue to be accepted by a file
    */
	   public String toFile()
	   {
		   	return ""+this.getId()+";"+this.getName() +";"+this.getApprovedEvents().size()+";"+competitorArea+";"+spectatorArea+";"+numSecurity;
		   	
	   }


	public void updateLocalData(Scanner newValueInput)
	{
		/**
		 *  Function accepts input scanner from the keyboard.
		 *  Function accepts new value for venue properties from the users
		 *  and then updates old properties with new ones
		 */

		// newValueInput gets the new value for the properties of the venue previously entered
		// If input is empty string then old value remains

		newValueInput.nextLine();

		// Initializing Current Information from Venue
		String currname = super.getName();
		double currCompArea = getCompArea();
		double currSpecArea = getSpecArea();
		double currBasePri = super.getPrice();
		int currNumSecur = getNumSecurity();
		int currLevel = super.getLevel();
		// End

		//------------------------------------Updating Venue Name----------------------------------------------------------
		System.out.println("Hit enter to keep name as ["+currname+"], or enter new name:");
		String newName = newValueInput.nextLine(); // Used to set the new or current size
		if (newName.equals(""))
			newName = currname;
		//---------------------------------End Updating Venue Name---------------------------------------------------------


		//------------------------------------Updating Venue Competitor Area  Size----------------------------------------------------------
		System.out.println("Hit enter to keep Venue Competitor Area Size at ["+currCompArea+"] or enter new Size:");
		String compAreaEntry=newValueInput.nextLine();
		double newCompArea; // Used to set the new or current size
		if (compAreaEntry.equals(""))
			newCompArea = currCompArea;
		else
			newCompArea = Double.parseDouble(compAreaEntry);
		//---------------------------------End Updating Competitor Area Size---------------------------------------------------------

		//------------------------------------Updating Venue Spectator Area  Size----------------------------------------------------------
		System.out.println("Hit enter to keep Venue Spectator Area Size at ["+currSpecArea+"] or enter new Size:");
		String SpecAreaEntry=newValueInput.nextLine();
		double newSpecArea; // Used to set the new or current size
		if (SpecAreaEntry.equals(""))
			newSpecArea = currSpecArea;
		else
			newSpecArea = Double.parseDouble(SpecAreaEntry);
		//---------------------------------End Updating Spectator Area Size---------------------------------------------------------

		//------------------------------------Updating NumSecurity Size----------------------------------------------------------
		System.out.println("Hit enter to keep Venue NumSecurity Size at ["+currNumSecur+"] or enter new Size:");
		String numSecurEntry=newValueInput.nextLine();
		int newNumSecur; // Used to set the new or current size
		if (numSecurEntry.equals(""))
			newNumSecur = currNumSecur;
		else
			newNumSecur = Integer.parseInt(numSecurEntry);
		//---------------------------------End Updating NumSecurity Size---------------------------------------------------------

		//------------------------------------Updating Venue BasePrice------------------------------------------------------

		System.out.println("Hit enter to keep Venue BasePrice at ["+currBasePri +"] or enter new BasePrice:");
		String basePriEntry = newValueInput.nextLine();
		double newBasePrice;

		if (basePriEntry.equals(""))
			newBasePrice = currBasePri;
		else
			newBasePrice = Double.parseDouble(basePriEntry);
		//---------------------------------End Updating Venue BasePrice-----------------------------------------------------


		//------------------------------------Updating Venue Level---------------------------------------------------------
		System.out.println("Hit enter to keep Venue Level at ["+currLevel +"] or enter new Level:");
		String levelEntry = newValueInput.nextLine();
		int newLevel;

		if (levelEntry.equals(""))
			newLevel = currLevel;
		else
			newLevel = Integer.parseInt(levelEntry);
		//---------------------------------End Updating Venue BasePrice-----------------------------------------------------

		super.setName(newName);
		setSpecArea(newSpecArea);
		setCompArea(newCompArea);
		setNumSecurity(newNumSecur);
		super.setPrice(newBasePrice);
		super.setLevel(newLevel);
	}


}
