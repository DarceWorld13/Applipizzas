package fr.pizzeria.console;

import java.util.Scanner;

//import Dao.PizzamemDao;
import Dao.TestJDBC;
import fr.pizzeria.exception.DataAccessException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;
import fr.pizzeria.model.Pizza.Pizzahome;
import menuService.AjouterPizzaService;
import menuService.ListerPizzasService;
import menuService.ModifierPizzaService;
import menuService.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {

	public static void main(String args[]) {

		// instancié en créant une nouvelle pizza

		TestJDBC dao = new TestJDBC();

		
		Scanner question = new Scanner(System.in);

		int reponse = 0;
		while (reponse != 99) {

			try {
				
				System.out.println("1.liste des pizzas");
				System.out.println("2.Ajouter une nouvelle pizza");
				System.out.println("3. Mettre à jour une pizza");
				System.out.println("4. Supprimer une pizza");
				System.out.println("99. Sortir");


				System.out.println("veuillez saisir votre choix s'il vous plait ");

				reponse = Integer.parseInt(question.nextLine());

				switch (reponse) {
				case 1:
					ListerPizzasService liste = new ListerPizzasService();
					liste.executeUC(question, dao);

					break;
				case 2:
					AjouterPizzaService service = new AjouterPizzaService();
					try {
						service.executeUC(question, dao);
					} catch (SavePizzaException e) {
						System.err.println(e.getMessage());
					}
					break;

				case 3:
					ModifierPizzaService modif = new ModifierPizzaService();
					try {
						modif.executeUC(question, dao);
					} catch (UpdatePizzaException e) {
						System.err.println(e.getMessage());
					}
					break;

				case 4:
					SupprimerPizzaService suppr = new SupprimerPizzaService();
					try {

						suppr.executeUC(question, dao);
					} catch (Exception e) {

						System.err.println(e.getMessage());
					}
					break;
				case 99:
					System.out.println("Aurevoir ☹");
					break;

				default:
					System.out.println("pas de choix valide ! ");

				}
			}

			catch (DataAccessException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

	}

}
