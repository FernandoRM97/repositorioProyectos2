package repository;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Productos;

public class DaoImpl implements Dao {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	@SuppressWarnings("unchecked")
	public ArrayList<Productos> bebidasSin() throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT p FROM Productos p WHERE p.categoria = :categoria ");
		query.setParameter("categoria", 2);

		ArrayList<Productos> lista = new ArrayList<Productos>();

		lista = (ArrayList<Productos>) query.getResultList();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Productos> bebidasCon() throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT p FROM Productos p WHERE p.categoria = :categoria ");
		query.setParameter("categoria", 1);

		ArrayList<Productos> lista = new ArrayList<Productos>();

		lista = (ArrayList<Productos>) query.getResultList();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Productos> comida() throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT p FROM Productos p WHERE p.categoria = :categoria ");
		query.setParameter("categoria", 3);

		ArrayList<Productos> lista = new ArrayList<Productos>();

		lista = (ArrayList<Productos>) query.getResultList();

		return lista;
	}

}
