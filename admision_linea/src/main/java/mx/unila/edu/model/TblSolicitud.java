package mx.unila.edu.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_solicitud", catalog = "admision_ead")
public class TblSolicitud implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Date fechaSolicitud;
	
	private Date fechaActualizacion;
	
	private CatEstadoSolicitud catEstadoSolicitud;
	
	private TblUsuario usuario;
	
	private CatOfertaAcademica catOfertaAcademica;

	public TblSolicitud() {
		super();
	}

	public TblSolicitud(Long id) {
		super();
		this.id = id;
	}

	public TblSolicitud(Long id, Date fechaSolicitud, Date fechaActualizacion, CatEstadoSolicitud catEstadoSolicitud,
			TblUsuario usuario, CatOfertaAcademica catOfertaAcademica) {
		super();
		this.id = id;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaActualizacion = fechaActualizacion;
		this.catEstadoSolicitud = catEstadoSolicitud;
		this.usuario = usuario;
		this.catOfertaAcademica = catOfertaAcademica;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_solicitud", nullable = false, length = 10)
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualizacion", nullable = false, length = 10)
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_estado_solicitud", nullable = false)	
	public CatEstadoSolicitud getCatEstadoSolicitud() {
		return catEstadoSolicitud;
	}

	public void setCatEstadoSolicitud(CatEstadoSolicitud catEstadoSolicitud) {
		this.catEstadoSolicitud = catEstadoSolicitud;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_usuario", nullable = false)	
	public TblUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(TblUsuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_oferta_academica", nullable = false)
	public CatOfertaAcademica getCatOfertaAcademica() {
		return catOfertaAcademica;
	}

	public void setCatOfertaAcademica(CatOfertaAcademica catOfertaAcademica) {
		this.catOfertaAcademica = catOfertaAcademica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
