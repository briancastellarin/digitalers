# AcademiaAPI

**Descripción:**

La API de Academia es una plataforma que permite la gestión de estudiantes, instructores y cursos de una academia.
Además de las operaciones CRUD básicas, ofrece funcionalidades adicionales para mejorar la eficiencia y el análisis
empresarial.

## Requerimientos

Asegúrese de tener instalado lo siguiente antes de ejecutar la API:

- Java SDK 17.
- Spring Boot.
- MySQL 8.0+ (para base de datos).
- Xampp or Wampp (para el servidor de base de datos).

Y las dependencias de Maven:

- Spring Web WEB.
- Spring Data JPA SQL.
- MySQL Driver SQL.
- Lombok DEVELOPER TOOLS.

Recomiendo usar [IntelliJ IDEA IDE](https://www.jetbrains.com/idea/) para ejecutar la API y generar Spring con
[Spring Initializr](https://start.spring.io/).

## Instalación

1. Abra la terminal y arrastre el repositorio a una carpeta en su computadora:

   -> mkdir academia-api (en tu escritorio).

   -> cd academia-api

   -> git clone https://github.com/gmmaunas/academia-api

2. Abra xaamp o wampp y ejecute el servidor MySQL.
3. Crea una base de datos MySQL con el nombre "academia_db" (o llámala como quieras y modifica el archivo
   application.properties).
4. En la terminal, acceda al directorio de su proyecto:

   -> cd academia-api (en tu escritorio).
5. Compile y ejecute el proyecto:

   -> mvn spring-boot:run

## Uso

En el momento de la inicialización, la documentación de la API se puede encontrar en [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui/index.html).

Si no funciona, intente con localhost:****/swagger-ui.html y cambie **** al puerto que haya configurado.

En la carpeta collection están todas las colecciones de api para importar en Postman, todo está listo para 
ser probado (pruebas - testing).