package mx.unila.edu.model;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_contacto", catalog = "admision_ead")
public class TblContacto implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String email;
	
	private String telefonoLocal;
	
	private String telefonoCelular;
	
	private TblUsuario tblUsuario;	
	
	public TblContacto() {
		super();
	}

	public TblContacto(Long id, String email, String telefonoLocal, String telefonoCelular) {
		super();
		this.id = id;
		this.email = email;
		this.telefonoLocal = telefonoLocal;
		this.telefonoCelular = telefonoCelular;
	}

	public TblContacto(Long id, String email, String telefonoLocal, String telefonoCelular,
			TblUsuario tblUsuario) {
		super();
		this.id = id;
		this.email = email;
		this.telefonoLocal = telefonoLocal;
		this.telefonoCelular = telefonoCelular;
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
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "telefono_local", nullable = false, length = 50)
	public String getTelefonoLocal() {
		return this.telefonoLocal;
	}

	public void setTelefonoLocal(String telefonoLocal) {
		this.telefonoLocal = telefonoLocal;
	}

	@Column(name = "telefono_celular", length = 50)
	public String getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "tblContacto")
	public TblUsuario getTblUsuario() {
		return this.tblUsuario;
	}

	public void setTblUsuario(TblUsuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}

	@Override
	public String toString() {
		return "TblContacto [id=" + id + ", email=" + email + ", telefonoLocal=" + telefonoLocal + ", telefonoCelular="
				+ telefonoCelular + ", tblUsuario=" + tblUsuario + "]";
	}	
}