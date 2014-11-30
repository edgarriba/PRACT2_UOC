package edu.uoc.prac;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
*
* Answer class definition
*
* @author Edgar Riba
*
*/

public class Answer {

	/** attributes definition */
	private Boolean attending;
	private Integer guests;
	private AttendingResult attendingResult;
	private User user;
	private Meeting meeting;

	/**
    * Constructor
    */
    public Answer(User user, Meeting meeting, AttendingResult attendingResult, Integer guests) {
    	this.attending = ( attendingResult==AttendingResult.Yes ) ? true : false;
    	this.guests = guests;
    	this.attendingResult = attendingResult;
    	this.user = user;
    	//this.user.addAnswer(this);
    	this.meeting = meeting;
    	//this.meeting.addAnswer(this);
    }
    
    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;
        if (object != null && object instanceof Answer)
        {
        	sameSame = this.meeting.getDescription().equals(((Answer) object).meeting.getDescription()) &&
        			   this.user.getEmail().equals(((Answer) object).user.getEmail()) &&
        			   this.user.getPassword().equals(((Answer) object).user.getPassword());
        }
        return sameSame;
    }
    
    @Override public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        // User info
        String u = this.getUser().toString().substring(2);
        sb.append("User information: ").append(u);
        // Answer info
        sb.append("Guests Coming: ").append(this.getGuests()).append("\n");
        sb.append("Attending Result: ").append(this.getAttendingResult().toString()).append("\n");
        // Meeting info
        String s = this.getMeeting().toString();
        s = s.substring(s.indexOf('\n')+1); // remove first empty line
        sb.append("Information Meeting: ").append(s).append("\n");
        return sb.toString();
    }
    
    /** Getters Methods **/
    public Meeting         getMeeting()          { return this.meeting;          }
    public User            getUser()             { return this.user;             }
    public Integer         getGuests()           { return this.guests;           }
    public AttendingResult getAttendingResult()  { return this.attendingResult;  }

}