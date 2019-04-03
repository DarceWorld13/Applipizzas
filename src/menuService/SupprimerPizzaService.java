package menuService;

import java.util.Scanner;

import Dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;

public class SupprimerPizzaService extends MenuService {

	private Scanner question;

	@Override
	public void executeUC(Scanner scanner, PizzaDao dao) throws DeletePizzaException{
		question = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Supprimer une pizza");
		System.out.println("Quelle est le code de la pizza que vous voulez supprimer ?");
		String reponsesupprimer = question.nextLine();
		
		
		if(!reponsesupprimer.equals("PEP")){
			dao.deletePizza(reponsesupprimer);
		}
		else{
			
				throw new DeletePizzaException("Vous ne pouvez supprimer cette pizza ");
		}
		
		
		

		for (int i = 0; i < dao.findAllPizzas().length; i++) {
			if (dao.findAllPizzas()[i] != null) {
				System.out.println(dao.findAllPizzas()[i].getCode() + "  " + dao.findAllPizzas()[i].getLibelle()
						+ "   " + dao.findAllPizzas()[i].getPrix() + "->>>>" + dao.findAllPizzas()[i].getCategorie());
			}

		}
		
	}

}
