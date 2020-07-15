package service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.PedidosProductos;

public interface CarritoService {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	public ArrayList<PedidosProductos> carrito() throws ClassNotFoundException, SQLException;
	public void borrarCarrito(String codigo) throws SQLException;
	public void vaciarCarrito() throws SQLException;
}
