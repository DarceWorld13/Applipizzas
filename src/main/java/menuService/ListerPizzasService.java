package menuService;

import java.util.Scanner;

import Dao.PizzaDao;

public class ListerPizzasService extends MenuService {
	

      
	@Override
	public
	void executeUC (Scanner question, PizzaDao dao) {
		
		System.out.println("liste des pizzas");

		for (int i = 0; i < dao.findAllPizzas().length; i++) {

			if (dao.findAllPizzas()[i] != null) {
				System.out.println(dao.findAllPizzas()[i].getCode() + "->" + dao.findAllPizzas()[i].getLibelle()
						+ " " + dao.findAllPizzas()[i].getPrix() + dao.findAllPizzas()[i].getCategorie());
			}

		}

		
		
	}
		


}