package biblioteca.dwf.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import biblioteca.dwf.model.Libro;
import  biblioteca.dwf.repository.LibroRepository;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin
@RequiredArgsConstructor
public class LibroController {

    private final LibroRepository libroRepository;

    @GetMapping
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @PostMapping
    public Libro guardar(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setId(id);
        return libroRepository.save(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }
}