package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import buttons.ExitButton;
import command.ButtonPattern;
import components.TaskButtonPanel;
import components.TextPanePanel;
import listeners.ButtonListener;

public class TaskPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//TEXT AREA
	private TextPanePanel description;
	public static final int DESCRIPTION_TOPOFFSET = 50;
	
	//EXIT BUTTOn
	private ExitButton exit;
	private ArrayList<ButtonPattern> buttons;
	private ButtonListener listener;
	
	//BUTTON PANEL
	public static TaskButtonPanel buttonPanel;

	private Image background;
	
	
	//SINGLETON
	private static TaskPanel panel;
	
	public TaskPanel(){
		
		try {
			background = ImageIO.read(new File("img/taskbackground.jpg"));
		} catch (IOException e) {System.out.println("Image not found @ TASK PANEL");}
		
		setLayout(null);
		//setVisible(false);
		
		//COMPONENTS
		description = new TextPanePanel();
		description.setBounds(MainFrame.WIDTH/2, TaskPanel.DESCRIPTION_TOPOFFSET, MainFrame.WIDTH/2 - 20, MainFrame.HEIGHT - 150);
		
		buttonPanel = new TaskButtonPanel();
		buttonPanel.setBounds(0,MainFrame.HEIGHT - 80, MainFrame.WIDTH, 200);
		
		add(description);
		add(buttonPanel);
		
		//EXIT BUTTON
		exit = new ExitButton("Exit",MainFrame.WIDTH -120,10,MainFrame.device,this);
		buttons = new ArrayList<ButtonPattern>();
		buttons.add(exit);
		listener = new ButtonListener(buttons);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		g.setColor(Color.YELLOW);
		g.setFont(MainPanel.titleFont);
		g.drawString("To Do", MainFrame.WIDTH / 2 - 80, 35);
	}
	
	public static TaskPanel getInstance(){
		
		if(TaskPanel.panel == null){
			TaskPanel.panel = new TaskPanel();
		}
		return TaskPanel.panel;
	}
}
