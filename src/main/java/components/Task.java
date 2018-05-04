package components;

import java.util.Calendar;

import buttons.TaskButton;

public class Task {
	
	private Calendar start;
	private Calendar end;
	private Calendar creation;
	private String title;
	private String description;
	private TaskButton displayInfo;
	private State state;
	
	public Task(String title, String description, Calendar creation, Calendar start, Calendar end){
		this.start = start;
		this.end = end;
		this.creation = creation;
		this.title = title;
		this.description = description;
		this.state = State.Pendiente;
		
	}

	public String toString(){
		return this.title + "\nFECHA DE COMIENZO: " + this.start.toString() + "\nFECHA DE FIN: " + this.end.toString() + "\n" + this.description;
	}

	public Calendar getStart() {
		return start;
	}


	public void setStart(Calendar start) {
		this.start = start;
	}


	public Calendar getEnd() {
		return end;
	}


	public void setEnd(Calendar end) {
		this.end = end;
	}


	public Calendar getCreation() {
		return creation;
	}


	public void setCreation(Calendar creation) {
		this.creation = creation;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public TaskButton getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(TaskButton displayInfo) {
		this.displayInfo = displayInfo;
	}
	public void switchState(){
		if(state == State.Pendiente) state = State.Finalizada;
		else state = State.Pendiente;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
