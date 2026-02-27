package biblioteca.dwf.controller;

import biblioteca.dwf.model.Asignatura;
import biblioteca.dwf.service.AsignaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/asignaturas")
@CrossOrigin
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @GetMapping
    public List<Asignatura> listar() {
        return asignaturaService.listarTodas();
    }

    @GetMapping("/promedio")
    public ResponseEntity<Map<String, Double>> obtenerPromedio() {
        double promedio = asignaturaService.calcularPromedio();
        return ResponseEntity.ok(Map.of("promedio", promedio));
    }

    @PostMapping
    public Asignatura guardar(@RequestBody Asignatura asignatura) {
        return asignaturaService.guardar(asignatura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        asignaturaService.eliminarPorId(id);
    }
}
