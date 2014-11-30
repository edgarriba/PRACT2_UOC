package edu.uoc.prac;

import java.util.ArrayList;

/**
*
* Country class definition
*
* @author Edgar Riba
*
*/

public class Country {

    /** attributes definition */
	private String name;
	private ArrayList<Place> places;

	/**
    * Constructor
    */
    public Country(String name) {
    	this.name = name;
    	this.places = new ArrayList<Place>();
    }
    
    /**
	* Getter method
	* @return type of {@link String}
	*/
	public String getName() {
	     return this.name;
	}
	
	/**
	* Method to add a place
	* @param type of {@link Place}
	*/
	public void addPlace(Place place) {
	    if ( this.places.contains(place) ){
	    	System.out.println("Duplicated place in the same country");
	    }
	    else{
	    	this.places.add(place);
	    }
	}
}
