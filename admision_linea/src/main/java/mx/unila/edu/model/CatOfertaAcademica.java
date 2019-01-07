package mx.unila.edu.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonView;
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
	
	public interface Basico{}
	
	private static final long serialVersionUID = 1L;
	
	@JsonView(Basico.class)
	private Long id;
	
	@JsonView(Basico.class)
	private String nombre;
	
	@JsonView(Basico.class)
	private String descripcion;
	
	@JsonView(Basico.class)
	private boolean activo;
	
	private CatNivelEducativo catNivelEducativo;
	
	private CatModalidad catModalidad;
	
	private Set<TblSolicitud> tblSolicitudes = new HashSet<TblSolicitud>(0);

	public CatOfertaAcademica() {
		super();
	}

	public CatOfertaAcademica(Long id) {
		super();
		this.id = id;
	}
	
	public CatOfertaAcademica(String nombre, String descripcion, boolean activo) {
		super();		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public CatOfertaAcademica(String nombre, String descripcion, boolean activo,
			CatNivelEducativo catNivelEducativo, CatModalidad catModalidad) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.catNivelEducativo = catNivelEducativo;
		this.catModalidad = catModalidad;
	}
	
	public CatOfertaAcademica(String nombre, String descripcion, boolean activo,
			CatNivelEducativo catNivelEducativo, CatModalidad catModalidad, Set<TblSolicitud> tblSolicitudes) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.catNivelEducativo = catNivelEducativo;
		this.catModalidad = catModalidad;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_modalidad", nullable = false)
	public CatModalidad getCatModalidad() {
		return this.catModalidad;
	}

	public void setCatModalidad(CatModalidad catModalidad) {
		this.catModalidad = catModalidad;
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
