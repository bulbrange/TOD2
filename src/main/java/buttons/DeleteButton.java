package buttons;

import javax.swing.JPanel;

import command.ButtonDevice;
import command.ButtonPattern;
import components.Task;
import components.User;

public class DeleteButton extends ButtonPattern{

	private static final long serialVersionUID = 1L;
	private User user;

	public DeleteButton(String title, int x, int y, ButtonDevice device, JPanel view, User user) {
		super(title, x, y, device, view);
		this.user = user;
	}

	
	public void execute() {
		device.deleteTask(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
