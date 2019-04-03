package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException {
	public UpdatePizzaException(){
		
		super("Une pizza à ce prix est très cher");
	}
	public UpdatePizzaException(String message){
		super(message);
	}

}
