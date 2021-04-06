/**
* Date
**/

public class Date {
  private int day;
  
/**
* Method to get date of event
* @param day takes a day
**/
  public Date(int day)
  {
	  this.day =day;
  }
  
/**
* Method to set day of event
* @param day takes the day of the event
**/
  public void setDay(int day)

    {
	  this.day=day;
    }
	
/**
* Method to get day of the event
* @return day as an integer
**/
  public int getDay()
  {
	  return day;
  }
  
/** 
* Method to get new day of the event
* @return the new day as an integer
**/
  public Date next(int day)
  {
	  return new Date(day+1);
  }
	
/**
* toString method
* @return string representation of the day
**/
  public String toString()
  {
	  return ""+day;
  }
}
