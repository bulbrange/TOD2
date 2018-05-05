package todo;

import static org.junit.Assert.*;

import org.junit.Test;

import command.ButtonDevice;
import command.ButtonPattern;

public class CommandTest {

	public void buttonDeviceTest() {
				ButtonDevice p = new ButtonDevice();
				assertNotNull(p);
		}
	
	
	@Test
	public void buttonPattern() {
		assertNotNull(ButtonPattern.WIDTH);
		assertNotNull(ButtonPattern.HEIGHT);
		
	}
	
	

}
