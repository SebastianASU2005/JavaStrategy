🚀 Generador de Reportes con Patrón Strategy en Java
Este proyecto demuestra una implementación práctica y educativa del Patrón de Diseño Strategy en Java. Desarrollado con Spring Boot e iTextPDF, permite generar reportes PDF personalizados para diferentes perfiles de usuario: Alumno, Profesor y Director, desacoplando eficientemente la lógica de creación de documentos.

✨ Características Destacadas
Implementación del Patrón Strategy: Separa la lógica de generación de reportes, haciendo el código más modular y fácil de mantener.

Generación de PDFs Personalizados: Utiliza iTextPDF para crear documentos dinámicos con información relevante para cada tipo de usuario.

API RESTful con Spring Boot: Expone endpoints claros para la generación de reportes.

Estructura de Proyecto Limpia: Organizado para facilitar la comprensión y la escalabilidad.

🛠️ Tecnologías Utilizadas
Java 17: La base del proyecto.

Spring Boot: Para el rápido desarrollo de la aplicación web y la API REST.

Maven o Gradle: Sistema de construcción de proyectos (elige el de tu preferencia).

Lombok: Reduce el código boilerplate.

iTextPDF 5: Biblioteca para la generación de documentos PDF.

IntelliJ IDEA: Entorno de desarrollo recomendado.

🎯 Objetivo Pedagógico
El principal objetivo de este proyecto es ilustrar cómo el Patrón Strategy permite desacoplar comportamientos (en este caso, la generación de reportes) del contexto que los utiliza. Cada "estrategia" (Alumno, Profesor, Director) encapsula la lógica específica para construir su propio documento PDF con información detallada, demostrando una solución extensible y mantenible.

📁 Estructura del Proyecto
Plaintext

src/
 ├─ controller/          # Endpoints REST para la generación de reportes
 │   ├─ (controladores específicos si los hay)
 │   └─ StrategyController.java
 ├─ strategy/            # Implementación del Patrón Strategy
 │   ├─ IReport.java       # Interfaz de la estrategia (contrato común)
 │   ├─ ReportFactory.java # Fábrica para obtener la estrategia correcta
 │   ├─ AlumnoStrategy.java
 │   ├─ ProfesorStrategy.java
 │   └─ DirectorStrategy.java
 ├─ entity/              # Modelos de datos del dominio
 │   ├─ Alumno.java
 │   ├─ Profesor.java
 │   ├─ Director.java
 │   ├─ Materia.java
 │   ├─ Curso.java
 │   └─ Base.java          # Clase base para entidades
 ├─ repository/          # Capa de acceso a datos (Spring Data JPA)
 │   └─ (repositorios específicos para cada entidad)
 └─ service/             # Lógica de negocio y servicios
      └─ (servicios base + personalizados)
📊 Ejemplos de Contenido de Reportes
A continuación, se detalla la información que se incluye en cada tipo de reporte:

🔹 Alumno: Muestra el nombre, edad, materias que cursa, profesor y curso asociado.

🔹 Profesor: Presenta el nombre, años de experiencia, materias que dicta, cursos a su cargo y un resumen de alumnos por materia.

🔹 Director: Ofrece una visión completa con todos los cursos, las materias de cada curso, los profesores asignados, la cantidad de alumnos por curso y un listado exhaustivo de todos los alumnos de la institución.

▶️ Ejecución del Proyecto
Sigue estos pasos para poner en marcha el proyecto:

Clonar el repositorio:

Bash

git clone https://github.com/SebastianASU2005/JavaStrategy # Asegúrate de usar tu propio enlace aquí
Abrir con un IDE: Importa el proyecto en tu IDE favorito (como IntelliJ IDEA).

Ejecutar la aplicación: Ejecuta la clase principal de Spring Boot (la que tiene la anotación @SpringBootApplication).

Acceder a la API: Utiliza herramientas como Postman o tu navegador web para acceder al endpoint de generación de reportes:

GET /reports/generatePdf/{id}?tipoPersona=...
Reemplaza {id} con el ID de la persona.

Reemplaza ... en tipoPersona con ALUMNO, PROFESOR o DIRECTOR.

Ejemplo: http://localhost:8080/reports/generatePdf/1?tipoPersona=ALUMNO

📌 Conclusión
Este proyecto es un excelente recurso para comprender la aplicación del Patrón Strategy en un contexto real, mostrando cómo se pueden desacoplar y organizar comportamientos complejos de manera efectiva, resultando en un código más robusto, legible y fácil de escalar.