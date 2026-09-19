# Taller Mecánico Martínez - Módulo UI

## Descripción

Este módulo corresponde a la interfaz gráfica del proyecto Taller Mecánico Martínez. Su función es permitir que el usuario pueda administrar las citas del taller de una forma más sencilla y visual, sin necesidad de realizar las operaciones directamente desde la consola.

Para desarrollar esta parte utilicé Java Swing, creando una ventana principal desde la cual se puede ingresar, consultar, modificar y eliminar la información de las citas.

## ¿Qué realiza este módulo?

El módulo UI permite al usuario:

- Registrar una nueva cita.
- Visualizar las citas registradas en una tabla.
- Seleccionar una cita existente.
- Actualizar la información de una cita.
- Eliminar una cita.
- Limpiar los campos del formulario.
- Mostrar mensajes de confirmación y de error.
- Validar los datos ingresados antes de enviarlos al módulo Core.

## Datos utilizados en el formulario

Para cada cita se manejan los siguientes datos:

- Nombre del cliente.
- Fecha de la cita.
- Hora de la cita.
- Servicio solicitado.
- Duración del servicio en minutos.
- Estado de la cita.

## Validaciones realizadas

Agregué diferentes validaciones para evitar que se ingresen datos incorrectos. Entre ellas se encuentran:

- El nombre del cliente debe contener letras.
- El servicio debe corresponder a uno de los servicios disponibles.
- La duración debe ser un número entero mayor que cero.
- La fecha debe utilizar el formato AAAA-MM-DD.
- La hora debe utilizar el formato HH:MM.
- No se permiten citas con fecha y hora en el pasado.
- El estado debe ser pendiente, completado o cancelada.
- Los campos obligatorios deben estar completos.

## Servicios disponibles

Los servicios que se pueden registrar son:

- Cambio de aceite.
- Revisión de frenos.
- Cambio de pastillas.
- Revisión general.

## Funcionamiento

La interfaz se comunica con el módulo Core mediante la clase CitaDao. Cuando el usuario realiza una operación desde la ventana, la interfaz obtiene los datos ingresados, los valida y posteriormente utiliza los métodos correspondientes para guardar, consultar, actualizar o eliminar la información.

Después de realizar una operación correctamente, la tabla se vuelve a cargar para mostrar los datos actualizados.

## Tecnologías utilizadas

- Java.
- Java Swing.
- Maven.
- JDBC.
- MariaDB.
- Eclipse IDE.

## Organización del proyecto

Separé la interfaz gráfica del módulo Core para mantener el proyecto organizado. De esta manera, el módulo UI se encarga principalmente de la interacción con el usuario, mientras que el módulo Core contiene el modelo, el acceso a los datos y la lógica relacionada con las citas.

Esta separación facilita la comprensión del código y permite realizar cambios en la interfaz sin modificar directamente la lógica principal del sistema.

## Autor

Gesler Duque