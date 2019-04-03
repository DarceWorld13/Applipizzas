package fr.pizzeria.exception;

public class SavePizzaException extends StockageException {

	public SavePizzaException() {
		super("Veuillez saisir 3 caractères en majuscule s'il vous plaît ");
	}
	public SavePizzaException(String message) {
		super("Veuillez saisir 3 caractères en majuscule s'il vous plaît ");
	}

}
