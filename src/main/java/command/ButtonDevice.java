package command;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.DBController;
import controller.FormValidator;
import view.MainFrame;
import view.MainPanel;

public class ButtonDevice implements Actions {

	
	public void accept() {
		ArrayList<JTextField> in = new ArrayList<JTextField>();

		if (MainPanel.getInstance().isLoginView()) {
			in = MainPanel.getInstance().getLogin().getInputs();
			initLoginProtocol(in);

		} else if (MainPanel.getInstance().isRegisterView()) {
			in = MainPanel.getInstance().getRegister().getInputs();
			initRegisterProtocol(in);

		}
	}

	
	public void cancel() {
		if (MainPanel.getInstance().isRegisterView()) {
			resetComponents(false);
		}

	}

	
	public void register() {
		resetComponents(true);

	}
	
	
	public void createTask() {
		System.out.println("CREATE TASK WORKING");
		
	}
	
	public void deleteTask() {
		System.out.println("DELETE TASK WORKING");
		
	}

	
	public void finishTask() {
		System.out.println("FINISH TASK WORKING");
		
	}

	
	public void modifyTask() {
		System.out.println("MODIFY TASK WORKING");
		
	}
	
	public void exitView() {
		MainFrame.switchView();
		
	}
	private void resetComponents(boolean isLogin) {
		if (isLogin) {
			MainPanel.getInstance().getLogin().hideComponents();
			MainPanel.getInstance().getLogin().cleanInput();
			MainPanel.getInstance().getRegister().showComponents();
			MainPanel.getInstance().setViews(false, true);
			MainPanel.getInstance().repaint();
		} else {
			MainPanel.getInstance().getRegister().hideComponents();
			MainPanel.getInstance().getRegister().cleanInput();
			MainPanel.getInstance().getLogin().showComponents();
			MainPanel.getInstance().setViews(true, false);
			MainPanel.getInstance().repaint();
		}
	}

	@Override
	public void showTask() {
		System.out.println("TASK BUTTON WORKING");
		
	}
	
	private void initLoginProtocol(ArrayList<JTextField> input){
		
		if(new FormValidator(input).validateUser()){
			JOptionPane.showMessageDialog(null, "<html><body>Welcome back!!!<br><br>What TO DO today??<br></html></body>", "Loggin successful", 1);
			MainFrame.switchView();
		}
	}
	
	private void initRegisterProtocol(ArrayList<JTextField> input){
		
		if(new FormValidator(input).validateRegister()){
			String mail = input.get(0).getText();
			String pass = input.get(1).getText();
			String user = input.get(3).getText();
			
			DBController.getInstance().insertIntoPersona(user, mail, pass);
			resetComponents(false);
			String welcomeMsg = "<html><body>REGISTER SUCCESFULL!!<br><br>Welcome " 
								+ user + "<br><br>To log in you must use your mail:<br>"
								+ mail;
			JOptionPane.showMessageDialog(null, welcomeMsg);
		}
	}

}
