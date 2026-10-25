# Gestión de Incidencias de un centro educativo

Aplicación de consola en Java desarrollada para la consulta y gestión eficiente de incidencias de soporte técnico en un centro educativo. Este proyecto permite registrar, clasificar y realizar el seguimiento del estado de peticiones de soporte informático en un entorno escolar.

---

## Información del Proyecto

- **Nombre del proyecto:** Gestión de Incidencias de Soporte Técnico
- **Finalidad:** Proporcionar una solución sencilla por consola para que el personal del centro pueda realizar el seguimiento de averías, solicitudes de material o problemas técnicos de las aulas.
- **Versión de Java requerida:** Java 25
- **Gestor de dependencias / construcción:** Apache Maven 4.0.0

---

## Funcionalidades Principales

- **Registro de Incidencias:** Alta de nuevas incidencias indicando título, descripción, ubicación y nivel de prioridad.
- **Consulta y Listado:** Visualización del listado completo de incidencias.
- **Búsqueda:** Búsqueda de incidencias concretas por identificador y mostrar detalle.

---

## Compilación y Ejecución

Puedes compilar y ejecutar el proyecto mediante Maven desde la terminal.

### Usando Maven instalado en el sistema

```bash
# Limpiar y compilar el proyecto
mvn clean compile

# Compilar y ejecutar la aplicación de consola
mvn clean compile exec:java
```

### Usando el Maven Wrapper integrado

**En PowerShell / CMD:**
```cmd
.\mvnw.cmd clean compile exec:java
```

---

## Generación y Consulta de Javadoc

El proyecto incluye comentarios descriptivos y etiquetas Javadoc (`@author`, `@version`, `@param`, `@return`, `@throws`, `@deprecated`, etc.) en todas sus clases y métodos públicos.

### Generar la documentación HTML con Javadoc

**Usando Maven local:**
```bash
mvn javadoc:javadoc
```

**Usando Maven Wrapper:**
```cmd
.\mvnw.cmd javadoc:javadoc
```

Una vez generado, el sitio web estático resultante se almacenará en la carpeta `docs/`.

---

## Documentación en línea (GitHub Pages)

La documentación técnica Javadoc generada está publicada de forma accesible a través de GitHub Pages:

**[Consultar Documentación Javadoc en GitHub Pages](https://olga603.github.io/documentacion-proyecto-ud1-olga-dominguez/es/centro/incidencias/package-summary.html)**

---

## Clases Principales y Responsabilidades

| Clase | Responsabilidad Principal                                                                                       |
| :--- |:----------------------------------------------------------------------------------------------------------------|
| `App` | Punto de entrada de la aplicación (`main`). Gestiona el menú interactivo por consola y el flujo con el usuario. |
| `Incidencia` | Modelo de datos que representa una incidencia de soporte (ID, título, fecha, estado, prioridad).                |
| `GestorIncidencias` | Lógica de negocio. Encargada de almacenar, buscar, modificar y filtrar la colección de incidencias.             |
| `IncidenciaNoEncontradaException` | Excepción personalizada para cuando no se encuentran incidencias que coicidan con un id.                        |

---

## Estructura de Archivos del Proyecto
```text
documentacion-proyecto-ud1-nombre-apellidos/
├── .gitignore
├── pom.xml
├── README.md
├── mvnw
├── mvnw.cmd
├── docs/                     
│   ├── index.html
│   └── ...
└── src/
    ├── main/
    │   └── java/
    │       └── es/
    │           └── educacion/
    │               └── incidencias/
    │                   ├── App.java
    │                   ├── Incidencia.java
    │                   ├── GestorIncidencias.java
    │                   └── IncidenciaNoEncontradaException.java
    └── test/
        └── java/
```

---

## Autoría

- **Alumno:** Olga Domínguez Barreiro
- **Módulo:** Despregamento de aplicacións web
- **Grupo:** ODAW2B
- **Curso Académico:** 2026/2027
