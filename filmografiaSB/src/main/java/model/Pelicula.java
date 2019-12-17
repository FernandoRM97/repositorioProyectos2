package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pelicula {

	@Id
	private int id;
	public String director;
	public String titulo;
	public String fecha;

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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha2) {
		this.fecha = fecha2;
	}

	public Pelicula() {
		super();
	}

	public Pelicula(String director, String titulo, String fecha) {
		super();
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
	}

	public Pelicula(int id, String director, String titulo, String fecha) {
		super();
		this.id = id;
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", titulo=" + titulo + ", fecha=" + fecha + "]";
	}

}
