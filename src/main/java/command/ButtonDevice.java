package command;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import components.Task;
import components.TaskButtonPanel;
import components.TextPanePanel;
import components.User;
import controller.DBController;
import controller.FormValidator;
import view.MainFrame;
import view.MainPanel;
import view.TaskPanel;

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
	
	
	public void createTask(User user) {
		System.out.println("BUTTON CREATE WOOOOOORKING");
		try{
			String title = getInput("Insert title please:");
			String description = getInput("Insert description please:");
			String date_init = getInput("Insert starting date please (YYYY-MM-DD):");
			String date_end = getInput("Insert ending date please(YYYY-MM-DD):");
			
			DBController.getInstance().insertIntoTarea(user.getID(), title, description, date_init, date_end);
			//AKI
			updateView(user);
			
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Operation cancelled", "Operation cancelled", 0);
		}
	}
	
	public void deleteTask(User user) {
		for(int i = 0; i < user.getTasks().size(); i++){
			if(user.getTasks().get(i).isSelected()){
				int answer = JOptionPane.showConfirmDialog(null, "Do you want to remove the task?");
				System.out.println(answer);
				//DBController.getInstance().removeFromTarea(user.getTasks().get(i).getID());
				break;
			}
		}
		//updateView(user);
		
	}

	
	public void finishTask() {
		System.out.println("FINISH TASK WORKING");
		
	}

	
	public void modifyTask() {
		System.out.println("MODIFY TASK WORKING");
		
	}
	
	public void exitView() {
		cleanView(TaskPanel.user);
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
	public void showTask(Task task) {
		TextPanePanel.area.setText("");
		TextPanePanel.area.setText(task.getTitle()+"\tESTADO:  " + task.getState() +"\n\n");
		TextPanePanel.area.setText(TextPanePanel.area.getText() + "FECHA DE INICIO: " + task.getStart() + "\n");
		TextPanePanel.area.setText(TextPanePanel.area.getText() + "FECHA DE FIN: " + task.getEnd() + "\n\n");
		TextPanePanel.area.setText(TextPanePanel.area.getText() + "DESCRIPCION:\n\n");
		TextPanePanel.area.setText(TextPanePanel.area.getText() + task.getDescription() + "\n");
		User u = task.getDisplayInfo().getUser();
		for(int i = 0; i < u.getTasks().size(); i++){
			if(u.getTasks().get(i) == task) u.getTasks().get(i).getDisplayInfo().setBackground(Color.GREEN);
			else u.getTasks().get(i).getDisplayInfo().setBackground(Color.GRAY);
			
		}
		
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
	private String getInput(String title){
		
		String input = "";
		
			while(input.equals("")){
				input = JOptionPane.showInputDialog(null, title);
				if(input.equals("")) JOptionPane.showMessageDialog(null, "Can�t handle empty input...", "Task creation failure", 0);
				if(title.contains("date")){
					if (!input.matches("\\d{4}-\\d{2}-\\d{2}")) {
						JOptionPane.showMessageDialog(null, "Wrong date regex, must be (YYYY-MM-DD)", "Task creation failure", 0);
						input = "";
					}
				}
	
			}
		
		return input;
		
	}
	private void updateView(User user){
		for(int i = 0; i < user.getTasks().size(); i++){
			TaskPanel.getInstance().remove(user.getTasks().get(i).getDisplayInfo());
		}
		user.setTasks();
		TaskPanel.getInstance().repaint();
	}

	private void cleanView(User user){
		TextPanePanel.area.setText("");

		for(int i = 0; i < user.getTasks().size(); i++){
			TaskPanel.getInstance().remove(user.getTasks().get(i).getDisplayInfo());
		}
	}
}
