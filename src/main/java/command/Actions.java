package command;

import components.Task;
import components.User;

public interface Actions {

	public void accept();
	
	public void cancel();
	
	public void register();
	
	public void createTask(User user);
	
	public void deleteTask(User user);
	
	public void finishTask(User user);
	
	public void modifyTask(User user);
	
	public void exitView();

	void showTask(Task task);
}
