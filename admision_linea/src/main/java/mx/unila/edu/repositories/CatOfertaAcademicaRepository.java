package mx.unila.edu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import mx.unila.edu.model.CatOfertaAcademica;

public interface CatOfertaAcademicaRepository extends JpaRepository<CatOfertaAcademica, Long>{
	
	@Query("SELECT o FROM CatOfertaAcademica o where o.catModalidad.id = :id")
	List<CatOfertaAcademica> findByAllActivo(@Param("id") Long id);

}
