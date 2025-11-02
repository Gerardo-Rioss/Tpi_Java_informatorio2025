# LaboratorioChad - Sistema de Gestión de Laboratorio

## Descripción
LaboratorioChad es una aplicación de línea de comandos desarrollada en Java para la gestión de un laboratorio de investigación. Permite administrar investigadores y experimentos, así como realizar operaciones CRUD sobre ellos.

## Características

- Gestión de investigadores (alta y consulta)
- Gestión de experimentos físicos y químicos (alta y consulta)
- Exportación de datos de investigadores a formato CSV
- Interfaz de línea de comandos intuitiva
- Carga inicial de datos para pruebas

## Requisitos del Sistema

- Java 21 o superior
- Maven 3.6 o superior
- OpenCSV 5.9 (se incluye como dependencia)

## Estructura del Proyecto

```
src/main/java/com/informatorio/laboratorioChad/
├── dominio/                  # Clases de dominio
│   ├── Experimento.java
│   ├── ExperimentoFisico.java
│   ├── ExperimentoQuimico.java
│   └── Investigador.java
├── repository/               # Capa de acceso a datos
│   ├── experimento/
│   └── investigador/
├── service/                  # Lógica de negocio
│   ├── archivos/            # Servicios de exportación
│   ├── experimento/         # Servicios de experimentos
│   ├── investigador/        # Servicios de investigadores
│   ├── menu/                # Gestión del menú principal
│   ├── ui/                  # Servicios de interfaz de usuario
│   └── utils/               # Utilidades varias
└── App.java                 # Punto de entrada de la aplicación
```

## Dependencias

- JUnit 3.8.1 - Para pruebas unitarias
- OpenCSV 5.9 - Para exportación de datos a CSV

