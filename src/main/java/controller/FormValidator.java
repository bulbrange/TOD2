package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import components.User;
import view.TaskPanel;

public class FormValidator {
	
	private ArrayList<JTextField> inputs;
	
	
	public FormValidator(ArrayList<JTextField> inputs){
		
		this.inputs = inputs;
	}
	
	
	public boolean validateRegister(){
		
		if(!uniqueMail(inputs.get(0).getText())){
			JOptionPane.showMessageDialog(null, inputs.get(0).getText() + " is not a valid mail...", "Register issue", 0);
			return false;
		}
		for(JTextField f: inputs){
			if(f.getText().length() == 0) return false;
			if(f.getName().equals("Re-Password:") && !samePassword()){
				JOptionPane.showMessageDialog(null, "Matching passwords failed...", "Register form", 0);
				return false; 
			}
		}

		return true;
	}
	public boolean validateUser(){
		String mail = inputs.get(0).getText();
		String pass = inputs.get(1).getText();
		String ID = "";
		try {
			String query = "SELECT Email FROM Persona WHERE Email='" + mail + "'";
			ArrayList<Object> user = DBController.getInstance().query(query, "Email");
			if(user.size() == 0){
				JOptionPane.showMessageDialog(null, "Invalid user... sing up first...", "Loggin issue", 0);
				return false;
			}
			
			String query2 = "SELECT Pass FROM Persona WHERE Email='" + mail + "'";
			user = DBController.getInstance().query(query2, "Pass");
			if(!user.get(0).toString().equals(pass)){
				JOptionPane.showMessageDialog(null, "Invalid password...", "Loggin issue", 0);
				return false;
			}
			String query3 = "SELECT ID FROM Persona WHERE Email='" + mail + "'";
			user = DBController.getInstance().query(query3, "ID");
			ID = user.get(0).toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TaskPanel.user = new User(ID, mail, pass);
		TaskPanel.buttonPanel.getCreateTask().setU(TaskPanel.user);
		return true;
	}

	private boolean samePassword(){
		String pass = "";
		String repass = "";
		for(JTextField f: inputs){
			if(f.getName().equals("Password:")) pass = f.getText();
			else if(f.getName().equals("Re-Password:")) repass = f.getText();
		}
		return pass.equals(repass);
	}
	
	private boolean uniqueMail(String mail){
		try {
			ArrayList<Object> info = DBController.getInstance().query(DBController.ALLUSERS, "Email");
			for(Object i : info){
				if(mail.equalsIgnoreCase(i.toString())) return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
