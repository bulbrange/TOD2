package command;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class ButtonPattern extends JButton implements  Command{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 100;
	public static final int HEIGHT = 30;
	
	protected ButtonDevice device;
	protected JPanel view;
	

	
	public ButtonPattern(String title, int x, int y, ButtonDevice device, JPanel view){
		
		this.device = device;
		this.view = view;
		
		setText(title);
		setBounds(x, y, WIDTH, HEIGHT);
		
		view.add(this);

	}

}
