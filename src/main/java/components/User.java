package components;

import java.util.ArrayList;

import buttons.TaskButton;
import command.ButtonPattern;
import controller.DBController;
import listeners.ButtonListener;
import view.MainFrame;
import view.TaskPanel;

public class User {
	
	private String name;
	private String pass;
	private ArrayList<Task> tasks;
	private String ID;
	private ButtonListener taskListener;
	
	public User(){
		this.name = null;
		this.pass = null;
		this.tasks = null;
	}
	
	public User(String ID, String name, String pass){
		this.ID = ID;
		this.name = name;
		this.pass = pass;
		setTasks();
	}
	
	public void setTasks(){
		tasks = new ArrayList<Task>();
		String queryLength = "SELECT * FROM Tarea WHERE ID_persona=" + ID;
		String queryTitulo = "SELECT Titulo FROM Tarea WHERE ID_persona=" + ID;
		String queryDescripcion = "SELECT Descripcion FROM Tarea WHERE ID_persona=" + ID;
		String queryFecha_ini = "SELECT Fecha_ini FROM Tarea WHERE ID_persona=" + ID;
		String queryFecha_fin = "SELECT Fecha_fin FROM Tarea WHERE ID_persona=" + ID;
		String queryEstado = "SELECT Estado FROM Tarea WHERE ID_persona=" + ID;
		try {
			ArrayList<Object> length = DBController.getInstance().query(queryLength, "ID");
			for(int i = 0; i < length.size(); i++){
				Task t = new Task(length.get(i).toString());
				tasks.add(t);
			}
			ArrayList<Object> titles = DBController.getInstance().query(queryTitulo, "Titulo");
			for(int i = 0; i < tasks.size(); i++){
				tasks.get(i).setTitle(titles.get(i).toString());
			}
			ArrayList<Object> descriptions = DBController.getInstance().query(queryDescripcion, "Descripcion");
			for(int i = 0; i < tasks.size(); i++){
				tasks.get(i).setDescription(descriptions.get(i).toString());
			}
			ArrayList<Object> init_date = DBController.getInstance().query(queryFecha_ini, "Fecha_ini");
			for(int i = 0; i < tasks.size(); i++){
				if(init_date.get(i) != null)tasks.get(i).setStart(init_date.get(i).toString());
				else tasks.get(i).setStart("Undefined");
			}
			ArrayList<Object> end_date = DBController.getInstance().query(queryFecha_fin, "Fecha_fin");
			for(int i = 0; i < tasks.size(); i++){
				if(end_date.get(i) != null)tasks.get(i).setEnd(init_date.get(i).toString());
				else tasks.get(i).setEnd("Undefined");
			}
			ArrayList<Object> state = DBController.getInstance().query(queryEstado, "Estado");
			for(int i = 0; i < tasks.size(); i++){
				tasks.get(i).setState(state.get(i).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ButtonPattern> taskButtons = new ArrayList<ButtonPattern>();
		for(int i = 0; i < tasks.size(); i++){
			System.out.println();
			tasks.get(i).setDisplayInfo(new TaskButton(
										tasks.get(i).getTitle(),
										100,
										50 + (i * 50),
										MainFrame.device,
										TaskPanel.getInstance(),
										tasks.get(i),
										this));
			taskButtons.add(tasks.get(i).getDisplayInfo());
		}
		taskListener = new ButtonListener(taskButtons);
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

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

}
