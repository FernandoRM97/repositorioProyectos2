package service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Restaurantes;

public interface LoginService {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	public ArrayList<Restaurantes> consultarLogin(String correo, String clave) throws ClassNotFoundException, SQLException;
}
