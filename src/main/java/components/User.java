package components;

import java.util.ArrayList;
import java.util.Calendar;

public class User {
	
	private String name;
	private String pass;
	private ArrayList<Task> tasks;
	private int idPersona;
	
	public User(){
		this.name = null;
		this.pass = null;
		this.tasks = null;
	}
	
	public User(String name, String pass){
		this.name = name;
		this.pass = pass;
		
		tasks = new ArrayList<Task>();
		tasks.add(new Task("Planchar la ropa",
							"Para planchar hay que hacerlo despacito y buena letra. No me toques los borondongos que me conozco",
							new Calendar.Builder().setDate(2018, 5, 4).build(),  	//CREATION
							new Calendar.Builder().setDate(2018, 5, 4).build(),  	//START
							new Calendar.Builder().setDate(2018, 5, 4).build()));	//END
		tasks.add(new Task("Planchar la ropa2",
				"Para planchar hay que hacerlo222 despacito y buena letra. No me toques los borondongos que me conozco",
				new Calendar.Builder().setDate(2018, 5, 4).build(),  	//CREATION
				new Calendar.Builder().setDate(2018, 5, 4).build(),  	//START
				new Calendar.Builder().setDate(2018, 5, 4).build()));	//END
		tasks.add(new Task("Planchar la ropa3",
				"Para planchar hay que hacerlo333 despacito y buena letra. No me toques los borondongos que me conozco",
				new Calendar.Builder().setDate(2018, 5, 4).build(),  	//CREATION
				new Calendar.Builder().setDate(2018, 5, 4).build(),  	//START
				new Calendar.Builder().setDate(2018, 5, 4).build()));	//END
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

}
