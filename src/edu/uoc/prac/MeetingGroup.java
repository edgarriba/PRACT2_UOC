package edu.uoc.prac;
import java.util.ArrayList;
import java.util.Collections;

/**
*
* MeetingGroup class definition
*
* @author Edgar Riba
*
*/

public class MeetingGroup {

	/** attributes definition */
	private String name;
	private Assignment assignment;
	private ArrayList<Place> places;
	private ArrayList<User> members;
	private ArrayList<User> coorganizers;
	private ArrayList<Meeting> meetings;

	/**
    * Constructor
    */
    public MeetingGroup(String name) {
    	this.name = name;
    	this.assignment = null;
    	this.places = new ArrayList<Place>();
    	this.members = new ArrayList<User>();
    	this.coorganizers = new ArrayList<User>();
    	this.meetings = new ArrayList<Meeting>();
    }
    
    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;
        if (object != null && object instanceof MeetingGroup)
        {
            sameSame = this.name.equals(((MeetingGroup) object).getName());
        }
        return sameSame;
    }
    
    @Override public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        // Group name
		sb.append("Information Meeting Group Name: ").append(this.name).append("\n");
		// Members
		if( members.size() <= 0 ) {
			sb.append("No members to show").append("\n");
		} else {
			sb.append("MeetingGroup Members in alphabetical email order: ").append("\n");
			this.sortMembers(); // sort members
			for (int i = 0; i < members.size(); i++)
				sb.append( members.get(i) ).append("\n");
		}
		// Coorganizers
		if( coorganizers.size() <= 0 ) {
			sb.append("No coorganizers to show").append("\n");
		} else {
			sb.append("MeetingGroup Coorganizers in insertion order: ").append("\n");
			for (int i = 0; i < coorganizers.size(); i++)
				sb.append( coorganizers.get(i) ).append("\n");
		}
		// Organizer
		sb.append("MeetingGroup Organizer Information").append("\n");
		sb.append( this.assignment.getOrganizer() );
		// Rates
		sb.append("Fixed fee: ").append(this.assignment.getFixedFee()).append(" Percentage: ").append(this.assignment.getPercentage()).append("\n");
		// Places
		if( places.size() <= 0 ) {
			sb.append("No places to show").append("\n");
		} else {
			sb.append("List of available places------------------").append("\n");
			for (int i = 0; i < places.size(); i++)
				sb.append( places.get(i) ).append("\n");
		}
		// Meetings
		if( meetings.size() <= 0 ) {
			sb.append("NO meetings to show").append("\n");
		} else {
			sb.append("MG Meetings Information------------------");
			for (int i = 0; i < meetings.size(); i++)
				sb.append( meetings.get(i) ).append("\n");
		}
        return sb.toString();
    }
    
    /**
	* The method adds a user into the members list
	* @param user type of User
	*/
    public void addMember(User user) {	
		this.members.add(user);
		user.addMeetingGroup(this);
	}
    
    /**
	* The method removes a user from the members list
	* @param user type of User
	*/
    public void removeMember(User user) {	
		this.members.remove(user);		
	}
    
    /**
	* The method sorts the members list
	* @param user type of User
	*/
    public void sortMembers() {	
 	   Collections.sort(this.members, new UserEmailComparator());	
	}
    
    /**
	* The mehtod adds a user into the coorganizers list
	* @param user type of User
	*/
    public void addCoorganizer(User user) {	
		this.coorganizers.add(user);
		user.addMeetingGroup(this);
	}
    
    /**
	* The mehtod adds a meeting into the meetings list
	* @param meeting type of Meeting
	*/
    public void addMeeting(Meeting meeting) {
		this.meetings.add(meeting);
  	}
    
    /**
   	* Getter method
   	* @return type of String
   	*/
   	public String getName() {
   	     return this.name;
   	}
   	
   	/**
   	* Getter method
   	* @return type of ArrayList<User>
   	*/
   	public ArrayList<User> getMembers() {
   	     return this.members;
   	}
   	
   	/**
   	* Getter method
   	* @return type of ArrayList<Meetings>
   	*/
   	public ArrayList<Meeting> getMeetings() {
   	     return this.meetings;
   	}  
   	
   	/**
   	* Getter method
   	* @return type of ArrayList<User>
   	*/
   	public ArrayList<User> getCoorganizers() {
   	     return this.coorganizers;
   	}  
   	
   	/**
	* Getter method
	*  @return type of Place
	*/
	public ArrayList<Place> getPlaces() {
		return this.places;
	}
   	
   	/**
	* Setter method
	* param type of {@link Place}
	*/
	public void AddPlace(Place place) {
	     this.places.add(place);
	     place.setMeetingGroup(this);
	}

	/**
	* Getter method
	*  @return type of Assignment
	*/
	public Assignment getAssignment() {
		return this.assignment;
	}
	
	/**
	* Setter method
	* param type of {@link Assignment}
	*/
	public void setAssignment(Assignment assignment) {
	     this.assignment = assignment;
	}
}
