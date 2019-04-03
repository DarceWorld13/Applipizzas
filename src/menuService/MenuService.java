package menuService;

import java.util.Scanner;

import Dao.PizzaDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {

	
	
	public abstract void executeUC(Scanner scanner, PizzaDao pizzaDao) throws StockageException;

	void executeUC(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}
	
		
	
}
