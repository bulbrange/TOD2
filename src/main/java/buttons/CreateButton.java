package buttons;

import javax.swing.JPanel;

import command.ButtonDevice;
import command.ButtonPattern;
import components.User;

public class CreateButton extends ButtonPattern{

	private static final long serialVersionUID = 1L;
	private User user;

	public CreateButton(String title, int x, int y, ButtonDevice device, JPanel view,User user) {
		super(title, x, y, device, view);
		this.user = user;
	}

	
	public void execute() {
		device.createTask(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
