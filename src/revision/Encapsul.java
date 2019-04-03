package revision;

public class Encapsul {

	//on met nos attributs en private 
	
	private int nb=20;
	private String test= "85";
	
	
	//le constructeur 
	public Encapsul(int nb, String test) {
		super();
		this.nb = nb;
		this.test = test;
	}
	
	
	//les getters et setters
	public int getNb() {
		return nb +89;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
	
}
