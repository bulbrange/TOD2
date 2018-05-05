package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import command.ButtonDevice;

public class MainFrame extends JFrame {

	//POSITION AND BOUNDS VARAIBLES
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	//VIEWS CONTAINER
	public static JPanel container;
	
	//FUNCTIONALITY
	public static ButtonDevice device;
	
	//SINGLETON
	public static MainFrame frame;
	
	public MainFrame(){
		
		//FRAME CONFIG
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension screen = tool.getScreenSize();
		setBounds(screen.width / 4, screen.height / 5, WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("---Project IC---");
		setBackground(Color.BLACK);
		
		//FUNCTIONALITY INIT
		device = new ButtonDevice();
		
		//VIEWS INIT
		container = new JPanel(new CardLayout());

		//taskView = new TaskPanel();
		
		//add();
		container.add(MainPanel.getInstance());
		container.add(TaskPanel.getInstance());
		
		
		add(container);
		
		//ESTO ES UN TEST PARA GIT
		
	}
	
	public static void switchView(){
		CardLayout cl = (CardLayout)container.getLayout();
		//System.out.println(container.get);
		
		cl.next(container);
	}
	public static MainFrame getInstance(){
		
		if(MainFrame.frame == null){
			MainFrame.frame = new MainFrame();
		}
		return frame;
	}

}
