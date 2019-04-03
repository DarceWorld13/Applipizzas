package fr.pizzeria.model.Pizza;

public class Pizza {
	
	
	//attributs 
	protected int id;
	protected String code;
	protected String libelle;
	protected double prix;
	protected Categorie categorie;

	private static int count=0;
	
	//constructeur
	public Pizza(String code, String libelle, double prix, Categorie categorie) {
		super();
		this.id=count;
		count++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

		//constructeur
		/**
		 * @param id
		 * @param code
		 * @param libelle
		 * @param prix
		 */
		public Pizza(int id, String code, String libelle, double prix, Categorie categorie) {
			super();
			this.id = id;
			this.code = code;
			this.libelle = libelle;
			this.prix = prix;
			this.categorie = categorie;
		}
		
		public String toString(){
			return "id = " + id + " code = " + code + " libelle = " + libelle + " prix = " + prix;
		}
		
	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Pizza.count = count;
	}
	
	
	

	
	
	
	
	
	
	

}
