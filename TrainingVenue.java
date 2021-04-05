

import java.util.Scanner;

public class TrainingVenue extends Venue {
	private double instructorArea;
	private double otherArea;
   	


public TrainingVenue(String name, double instructorArea, double otherArea,
		double basePrice,int lev)
{
super(name, instructorArea +otherArea, basePrice,  lev);
this.instructorArea = 	instructorArea;
this.otherArea = otherArea;

}
public double getEstimate(String type)
{
		double price = basePrice;
		if (type.equals("PARTY"))
			price += partyPrep;
        if (type.equals("SPORT"))
				price += sportsPrep;

		//System.out.println(this.getName()+":estimate  to hold a "+type +" is "+ price);
		return price;

	}



public double getInstructorArea()
{
	return instructorArea;
}

public double getOtherArea()
{
	return otherArea;
			
}



public void setInstructorArea(double instructorArea)
{
	
	this.instructorArea =instructorArea;
}

public void setOtherArea(double otherArea)
{
	
	this.otherArea =otherArea;
}

public String toString()
{
	return "ID:"+this.getId()+";"+this.getName() +";#Events:"+this.getApprovedEvents().size()+";Inst.Area"+instructorArea+";Oth.Area"+otherArea;
	
}
public String toFile()
{
	return ""+this.getId()+";"+this.getName() +";"+this.getApprovedEvents().size()+";"+instructorArea+";"+otherArea;
	
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
	double currInstructorArea = getInstructorArea();
	double currOtherArea = getOtherArea();
	double currBasePri = getPrice();
	int currLevel = getLevel();
	// End

	//------------------------------------Updating Venue Name----------------------------------------------------------
	System.out.println("Hit enter to keep name as ["+currname+"], or enter new name:");
	String newName = newValueInput.nextLine(); // Used to set the new or current size
	if (newName.equals(""))
		newName = currname;
	//---------------------------------End Updating Venue Name---------------------------------------------------------


	//------------------------------------Updating Venue Instructor Area  Size----------------------------------------------------------
	System.out.println("Hit enter to keep Venue Instructor Area Size at ["+currInstructorArea+"] or enter new Size:");
	String instructorAreaEntry=newValueInput.nextLine();
	double newInstructorArea; // Used to set the new or current size
	if (instructorAreaEntry.equals(""))
		newInstructorArea = currInstructorArea;
	else
		newInstructorArea = Double.parseDouble(instructorAreaEntry);
	//---------------------------------End Updating Instructor Area Size---------------------------------------------------------

	//------------------------------------Updating Venue Other Area  Size----------------------------------------------------------
	System.out.println("Hit enter to keep Venue Other Area Size at ["+currOtherArea+"] or enter new Size:");
	String OtherAreaEntry=newValueInput.nextLine();
	double newOtherArea; // Used to set the new or current size
	if (instructorAreaEntry.equals(""))
		newOtherArea = currOtherArea;
	else
		newOtherArea = Double.parseDouble(OtherAreaEntry);
	//---------------------------------End Updating Other Area Size---------------------------------------------------------


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
	setInstructorArea(newInstructorArea);
	setOtherArea(newOtherArea);
	super.setPrice(newBasePrice);
	super.setLevel(newLevel);
}

}

