package components;

import buttons.TaskButton;

public class Task {
	
	private String start;
	private String end;
	private String title;
	private String description;
	private TaskButton displayInfo;
	private State state;
	private boolean selected = false;
	
	public Task(String title, String description){

		this.title = title;
		this.description = description;
		
	}
	public Task(){
		this.start = null;
		this.end = null;
		this.title = "";
		this.description = "";
		this.displayInfo = null;
		this.state = State.Pendiente;
		
	}

	public String toString(){
		return this.title + "\nFECHA DE COMIENZO: " 
				+ this.start.toString() + "\nFECHA DE FIN: " 
				+ this.end.toString() + "\n" + this.description
				+ "\n" + this.state;
	}

	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
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

	public void setState(String state) {
		if(state.equals(State.Pendiente.name())) this.state = State.Pendiente;
		else this.state = State.Finalizada;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
