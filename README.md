# Prueba Técnica Módulo 1 Java Básico
Primera evaluación técnica del Bootcamp de JAVA en HACK A BOSS
# Gestión de Empleados - Aplicación de Consola

## Descripción
Esta aplicación de consola permite gestionar empleados en una empresa. Proporciona funcionalidades para agregar, buscar, actualizar, eliminar y listar empleados. El sistema valida la entrada del usuario para garantizar la integridad de los datos.

## Características
- **Agregar empleados**: Registra nuevos empleados con nombre, apellido, cargo, salario y fecha de inicio.
- **Buscar empleados**: Permite buscar empleados por diferentes criterios como nombre, apellido, cargo, salario o fecha de inicio.
- **Actualizar empleados**: Actualiza la información de un empleado existente, incluyendo nombre, apellido, cargo, salario y fecha de inicio.
- **Eliminar empleados**: Elimina a un empleado del sistema.
- **Listar empleados**: Muestra una lista completa de todos los empleados registrados.

## Requisitos
- **Java**: Versión 17 en adelante.
- Dependencias necesarias:
  Las especificadas en pom.xml

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/M4R14-N3l0/Prueba-Tecnica-Modulo1-Java-Basico.git
   ```
2. Ejecuta el programa:
   ```bash
   usando IntelliJ IDEA Community Edition 2024.3.1
   ```

## Uso
1. Al ejecutar la aplicación, se mostrará un menú con las siguientes opciones:
   ```
   MENU:
   1: Agregar un empleado
   2: Buscar un empleado
   3: Cambiar un dato de un empleado
   4: Eliminar un empleado
   5: Listar todos los empleados
   ```
2. Selecciona una opción ingresando el número correspondiente y sigue las instrucciones.
3. La aplicación valida automáticamente la entrada del usuario para evitar errores comunes, como insertar números en campos de texto.

## Validaciones
- **Opciones del menú**: Solo acepta valores entre 1 y 5.
- **Campos de texto**: No permite números.
- **Salario**: Valida que sea un número decimal válido.

## Ejemplo de Uso
### Agregar un empleado
1. Selecciona la opción `1` del menú.
2. Ingresa los datos solicitados:
   - Nombre
   - Apellido
   - Cargo
   - Salario
   - Fecha de inicio (año, mes, día, hora, minutos)
3. El empleado será registrado en el sistema.

### Buscar un empleado
1. Selecciona la opción `2` del menú.
2. Escoge el criterio de búsqueda (nombre, apellido, etc.)
3. Ingresa el valor solicitado.
4. La aplicación mostrará los empleados que coincidan con el criterio.

### Actualizar un empleado

1. Selecciona la opción `3` del menú.
2. Ingresa el nombre y apellido del empleado que deseas actualizar.
3. Escoge el dato que deseas modificar (nombre, apellido, cargo, salario o fecha de inicio).
4. Proporciona el nuevo valor para el campo seleccionado.
5. El sistema actualizará la información del empleado.

### Eliminar un empleado

1. Selecciona la opción `4` del menú.
2. Ingresa el nombre y apellido del empleado que deseas eliminar.
3. El sistema eliminará al empleado si coincide con los datos ingresados.

### Listar todos los empleados

1. Selecciona la opción `5` del menú.
2. El sistema mostrará una lista con todos los empleados registrados, incluyendo sus datos completos.

## Contribución
Si deseas contribuir al proyecto:
1. Haz un fork del repositorio.
2. Crea una nueva rama:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza los cambios y súbelos a tu fork.
4. Crea un pull request con una descripción clara de los cambios realizados.

## Licencia
Este proyecto está licenciado bajo la [MIT License](LICENSE).

## Créditos
Desarrollado por [María Nelo].

---
Este archivo README describe la funcionalidad básica de la aplicación y proporciona instrucciones claras para instalarla y usarla. Si necesitas agregar más detalles o ajustar algo, ¡házmelo saber!

