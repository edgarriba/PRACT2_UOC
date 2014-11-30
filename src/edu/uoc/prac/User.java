package edu.uoc.prac;
import java.util.ArrayList;

/**
*
* User class definition
*
* @author Edgar Riba
*
*/

public class User {

	/** attributes definition */
	private String email;
	private String password;
	private ArrayList<MeetingGroup> meetingGroups;
	private ArrayList<Answer> answers;
	private ArrayList<String> interests;

	/**
    * Constructor
    */
    public User(String email, String password) {
    	this.email = email;
    	this.password = password;
    	this.meetingGroups = new ArrayList<MeetingGroup>();
    	this.answers = new ArrayList<Answer>();
    	this.interests = new ArrayList<String>();
    }

    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;
        if (object != null && object instanceof User)
        {
            sameSame = this.email.equals(((User) object).email);
        }
        return sameSame;
    }
    
    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Personal info
		sb.append("* ").append(this.email).append(" ").append(this.password).append("\n");
		// Interests
		if( interests.size() <= 0 ) {
			sb.append("Not available Interests for user yet").append("\n");
		} else {
			sb.append("List of interests").append("\n");
			for (int i = 0; i < interests.size(); i++)
				sb.append( interests.get(i) ).append(" ");
		}
		return sb.toString();
    }
    
    /**
	* Getter method
	* @return type of String
	*/
	public String getEmail() {
	     return this.email;
	}
	
	/**
	* Getter method
	* @return type of String
	*/
	public String getPassword() {
	     return this.password;
	}
	
	/**
	* Getter method
	* @return type of ArrayList<String>
	*/
	public ArrayList<String> getInterests() {
	     return this.interests;
	}
	
	/**
	* Method to add a meeting
	* @param type of {@link Meeting}
	*/
	public void addMeetingGroup(MeetingGroup meetingGroup) {
	    if ( this.meetingGroups.contains(meetingGroup) ){
	    	System.out.println("Duplicated meeting group in the same user");
	    }
	    else{
	    	this.meetingGroups.add(meetingGroup);
	    }
	}
	
	/**
	* Method to add an Answer
	* @param type of {@link String}
	*/
	public void addInterest(String interest) {
		this.interests.add(interest);
	}
	
	/**
	* Method to add an Answer
	* @param type of {@link Answer}
	*/
	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}

	/**
	* Method to add search a meeting group with given interests
	* @param type of {@link MeetingGroup}
	*/
	public String matchMeetingGroups(ArrayList<MeetingGroup> meetingGroups) {
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < interests.size(); i++) {
			String interest_i = interests.get(i);
			sb.append("Checking interest .....").append(interest_i).append("\n");
			for (int j = 0; j < meetingGroups.size(); j++) {
				String meetinGroup_j = meetingGroups.get(j).getName();
				boolean match = meetinGroup_j.toLowerCase().contains(interest_i.toLowerCase()) || interest_i.matches( meetinGroup_j );
				if (match) {
					sb.append("Matching MeetingGroup ").append(meetinGroup_j).append(" for interest ").append(interest_i);
				} else {
					sb.append("No Matching MeetingGroup for interest ").append(interest_i);
				}
				if( i<interests.size()-1 && j<meetingGroups.size()) sb.append("\n");
			}
		}
		return sb.toString();
	}

	public ArrayList<Answer> getAnswers() { return this.answers; }

} // end class User