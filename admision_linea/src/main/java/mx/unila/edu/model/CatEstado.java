package mx.unila.edu.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cat_estado", catalog = "admision_ead")
public class CatEstado implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	private Date fechaCreacion;
	
	private Set<TblDireccion> tblDireccions = new HashSet<TblDireccion>(0);

	
	public CatEstado() {
	}

	public CatEstado(long id) {
		this.id = id;
	}

	public CatEstado(long id, String nombre, Date fechaCreacion) {
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
	}

	public CatEstado(long id, String nombre, String descripcion, Date fechaCreacion, Set<TblDireccion> tblDireccions) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.tblDireccions = tblDireccions;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catEstado")
	public Set<TblDireccion> getTblDireccions() {
		return this.tblDireccions;
	}

	public void setTblDireccions(Set<TblDireccion> tblDireccions) {
		this.tblDireccions = tblDireccions;
	}

	@Override
	public String toString() {
		return "CatEstado [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaCreacion="
				+ fechaCreacion + ", tblDireccions=" + tblDireccions + "]";
	}

}
