package biblioteca.dwf.service;

import biblioteca.dwf.model.Asignatura;
import biblioteca.dwf.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public List<Asignatura> listarTodas() {
        return asignaturaRepository.findAll();
    }

    /**
     * Calcula el promedio de todas las notas de las asignaturas.
     * Si no hay asignaturas, devuelve 0.0.
     */
    public double calcularPromedio() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        if (asignaturas == null || asignaturas.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Asignatura a : asignaturas) {
            suma += a.getNota();
        }
        return suma / asignaturas.size();
    }

    public Asignatura guardar(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public void eliminarPorId(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
