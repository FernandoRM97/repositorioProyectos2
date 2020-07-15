package service;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.PedidosProductos;

public interface ProductosService {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");

	public Integer generarCodPedProd() throws ClassNotFoundException, SQLException;
	public Integer sacarCodProd(String nombre) throws ClassNotFoundException, SQLException;
	public void meterEnBd(PedidosProductos pp);
	public String sacarNombre(Integer codigo);

}
