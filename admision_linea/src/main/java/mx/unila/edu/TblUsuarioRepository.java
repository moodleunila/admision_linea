package mx.unila.edu;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.unila.edu.model.TblUsuario;

public interface TblUsuarioRepository extends JpaRepository<TblUsuario, Long>{
	
	TblUsuario findByUsername(String username);

}
