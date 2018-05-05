package buttons;

import javax.swing.JPanel;

import command.ButtonDevice;
import command.ButtonPattern;
import components.Task;
import components.User;

public class TaskButton extends ButtonPattern{
	
	private static final long serialVersionUID = 1L;
	private Task task;
	private User user;
	
	public TaskButton(String title, int x, int y, ButtonDevice device, JPanel view, Task task, User user) {
		super(title, x, y, device, view);
		this.task = task;
		this.user = user;
	}

	@Override
	public void execute() {
		device.showTask(task);
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
