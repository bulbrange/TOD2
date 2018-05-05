package components;

public enum State {
	
	Pendiente("Pendiente"),
	Finalizada("Finalizada");
	
	private final String state;
	
	State(String state){
		this.state = state;
	}

}
