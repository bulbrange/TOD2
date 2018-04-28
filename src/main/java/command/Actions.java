package command;

public interface Actions {

	public void accept();
	
	public void cancel();
	
	public void register();
	
	public void createTask();
	
	public void deleteTask();
	
	public void finishTask();
	
	public void modifyTask();
	
	public void exitView();
}
