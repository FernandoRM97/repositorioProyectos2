package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Usuario;
import service.DaoImpl;

@Controller
@EnableAutoConfiguration
public class SpringBootController {
	
	DaoImpl service = new DaoImpl();

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index2() {

		return "index";
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {

		return "info";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/logearse", method = RequestMethod.POST)
	public String logearse(HttpServletRequest request, HttpServletResponse response) {

		String usuario = request.getParameter("user");
		String clave = request.getParameter("passwd");
		
		System.out.println(usuario);
		System.out.println(clave);

		String pagina;

		try {

			ArrayList<Usuario> lista = new ArrayList<Usuario>();

			lista = service.consultarLogin(usuario, clave);
			
			Usuario u = new Usuario(usuario, clave);

			if (lista.contains(u)) {
				request.setAttribute("nombre", usuario);
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

}