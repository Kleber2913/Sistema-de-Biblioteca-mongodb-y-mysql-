package biblioteca.dwf;

import biblioteca.dwf.model.Asignatura;
import biblioteca.dwf.service.AsignaturaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class AsignaturaServiceTest {

    @Autowired
    private AsignaturaService asignaturaService;

    @Test
    @DisplayName("La lista de materias no debe ser nula")
    void listaDeMateriasNoEsNula() {
        List<Asignatura> asignaturas = asignaturaService.listarTodas();
        assertNotNull(asignaturas, "La lista de asignaturas no debe ser nula");
    }

    @Test
    @DisplayName("El cálculo del promedio en el Service debe ser correcto")
    void calculoDelPromedioEsCorrecto() {
        // Con import.sql: 14.5 + 15.0 + 13.0 + 16.0 + 14.0 = 72.5 / 5 = 14.5
        double promedio = asignaturaService.calcularPromedio();
        assertEquals(14.5, promedio, 0.01,
                "El promedio de las 5 materias (14.5, 15, 13, 16, 14) debe ser 14.5");
    }
}
