package components;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import buttons.CancelButton;
import buttons.ConfirmButton;
import command.ButtonPattern;
import listeners.ButtonListener;
import view.MainFrame;
import view.MainPanel;

public class RegisterForm extends Form{

	private JPasswordField repassword;
	private JTextField user;
	
	private ConfirmButton acept;
	private CancelButton cancel;
	
	private ArrayList<ButtonPattern> buttons;
	public RegisterForm(JPanel view) {
		super(view);
		// INIT TEXT FIELDS

		repassword = new JPasswordField();
		user = new JTextField();
		configTextField(repassword, "Re-Password:", 0, 100);
		configTextField(user, "User:", 0, 150);

		// INIT BUTTONS
		acept = new ConfirmButton("Acept", nameX, nameY * 3, MainFrame.device, view);
		cancel = new CancelButton("Cancel", nameX + 150, nameY * 3, MainFrame.device, view);
		buttons = new ArrayList<ButtonPattern>();
		buttons.add(acept);
		buttons.add(cancel);
		
		//ADDING BUTTON LISTENERS
		listener = new ButtonListener(buttons);
		
		hideComponents();
	}
	
	public void hideComponents(){
		for(ButtonPattern p : buttons){
			p.setVisible(false);
		}
		for(JTextField f: inputs){
			f.setVisible(false);
		}
	}

	
	public void showComponents(){
		for(ButtonPattern p : buttons){
			p.setVisible(true);
		}
		for(JTextField f: inputs){
			f.setVisible(true);
		}
	}
	public void show(Graphics g){
		g.drawImage(MainPanel.loginBackground, 0, 0, null);
		g.setFont(MainPanel.titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Register", MainFrame.WIDTH / 3 + 60, 50);
		this.draw(g);
	}

}
