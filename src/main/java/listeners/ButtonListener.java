package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import command.ButtonPattern;

public class ButtonListener implements ActionListener{

	private ArrayList<ButtonPattern> buttons;
	
	public ButtonListener(ArrayList<ButtonPattern> buttons){
		this.buttons = buttons;
		
		for(ButtonPattern b: buttons){
			b.addActionListener(this);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		for(ButtonPattern b: buttons){
			if(e.getActionCommand().equals(b.getText())) b.execute();
		}
		//System.out.println(e.getActionCommand());
		
	}

}
