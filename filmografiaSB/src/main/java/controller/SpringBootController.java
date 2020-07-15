package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Email;
import model.Pedidos;
import model.PedidosProductos;
import model.Productos;
import model.Restaurantes;
import repository.DaoImpl;
import service.CarritoServiceImpl;
import service.LoginServiceImpl;
import service.PedidosServiceImpl;
import service.ProductosServiceImpl;
import service.RestauranteServiceImpl;

@Controller
@EnableAutoConfiguration
public class SpringBootController {

	DaoImpl service = new DaoImpl();
	LoginServiceImpl serviceLogin = new LoginServiceImpl();
	RestauranteServiceImpl serviceRestaurante = new RestauranteServiceImpl();
	ProductosServiceImpl serviceProducto = new ProductosServiceImpl();
	PedidosServiceImpl servicePedido = new PedidosServiceImpl();
	CarritoServiceImpl serviceCarrito = new CarritoServiceImpl();
	
	String correo = "testrestaurante1212@gmail.com";
	
	Integer id = null;
	ArrayList<PedidosProductos> carrito = new ArrayList<PedidosProductos>();

	@GetMapping(value = "")
	public String index() {

		return "index";
	}

	@GetMapping(value = "/index")
	public String index2() {

		return "index";
	}

	@GetMapping(value = "/info")
	public String info() {

		return "info";
	}

	@GetMapping(value = "/login")
	public String login() {

		return "login";
	}

	@PostMapping(value = "/loguearse")
	public String loguearse(HttpServletRequest request) {

		String correo = request.getParameter("user");
		String clave = request.getParameter("passwd");

		String pagina;

		try {

			ArrayList<Restaurantes> lista = new ArrayList<Restaurantes>();

			lista = serviceLogin.consultarLogin(correo, clave);

			if (lista.get(0).getCorreo().equals(correo) && lista.get(0).getClave().equals(clave)) {
				request.setAttribute("correo", correo);
				
				id = serviceRestaurante.sacarIdRestaurante(correo);
				
				pagina = "loginCorrecto";
			} else {
				pagina = "loginIncorrecto";

			}

		} catch (ClassNotFoundException e) {
			pagina = "loginIncorrecto";
		} catch (SQLException e) {
			pagina = "loginIncorrecto";
		} catch (IndexOutOfBoundsException e) {
			pagina = "loginIncorrecto";
		}

		return pagina;
	}

	@GetMapping(value = "/loginCorrecto")
	public String loginCorrecto() {

		return "loginCorrecto";
	}

	@GetMapping(value = "/bebidasCon")
	public String bebidasCon(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		ArrayList<Productos> lista = new ArrayList<Productos>();

		lista = service.bebidasCon();

		request.setAttribute("bebidas", lista);
		
		return "bebidasCon";
	}
	
	@GetMapping(value = "/bebidasSin")
	public String bebidasSin(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		ArrayList<Productos> lista = new ArrayList<Productos>();

		lista = service.bebidasSin();

		request.setAttribute("bebidas", lista);
		
		return "bebidasSin";
	}
	
	@GetMapping(value = "/comida")
	public String comida(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		ArrayList<Productos> lista = new ArrayList<Productos>();

		lista = service.comida();

		request.setAttribute("comida", lista);
		
		System.out.println(id);
		
		return "comida";
	}
	
	
	@RequestMapping(value = "/comprarCon", method= { RequestMethod.GET, RequestMethod.POST })
	public String comprarCon(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		String nombre = request.getParameter("nombre");
		Integer unidades = Integer.parseInt(request.getParameter("comprar"));
		Integer codProd = serviceProducto.sacarCodProd(nombre);
		Integer codPed = id;
		Integer codPedProd = serviceProducto.generarCodPedProd(); 
		
		PedidosProductos pp = new PedidosProductos();
		pp.setCodPedProd(codPedProd);
		pp.setPedido(codPed);
		pp.setProducto(codProd);
		pp.setUnidades(unidades);
		
		try {
			Pedidos p = new Pedidos();
			p.setCodPed(servicePedido.generarCodPed());
			p.setFecha("10-03-2020");
			p.setEnviado(0);
			p.setCodRes(id);
			
			servicePedido.meterEnBd(p);
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		
		serviceProducto.meterEnBd(pp);
		
		return "redirect:bebidasCon";
	}
	
	@RequestMapping(value = "/comprarSin", method= { RequestMethod.GET, RequestMethod.POST })
	public String comprarSin(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		String nombre = request.getParameter("nombre");
		Integer unidades = Integer.parseInt(request.getParameter("comprar"));
		Integer codProd = serviceProducto.sacarCodProd(nombre);
		Integer codPed = id;
		Integer codPedProd = serviceProducto.generarCodPedProd(); 
		
		PedidosProductos pp = new PedidosProductos();
		pp.setCodPedProd(codPedProd);
		pp.setPedido(codPed);
		pp.setProducto(codProd);
		pp.setUnidades(unidades);
		
		try {
			Pedidos p = new Pedidos();
			p.setCodPed(servicePedido.generarCodPed());
			p.setFecha("10-03-2020");
			p.setEnviado(0);
			p.setCodRes(id);
			
			servicePedido.meterEnBd(p);
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		
		serviceProducto.meterEnBd(pp);
		
		return "redirect:bebidasSin";
	}
	
	@RequestMapping(value = "/comprarComida", method= { RequestMethod.GET, RequestMethod.POST })
	public String comprarComida(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		String nombre = request.getParameter("nombre");
		Integer unidades = Integer.parseInt(request.getParameter("comprar"));
		Integer codProd = serviceProducto.sacarCodProd(nombre);
		Integer codPed = id;
		Integer codPedProd = serviceProducto.generarCodPedProd(); 
		
		PedidosProductos pp = new PedidosProductos();
		pp.setCodPedProd(codPedProd);
		pp.setPedido(codPed);
		pp.setProducto(codProd);
		pp.setUnidades(unidades);
		
		try {
			Pedidos p = new Pedidos();
			p.setCodPed(servicePedido.generarCodPed());
			p.setFecha("10/03/2020");
			p.setEnviado(0);
			p.setCodRes(id);
			
			servicePedido.meterEnBd(p);
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		
		serviceProducto.meterEnBd(pp);
		
		return "redirect:comida";
	}
	
	@RequestMapping(value = "/carrito", method= { RequestMethod.GET, RequestMethod.POST })
	public String carrito(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		ArrayList<PedidosProductos> lista = new ArrayList<PedidosProductos>();
		
		lista= serviceCarrito.carrito();
		
		request.setAttribute("carrito", lista);
		
		return "carrito";
	}
	
	
	@GetMapping(value = "/pedido")
	public String pedido(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		Email em = new Email();
		
		em.enviarCorreo(correo);
		serviceCarrito.vaciarCarrito();
		
		return "pedido";
	}
	
	@PostMapping(value = "/borrarCarrito")
	public String borrarCarrito(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		String codigo = request.getParameter("codigo");
		
		serviceCarrito.borrarCarrito(codigo);
		
		return "redirect:carrito";
	}
	
	
	

}