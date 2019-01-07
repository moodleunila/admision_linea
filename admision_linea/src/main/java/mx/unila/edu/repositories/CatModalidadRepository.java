package mx.unila.edu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.unila.edu.model.CatModalidad;

public interface CatModalidadRepository extends JpaRepository<CatModalidad, Long>{
	
	@Query("select m from CatModalidad m where m.activo = true")
	List<CatModalidad> findByAllActivo();
	
}