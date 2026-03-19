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

