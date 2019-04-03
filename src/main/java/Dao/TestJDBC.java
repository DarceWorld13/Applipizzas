package Dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import fr.pizzeria.exception.DataAccessException;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;

public class TestJDBC implements PizzaDao {

	@Override
	public Pizza[] findAllPizzas() {
		java.util.List<Pizza> pizzas = new ArrayList<>();
		try {
			// Etape 1 - Chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 - Définition de la JDBC URL
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria";
			// Etape 3 - Création de la connexion
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
			// Etape 4 - exécution de la requête
			Statement statem = uneConnexion.createStatement();
			ResultSet results = statem.executeQuery("SELECT * FROM toutes_les_pizzas");
			while (results.next()) {
				int id = results.getInt("id");
				String code = results.getString("code");
				String libelle = results.getString("libelle");
				double prix = results.getDouble("prix");
				String categorie = results.getString("categorie");

				Pizza pizza = new Pizza(id, code, libelle, prix, Categorie.valueOf(categorie));

				pizzas.add(pizza);
			}

		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Problème de chargement du pilote", e);
		} catch (SQLException e) {
			throw new DataAccessException("Problème lors de la communication avec la base de données", e);
		}
		Pizza[] itemsArray = new Pizza[pizzas.size()];
		itemsArray = pizzas.toArray(itemsArray);

		return itemsArray;
	}

	public void saveNewPizza(Pizza pizza) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria";
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
			Statement statem = uneConnexion.createStatement();

			int results = statem.executeUpdate(
					"INSERT INTO toutes_les_pizzas(code, libelle, prix, categorie)  VALUES ('" + pizza.getCode() + "','"
							+ pizza.getLibelle() + "'," + pizza.getPrix() + ",'" + pizza.getCategorie() + "');");

			System.out.println(results + " pizza inséré");

		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Problème de chargement du pilote", e);
		} catch (SQLException e) {
			throw new DataAccessException("Problème lors de la communication avec la base de données", e);
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria";
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
			Statement statem = uneConnexion.createStatement();

			int results = statem.executeUpdate("UPDATE  toutes_les_pizzas SET code = '" + pizza.getCode()
					+ "',libelle='" + pizza.getLibelle() + "',prix =" + pizza.getPrix() + ",categorie='"
					+ pizza.getCategorie() + "' WHERE code =  '" + pizza.getCode() + "'");

			System.out.println(results + " pizza inséré");

		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Problème de chargement du pilote", e);
		} catch (SQLException e) {
			throw new DataAccessException("Problème lors de la communication avec la base de données", e);
		}
	}

	@Override
	public void deletePizza(String codePizza) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria";
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
			Statement statem = uneConnexion.createStatement();

			int results = statem.executeUpdate("DELETE    FROM toutes_les_pizzas WHERE code = '" + codePizza + "'");

			System.out.println(results + " pizza inséré");

		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Problème de chargement du pilote", e);
		} catch (SQLException e) {
			throw new DataAccessException("Problème lors de la communication avec la base de données", e);
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
