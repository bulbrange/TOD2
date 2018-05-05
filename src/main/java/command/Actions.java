package command;

import components.Task;

public interface Actions {

	public void accept();
	
	public void cancel();
	
	public void register();
	
	public void createTask(String userID);
	
	public void deleteTask();
	
	public void finishTask();
	
	public void modifyTask();
	
	public void exitView();

	void showTask(Task task);
}
