package fr.pizzeria.exception;

public class DeletePizzaException extends StockageException {
	
 public DeletePizzaException(){
		
		super("Vous ne pouvez supprimer cette pizza");
	}
 public DeletePizzaException(String message){
	 
	 super(message);
 }

}
