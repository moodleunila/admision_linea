package mx.unila.edu.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cat_modalidad", catalog = "admision_ead")
public class CatModalidad implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	private Date fechaCreacion;
	
	private boolean activo;
	
	private Set<CatOfertaAcademica> catOfertaAcademica = new HashSet<CatOfertaAcademica>(0);

	public CatModalidad() {
		super();
	}

	public CatModalidad(long id) {
		super();
		this.id = id;
	}

	public CatModalidad(String nombre, String descripcion, Date fechaCreacion, boolean activo) {
		super();		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}
	
	public CatModalidad(long id, String nombre, String descripcion, Date fechaCreacion, boolean activo,
			Set<CatOfertaAcademica> catOfertaAcademica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
		this.catOfertaAcademica = catOfertaAcademica;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catModalidad")
	public Set<CatOfertaAcademica> getCatOfertaAcademica() {
		return catOfertaAcademica;
	}

	public void setCatOfertaAcademica(Set<CatOfertaAcademica> catOfertaAcademica) {
		this.catOfertaAcademica = catOfertaAcademica;
	}
}
