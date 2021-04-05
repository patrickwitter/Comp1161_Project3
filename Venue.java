

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *Venue
 **/
public class Venue implements Comparable<Venue> {
	private String name;
	private double size;
	protected double basePrice;
	private ArrayList<Event> approvedEvents=new ArrayList<Event>();
	private int level; // 1,2,3 for low,medium, high repectively;
	private int id;
	private static int nextId=0;
	protected double partyPrep=2000,  trainPrep=500, sportsPrep = 1000;
	
	
	public Venue() 
	{}
	/**
	 *Venue constructor
	 **/
	public Venue( String name, double size, double basePrice, int lev)
	{
        this.name = name;
		this.size = size;
		this.basePrice=basePrice;
		this.level = lev;
	
		id =nextId;
		nextId++;
		

	}
	
	public static void resetId()
	{
		
		nextId=0;
	}
	
	//////
	
	public int compareTo(Venue other)
	{
		return this.getName().compareTo(other.getName());
	}
	
	public double getSize()
	{
		return size;
	
	}
	
	public String getName()
	{
		return name;
	}
	public double getPrice()
	{
		return basePrice;
	
	}
	
	public int getLevel()
	{
		return level;
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
		String currname = getName();
		double currSize = getSize();
		double currBasePri = getPrice();
		int currLevel = getLevel();
		// End

	//------------------------------------Updating Venue Name----------------------------------------------------------
		System.out.println("Hit enter to keep name as ["+currname+"], or enter new name:");
		String newName = newValueInput.nextLine(); // Used to set the new or current size
		if (newName.equals(""))
			newName = currname;
	//---------------------------------End Updating Venue Name---------------------------------------------------------


	//------------------------------------Updating Venue Size----------------------------------------------------------
		System.out.println("Hit enter to keep Venue Size at ["+currSize +"] or enter new Size:");
		String sizeEntry=newValueInput.nextLine();
		double newSize; // Used to set the new or current size
		if (sizeEntry.equals(""))
			newSize = currSize;
		else
			newSize = Double.parseDouble(sizeEntry);
	//---------------------------------End Updating Venue Size---------------------------------------------------------


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

		setName(newName);
		setSize(newSize);
		setPrice(newBasePrice);
		setLevel(newLevel);
	}
	
	public void setName(String name)
	{
		
		this.name =name;
	}
	
	public void setPrice(double basePrice)
	{
		
		this.basePrice =basePrice;
	}
	
	public void setSize(double size)
	{
		
		this.size =size;
	}	
	
	public void setLevel(int level)
	{
		
		this.level =level;
	}
	
	
	public double getEstimate(String type)
	{
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

public int getId()
{
	return id;
}


	public int reserve( Event event,double availBal, Ministry min)
	
	{   
		System.out.println("Submitted "+event +" for approval at " + this);
		ApprovalRequest ar = new ApprovalRequest(event, this);
	int approval = min.checkApproval(ar);
	if (approval>=0)
	{
		if (availBal >= getEstimate(event.getType()))
		{
            approvedEvents.add(event);
			event.setVenue(this);
			System.out.println("Successfully Approved and registered "+event.toString());
		}
			
	}
			
	return approval;
	}
	
	public boolean available(Date date)
	{
		boolean returnVal=true;
			
		ArrayList<Integer> reservedDays = new ArrayList<Integer>();
		for(Event e:approvedEvents)
			reservedDays.add(e.getDate().getDay());
		int dx =0;
		while ((dx<reservedDays.size())&&(returnVal))
		{
			if (date.getDay()==approvedEvents.get(dx).getDate().getDay())
				returnVal=false;
			dx++;
		}
		//System.out.println("checking  "+getName()+" availability for "+ date.getDay()+":"+ returnVal);
		
		
		return returnVal;
	}
	
	public  boolean canHold(int nump)
	{
		boolean returnVal = false;
		
	    int separation=0;
	  		switch(level)
	   		{
	   		case 1:{
	   			separation= Ministry.LOWRISK_SEPARATION;
	   			break;
	   		}
	   		case 2:{
	   			separation= Ministry.MEDIUMRISK_SEPARATION;
	   			break;
	   		}
	   		case 3:{
	   			separation= Ministry.HIGHRISK_SEPARATION;
	   			break;
	   		}
	   		}
	  	//System.out.println(this.getName()+":"+this.getSize()+"/"+separation);
        if (nump <(int)(getSize()/separation))
           returnVal = true;
        
        else
        	 returnVal= false;
		//System.out.println("checking  "+getName()+" space for "+ nump +" persons "+":"+ returnVal);

		return returnVal;
	}


	public void promoteEvents(PrintStream outStream)
	{
		outStream.println("EVENTS AT "+getName());
		outStream.println("===================");
	    for(Event e:approvedEvents)
		   outStream.println(e);
	    outStream.println("--------------------");
		   
	}
	
	public ArrayList<Event> getApprovedEvents()
	{
		
		return approvedEvents;
	}
	

	public String toString()
	{
		return "ID:"+this.getId()+";"+this.name +";#Events:"+this.approvedEvents.size()+";Area:"+this.getSize();
		
	}
	
	public String toFile()
	{
		return ""+this.getId()+";"+this.name +";"+this.approvedEvents.size()+";"+this.getSize();
		
	}

}
