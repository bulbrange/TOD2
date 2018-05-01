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
		String msgOK = "";
		String msgKO = "";
		String title = "";

		if (MainPanel.getInstance().isLoginView()) {
			System.out.println("LOGGIN BUTTON WORKING");
			in = MainPanel.getInstance().getLogin().getInputs();
			msgOK = "<html><body>Greetings ";
			msgKO = "Access denied...";
			title = "Login";
			for (Object o : getData("select * from test2", "col1")) {
				System.out.println(o.toString());
			}

		} else if (MainPanel.getInstance().isRegisterView()) {
			System.out.println("REGISTER BUTTON WORKING");
			in = MainPanel.getInstance().getRegister().getInputs();
			msgOK = "<html><body>---NEW USER---<br>";
			msgKO = "Incomplete or wrong form...";
			title = "Register form";
		}

		for (JTextField f : in) {
			System.out.println(f.getText());
		}

		FormValidator validator = new FormValidator(in);
		if (validator.validate()) {
			JOptionPane.showMessageDialog(null, msgOK + validator.toString(), title, 1);
			if (MainPanel.getInstance().isRegisterView()) {
				resetComponents(false);
			} else {
				MainFrame.switchView();
			}
		} else {
			JOptionPane.showMessageDialog(null, msgKO, title, 0);
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

	public ArrayList<Object> getData(String query, String columnName) {
		ArrayList<Object> data = new ArrayList<Object>();
		try {
			data = DBController.getInstance().query(query, columnName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
		return data;
	}


	@Override
	public void showTask() {
		System.out.println("TASK BUTTON WORKING");
		
	}






}
