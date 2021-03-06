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
@Table(name = "cat_pais", catalog = "admision_ead")
public class CatPais implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private Date fechaCreacion;
	
	private Set<TblDireccion> tblDireccions = new HashSet<TblDireccion>(0);
	

	public CatPais() {
	}

	public CatPais(Long id) {
		this.id = id;
	}

	public CatPais(String nombre, Date fechaCreacion) {
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
	}

	public CatPais(String nombre, String descripcion, Date fechaCreacion, Set<TblDireccion> tblDireccions) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.tblDireccions = tblDireccions;
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

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion", nullable = false, length = 10)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catPais")
	public Set<TblDireccion> getTblDireccion() {
		return this.tblDireccions;
	}

	public void setTblDireccion(Set<TblDireccion> tblDireccions) {
		this.tblDireccions = tblDireccions;
	}

	@Override
	public String toString() {
		return "CatPais [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaCreacion="
				+ fechaCreacion + ", tblDireccions=" + tblDireccions + "]";
	}
}
