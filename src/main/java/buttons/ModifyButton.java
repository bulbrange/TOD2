package buttons;

import javax.swing.JPanel;

import command.ButtonDevice;
import command.ButtonPattern;

public class ModifyButton extends ButtonPattern{

	private static final long serialVersionUID = 1L;

	public ModifyButton(String title, int x, int y, ButtonDevice device, JPanel view) {
		super(title, x, y, device, view);
		// TODO Auto-generated constructor stub
	}

	
	public void execute() {
		device.modifyTask();
	}

}
