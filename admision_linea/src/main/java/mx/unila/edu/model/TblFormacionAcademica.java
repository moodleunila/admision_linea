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
@Table(name = "tbl_formacion_academica", catalog = "admision_ead")
public class TblFormacionAcademica implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CatGradoEstudios catGradoEstudios;
	
	private String universidadOrigen;
	
	private String tituloLicenciatura;
	
	private Set<TblUsuario> tblUsuarios = new HashSet<TblUsuario>(0);
	
	public TblFormacionAcademica() {
		super();
	}

	public TblFormacionAcademica(Long id, CatGradoEstudios catGradoEstudios, String universidadOrigen,
			String tituloLicenciatura) {
		super();
		this.id = id;
		this.catGradoEstudios = catGradoEstudios;
		this.universidadOrigen = universidadOrigen;
		this.tituloLicenciatura = tituloLicenciatura;
	}
	
	public TblFormacionAcademica(Long id, CatGradoEstudios catGradoEstudios, String universidadOrigen,
			String tituloLicenciatura, Set<TblUsuario> tblUsuarios) {
		super();
		this.id = id;
		this.catGradoEstudios = catGradoEstudios;
		this.universidadOrigen = universidadOrigen;
		this.tituloLicenciatura = tituloLicenciatura;
		this.tblUsuarios = tblUsuarios;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_grado_estudios", nullable = false)
	public CatGradoEstudios getCatGradoEstudios() {
		return this.catGradoEstudios;
	}

	public void setCatGradoEstudios(CatGradoEstudios catGradoEstudios) {
		this.catGradoEstudios = catGradoEstudios;
	}
	
	@Column(name = "universidad_origen")
	public String getUniversidadOrigen() {
		return this.universidadOrigen;
	}

	public void setUniversidadOrigen(String universidadOrigen) {
		this.universidadOrigen = universidadOrigen;
	}

	@Column(name = "titulo_licenciatura")
	public String getTituloLicenciatura() {
		return this.tituloLicenciatura;
	}

	public void setTituloLicenciatura(String tituloLicenciatura) {
		this.tituloLicenciatura = tituloLicenciatura;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblFormacionAcademica")
	public Set<TblUsuario> getTblUsuarios() {
		return this.tblUsuarios;
	}

	public void setTblUsuarios(Set<TblUsuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

}
