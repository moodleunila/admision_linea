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
@Table(name = "tbl_contacto", catalog = "admision_ead")
public class TblContacto implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String email;
	
	private String telefonoLocal;
	
	private String telefonoCelular;
	
	private Set<TblUsuario> tblUsuarios = new HashSet<TblUsuario>(0);	
	
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
			Set<TblUsuario> tblUsuarios) {
		super();
		this.id = id;
		this.email = email;
		this.telefonoLocal = telefonoLocal;
		this.telefonoCelular = telefonoCelular;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblContacto")
	public Set<TblUsuario> getTblUsuarios() {
		return this.tblUsuarios;
	}

	public void setTblUsuarios(Set<TblUsuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

	@Override
	public String toString() {
		return "TblContacto [id=" + id + ", email=" + email + ", telefonoLocal=" + telefonoLocal + ", telefonoCelular="
				+ telefonoCelular + ", tblUsuarios=" + tblUsuarios + "]";
	}	
}
