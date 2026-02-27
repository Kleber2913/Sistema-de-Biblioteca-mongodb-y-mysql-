# Documento de Validación - Historial Académico

*(Entregar en PDF o Word con tus propias palabras. Respuestas idénticas entre compañeros anularán la nota.)*

---

## 1. Tu Lógica de Negocio: Cálculo del promedio

*Explica cómo calculaste el promedio de tus notas en la capa de Servicio.*

**Ejemplo de redacción (adaptar a tu código):**  
En la capa de servicio (`AsignaturaService`) el promedio se calcula obteniendo todas las asignaturas desde el repositorio, sumando sus notas en un acumulador y dividiendo esa suma entre la cantidad de materias. Si no hay asignaturas, se devuelve 0.0 para evitar división por cero.

---

## 2. Análisis de Inyección

*¿Qué beneficio encontraste al inyectar el Repositorio en el Servicio mediante el constructor en lugar de hacerlo de forma manual con `new`?*

**Ideas que puedes desarrollar:**  
- El contenedor de Spring se encarga de crear una sola instancia del repositorio y reutilizarla (control de ciclo de vida).  
- Facilita las pruebas unitarias: en los tests puedes inyectar un “mock” del repositorio.  
- No acoplamos el servicio a una implementación concreta; podemos cambiar la implementación sin tocar el servicio.

---

## 3. Comportamiento de Perfiles

*Describe qué sucede con tus notas cuando cierras la aplicación en perfil dev vs. cuando la cierras en perfil prod.*

- **Perfil dev:** La base de datos H2 está en memoria (`jdbc:h2:mem:...`). Al cerrar la aplicación, la base se destruye y **todas las notas se pierden**. Cada vez que inicias en dev, se crea la base de nuevo y se ejecuta `import.sql` con las 5 materias iniciales.  
- **Perfil prod:** La base está en un archivo en disco (`jdbc:h2:file:./data/historial_academico`). Al cerrar la aplicación, **los datos se conservan** en la carpeta `data/`. Al volver a iniciar con perfil prod, las notas siguen ahí.

**Cómo alternar perfiles:**  
- En `application.properties`: `spring.profiles.active=dev` o `spring.profiles.active=prod`.  
- O al ejecutar: `--spring.profiles.active=prod` (por línea de comandos o en la IDE).

---

## 4. Uso de Lombok

*Identifica qué anotaciones usaste en tu entidad y por qué facilitan el desarrollo.*

En la entidad `Asignatura` se usan:

- **@Getter y @Setter:** Generan los métodos get y set de todos los campos; no hay que escribirlos a mano.  
- **@NoArgsConstructor y @AllArgsConstructor:** Generan el constructor vacío (requerido por JPA) y el constructor con todos los campos.  
- **@Builder:** Permite crear objetos con estilo builder (`Asignatura.builder().nombreMateria("...").nota(15).build()`), lo que hace el código más legible.  
- **@Entity y @Table:** Son de JPA, no de Lombok; definen la entidad y el nombre de la tabla.

En conjunto, Lombok reduce código repetitivo (boilerplate) y mantiene la entidad más clara.

---

## 5. Capturas de pantalla del programa corriendo

*Incluir al menos:*

1. Aplicación iniciada (consola con perfil activo: dev o prod).  
2. Resultado de `GET http://localhost:8080/api/asignaturas` (lista de materias).  
3. Resultado de `GET http://localhost:8080/api/asignaturas/promedio` (promedio calculado).  
4. (Opcional) Consola H2 en `http://localhost:8080/h2-console` mostrando la tabla `asignaturas`.

---

*Recuerda personalizar las materias y notas en `src/main/resources/import.sql` con tus datos reales o estimados para cumplir el criterio de autenticidad (20% de la rúbrica).*
