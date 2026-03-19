# Laboratorio TDD: Gestión de Usuarios con Spring Boot
Este proyecto tiene como objetivo aplicar el ciclo Red-Green-Refactor para construir un CRUD de usuarios siguiendo una arquitectura de capas.

## Stack Tecnológico
Java 17+ / Spring Boot 3.x

Gradle

JUnit 5 & Mockito (Testing)

H2 Database (Pruebas unitarias/integración)

## Bitácora de Ciclos TDD 
 
## Ciclo 1: Registro de Usuario (Capa de Servicio)

### Fase 🔴 RED:

Se creo el test `mustSaveSuccessfully` en `UserServiceTest`. Fallo por falta de clases:

- UserRepository:
 
    ```
  error: cannot find symbol
    private UserRepository userRepository;
            ^
  symbol:   class UserRepository
  location: class UserServiceTest
  ```
- UserService:
    
    ```
  error: cannot find symbol
    private UserService userService;
            ^
  symbol:   class UserService
  location: class UserServiceTest
  ```

- User:
    
    ```
  error: cannot find symbol
        User userForSave = new User(null, "Name test", "test@gmail.com");
        ^
  symbol:   class User
  location: class UserServiceTest
  ```

### Fase 🟢 GREEN:

Se creo la entidad `User`, repositorio `UserRepository` y el servicio `UserService`. El test paso.

### Fase 🔵 REFACTOR:
- Mejora: Implementación de patrón DTO para desacoplar la capa de persistencia de la capa de presentación.
    
    - Se crearon las clases `UserRequestDto` y `UserResponseDto`.
    - Se integro una logica de maper con MapStruct en el `UserService`. Se creo la interface `UserMappe`.
    - Se actualizaron los tests para verificar que el servicio ahora procesa y retorna DTOs en lugar de la Entidad pura.

## Ciclo 2: Registro de Usuario - Email formato incorrrecto (Capa de Servicio)

### Fase 🔴 RED:

Se creo el test `saveError_emailIncorrect` en `UserServiceTest`. Fallo por que no genero la excepcion esperada.

``` 
Expected com.tdd.laboratorio_tdd_spring.exception.EmailIncorrectException to be thrown, but nothing was thrown.
org.opentest4j.AssertionFailedError: Expected com.tdd.laboratorio_tdd_spring.exception.EmailIncorrectException to be thrown, but nothing was thrown.
	at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:159)
	at org.junit.jupiter.api.AssertThrows.assertThrows(AssertThrows.java:74)
	at org.junit.jupiter.api.AssertThrows.assertThrows(AssertThrows.java:35)
	at org.junit.jupiter.api.Assertions.assertThrows(Assertions.java:3223)
	at com.tdd.laboratorio_tdd_spring.service.UserServiceTest.saveError_emailIncorrect(UserServiceTest.java:54)
```

### Fase 🟢  GREEN:

Se agrego validacion al email usando la expresion regular `^[A-Za-z0-9+_.-]+@(.+)$`. El test paso.

### Fase 🔵 REFACTOR:

Se extrajo la expresión regular a una constante estática EMAIL_PATTERN y se utilizó Pattern.compile() para optimizar el rendimiento de la validación, evitando recompilar la Regex en cada llamada.