package mx.unila.edu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.unila.edu.model.TblUsuario;

public interface TblUsuarioRepository extends JpaRepository<TblUsuario, Long>{
	
	TblUsuario findByUsername(String username);

}
