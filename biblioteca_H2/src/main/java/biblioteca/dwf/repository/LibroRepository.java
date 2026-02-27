package biblioteca.dwf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import biblioteca.dwf.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}