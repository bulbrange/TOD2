# Maven

Es una herramienta para la gestión y creación de proyectos Java, Mediante un archivo XML llamado POM (project object model) se puede describir la totalidad del proyecto a construir con todas las dependencias, módulos externos, plugins y versiones que sean necesarias. En dicha descripción se puede establecer el orden de construcción y las tareas a realizar, para compilar, testear o empaquetar la build.

Maven funciona con un repositorio central que facilita el uso de librerias, plugins, versiones de java, componentes, las cuales se agregan o modifican al proyecto, e incluso módulos creados pueden subirse al repositorio para que otros hagan uso de él.





Modificación del POM.XML para el proyecto

Plugins

- Maven compiler plugin (determina la versión de Java objetivo en la que compilara el proyecto)
- Maven assembly (jar ejecutable)

Dependencias

- mySQL connector java (libreria para conectar mySQL)
- Junit(pruebas unitarias)
<img src="http://danilab.es/img/pom.png"></img>
