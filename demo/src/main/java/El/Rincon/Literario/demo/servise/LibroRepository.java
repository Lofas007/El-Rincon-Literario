package El.Rincon.Literario.demo.servise;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libros, Long> {
    List<Libros> findByIdioma(String idioma);
}

