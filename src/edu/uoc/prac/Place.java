package edu.uoc.prac;
import java.util.ArrayList;

/**
*
* Place class definition
*
* @author Edgar Riba
*
*/

public class Place {

    /** attributes definition */
	private String name;
	private String address;
	private String zone;
	private Boolean privateResidence;
	private Integer id;
	private Country country;
	private MeetingGroup meetingGroup;
	private ArrayList<Meeting> meetings;
	
	/**
    * Constructor
    */
	public Place(String name, String address, String zone, 
			     Boolean privateResidence, Country country) {
		this.name = name;
		this.address = address;
		this.zone = zone;
		this.privateResidence = privateResidence;
		this.setId(0);
		this.country = country;
		this.country.addPlace(this);
		this.meetings = new ArrayList<Meeting>();
	}
	
	@Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;
        if (object != null && object instanceof Place)
        {
            sameSame = this.name.equals(((Place) object).getName()) && // check place names
            		   this.getCountry().getName().equals(((Place) object).getCountry().getName()); // check country names
        }
        return sameSame;
    }
	
	@Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Identifier: ").append(this.getId());
        sb.append(" Name: ").append(this.getName());
        sb.append(" Address: ").append(this.getAddress());
        sb.append("Zone: ").append(this.getZone());
        sb.append(" Private Residence: ").append( (this.getPrivateResidence()) ? "Yes" : "No" );
        sb.append(" Country: ").append(this.getCountry().getName());
		return sb.toString();
    }

	/**
	* Getter method
	* @return type of {@link String}
	*/
	public String getName() {
	     return this.name;
	}
	
	/**
	* Getter method
	* @return type of {@link String}
	*/
	public String getAddress() {
	     return this.address;
	}
	
	/**
	* Getter method
	* @return type of {@link Boolean}
	*/
	public Boolean getPrivateResidence() {
	     return this.privateResidence;
	}
	
	/**
	* Getter method
	* @return type of {@link String}
	*/
	public String getZone() {
		return this.zone;
	}
	
	/**
	* Getter method
	* @return type of {@link Country}
	*/
	public Country getCountry() {
	     return this.country;
	}
	
	/**
	* Getter method
	* @return type of {@link Integer}
	*/
	public Integer getId() {
	     return this.id;
	}
	
	/**
	* Setter method
	* param type of {@link Integer}
	*/
	public void setId(Integer id) {
	     this.id = id;
	}
	
	/**
	* Setter method
	* param type of {@link MeetingGroup}
	*/
	public void setMeetingGroup(MeetingGroup meetingGroup) {
	     this.meetingGroup = meetingGroup;
	     //meetingGroup.setPlace(this);
	}
	
	/**
	* Method to add a meeting
	* @param type of {@link Meeting}
	*/
	public void addMeeting(Meeting meeting) {
	    if ( this.meetings.contains(meeting) ){
	    	System.out.println("Duplicated meeting in the same place");
	    }
	    else{
	    	this.meetings.add(meeting);
	    }
	}
}
