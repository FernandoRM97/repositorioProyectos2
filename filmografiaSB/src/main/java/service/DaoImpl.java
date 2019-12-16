package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pelicula;
import model.Usuario;
import repository.Dao;

public class DaoImpl implements Dao {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	public ArrayList<Usuario> consultarLogin(String usuario, String clave) throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :usuario AND u.clave = :clave", Usuario.class);
		query.setParameter("usuario", usuario);
		query.setParameter("clave", clave);
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		lista = (ArrayList<Usuario>) query.getResultList();

		return lista;
	}

	public void nuevoUser(String nombre, String clave) throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Usuario usr = new Usuario();
		usr.setId(usr.getId());
		usr.setNombre(nombre);
		usr.setClave(clave);

		entitymanager.persist(usr);
		entitymanager.getTransaction().commit();

		entitymanager.close();

		emfactory.close();

	}

	@Override
	public ArrayList<Pelicula> verPelis() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nuevaPeli(String director, String titulo, String fecha) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarPeli(String director, String titulo, String fecha, String tituloMod)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarPeli(String titulo) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Pelicula> consultarDirector(String director) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashSet<String> listaDirectores() {
		// TODO Auto-generated method stub
		return null;
	}

}
