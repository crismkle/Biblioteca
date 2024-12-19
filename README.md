# Biblioteca
Sistema de gestión de biblioteca simple hecho para el curso de Java 1 de UTN Mendoza

## Enunciado
### Ejercicio: Sistema de Gestión de Biblioteca
Estás diseñando un sistema para gestionar una biblioteca. La biblioteca tiene
diferentes tipos de materiales que se pueden prestar, como libros, revistas y DVDs. Cada
material tiene características comunes, pero se gestionan de manera diferente. Además,
el sistema debe permitir a los usuarios registrarse, realizar préstamos y devoluciones,
gestionar los materiales y aplicar restricciones según el tipo de usuario.
#### Requisitos del ejercicio:
#### 1. Clase abstracta MaterialBiblioteca:
- Atributos comunes:
  - codigo: código único del material.
  - titulo: título del material.
  - disponible: booleano que indica si el material está disponible para préstamo.
  - Variable estática totalMateriales: un contador que lleva el número total de materiales en la biblioteca.

- Constructor:
  - Inicializa los atributos y aumenta el contador estático totalMateriales.
  - Métodos abstractos:
    - prestamo(): método abstracto que se implementará de forma diferente según el tipo de material.
    - devolucion(): método abstracto que gestiona la devolución del material.
- Métodos concretos:
    - getCodigo(): retorna el código del material.
    - getTitulo(): retorna el título del material.
    - esDisponible(): retorna si el material está disponible o no.
    - setDisponible(boolean disponible): cambia el estado de disponibilidad del material.

#### 2. Clases que extienden MaterialBiblioteca:
- Clase Libro:
    - Atributo adicional:
      - autor: autor del libro.
    - Constructor:
      - Inicializa el código, título, autor y establece que el material está disponible.
    - Implementa prestamo() verificando si el libro está disponible y, si es así, lo marca como no disponible. Si no está disponible, lanza una excepción.
    - Implementa devolucion() que marca el libro como disponible nuevamente.

- Clase Revista:
    - Atributos adicionales:
      - mes: el mes de publicación.
      - ano: el año de publicación.
    - Constructor:
      - Inicializa el código, título, mes, año y establece que el material está disponible.
    - Implementa prestamo() con una restricción: las revistas solo se pueden prestar por un máximo de 7 días. Si no está disponible, lanza una excepción.
    - Implementa devolucion() que marca la revista como disponible.
 - Clase DVD:
    - Atributo adicional:
      - duracion: duración del DVD en minutos.
      - Constructor:
        - Inicializa el código, título, duración y establece que el material está disponible.
      - Implementa prestamo() con una restricción: los DVDs solo se pueden prestar a usuarios mayores de 18 años (verificando la edad del usuario). Si no está disponible o el usuario no cumple con la edad mínima, lanza una excepción.
      - Implementa devolucion() que marca el DVD como disponible.

#### 3. Interfaz Prestamo:
- Define los métodos realizarPrestamo(MaterialBiblioteca material) y devolverMaterial(MaterialBiblioteca material), que deben ser implementados por las clases que permiten gestionar préstamos de materiales.

#### 4. Clase Usuario:
- Atributos:
  - nombre: nombre del usuario.
  - idUsuario: identificador único.
  - edad: edad del usuario.
  - Variable estática totalUsuarios: lleva el conteo del total de usuarios registrados.
- Constructor:
  - Inicializa los atributos y aumenta el contador totalUsuarios.
- Métodos:
  - realizarPrestamo(MaterialBiblioteca material): realiza un préstamo si el material está disponible y cumple con las restricciones del tipo de material.
  - devolverMaterial(MaterialBiblioteca material): realiza la devolución de un material prestado.
  - verificarEdad(): retorna la edad del usuario (usado para restricciones de edad en algunos materiales como DVDs).
  - getTotalUsuarios(): retorna el número total de usuarios registrados.

#### 5. Clase Bibliotecario que implementa la interfaz Prestamo:
- Atributos:
  - nombre: nombre del bibliotecario.
  - idBibliotecario: identificador único del bibliotecario.
- Constructor:
  - Inicializa los atributos del bibliotecario.
- Métodos:
  - realizarPrestamo(MaterialBiblioteca material, Usuario usuario): verifica que el material esté disponible y realiza el préstamo si cumple con las restricciones.
  - devolverMaterial(MaterialBiblioteca material, Usuario usuario): permite devolver el material y marca el material como disponible.

#### 6. Clase Biblioteca:
- Atributos:
  - Lista de materiales disponibles.
  - Lista de usuarios registrados.
  - Lista de bibliotecarios.
- Métodos:
  - agregarMaterial(MaterialBiblioteca material): agrega un material a la lista de materiales.
  - registrarUsuario(Usuario usuario): registra un usuario en la biblioteca.
  - mostrarMaterialesDisponibles(): muestra todos los materiales disponibles.
  - realizarPrestamo(MaterialBiblioteca material, Usuario usuario): permite realizar un préstamo a un usuario.
  - devolverMaterial(MaterialBiblioteca material, Usuario usuario): permite devolver un material.

#### 7. Clase principal Main:
  - Crea varios tipos de materiales (libros, revistas, DVDs).
  - Crea varios usuarios y bibliotecarios.
  - Realiza préstamos y devoluciones de materiales, mostrando mensajes de éxito o lanzando excepciones si hay problemas.
  - Muestra los materiales disponibles antes y después de los préstamos.
  - Controla las restricciones de edad y duración de préstamos para algunos tipos de materiales.
