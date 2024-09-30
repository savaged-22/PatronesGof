# Patrones GoF - Sistema de Transporte Público

Este proyecto es una aplicación web que implementa varios patrones de diseño GoF (Factory, Observer, Visitor) en el contexto de un sistema de transporte público, similar al de TransMilenio. La aplicación permite gestionar rutas, estaciones y usuarios, incluyendo diferentes tipos de buses y usuarios con tarifas especiales.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para construir la aplicación.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.
- **Thymeleaf**: Motor de plantillas para la generación de vistas HTML.
- **PostgreSQL**: Base de datos utilizada para almacenar la información de rutas, estaciones, buses y usuarios.

## Estructura del Proyecto

El proyecto sigue una estructura estándar de Spring Boot con Maven:

### Descripción de Carpetas y Archivos

- **src/main/java/co/patronesgof/fis/controllers**: Contiene los controladores de Spring MVC que manejan las solicitudes HTTP para rutas, estaciones y usuarios.
- **src/main/java/co/patronesgof/fis/models**: Contiene las clases de modelo que representan las entidades de la base de datos como buses, rutas, estaciones y usuarios.
- **src/main/java/co/patronesgof/fis/repositories**: Contiene las interfaces de repositorio que extienden `JpaRepository` para realizar operaciones CRUD en la base de datos.
- **src/main/java/co/patronesgof/fis/services**: Contiene las clases de servicio que implementan la lógica de negocio para la creación de buses, rutas y la validación de usuarios.
- **src/main/java/co/patronesgof/fis/services/interfaces**: Contiene las interfaces de los servicios, como el patrón Visitor para la validación de usuarios.
- **src/main/resources/static**: Contiene archivos estáticos como CSS.
- **src/main/resources/templates**: Contiene las plantillas Thymeleaf para las vistas HTML, como formularios para crear rutas, estaciones y usuarios.
- **src/main/resources/application.yml**: Archivo de configuración de Spring Boot, donde se configuran los detalles de la base de datos.
- **src/test/java**: Contiene las pruebas unitarias y de integración.
- **pom.xml**: Archivo de configuración de Maven que gestiona las dependencias del proyecto.
- **README.md**: Archivo que estás leyendo actualmente.

## Configuración

1. Clona el repositorio:
    ```sh
    git clone <URL_DEL_REPOSITORIO>
    ```
2. Configura las variables de entorno para la base de datos en `application.yml`:
    ```yaml
    spring:
      datasource:
        url: jdbc:postgresql://<HOST>:<PUERTO>/<NOMBRE_BD>
        username: <USUARIO>
        password: <CONTRASEÑA>
    ```
3. Ejecuta la aplicación:
    ```sh
    mvn spring-boot:run
    ```

## Patrones de Diseño Implementados

### 1. **Observer** - Monitorización en tiempo real de estaciones
   - Las estaciones de TransMilenio notifican a los usuarios cuando cambia el estado (como congestión o llegada de buses).
   - Los usuarios pueden suscribirse o desuscribirse de las estaciones que deseen.
   - **Clases involucradas**: `Estacion`, `Usuario`, `EstacionController`, `UsuarioController`.

### 2. **Factory** - Creación de rutas y buses
   - La aplicación utiliza el patrón Factory para crear diferentes tipos de buses (articulados y biarticulados) y rutas (locales y troncales).
   - **Clases involucradas**: `BusFactoryService`, `RutaFactoryService`, `Bus`, `Ruta`.

### 3. **Visitor** - Validación de boletos y usuarios
   - El patrón Visitor se utiliza para validar a los usuarios, aplicando tarifas diferentes según si son estudiantes, personas mayores o usuarios regulares.
   - **Clases involucradas**: `ValidadorVisitorInterfaceService`, `ValidadorConcretoService`, `UsuarioRegular`, `Estudiante`, `PersonaMayor`.

## Uso

- Accede a la aplicación en `http://localhost:8080/index`.
- Puedes crear rutas en `http://localhost:8080/routes`, crear estaciones en `http://localhost:8080/estaciones` y gestionar usuarios en `http://localhost:8080/usuarios`.

## Base de Datos

La base de datos utiliza PostgreSQL y almacena la información de rutas, estaciones, buses y usuarios. Aquí están las tablas principales:

- **Usuario**: Almacena información sobre los usuarios del sistema.
- **Estacion**: Almacena información sobre las estaciones.
- **Bus**: Almacena información sobre los buses (articulado, biarticulado).
- **Ruta**: Almacena información sobre las rutas (locales, troncales).

## Contribuciones

1. Realiza un fork del proyecto.
2. Crea una rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva funcionalidad'`).
4. Sube los cambios a tu repositorio (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request para que podamos revisar tus cambios.

