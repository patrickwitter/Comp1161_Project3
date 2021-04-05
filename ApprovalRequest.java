/**
 * Approval Request
 */
class ApprovalRequest
{ 
private Event event;
private Venue venue;
private int id;
private static int nextid=0;
private String comment;


public ApprovalRequest(Event event, Venue venue)
{
	/**
	 * Constructor for Approval Request. Also generates a unique id.
	 * @param Event seeking approval
	 * @param Venue that the Event is taking place
	 */
	this.event = event;
	this.venue = venue;
	id = nextid;
	nextid++;
}

public int getId()
{
	return id;
}
public Event getEvent()
{return event;
}

public Venue getVenue()
{return venue;
}
public void setComment(String info)
{
	this.comment = info+":"+event.toString();
}

public String toString()
{
	return comment;
}
}


