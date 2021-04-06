

import java.util.Scanner;

/**
* Party Venue
**/

public class PartyVenue extends Venue{
	double stageArea;
	double barArea, foodArea;
	int numSecurity;
	
	/**
	 * Party Venue constructor.
	 * @param name  The name of the Party Venue.
	 * @param stageArea  Size of the Stage area on the Party Venue.
	 * @param barArea  Size of the Bar area on the Party Venue.
	 * @param foodArea  Size of the Food area on the Party Venue.
	 * @param numSecurity  The number of security personnel on the Party Venue.
	 * @param basePrice  Venue's base price.
	 * @param lev   Alert level for this venue.
	 */
	public PartyVenue(String name, double stageArea,	double barArea, 
			           double foodArea,int numSecurity, double basePrice,
			            int lev)
	{
		super( name, stageArea+barArea+foodArea, basePrice, lev);
		this.numSecurity=numSecurity;
		this.stageArea = 	stageArea;
		this.barArea = barArea;
		this.foodArea = foodArea;
		
		
		
	}
	
	public double getEstimate(String type)
	{
		/**
		 * Function accepts Venue Type as a string
		 * and determines estimated price based on the type
		 * @returns Double that is the estimated price
		 */
		double price = basePrice;
		if (type.equals("PARTY"))
			price += partyPrep;
		if (type.equals("SPORT"))
			price += sportsPrep;
		if (type.equals("TRAINING"))
			price += trainPrep;
	
		
		//System.out.println(this.getName()+":estimate  to hold a "+type +" is "+ price);
		return price;

	}
	
	/**
	* Method to get the size of the stage area
	* @return the stage area size as a double
	*/
	
	public double getCurrStage()
	{
		return stageArea;
	}
	
	/**
	* Method to get the size of the bar area
	* @return the bar area size as a double
	*/
	public double getBarArea()
	{
		return barArea;
	}
	
	/**
	* Method to get the size of the food area
	* @return the food area size as a double
	*/
	
	public double getFoodArea()
	{
		return foodArea;
	}
	
	/**
	* Method to get the number of security needed
	* @return the number of security as an integer
	*/
	
	public int getNumSecurity()
	{
		return numSecurity;
	}
	
	/**
	* Method to set the size of the stage area
	* @param stageArea takes a stage area
	*/
	
	public void setStageArea(double stageArea)
	{
		
		this.stageArea =stageArea;
	}
	
	/**
	* Method to set the size of the food area
	* @param foodArea takes a food area
	*/
	
	public void setFoodArea(double foodArea)
	{
		
		this.foodArea =foodArea;
	}
	
	/**
	* Method to set the size of the bar area
	* @param barArea takes a bar area
	*/
	
	public void setBarArea(double barArea)
	{
		
		this.barArea =barArea;
	}	
	
	/**
	* Method to set the number of security
	* @param numSecurity takes the number of security
	*/
	
	public void setNumSecurity(int numSecurity)
	{
		
		this.numSecurity =numSecurity;
	}

	/** 
	* toString method
	* @return string representation of the party venue
	*/
	   public String toString()
	   {
	   	return "ID:"+this.getId()+";"+this.getName() +";#Events:"+this.getApprovedEvents().size()+";Stage Area:"+stageArea+";Bar Area:"+barArea+";Food Area:"+foodArea+";#Sec"+numSecurity;
	
	/** 
	* toFile method
	* @return string representation of the party venue to be accepted by a file
	*/
	   }
	   public String toFile()
	   {
		   	return ""+this.getId()+";"+this.getName() +";"+this.getApprovedEvents().size()+";"+stageArea+";"+barArea+";"+foodArea+";"+numSecurity;
		   	
	   }
	public void updateLocalData(Scanner newValueInput)
	{
		/**
		 *  Function accepts input scanner from the keyboard.
		 *  Function accepts new value for venue properties from the users
		 *  and then updates old properties with new ones
		 */
		// newValueInput gets the new value for the properties of the venue previously entered
		// by the user.

		newValueInput.nextLine();

		// Initializing Current Information from Venue
		String currname = super.getName();
		double currStageArea = getCurrStage();
		double currBarArea = getBarArea();
		double currFoodArea = getFoodArea();
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


		//------------------------------------Updating Venue Stage Area  Size----------------------------------------------------------
		System.out.println("Hit enter to keep Venue Stage Area Size at ["+currStageArea+"] or enter new Size:");
		String stageAreaEntry=newValueInput.nextLine();
		double newStageArea; // Used to set the new or current size
		if (stageAreaEntry.equals(""))
			newStageArea = currStageArea;
		else
			newStageArea = Double.parseDouble(stageAreaEntry);
		//---------------------------------End Updating Stage Area Size---------------------------------------------------------

		//------------------------------------Updating Venue Bar Area  Size----------------------------------------------------------
		System.out.println("Hit enter to keep Venue Bar Area Size at ["+currBarArea+"] or enter new Size:");
		String BarAreaEntry=newValueInput.nextLine();
		double newBarArea; // Used to set the new or current size
		if (BarAreaEntry.equals(""))
			newBarArea = currBarArea;
		else
			newBarArea = Double.parseDouble(BarAreaEntry);
		//---------------------------------End Updating Bar Area Size---------------------------------------------------------

		//------------------------------------Updating Venue Food Area  Size----------------------------------------------------------
		System.out.println("Hit enter to keep Venue Food Area Size at ["+currFoodArea+"] or enter new Size:");
		String FoodAreaEntry=newValueInput.nextLine();
		double newFoodArea; // Used to set the new or current size
		if (FoodAreaEntry.equals(""))
			newFoodArea = currFoodArea;
		else
			newFoodArea = Double.parseDouble(FoodAreaEntry);
		//---------------------------------End Updating Food Area Size---------------------------------------------------------

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
		setBarArea(newBarArea);
		setFoodArea(newFoodArea);
		setStageArea(newStageArea);
		setNumSecurity(newNumSecur);
		super.setPrice(newBasePrice);
		super.setLevel(newLevel);
	}
}
