package mx.unila.edu.model;
// Generated 17/09/2018 12:02:24 PM by Hibernate Tools 4.3.1


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

/**
 * TblUsuario generated by hbm2java
 */
@Entity
@Table(name="tbl_usuario",catalog="admision_ead")
public class TblUsuario  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
     private CatEstado catEstado;
     private CatGradoEstudios catGradoEstudios;
     private CatPais catPais;
     private String nombre;
     private String APaterno;
     private String AMaterno;
     private String email;
     private String curp;
     private String rfc;
     private String genero;
     private Date fechaNacimiento;
     private String telefonoLocal;
     private String telefonoCelular;
     private String universidadOrigen;
     private String tituloLicenciatura;
     private boolean activo;
     private Set<RelUsuarioRol> relUsuarioRols = new HashSet<RelUsuarioRol>(0);

    public TblUsuario() {
    }

	
    public TblUsuario(CatEstado catEstado, CatGradoEstudios catGradoEstudios, CatPais catPais, String nombre, String APaterno, String AMaterno, String email, String curp, String rfc, String genero, Date fechaNacimiento, String telefonoLocal, boolean activo) {
        this.catEstado = catEstado;
        this.catGradoEstudios = catGradoEstudios;
        this.catPais = catPais;
        this.nombre = nombre;
        this.APaterno = APaterno;
        this.AMaterno = AMaterno;
        this.email = email;
        this.curp = curp;
        this.rfc = rfc;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.telefonoLocal = telefonoLocal;
        this.activo = activo;
    }
    public TblUsuario(CatEstado catEstado, CatGradoEstudios catGradoEstudios, CatPais catPais, String nombre, String APaterno, String AMaterno, String email, String curp, String rfc, String genero, Date fechaNacimiento, String telefonoLocal, String telefonoCelular, String universidadOrigen, String tituloLicenciatura, boolean activo, Set<RelUsuarioRol> relUsuarioRols) {
       this.catEstado = catEstado;
       this.catGradoEstudios = catGradoEstudios;
       this.catPais = catPais;
       this.nombre = nombre;
       this.APaterno = APaterno;
       this.AMaterno = AMaterno;
       this.email = email;
       this.curp = curp;
       this.rfc = rfc;
       this.genero = genero;
       this.fechaNacimiento = fechaNacimiento;
       this.telefonoLocal = telefonoLocal;
       this.telefonoCelular = telefonoCelular;
       this.universidadOrigen = universidadOrigen;
       this.tituloLicenciatura = tituloLicenciatura;
       this.activo = activo;
       this.relUsuarioRols = relUsuarioRols;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_estado_residencia", nullable=false)
    public CatEstado getCatEstado() {
        return this.catEstado;
    }
    
    public void setCatEstado(CatEstado catEstado) {
        this.catEstado = catEstado;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_grado_estudios", nullable=false)
    public CatGradoEstudios getCatGradoEstudios() {
        return this.catGradoEstudios;
    }
    
    public void setCatGradoEstudios(CatGradoEstudios catGradoEstudios) {
        this.catGradoEstudios = catGradoEstudios;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_pais", nullable=false)
    public CatPais getCatPais() {
        return this.catPais;
    }
    
    public void setCatPais(CatPais catPais) {
        this.catPais = catPais;
    }
    
  

    
    @Column(name="nombre", nullable=false)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="a_paterno", nullable=false)
    public String getAPaterno() {
        return this.APaterno;
    }
    
    public void setAPaterno(String APaterno) {
        this.APaterno = APaterno;
    }

    
    @Column(name="a_materno", nullable=false)
    public String getAMaterno() {
        return this.AMaterno;
    }
    
    public void setAMaterno(String AMaterno) {
        this.AMaterno = AMaterno;
    }

    
    @Column(name="email", nullable=false)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="curp", nullable=false)
    public String getCurp() {
        return this.curp;
    }
    
    public void setCurp(String curp) {
        this.curp = curp;
    }

    
    @Column(name="rfc", nullable=false)
    public String getRfc() {
        return this.rfc;
    }
    
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    
    @Column(name="genero", nullable=false)
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_nacimiento", nullable=false, length=10)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
    @Column(name="telefono_local", nullable=false, length=50)
    public String getTelefonoLocal() {
        return this.telefonoLocal;
    }
    
    public void setTelefonoLocal(String telefonoLocal) {
        this.telefonoLocal = telefonoLocal;
    }

    
    @Column(name="telefono_celular", length=50)
    public String getTelefonoCelular() {
        return this.telefonoCelular;
    }
    
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    
    @Column(name="universidad_origen")
    public String getUniversidadOrigen() {
        return this.universidadOrigen;
    }
    
    public void setUniversidadOrigen(String universidadOrigen) {
        this.universidadOrigen = universidadOrigen;
    }

    
    @Column(name="titulo_licenciatura")
    public String getTituloLicenciatura() {
        return this.tituloLicenciatura;
    }
    
    public void setTituloLicenciatura(String tituloLicenciatura) {
        this.tituloLicenciatura = tituloLicenciatura;
    }

    
    @Column(name="activo", nullable=false)
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tblUsuario")
    public Set<RelUsuarioRol> getRelUsuarioRols() {
        return this.relUsuarioRols;
    }
    
    public void setRelUsuarioRols(Set<RelUsuarioRol> relUsuarioRols) {
        this.relUsuarioRols = relUsuarioRols;
    }




}

