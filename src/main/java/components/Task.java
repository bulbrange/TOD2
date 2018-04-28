package components;

import java.util.Calendar;

public class Task {
	
	private Calendar start;
	private Calendar end;
	private Calendar creation;
	private String title;
	private String description;
	
	
	public Task(Calendar start, Calendar end, Calendar creation, String title, String description){
		this.start = start;
		this.end = end;
		this.creation = creation;
		this.title = title;
		this.description = description;
		
	}
	

}
