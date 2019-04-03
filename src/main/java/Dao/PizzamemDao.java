package Dao;

import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;

//on fait hériter notre classe de l'interface PizzaDao; et on génère automatiquement notre méthode d'implémentation

public class PizzamemDao implements PizzaDao {
	
	

	
	
	private Pizza [] tabledepizza;
	
	//on crée notre constructeur 
	
	public PizzamemDao(){
		//on crée un tableau de pizza 
		tabledepizza = new Pizza[20];
		//on remplit le tableau
		tabledepizza[0] = new Pizza(0, "PEP", "pépéronni", 12.5, Categorie.AVEC_VIANDE);
		tabledepizza[1] = new Pizza(1, "MAR", "magherita", 14.00, Categorie.SANS_VIANDE);
		tabledepizza[2] = new Pizza(2, "REI", "reine", 11.5, Categorie.AVEC_VIANDE);
		tabledepizza[3] = new Pizza(3, "FRO", "4 fromages", 12.00, Categorie.SANS_VIANDE);
		tabledepizza[4] = new Pizza(4, "CAN", "cannibale", 10.5, Categorie.AVEC_VIANDE);
		tabledepizza[5] = new Pizza(5, "SAV", "savoyarde", 15.5, Categorie.AVEC_VIANDE);
		tabledepizza[6] = new Pizza(6, "ORI", "orientale", 14.00, Categorie.AVEC_VIANDE);
		tabledepizza[7] = new Pizza(7, "IND", "indienne", 12.3, Categorie.AVEC_VIANDE);
	}
	
	@Override
	public Pizza[] findAllPizzas() {
		// TODO Auto-generated method stub
		return tabledepizza;
	}

	@Override
	public void saveNewPizza(Pizza nvpizza) {
		for (int i= 0; i<tabledepizza.length; i++){
			
			if(tabledepizza[i] == null){
				tabledepizza[i]= nvpizza;
			break;
			}
			
		}
		
	}

	
	//à chaque fois que l'utilisateur met à jour une pizza 
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		for (int j = 0; j < tabledepizza.length; j++) {

			if (tabledepizza[j] != null && codePizza.equals(tabledepizza[j].getCode())) {
				
				tabledepizza[j] = pizza;
				
			}
		}	
		
	}

	@Override
	public void deletePizza(String reponsesupprimer) {
		for (int j = 0; j < tabledepizza.length; j++) {

			if (tabledepizza[j] != null && reponsesupprimer.equals(tabledepizza[j].getCode())) {
				
				tabledepizza[j] = null;
				
			}
		}		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
