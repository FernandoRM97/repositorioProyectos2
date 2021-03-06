package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.PersonaDAO;
import model.Persona;

@ManagedBean
public class PersonaMB {
	private Persona persona;
	private PersonaDAO personaDAO;
	private List<Persona> Lista;

	public PersonaMB() {
		personaDAO = new PersonaDAO();
		persona = new Persona();

		Lista = personaDAO.listarTodos();
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getList() {
		return this.Lista;
	}

	public void salvar() {
		personaDAO.salvar(persona);
		addMessage("Guardado exitoso!!");
		persona = new Persona();
		Lista = personaDAO.listarTodos();

	}
	
	public void excluir(){
		personaDAO.excluir(persona);
		addMessage("Borrado exitoso!!");
		Lista = personaDAO.listarTodos();
	}
	
	public void modificar(){
		personaDAO.modificar(persona);
		addMessage("Modificaste exitosamente!!");
		Lista = personaDAO.listarTodos();
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage("messages", message);
	}
}
