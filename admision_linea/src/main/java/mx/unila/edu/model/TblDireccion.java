package mx.unila.edu.model;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_direccion", catalog = "admision_ead")
public class TblDireccion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String calle;
	
	private String numeroInterno;
	
	private String numeroExterno;
	
	private String colonia;
	
	private String codigoPostal;
	
	private CatEstado catEstado;
	
	private CatPais catPais;
	
	private String ciudadInternacional;
	
	private TblUsuario tblUsuario;
	

	public TblDireccion(Long id, String calle, String numeroInterno, String numeroExterno, String colonia,
			String codigoPostal, CatEstado catEstado, CatPais catPais, String ciudadInternacional) {
		super();
		this.id = id;
		this.calle = calle;
		this.numeroInterno = numeroInterno;
		this.numeroExterno = numeroExterno;
		this.colonia = colonia;
		this.codigoPostal = codigoPostal;
		this.catEstado = catEstado;
		this.catPais = catPais;
		this.ciudadInternacional = ciudadInternacional;
	}

	public TblDireccion(Long id, String calle, String colonia, String codigoPostal, CatEstado catEstado,
			CatPais catPais, String ciudadInternacional, TblUsuario tblUsuario) {
		super();
		this.id = id;
		this.calle = calle;
		this.colonia = colonia;
		this.codigoPostal = codigoPostal;
		this.catEstado = catEstado;
		this.catPais = catPais;
		this.ciudadInternacional = ciudadInternacional;
		this.tblUsuario = tblUsuario;
	}

	public TblDireccion() {
		super();
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
	@JoinColumn(name = "fk_estado_residencia", nullable = false)
	public CatEstado getCatEstado() {
		return this.catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_pais", nullable = false)
	public CatPais getCatPais() {
		return this.catPais;
	}

	public void setCatPais(CatPais catPais) {
		this.catPais = catPais;
	}

	@Column(name = "calle", nullable = false)
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	@Column(name = "numero_interno")
	public String getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(String numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	@Column(name = "numero_externo")
	public String getNumeroExterno() {
		return numeroExterno;
	}

	public void setNumeroExterno(String numeroExterno) {
		this.numeroExterno = numeroExterno;
	}

	@Column(name = "colonia", nullable = false)
	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	@Column(name = "codigo_postal", nullable = false)
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	@Column(name = "ciudad_internacional")
	public String getCiudadInternacional() {
		return ciudadInternacional;
	}

	public void setCiudadInternacional(String ciudadInternacional) {
		this.ciudadInternacional = ciudadInternacional;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "tblDireccion")
	public TblUsuario getTblUsuario() {
		return this.tblUsuario;
	}

	public void setTblUsuario(TblUsuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}

	@Override
	public String toString() {
		return "TblDireccion [id=" + id + ", calle=" + calle + ", numeroInterno=" + numeroInterno + ", numeroExterno="
				+ numeroExterno + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + ", catEstado=" + catEstado
				+ ", catPais=" + catPais + ", tblUsuarios=" + tblUsuario + "]";
	}
}
