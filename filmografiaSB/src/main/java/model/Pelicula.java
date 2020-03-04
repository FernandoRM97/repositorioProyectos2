package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pelicula {

	@Id
	private int id;
	private String director;
	private String titulo;
	private String fecha;
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Pelicula(int id, String director, String titulo, String fecha, String url) {
		super();
		this.id = id;
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
		this.url = url;
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", titulo=" + titulo + ", fecha=" + fecha + "]";
	}

}
