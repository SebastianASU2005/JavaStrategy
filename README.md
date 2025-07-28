# 📄 Generador de Reportes con Patrón Strategy en Java

Este proyecto es una implementación educativa del Patrón de Diseño Strategy en Java, desarrollada con Spring Boot y el generador de PDF iText. Permite generar reportes personalizados para distintos tipos de usuarios: Alumno, Profesor y Director.

---

## 🔧 Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven o Gradle (dependiendo de tu build)
- Lombok
- iTextPDF 5
- IntelliJ IDEA

---

## 🎯 Objetivo

Aplicar el Patrón Strategy para desacoplar la lógica de generación de reportes según el tipo de persona (Alumno, Profesor o Director).
Cada estrategia se encarga de construir su propio documento PDF con información específica.

---

## 📁 Estructura del Proyecto

```plaintext
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
```

## 🧾 Ejemplo de Reportes

🔹 Alumno
Muestra el nombre, edad, materias que cursa, profesor y curso asociado.

🔹 Profesor
Muestra nombre, años de experiencia, materias que dicta, curso y alumnos por materia.

🔹 Director
Muestra todos los cursos, materias de cada curso, profesores y cantidad de alumnos, y finalmente, un listado completo de todos los alumnos.

---

## ▶️ Ejecución del Proyecto

1. Clonar el repositorio:
```bash
git clone https://github.com/PabloLimaDelgado/ejercicio-java-strategy
```
2. Abrí el proyecto con IntelliJ IDEA.
   
4. Ejecutá la clase principal de Spring Boot (con @SpringBootApplication).
   
6. Accedé al endpoint /reports/generatePdf/{id}?tipoPersona=... desde Postman o navegador.

---

## 📌 Conclusión

Este proyecto es una implementación limpia y extensible del patrón Strategy, demostrando cómo separar comportamientos según el contexto, con un ejemplo concreto de generación de reportes PDF.

---

## ✍️ Autor
Pablo Gabriel Lima Delgado

