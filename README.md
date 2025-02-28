 API RESTful con Spring Boot

Este proyecto es una API RESTful desarrollada con **Spring Boot 3**, que incluye un CRUD de productos, internacionalización y pruebas unitarias con StepVerifier.

 🚀 Tecnologías utilizadas
- Java 17+
- Spring Boot 3
- Spring WebFlux
- Maven
- JUnit 5 y StepVerifier
- Postman (para pruebas manuales)

---

 📌 Requisitos previos
Asegúrate de tener instalados:
- JDK 17+ ([Descargar](https://adoptium.net/))
- Maven ([Descargar](https://maven.apache.org/download.cgi))
- Git ([Descargar](https://git-scm.com/))
- Postman (opcional, para pruebas REST)

Verifica que Maven y Java estén instalados ejecutando:
```sh
java -version
mvn -version
```

---

 ⚙️ Instalación y Ejecución

 1️⃣ Clonar el repositorio
```sh
git clone https://github.com/TU-USUARIO/api-restful-spring.git
cd api-restful-spring
```

 2️⃣ Compilar y ejecutar
```sh
mvn clean install
mvn spring-boot:run
```
La API se iniciará en `http://localhost:8080`

---

 🛠️ Uso de la API

🔹 Obtener saludo internacionalizado
- GET `/api/saludo`  
- Headers: `Accept-Language: es | en`
- Ejemplo:
  ```sh
  curl -X GET "http://localhost:8080/api/saludo" -H "Accept-Language: es"
  ```
- Respuestas:
  - `es`: `¡Hola, API RESTful en Español!`
  - `en`: `Hello, RESTful API in English!`

 🔹 CRUD de productos

| Método  | URL | Descripción |
|---------|--------------------------|---------------------------|
| POST | `/api/productos` | Agregar un producto |
| GET | `/api/productos` | Listar todos los productos |
| GET | `/api/productos/{id}` | Obtener un producto por ID |
| PUT | `/api/productos/{id}` | Actualizar un producto |
| DELETE | `/api/productos/{id}` | Eliminar un producto |

Ejemplo de creación de producto:
```sh
curl -X POST "http://localhost:8080/api/productos" \
     -H "Content-Type: application/json" \
     -d '{"id": "1", "nombre": "Laptop", "precio": 1200.00}'
```

Ejemplo de consulta de productos:
```sh
curl -X GET "http://localhost:8080/api/productos"
```

---

 ✅ Pruebas automatizadas

Ejecutar pruebas con Maven
```sh
mvn test
```
Si todas las pruebas pasan, verás:
```
BUILD SUCCESS
Tests run: X, Failures: 0, Errors: 0, Skipped: 0
```



 📄 Licencia
Este proyecto está bajo la licencia MIT.



📢 **Contribuciones y mejoras son bienvenidas.**

