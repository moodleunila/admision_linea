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
@Table(name = "cat_estado_solicitud", catalog = "admision_ead")
public class CatEstadoSolicitud implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String descripcion;
	
	private Date fechaCreacion;
	
	private String nombre;
	
	private Set<TblSolicitud> tblSolicitudes = new HashSet<TblSolicitud>(0);

	public CatEstadoSolicitud() {
		super();
	}
	
	public CatEstadoSolicitud(Long id) {
		super();
		this.id = id;
	}

	public CatEstadoSolicitud(Long id, String descripcion, Date fechaCreacion, String nombre) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.nombre = nombre;
	}
	
	

	public CatEstadoSolicitud(Long id, String descripcion, Date fechaCreacion, String nombre,
			Set<TblSolicitud> tblSolicitudes) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.nombre = nombre;
		this.tblSolicitudes = tblSolicitudes;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion", nullable = false, length = 10)
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catEstadoSolicitud")
	public Set<TblSolicitud> getTblSolicitudes() {
		return tblSolicitudes;
	}

	public void setTblSolicitudes(Set<TblSolicitud> tblSolicitudes) {
		this.tblSolicitudes = tblSolicitudes;
	}	
}
