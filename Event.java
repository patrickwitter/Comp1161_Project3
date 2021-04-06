

public class Event{
	   String name;
	   Venue venue;
	   Date date;
	   String type;
	   int numPeople;
	  
	   /**
	   * Event Constructor
	   * @param name name of the event
	   * @param type type of event
	   * @param numPeople number of people to attend event
	   * @param date date of the event
	   **/
	   public Event(String name, String type, int numPeople, Date date )
	   {
		   this.name = name;
		   this.type = type;
		   this.date = date;
		   this.numPeople= numPeople;
	   }
	   
	/**
	* Method to get name of event
	@return the name as a string
	**/
	   public String getName()
	   {
		   return name;
	   }
	   
	/**
	* Method to get type of event
	@return the type as a string
	**/
	     public String getType()
	   { 
		   return type;
	   }
	   
	/**
	* Method to get number of people
	@return the number of people as an integer
	**/
	   public int getNumPeople()
	   {
		   return numPeople;
	   }

	 /**
	* Method to get date of event
	@return the date as a Date
	**/
	   public Date getDate()
	   {
		   
		   return date;
	   }
	
	   /**
	* Method to get venue of event
	@return the venue as a Venue
	**/
	   public Venue getVenue()
	   {
		   return venue;
	   }
	
	/**
	* Method to set the venue of event
	**/
	   public void setVenue(Venue v)
	   {
		   venue =v;
	   }
	/**
	* toString method
	* @return string represetation of the event
	**/
	   public String toString()
	   {
		   return "Date:"+this.getDate()+";Name:"+this.getName()+";Type:"+this.getType()+";Venue:"+this.getVenue()+":numPeople:"+this.getNumPeople();
	   }

	 }


