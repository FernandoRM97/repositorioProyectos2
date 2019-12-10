package filmografia.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import filmografia.model.Pelicula;
import filmografia.model.Usuario;

public class Conexion {

	private static final String URL = "jdbc:oracle:thin:@192.168.1.46:1521:xe";
	private static final String USERNAME = "cine";
	private static final String PASSWORD = "cine";

	public static Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Conexion realizada con exito");
			System.out.println("");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Conexion fallida");
			System.out.println("");
		}
		return connection;
	}

	public static ArrayList<Usuario> consultarLogin(String usuario, String clave)
			throws ClassNotFoundException, SQLException {

		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();

		ResultSet rs = st
				.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE = '" + usuario + "' AND CLAVE = '" + clave + "' ");

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (rs.next()) {
			lista.add(new Usuario(rs.getString("nombre"), rs.getString("clave")));
		}

		return lista;

	}
	
	public static void nuevoUser(String nombre, String clave) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();
		
		String sql = "INSERT INTO USUARIOS VALUES ('" + nombre + "', '" + clave + "')";
		
		st.executeUpdate(sql);
		
	}
	
	public static ArrayList<Pelicula> verPelis() throws ClassNotFoundException, SQLException{
		
		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
		
		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM PELICULA");
		
		while(rs.next()) {
			lista.add(new Pelicula(rs.getString("director"), rs.getString("titulo"), rs.getDate("fecha")));
		}
		
		return lista;
		
	}
	

	/*
	 * 
	 * public static List<Empleado> mostrarEmpleados() throws
	 * ClassNotFoundException, SQLException, DatosNoCorrectosException {
	 * 
	 * Connection connection = null;
	 * 
	 * ArrayList<Empleado> lista = new ArrayList<Empleado>();
	 * 
	 * Class.forName("oracle.jdbc.driver.OracleDriver"); connection =
	 * DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement st =
	 * connection.createStatement(); ResultSet rs =
	 * st.executeQuery("SELECT * FROM EMPLEADOS");
	 * 
	 * while (rs.next()) { lista.add(new Empleado(rs.getString("dni"),
	 * rs.getString("nombre"), rs.getString("sexo").charAt(0),
	 * rs.getInt("categoria"), rs.getInt("anyos"))); }
	 * 
	 * return lista; }
	 * 
	 * public static String mostrarSalarioDni(String dni) {
	 * 
	 * String linea = null;
	 * 
	 * try {
	 * 
	 * Connection connection = null;
	 * 
	 * Class.forName("oracle.jdbc.driver.OracleDriver");
	 * 
	 * connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	 * 
	 * PreparedStatement pst =
	 * connection.prepareStatement("SELECT SUELDO FROM NOMINAS WHERE DNI = ?");
	 * 
	 * pst.setString(1, dni);
	 * 
	 * ResultSet rs = pst.executeQuery();
	 * 
	 * while (rs.next()) {
	 * 
	 * linea = rs.getString(1);
	 * 
	 * }
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException sqle) { sqle.printStackTrace();
	 * System.out.println(); System.out.println(sqle.getMessage());
	 * System.out.println(); System.out.println(sqle.getSQLState());
	 * System.out.println(); System.out.println(sqle.getErrorCode()); }
	 * 
	 * return linea;
	 * 
	 * }
	 * 
	 * public static void modificarEmpleado(String dni, String nombre, char sexo,
	 * int categoria, int anyos) throws ClassNotFoundException, SQLException,
	 * DatosNoCorrectosException {
	 * 
	 * Class.forName("oracle.jdbc.driver.OracleDriver");
	 * 
	 * Connection connection = null;
	 * 
	 * connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	 * 
	 * Statement st = connection.createStatement();
	 * 
	 * st.executeUpdate("UPDATE EMPLEADOS SET NOMBRE = '" + nombre +
	 * "' WHERE DNI = '" + dni + "'");
	 * st.executeUpdate("UPDATE EMPLEADOS SET SEXO = '" + sexo + "' WHERE DNI = '" +
	 * dni + "'"); st.executeUpdate("UPDATE EMPLEADOS SET CATEGORIA = '" + categoria
	 * + "' WHERE DNI = '" + dni + "'");
	 * st.executeUpdate("UPDATE EMPLEADOS SET ANYOS = '" + anyos + "' WHERE DNI = '"
	 * + dni + "'");
	 * 
	 * Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);
	 * 
	 * int sueldo = emp.sueldo();
	 * 
	 * st.executeUpdate("UPDATE NOMINAS SET SUELDO = " + sueldo);
	 * 
	 * st.close(); connection.close(); }
	 * 
	 */

}
