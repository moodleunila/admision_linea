package mx.unila.edu.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cat_oferta_educativa", catalog = "admision_ead")
public class CatOfertaAcademica implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private boolean activo;
	
	private CatNivelEducativo catNivelEducativo;
	
	private Set<TblSolicitud> tblSolicitudes = new HashSet<TblSolicitud>(0);

	public CatOfertaAcademica() {
		super();
	}

	public CatOfertaAcademica(String nombre, String descripcion, boolean activo) {
		super();		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public CatOfertaAcademica(String nombre, String descripcion, boolean activo,
			CatNivelEducativo catNivelEducativo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.catNivelEducativo = catNivelEducativo;		
	}
	
	public CatOfertaAcademica(String nombre, String descripcion, boolean activo,
			CatNivelEducativo catNivelEducativo, Set<TblSolicitud> tblSolicitudes) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.catNivelEducativo = catNivelEducativo;
		this.tblSolicitudes = tblSolicitudes;
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

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_nivel_educativo", nullable = false)
	public CatNivelEducativo getCatNivelEducativo() {
		return this.catNivelEducativo;
	}

	public void setCatNivelEducativo(CatNivelEducativo catNivelEducativo) {
		this.catNivelEducativo = catNivelEducativo;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catOfertaAcademica")
	public Set<TblSolicitud> getTblSolicitudes() {
		return tblSolicitudes;
	}

	public void setTblSolicitudes(Set<TblSolicitud> tblSolicitudes) {
		this.tblSolicitudes = tblSolicitudes;
	}

	@Override
	public String toString() {
		return "CatOfertaAcademica [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", activo="
				+ activo + "]";
	}
}
