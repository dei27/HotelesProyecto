<h1 align="center">Alura Group Hotel Project</h1
<p>Este proyecto forma parte de la capacitación de One Next Education Alura Latam y consiste en la creación de dos hoteles pertenecientes al Alura Group: uno ubicado en la playa y otro en un bosque lluvioso.</p>
<p>Para demostrar la importancia que Alura Group le da a la inclusión, se incluyeron botones que permiten ajustar el tamaño de la letra y la opción de leer el texto a través de JavaScript.</p>
<h2>Hoteles</h2>
<p>Los hoteles creados son: Hotel Alurebi y Hotel Gökolura. El nombre Alurebi proviene de la combinación de las palabras Alura y Komorebi, donde Komorebi es una palabra japonesa que describe la luz del sol que se filtra a través de las hojas de los árboles. Por su parte, el nombre Gökolura proviene de la mezcla de Gökotta y Alura, donde Gökotta es una palabra sueca que describe la experiencia de despertarse en la mañana, salir al aire libre y escuchar los sonidos de la naturaleza, especialmente de pájaros cantando.</p>
<h2>Funcionalidades</h2>
<p>Entre las funcionalidades del proyecto se pueden crear, editar y modificar reservas y huéspedes. Aunque para este proyecto se utilizó una autenticación de usuario sin implementar Spring Security, se reconoce que esta es la opción ideal de implementación.</p>
<p>Para la gestión de la base de datos se utilizó MySQL. Se creó un procedimiento almacenado que libera las habitaciones automáticamente cuando se inicia la aplicación, comparando la fecha del sistema con las fechas finales de las reservas. 
También se creó un trigger que genera automáticamente la factura al momento de insertar una reserva, 
calculando los costos según el tipo de habitación y los días entre fechas. Por último, se creó un trigger que recalcula los costos al actualizar una reserva.
Se incluye un Script con el nombre de ScriptHoteles.sql que contiene todo lo necesario para crear la base de datos.</p>
<h2>Tecnologías utilizadas</h2>
<p align="center">Spring Boot 3
Maven
Hibernate
Thymeleaf
CSS</p>

<h6 align="center"> Puedes ver una demo acá: https://youtu.be/dAWvkG7N0RU </h6>

