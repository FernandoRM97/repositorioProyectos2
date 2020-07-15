package service;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.PedidosProductos;

public class ProductosServiceImpl implements ProductosService {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	public Integer generarCodPedProd() throws ClassNotFoundException, SQLException {
		
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT MAX(pp.codPedProd) FROM PedidosProductos pp ");

		Integer id = (Integer) query.getSingleResult();
		
		if (id == null) {
			id = 1;
		} else {
			id = id + 1;
		}
		
		System.out.println("ID " + id);
		
		return id;
	}
	
	public Integer sacarCodProd(String nombre) throws ClassNotFoundException, SQLException {
		
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT p.codProd FROM Productos p WHERE p.nombre = :nombre ");
		query.setParameter("nombre", nombre);
		
		Integer cod = (Integer) query.getResultList().get(0);
		
		return cod;
	}

	public void meterEnBd(PedidosProductos pp) {
		
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		entitymanager.persist(pp);
		
		entitymanager.getTransaction().commit();
		
	}

	public String sacarNombre(Integer codigo) {
		
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Query query = entitymanager.createQuery("SELECT p.nombre FROM Productos p WHERE p.codProd = :cod");
		query.setParameter("cod", codigo);
		
		String nombre = (String) query.getResultList().get(0);
		
		return nombre;
	}

}
