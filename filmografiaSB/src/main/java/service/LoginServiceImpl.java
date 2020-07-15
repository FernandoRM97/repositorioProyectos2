package service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Restaurantes;

public class LoginServiceImpl implements LoginService {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	@SuppressWarnings("unchecked")
	public ArrayList<Restaurantes> consultarLogin(String correo, String clave) throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager
				.createQuery("SELECT r FROM Restaurantes r WHERE r.correo = :correo AND r.clave = :clave ");
		query.setParameter("correo", correo);
		query.setParameter("clave", clave);

		ArrayList<Restaurantes> lista = new ArrayList<Restaurantes>();

		lista = (ArrayList<Restaurantes>) query.getResultList();

		return lista;
	}
}
