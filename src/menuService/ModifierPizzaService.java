package menuService;

import java.util.Scanner;

import Dao.PizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;

public class ModifierPizzaService extends MenuService{


	Scanner question = new Scanner(System.in);
	@Override
	public void executeUC(Scanner scanner, PizzaDao dao) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		System.out.println("Mettre à jour une pizza");

		System.out.println("Quelle est le code de la pizza que vous voulez modifier ?");
		String reponsemodif = question.nextLine();

		for (int i = 0; i < dao.findAllPizzas().length; i++) {

			if (dao.findAllPizzas()[i] != null && reponsemodif.equals(dao.findAllPizzas()[i].getCode())) {

				System.out.println(dao.findAllPizzas()[i].getCode());

				System.out.println("Veuillez saisir le code :");
				String reponseCode2 = question.nextLine();
				System.out.println("Veuillez saisir le nom (sans espace):");
				String reponseNom2 = question.nextLine();
				System.out.println("Veuillez saisir le prix:");
				String reponsePrix2 = question.nextLine();
				double prix2 = Double.parseDouble(reponsePrix2);
				
				System.out.println("votre pizza est elle 1 pour AVEC_VIANDE ou 2 pour SANS_VIANDE ?");
				
				String avecOuSans = question.nextLine();
				
				if(avecOuSans.equals("1")){
					
					dao.updatePizza(reponsemodif, new Pizza(reponseCode2, reponseNom2, prix2, Categorie.AVEC_VIANDE));
				}
				
				if(avecOuSans.equals("2")){
				
					dao.updatePizza(reponsemodif, new Pizza(reponseCode2, reponseNom2, prix2, Categorie.SANS_VIANDE));
					
				}
				
				
				if(prix2>20){
					
				throw new UpdatePizzaException("Une pizza à ce prix est très cher");
				}
				
				
				
				
				System.out.println(dao.findAllPizzas()[i].getCode() + "  " + dao.findAllPizzas()[i].getLibelle()
						+ "   " + dao.findAllPizzas()[i].getPrix() + "->>>>>>>"+dao.findAllPizzas()[i].getCategorie());
			}
		}
		
		
		
	}}
