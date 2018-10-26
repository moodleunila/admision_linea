package mx.unila.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "rel_usuario_rol", catalog = "admision_ead")
public class RelUsuarioRol implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CatRol catRol;
	
	private TblUsuario tblUsuario;
	
	private boolean activo;
	

	public RelUsuarioRol() {
	}

	public RelUsuarioRol(CatRol catRol, TblUsuario tblUsuario, boolean activo) {
		this.catRol = catRol;
		this.tblUsuario = tblUsuario;
		this.activo = activo;
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
	@JoinColumn(name = "fk_rol", nullable = false)
	public CatRol getCatRol() {
		return this.catRol;
	}

	public void setCatRol(CatRol catRol) {
		this.catRol = catRol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_usuario", nullable = false)
	public TblUsuario getTblUsuario() {
		return this.tblUsuario;
	}

	public void setTblUsuario(TblUsuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "RelUsuarioRol [id=" + id + ", catRol=" + catRol + ", tblUsuario=" + tblUsuario + ", activo=" + activo
				+ "]";
	}

}
