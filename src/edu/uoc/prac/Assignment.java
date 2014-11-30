package edu.uoc.prac;

/**
*
* Assignment class definition
*
* @author Edgar Riba
*
*/

public class Assignment {
	
	/** attributes definition */
	private Integer fixedFee;
	private Double percentage;
	private Organizer organizer;
	private MeetingGroup meetingGroup;
	
	/**
    * Constructor
    */
    public Assignment(Organizer organizer, MeetingGroup meetingGroup) {
    	this.fixedFee = 15;
    	this.percentage = 0.1;
    	this.setOrganizer(organizer);
    	this.setMeetingGroup(meetingGroup);
    }
    
    /**
	* Setter method
	* param type of {@link Organizer}
	*/
	public void setOrganizer(Organizer organizer) {
	     this.organizer = organizer;
	     this.organizer.addAssignment(this);
	}
	
	/**
	* Setter method
	* param type of {@link MeetingGroup}
	*/
	public void setMeetingGroup(MeetingGroup meetingGroup) {
	     this.meetingGroup = meetingGroup;
	}
    
    /**
	* Getter method
	*  @return type of Integer
	*/
	public Integer getFixedFee() {
		return this.fixedFee;
	}
	
	/**
	* Getter method
	*  @return type of Double
	*/
	public Double getPercentage() {
		return this.percentage;
	}

    /**
	* Getter method
	*  @return type of Organizer
	*/
	public Organizer getOrganizer() {
		return this.organizer;
	}

}
