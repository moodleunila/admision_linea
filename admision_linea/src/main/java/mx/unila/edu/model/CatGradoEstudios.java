package mx.unila.edu.model;
//Generated 17/09/2018 12:02:24 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* CatGradoEstudios generated by hbm2java
*/
@Entity
@Table(name="cat_grado_estudios",catalog="admision_ead")
public class CatGradoEstudios  implements java.io.Serializable {


  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Long id;
  private String nombre;
  private String descripcion;
  private boolean activo;
  private Set<TblUsuario> tblUsuarios = new HashSet<TblUsuario>(0);

 public CatGradoEstudios() {
 }
 
 public CatGradoEstudios(Long id) {
	 this.id = id;
 }

	
 public CatGradoEstudios(String nombre, boolean activo) {
     this.nombre = nombre;
     this.activo = activo;
 }
 public CatGradoEstudios(String nombre, String descripcion, boolean activo, Set<TblUsuario> tblUsuarios) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.activo = activo;
    this.tblUsuarios = tblUsuarios;
 }

  @Id @GeneratedValue(strategy=IDENTITY)

 
 @Column(name="id", unique=true, nullable=false)
 public Long getId() {
     return this.id;
 }
 
 public void setId(Long id) {
     this.id = id;
 }

 
 @Column(name="nombre", nullable=false)
 public String getNombre() {
     return this.nombre;
 }
 
 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 
 @Column(name="descripcion")
 public String getDescripcion() {
     return this.descripcion;
 }
 
 public void setDescripcion(String descripcion) {
     this.descripcion = descripcion;
 }

 
 @Column(name="activo", nullable=false)
 public boolean isActivo() {
     return this.activo;
 }
 
 public void setActivo(boolean activo) {
     this.activo = activo;
 }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catGradoEstudios")
 public Set<TblUsuario> getTblUsuarios() {
     return this.tblUsuarios;
 }
 
 public void setTblUsuarios(Set<TblUsuario> tblUsuarios) {
     this.tblUsuarios = tblUsuarios;
 }




}

