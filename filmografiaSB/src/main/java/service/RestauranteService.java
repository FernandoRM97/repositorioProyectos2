package service;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface RestauranteService {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	public Integer sacarIdRestaurante(String correo) throws ClassNotFoundException, SQLException;
	
}
