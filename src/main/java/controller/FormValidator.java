package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormValidator {
	
	private ArrayList<JTextField> inputs;
	
	
	public FormValidator(ArrayList<JTextField> inputs){
		
		this.inputs = inputs;
	}
	
	
	public boolean validate(){
		
		for(JTextField f: inputs){
			if(f.getText().length() == 0) return false;
			if(f.getName().equals("Re-Password:") && !samePassword()){
				JOptionPane.showMessageDialog(null, "Matching passwords failed...", "Register form", 0);
				return false; 
			}
		}
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
	
	public String toString(){
		String info = "";
		for(JTextField f: inputs){
			if(!f.getClass().getSimpleName().equals("JPasswordField")){
				info += f.getText() + "<br>";
			}
		}
		return info + "</body></html>";
	}
}
