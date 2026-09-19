# Taller Mecánico Martínez - Módulo Core

## Descripción

Este módulo corresponde a la parte principal de la lógica del proyecto Taller Mecánico Martínez, desarrollado para llevar un control de las citas de los clientes que solicitan diferentes servicios en el taller.

El objetivo de este módulo es manejar la información de las citas y realizar la comunicación con la base de datos. Se decidió separar esta parte del proyecto de la interfaz gráfica para mantener el código más organizado y facilitar su mantenimiento.

## ¿Qué realiza este módulo?

El módulo Core permite realizar las operaciones principales relacionadas con las citas del taller:

- Registrar nuevas citas.
- Consultar todas las citas almacenadas.
- Buscar una cita por medio de su ID.
- Actualizar la información de una cita existente.
- Eliminar una cita.
- Mantener la información almacenada en la base de datos.

Estas operaciones fueron desarrolladas utilizando Java y una conexión JDBC con la base de datos.

## Información que se guarda

Para cada cita se almacena la siguiente información:

- ID de la cita.
- Nombre del cliente.
- Fecha y hora de la cita.
- Servicio solicitado.
- Duración estimada del servicio en minutos.
- Estado de la cita.

El estado permite identificar si una cita se encuentra pendiente, completada o cancelada.

## Clase Cita

La clase Cita representa cada cita registrada dentro del sistema.

En esta clase se encuentran los atributos necesarios para almacenar los datos de una cita, además de sus constructores y métodos para obtener o modificar la información.

Esta clase permite trabajar con los datos de una manera ordenada antes de enviarlos o recuperarlos de la base de datos.

## Clase CitaDao

La clase CitaDao se encarga de realizar la comunicación entre el programa y la base de datos.

En esta clase se desarrollaron las operaciones CRUD:

- *Create:* guardar una nueva cita.
- *Read:* listar las citas y buscar una cita por ID.
- *Update:* modificar una cita existente.
- *Delete:* eliminar una cita.

Para realizar estas operaciones se utilizaron consultas SQL mediante PreparedStatement.

Se utilizó PreparedStatement porque permite enviar los datos de una manera más ordenada y segura al momento de ejecutar las consultas en la base de datos.

## Conexión con la base de datos

El módulo utiliza JDBC para establecer la conexión con la base de datos taller_mecanico_db.

La base de datos contiene la tabla de citas donde se almacena permanentemente la información registrada desde el sistema.

De esta manera, aunque el programa se cierre, las citas permanecen guardadas y pueden volver a consultarse cuando se ejecute nuevamente.

## ¿Por qué se realizó de esta manera?

Decidí separar la lógica y el acceso a datos de la interfaz gráfica para tener una mejor organización del proyecto.

El módulo Core se encarga principalmente de los datos y de la comunicación con la base de datos, mientras que el módulo UI se encarga de mostrar la información al usuario mediante una interfaz gráfica.

Esta estructura también facilita realizar cambios en una parte del programa sin afectar innecesariamente las demás.

## Tecnologías utilizadas

- Java
- Maven
- JDBC
- MariaDB
- SQL
- Eclipse IDE

## Conclusión

El módulo taller_mecanico_citas_core es una parte fundamental del proyecto, ya que contiene la estructura necesaria para manejar las citas y realizar las operaciones con la base de datos.

Con este módulo logré implementar las funciones de guardar, consultar, actualizar y eliminar citas, manteniendo el código separado de la interfaz gráfica y logrando una estructura más ordenada para el funcionamiento del sistema.