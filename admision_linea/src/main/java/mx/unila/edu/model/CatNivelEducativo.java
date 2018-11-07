package mx.unila.edu.model;

import static javax.persistence.GenerationType.IDENTITY;

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
@Table(name = "cat_nivel_educativo", catalog = "admision_ead")
public class CatNivelEducativo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nombre;
	
	private String descripcion;	
	
	private boolean activo;
	
	private Set<CatOfertaAcademica> catOfertaAcademica = new HashSet<CatOfertaAcademica>(0);
	
	public CatNivelEducativo() {
		super();
	}

	public CatNivelEducativo(String nombre, String descripcion, boolean activo) {
		super();		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public CatNivelEducativo(String nombre, String descripcion, boolean activo,
			Set<CatOfertaAcademica> catOfertaAcademica) {
		super();		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.catOfertaAcademica = catOfertaAcademica;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catNivelEducativo")
	public Set<CatOfertaAcademica> getCatOfertaAcademica() {
		return this.catOfertaAcademica;
	}

	public void setCatOfertaAcademica(Set<CatOfertaAcademica> catOfertaAcademica) {
		this.catOfertaAcademica = catOfertaAcademica;
	}

}
