package todo;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
import view.MainFrame;
import view.MainPanel;
import view.TaskPanel;

import static org.junit.Assert.*;

import org.junit.Test;

public class ViewTest {

	
	@Test
	public void mainFrameTest() {
		MainFrame f = new MainFrame();
		
		assertNotNull(f);
		assertNotNull(MainFrame.device);
		assertNotNull(MainFrame.container);
		
	}

	@SuppressWarnings("unused")
	@Test
	public void mainPaneltest() {
		MainPanel p = new MainPanel();		
		assertNotNull(p);
		assertNotNull(MainPanel.loginBackground);
		assertNotNull(MainPanel.titleFont);
	 	assertNotNull(p.getLogin());
	 	assertNotNull(p.getRegister());
	 	assertNotNull(p.isLoginView());
	 	assertNotNull(p.isRegisterView());	 	
	}
	
	@Test
	public void taskPanelTest() {
		assertNotNull(TaskPanel.buttonPanel);		

	}

}
