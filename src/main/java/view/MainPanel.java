package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import components.LoginForm;
import components.RegisterForm;


public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//VISUAL CONTENT
	public static Image loginBackground;
	public static Font titleFont = new Font("Eras Bold ITC",Font.BOLD,30);
	
	//VIEW COMPONENTS
	private LoginForm login;
	private RegisterForm register;
	
	//VIEW STATE BOOLEANS
	private boolean loginView;
	private boolean registerView;
	
	//SINGLETON
	public static MainPanel mainPanel;
	
	public MainPanel(){
		setLayout(null);
		try{
			loginBackground = ImageIO.read(ClassLoader.getSystemClassLoader().getResourceAsStream("mainbackground2.jpg"));
		}catch(Exception e){
			System.out.println("Imagen no encontrada");
		}
		login = new LoginForm(this);
		register= new RegisterForm(this);
		
		loginView = true;
		registerView = false;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(loginView) login.show(g);
		else if(registerView) register.show(g);
	}

	public static MainPanel getInstance(){
		if(MainPanel.mainPanel == null){
			MainPanel.mainPanel = new MainPanel();
		}
		return MainPanel.mainPanel;
	}
	
	public void setViews(boolean mainView, boolean registerView){
		this.loginView = mainView;
		this.registerView = registerView;
	}

	public RegisterForm getRegister() {
		return register;
	}

	public void setRegister(RegisterForm register) {
		this.register = register;
	}

	public LoginForm getLogin() {
		return login;
	}

	public void setLogin(LoginForm login) {
		this.login = login;
	}

	public boolean isLoginView() {
		return loginView;
	}

	public void setLoginView(boolean mainView) {
		this.loginView = mainView;
	}

	public boolean isRegisterView() {
		return registerView;
	}

	public void setRegisterView(boolean registerView) {
		this.registerView = registerView;
	}
}
