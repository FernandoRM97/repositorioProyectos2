package service;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RestauranteServiceImpl implements RestauranteService {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	public Integer sacarIdRestaurante(String correo) throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT r.codRes FROM Restaurantes r WHERE r.correo = :correo");
		query.setParameter("correo", correo);

		Integer id = (Integer) query.getSingleResult();

		return id;
	}
}
