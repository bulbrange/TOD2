package todo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Test;

import controller.DBController;
import controller.FormValidator;

import org.junit.Test;

import controller.FormValidator;

public class ControllerTest {

	
		@Test
		public void test() {
			
			JPasswordField repass = new JPasswordField();
			repass.setName("Re-Password:");
			repass.setText("1234");
			JPasswordField pass = new JPasswordField();
			pass.setName("Password:");
			pass.setText("1235");
			
			ArrayList<JTextField> inputs = new ArrayList<JTextField>();
			inputs.add(pass);
			inputs.add(repass);
			
			FormValidator validator = new FormValidator(inputs);
			System.out.println(validator.validateRegister());
			
			for(JTextField p : inputs){
				System.out.println("TEST INPUTS : " + p.getText());
			}
			
			System.out.println("Same ");
			assertTrue(validator.validateRegister());
		}
		
		@Test
		public void Formtest() {
				JTextField j1 = new JTextField();
				j1.setName("E-Mail:");
				j1.setText("PeppeterlovesJander");
				JTextField j2 = new JTextField();
				j2.setName("Password:");
				j2.setText("1234");		
				JTextField j3 = new JTextField();
				j3.setName("User:");
				j3.setText("PeppeterlovesJander");
				JTextField j4 = new JTextField();
				j4.setName("Re-Password:");
				j4.setText("1234");					
				ArrayList<JTextField> paco = new ArrayList<JTextField>();
				paco.add(j1);
				paco.add(j2);
				paco.add(j3);
				paco.add(j4);
				FormValidator f = new FormValidator(paco);
				assertTrue(f.validateRegister());
				
				/*ArrayList<JTextField> antonio = new ArrayList<JTextField>();
				antonio.add(j1);
				antonio.add(j2);				
				FormValidator f2 = new FormValidator(antonio);				
				assertTrue(f.validateUser());*/
			}
		
		
		/*@Test
		public void DBcontrollerTest() throws Exception {
			String clumnMail = "Mail";
			String qSelectPers = "SELECT" + clumnMail + "FROM Persona" ;
			assertNotNull(DBController.getInstance().query(qSelectPers, clumnMail));
						
		}*/
		
		/*@Test
		public void DBcontrollerTest2() throws Exception {
			String clumnMail = "Email";
			String qSelectPers = "SELECT Email FROM Persona" ;
			assertNotNull(DBController.getInstance().query(qSelectPers, clumnMail));
						
		}*/
		
		
		
}


