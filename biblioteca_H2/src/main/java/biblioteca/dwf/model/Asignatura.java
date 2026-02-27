package biblioteca.dwf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asignaturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_materia", nullable = false, length = 150)
    private String nombreMateria;

    @Column(nullable = false)
    private Double nota;

    @Column(nullable = false, length = 30)
    private String ciclo;
}
