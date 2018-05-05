package buttons;

import javax.swing.JPanel;

import command.ButtonDevice;
import command.ButtonPattern;
import components.User;

public class CreateButton extends ButtonPattern{

	private static final long serialVersionUID = 1L;
	private User u;

	public CreateButton(String title, int x, int y, ButtonDevice device, JPanel view,User u) {
		super(title, x, y, device, view);
		this.u = u;
	}

	
	public void execute() {
		device.createTask(u);
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
}
