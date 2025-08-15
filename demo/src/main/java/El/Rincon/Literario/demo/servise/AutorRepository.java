package El.Rincon.Literario.demo.servise;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByAnioNacimientoBeforeAndAnioFallecimientoAfter(int año, int año2);
    List<Autor> findByAnioFallecimientoIsNullOrAnioFallecimientoGreaterThan(int año);
}
