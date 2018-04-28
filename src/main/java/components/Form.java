package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listeners.ButtonListener;
import view.MainFrame;

public abstract class Form {

	// POSITION VARIABLES
	protected static final int nameX = MainFrame.WIDTH / 3;
	protected static final int nameY = 100;
	protected static final int WIDTH = 250;
	protected static final int HEIGHT = 25;

	// COMPONENTS
	protected JTextField email;
	protected JPasswordField password;
	protected ArrayList<JTextField> inputs;


	private Font font1 = new Font("Consolas", Font.PLAIN, 16);

	private JPanel view;
	
	//LISTENERS
	protected ButtonListener listener;

	public Form(JPanel view) {

		this.view = view;

		// INIT TEXT FIELDS
		inputs = new ArrayList<JTextField>();
		email = new JTextField();
		password = new JPasswordField();
		configTextField(email, "E-Mail:", 0, 0);
		configTextField(password, "Password:", 0, 50);


	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(font1);
		for (JTextField f : inputs) {
			String title = f.getName();
			g.drawString(title, f.getX() - title.length() * (font1.getSize() / 2) - 10, f.getY() + 16);
		}
	}

	protected void configTextField(JTextField txtF, String title, int posX, int posY) {

		txtF.setBounds(nameX + posX, nameY + posY, WIDTH, HEIGHT);
		txtF.setName(title);
		this.view.add(txtF);
		inputs.add(txtF);
	}

	public void cleanInput(){
		for(JTextField f : inputs){
			f.setText("");
		}
	}
	public JTextField getUser() {
		return email;
	}

	public void setUser(JTextField name) {
		this.email = name;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setSurname(JPasswordField password) {
		this.password = password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public ArrayList<JTextField> getInputs() {
		return inputs;
	}

	public void setInputs(ArrayList<JTextField> inputs) {
		this.inputs = inputs;
	}

}