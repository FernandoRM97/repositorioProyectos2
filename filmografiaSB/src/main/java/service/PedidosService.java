package service;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pedidos;
import model.PedidosProductos;

public interface PedidosService {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	public Integer generarCodPed() throws ClassNotFoundException, SQLException;
	public void meterEnBd(Pedidos p) throws SQLException;
	public void borrarEnBd(PedidosProductos pp) throws SQLException;
}
