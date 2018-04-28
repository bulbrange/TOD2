package main;


import view.MainFrame;

public class Main {

	//COMERME LOS HUEVOS
	
	public static void main(String[] args) {
		System.out.println("Opening Main class @ TODO app");
		try{
			MainFrame.getInstance().setVisible(true);
		}catch(Exception e){
			System.out.println("You are trying to open graphic environment...");
		}
		
	}

}
