package mx.unila.edu.model;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_formacion_academica", catalog = "admision_ead")
public class TblFormacionAcademica implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CatGradoEstudios catGradoEstudios;
	
	private String institucion;
	
	private String documentoObtenido;
	
	private String nombre;
	
	private TblUsuario tblUsuario;
	
	public TblFormacionAcademica() {
		super();
	}	
	
	public TblFormacionAcademica(Long id, CatGradoEstudios catGradoEstudios, String institucion,
			String documentoObtenido, String nombre) {
		super();
		this.id = id;
		this.catGradoEstudios = catGradoEstudios;
		this.institucion = institucion;
		this.documentoObtenido = documentoObtenido;
		this.nombre = nombre;
	}

	public TblFormacionAcademica(Long id, CatGradoEstudios catGradoEstudios, String institucion,
			String documentoObtenido, String nombre, TblUsuario tblUsuario) {
		super();
		this.id = id;
		this.catGradoEstudios = catGradoEstudios;
		this.institucion = institucion;
		this.documentoObtenido = documentoObtenido;
		this.nombre = nombre;
		this.tblUsuario = tblUsuario;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_usuario", nullable = false)
	public TblUsuario getTblUsuario() {
		return this.tblUsuario;
	}

	public void setTblUsuario(TblUsuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}
	
	@Column(name = "institucion")
	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "documento_obtenido")
	public String getDocumentoObtenido() {
		return this.documentoObtenido;
	}

	public void setDocumentoObtenido(String documentoObtenido) {
		this.documentoObtenido = documentoObtenido;
	}	
	
}