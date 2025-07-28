# 🚀 Generador de Reportes con Patrón Strategy en Java

Este proyecto implementa el **Patrón de Diseño Strategy** en Java para la generación dinámica de reportes PDF. Desarrollado con **Spring Boot** e **iTextPDF**, permite crear documentos personalizados para diferentes perfiles de usuario (Alumno, Profesor y Director), desacoplando eficientemente la lógica de creación de cada reporte.

---

## ✨ Características Principales

* **Patrón Strategy**: Implementación que separa la lógica de generación de reportes, resultando en un código modular y fácil de mantener.
* **Generación de PDFs Personalizados**: Utiliza **iTextPDF** para crear documentos dinámicos con información relevante para cada tipo de usuario.
* **API RESTful**: Expone *endpoints* claros para la generación de reportes vía **Spring Boot**.
* **Diseño Robusto y Escalable**: Estructura de proyecto organizada para facilitar la comprensión y la escalabilidad.

---

## 🛠️ Tecnologías Utilizadas

* **Java 17**: Lenguaje base del proyecto.
* **Spring Boot**: Para el rápido desarrollo de la API REST.
* **Maven / Gradle**: Sistema de construcción de proyectos.
* **Lombok**: Reduce el código *boilerplate*.
* **iTextPDF 5**: Biblioteca para la generación de documentos PDF.
* **IntelliJ IDEA**: Entorno de desarrollo recomendado.

---

📁 Estructura del Proyecto
src/
 ├─ controller/
 │   ├─ (controladores para cada entidad)
 │   └─ StrategyController.java
 ├─ strategy/
 │   ├─ IReport.java
 │   ├─ ReportFactory.java
 │   ├─ AlumnoStrategy.java
 │   ├─ ProfesorStrategy.java
 │   └─ DirectorStrategy.java
 ├─ entity/
 │   ├─ Alumno.java
 │   ├─ Profesor.java
 │   ├─ Director.java
 │   ├─ Materia.java
 │   ├─ Curso.java
 │   └─ Base.java
 ├─ repository/
 │   └─ (repositorios para cada entidad)
 └─ service/
     └─ (servicios base + personalizados)

---

## 📊 Contenido de Reportes

A continuación, se detalla la información que se incluye en cada tipo de reporte:

* **Alumno**: Muestra nombre, edad, materias que cursa, profesor y curso asociado.
* **Profesor**: Presenta nombre, años de experiencia, materias que imparte, cursos a su cargo y un resumen de alumnos por materia.
* **Director**: Ofrece una visión completa con todos los cursos, las materias de cada curso, los profesores asignados, la cantidad de alumnos por curso y un listado exhaustivo de todos los alumnos de la institución.

---

## 📌 Conclusión

Este proyecto es un recurso valioso para comprender la aplicación práctica del **Patrón Strategy**, demostrando cómo desacoplar comportamientos complejos para lograr una arquitectura de software más **robusta, legible y escalable**. Es una base sólida para cualquier desarrollador que desee profundizar en patrones de diseño y desarrollo de aplicaciones con Spring Boot.
