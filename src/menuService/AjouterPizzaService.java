package menuService;

import java.util.Scanner;
import Dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner question, PizzaDao dao) throws SavePizzaException {
		
		System.out.println("Ajout d’une nouvelle pizza");

		System.out.println("Veuillez saisir le code :");
		String reponseCode = question.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace):");
		String reponseNom = question.nextLine();
		System.out.println("Veuillez saisir le prix:");
		String reponsePrix = question.nextLine();
		double prix = Double.parseDouble(reponsePrix);
		System.out.println("votre pizza est elle 1 pour AVEC_VIANDE ou 2 pour SANS_VIANDE ?");
		
		String avecOuSansViande = question.nextLine();
		
		if(avecOuSansViande.equals("1")){
			
			dao.saveNewPizza(new Pizza(reponseCode, reponseNom, prix, Categorie.AVEC_VIANDE));
		}
		
		if (avecOuSansViande.equals("2")){
			
			dao.saveNewPizza(new Pizza(reponseCode, reponseNom, prix, Categorie.SANS_VIANDE));
		}
			if(!reponseCode.equals(reponseCode.toUpperCase())){
				throw new SavePizzaException();
		
			}
			
		

		System.out.println("liste des pizzas");
		
		for (int i = 0; i < dao.findAllPizzas().length; i++) {

			if (dao.findAllPizzas()[i] != null) {
				System.out.println(dao.findAllPizzas()[i].getCode() + "->" + dao.findAllPizzas()[i].getLibelle()
						+ " " + dao.findAllPizzas()[i].getPrix()+ "->>>>" + dao.findAllPizzas()[i].getCategorie());
			}

		}

		
	}
	}



