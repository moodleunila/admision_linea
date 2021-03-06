package mx.unila.edu.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cat_rol", catalog = "admision_ead")
public class CatRol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private String descripcion;
	
	private boolean activo;
	
	private Set<RelUsuarioRol> relUsuarioRols = new HashSet<RelUsuarioRol>(0);
	

	public CatRol() {
	}	

	public CatRol(String nombre, Date fechaCreacion, boolean activo) {
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}

	public CatRol(String nombre, Date fechaCreacion, String descripcion, boolean activo,
			Set<RelUsuarioRol> relUsuarioRols) {
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.descripcion = descripcion;
		this.activo = activo;
		this.relUsuarioRols = relUsuarioRols;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion", nullable = false, length = 10)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catRol")
	public Set<RelUsuarioRol> getRelUsuarioRols() {
		return this.relUsuarioRols;
	}

	public void setRelUsuarioRols(Set<RelUsuarioRol> relUsuarioRols) {
		this.relUsuarioRols = relUsuarioRols;
	}

	@Override
	public String toString() {
		return "CatRol [id=" + id + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", descripcion="
				+ descripcion + ", activo=" + activo + ", relUsuarioRols=" + relUsuarioRols + "]";
	}

}
