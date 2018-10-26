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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_usuario", catalog = "admision_ead")
public class TblUsuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;	
	
	private String nombre;
	
	private String APaterno;
	
	private String AMaterno;
	
	private String curp;
	
	private String rfc;
	
	private String genero;
	
	private Date fechaNacimiento;
	
	private boolean activo;
	
	private TblDireccion tblDireccion;
	
	private TblContacto tblContacto;
	
	private TblFormacionAcademica tblFormacionAcademica;
	
	private Set<RelUsuarioRol> relUsuarioRols = new HashSet<RelUsuarioRol>(0);

	public TblUsuario() {
		super();
	}	

	public TblUsuario(Long id, String nombre, String aPaterno, String aMaterno, String curp, String rfc, String genero,
			Date fechaNacimiento, boolean activo, TblDireccion tblDireccion, TblContacto tblcontacto,
			TblFormacionAcademica tblFormacionAcademica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.APaterno = aPaterno;
		this.AMaterno = aMaterno;
		this.curp = curp;
		this.rfc = rfc;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
		this.tblDireccion = tblDireccion;
		this.tblContacto = tblcontacto;
		this.tblFormacionAcademica = tblFormacionAcademica;
	}

	public TblUsuario(Long id, String nombre, String aPaterno, String aMaterno, String curp, String rfc, String genero,
			Date fechaNacimiento, boolean activo, TblDireccion tblDireccion, TblContacto tblcontacto,
			TblFormacionAcademica tblFormacionAcademica, Set<RelUsuarioRol> relUsuarioRols) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.APaterno = aPaterno;
		this.AMaterno = aMaterno;
		this.curp = curp;
		this.rfc = rfc;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
		this.tblDireccion = tblDireccion;
		this.tblContacto = tblcontacto;
		this.tblFormacionAcademica = tblFormacionAcademica;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tbl_contacto", nullable = false)
	public TblContacto getTblContacto() {
		return this.tblContacto;
	}

	public void setTblContacto(TblContacto tblContacto) {
		this.tblContacto = tblContacto;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tbl_direccion", nullable = false)
	public TblDireccion getTblDireccion() {
		return this.tblDireccion;
	}

	public void setTblDireccion(TblDireccion tblDireccion) {
		this.tblDireccion = tblDireccion;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tbl_formacion_academica", nullable = false)
	public TblFormacionAcademica getTblFormacionAcademica() {
		return this.tblFormacionAcademica;
	}

	public void setTblFormacionAcademica(TblFormacionAcademica tblFormacionAcademica) {
		this.tblFormacionAcademica = tblFormacionAcademica;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "a_paterno", nullable = false)
	public String getAPaterno() {
		return this.APaterno;
	}

	public void setAPaterno(String APaterno) {
		this.APaterno = APaterno;
	}

	@Column(name = "a_materno", nullable = false)
	public String getAMaterno() {
		return this.AMaterno;
	}

	public void setAMaterno(String AMaterno) {
		this.AMaterno = AMaterno;
	}

	@Column(name = "curp", nullable = false)
	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	@Column(name = "rfc", nullable = false)
	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Column(name = "genero", nullable = false)
	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento", nullable = false, length = 10)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblUsuario")
	public Set<RelUsuarioRol> getRelUsuarioRols() {
		return this.relUsuarioRols;
	}

	public void setRelUsuarioRols(Set<RelUsuarioRol> relUsuarioRols) {
		this.relUsuarioRols = relUsuarioRols;
	}
}
