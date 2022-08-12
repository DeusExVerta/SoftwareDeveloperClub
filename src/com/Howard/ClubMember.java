package com.Howard;

public class ClubMember {
	private String name;
	private String city,state;
	private String language;
	
	public ClubMember(String name, String city, String state, String language) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.language = language;
	}
	//standard getters&setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	//Specialized getters & setters for location
	//for use when moving within the same state
	public void setCity(String city) 
	{
		this.city=city;
	}
	
	//for use when moving to a new state regardless of city.
	public void setCityState(String city,String state) 
	{
		this.city = city;
		this.state = state;
	}
	
	//returns string including both city and state.
	public String getLocation() 
	{
		return String.format("%s, %s", city,state);
	}
	
	
	//display string method
	public String toString() {
		return String.format("Name: %s%nLocation: %s%nLanguage: %s", name, getLocation(),language);
	}
	
	// double star(**) delimited string method for file storage per specification.
	public String saveString() 
	{
		return String.format("%s**%s**%s**%s%n", name,city,state,language);
	}
}
