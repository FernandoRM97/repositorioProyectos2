package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public String director;
	public String titulo;
	public Date fecha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Pelicula(String director, String titulo, Date fecha) {
		super();
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", titulo=" + titulo + ", fecha=" + fecha + "]";
	}

}
