package Grups;

public class Alumne {
	private String id;
	
	public Alumne(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Alumne [id=" + id + "]\n";
	}
	
	
}
