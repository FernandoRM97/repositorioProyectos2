package repository;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Productos;

public interface Dao {
	
	ArrayList<Productos> bebidasCon() throws ClassNotFoundException, SQLException;
	ArrayList<Productos> bebidasSin() throws ClassNotFoundException, SQLException;
	ArrayList<Productos> comida() throws ClassNotFoundException, SQLException;

}
