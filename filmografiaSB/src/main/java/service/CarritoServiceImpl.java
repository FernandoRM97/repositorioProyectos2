package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.PedidosProductos;

public class CarritoServiceImpl implements CarritoService {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");
	
	Connection cn;
	Statement st;
	ResultSet rs;
	String query;

	@SuppressWarnings("unchecked")
	public ArrayList<PedidosProductos> carrito() throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT pp FROM PedidosProductos pp");

		ArrayList<PedidosProductos> lista = new ArrayList<PedidosProductos>();

		lista = (ArrayList<PedidosProductos>) query.getResultList();

		return lista;
	}

	public void borrarCarrito(String codigo) throws SQLException {
		
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante2?serverTimezone=UTC", "root", "");
		st = cn.createStatement();
		
		query = "DELETE FROM PedidosProductos WHERE CodPedProd = '" + codigo + "' ;";
		
		st.executeUpdate(query);
		
	}
	
	public void vaciarCarrito() throws SQLException {
		
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante2?serverTimezone=UTC", "root", "");
		st = cn.createStatement();
		
		query = "DELETE FROM PedidosProductos;";
		
		st.executeUpdate(query);
		
	}
	

}
