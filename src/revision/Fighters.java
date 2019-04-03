package revision;

//l'héritage fighters hérite du nom de sportif 

public class Fighters extends Sportif{

	int wrestling;
	int jiujitsu;
	int kickboxing;
	
	//le toString() 
	/*public String toString(){
		
		return "nom"+nom + "Wresl"+ wrestling ;
		
	}*/
	//constructeur
	public Fighters( String nom , int wrestling, int jiujitsu, int kickboxing) {
		super(nom);
		this.wrestling = wrestling;
		this.jiujitsu = jiujitsu;
		this.kickboxing = kickboxing;
	}
	
	static Fighters mcgregor= new Fighters("Mcgregor",10, 7, 8);
	
	public static void main(String args[]) {
		
		//pour afficher le contenu sans le toString()
	//System.out.println(Sportif.nom + " " + mcgregor.jiujitsu + " " + mcgregor.kickboxing + " " + mcgregor.wrestling);
		
		//pour afficher avec le toString();
		
	//System.out.println(mcgregor);
	

	}

	
	
}

