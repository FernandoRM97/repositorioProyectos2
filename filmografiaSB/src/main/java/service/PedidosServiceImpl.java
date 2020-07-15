package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Pedidos;
import model.PedidosProductos;

public class PedidosServiceImpl implements PedidosService {
	
	Connection cn;
	Statement st;
	ResultSet rs;
	String query;
	
	public Integer generarCodPed() throws ClassNotFoundException, SQLException {
		
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT MAX(p.codPed) FROM Pedidos p ");

		Integer id = (Integer) query.getSingleResult();
		
		if (id == null) {
			id = 1;
		} else {
			id = id + 1;
		}
		
		return id;
	}
	
	public void meterEnBd(Pedidos p) throws SQLException {
		
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante2?serverTimezone=UTC", "root", "");
		st = cn.createStatement();
		
		query = "INSERT INTO pedidos VALUES(" + p.getCodPed() + ",'" + p.getFecha() + "'," + p.getEnviado() + "," + p.getCodRes() + ");";
		
		st.executeUpdate(query);
		
		
//		EntityManager entitymanager = emfactory.createEntityManager();
//		entitymanager.getTransaction().begin();
//		
//		entitymanager.persist(p);
//		
//		entitymanager.getTransaction().commit();
		
	}
	
	public void borrarEnBd(PedidosProductos pp) {
		
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Query query = entitymanager.createQuery("DELETE FROM PedidosProductos pp WHERE pp. = :codPedProd ");
		query.setParameter("codPedProd",pp.getCodPedProd());
		
		query.executeUpdate();
		
	}

}
