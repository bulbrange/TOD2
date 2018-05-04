# GIT


## ¿Qué es GIT?

Git es un software de control de versiones diseñado por Linus Torvalds, pensando en la eficiencia y la confiabilidad del mantenimiento de versiones de aplicaciones cuando éstas tienen un gran número de archivos de código fuente. Su propósito es llevar un registro de los cambios en archivos de computadora y coordinar el trabajo que varias personas realizan sobre archivos compartidos.

Al principio, GIT se pensó como un motor de bajo nivel sobre el sobre el cual otros pudieran escribir la interfaz de usuario o front-end como _Cogito o StGIT._ Sin embargo, GIT se ha convertido desde entonces en un sistema de control de versiones con funcionalidad plena. Hay algunos proyectos de mucha relevancia que ya usan GIT, en particular, el grupo de programación del núcleo de Linux.

El mantenimiento de software GIT esta supervisado por Junio Hamano. Quien recibe contribuciones al código de más de 200 programadores.

En cuanto a derechos de autor GIT es un software GIT es un software libre distribuible bajo los términos de la versión 2 de la Licencia Publica General de GNU.



## Características

El diseño de GIT se basó en _BitKeeper_ y en _Monotone._

Originalmente fue diseñado como un motor de un sistema de control de versiones de bajo nivel sobre el cual otros podrían codificar interfaces frontales. Ahora GIT se ha vuelto un sistema de control de versiones completo, utilizable de forma directa.

_Linus Tolvas_ buscaba un sistema distribuido que pudiera se pudiera usar en forma semejante a _BitKeeper_, pero ninguno de los sistemas gratuitos disponibles cumplía con sus requerimientos. El diseño de GIT mantiene una enorme cantidad de código distribuida y gestionada por mucha gente, que incide en numerosos detalles de rendimiento, y de la necesidad de rapidez.

Características más relevantes:

- Fuerte apoyo al desarrollo no lineal, rapidez en la gestión de ramas y mezclado de diferentes versiones. Git incluye herramientas específicas para navegar y visualizar un historial de desarrollo no lineal. Una presunción fundamental en Git es que un cambio será fusionado mucho más frecuentemente de lo que se escribe originalmente, conforme se pasa entre varios programadores que lo revisan.

- Gestión distribuida. Al igual que  [Darcs](https://es.wikipedia.org/wiki/Darcs),  [BitKeeper](https://es.wikipedia.org/wiki/BitKeeper),  [Mercurial](https://es.wikipedia.org/wiki/Mercurial),  [SVK](https://es.wikipedia.org/w/index.php?title=SVK&amp;action=edit&amp;redlink=1),  [Bazaar](https://es.wikipedia.org/wiki/Bazaar_(software)) y  [Monotone](https://es.wikipedia.org/wiki/Monotone), Git le da a cada programador una copia local del historial del desarrollo entero, y los cambios se propagan entre los repositorios locales. Los cambios se importan como ramas adicionales y pueden ser fusionados en la misma manera que se hace con la rama local.
- Los almacenes de información pueden publicarse por  [HTTP](https://es.wikipedia.org/wiki/HTTP),  [FTP](https://es.wikipedia.org/wiki/File_Transfer_Protocol),  [rsync](https://es.wikipedia.org/wiki/Rsync) o mediante un protocolo nativo, ya sea a través de una conexión TCP/IP simple o a través de cifrado  [SSH](https://es.wikipedia.org/wiki/SSH). Git también puede emular servidores  [CVS](https://es.wikipedia.org/wiki/CVS), lo que habilita el uso de clientes CVS preexistentes y módulos IDE para CVS pre-existentes en el acceso de repositorios Git.
- Los repositorios Subversion y svk se pueden usar directamente con git-svn.
- Gestión eficiente de proyectos grandes, dada la rapidez de gestión de diferencias entre archivos, entre otras mejoras de optimización de velocidad de ejecución.
- Todas las versiones previas a un cambio determinado implican la notificación de un cambio posterior en cualquiera de ellas a ese cambio (denominado autenticación criptográfica de historial). Esto existía en  [Monotone](https://es.wikipedia.org/wiki/Monotone).
- Resulta algo más caro trabajar con ficheros concretos frente a proyectos, eso diferencia el trabajo frente a CVS, que trabaja con base en cambios de fichero, pero mejora el trabajo con afectaciones de código que concurren en operaciones similares en varios archivos.
- Los renombrados se trabajan basándose en similitudes entre ficheros, aparte de nombres de ficheros, pero no se hacen marcas explícitas de cambios de nombre con base en supuestos nombres únicos de nodos de sistema de ficheros, lo que evita posibles, y posiblemente desastrosas, coincidencias de ficheros diferentes en un único nombre.
- Re-almacenamiento periódico en paquetes (ficheros). Esto es relativamente eficiente para escritura de cambios y relativamente ineficiente para lectura si el reempaquetado (con base en diferencias) no ocurre cada cierto tiempo

## Comandos básicos

- git fetch:

Descarga los cambios realizados en el repositorio remoto.

- git merge _&lt;nombre\_rama&gt;_:

Impacta en la rama en la que te encuentras parado, los cambios realizados en la rama &quot;nombre\_rama&quot;.

- git pull:

Unifica los comandos _fetch_ y _merge_ en un único comando.

- git commit -am &quot;&lt;mensaje&gt;&quot;:

Confirma los cambios realizados. El &quot;mensaje&quot; generalmente se usa para asociar al _commit_ una breve descripción de los cambios realizados.

- git push origin _&lt;nombre\_rama&gt;_:

Sube la rama &quot;nombre\_rama&quot; al servidor remoto.

- git status:

Muestra el estado actual de la rama, como los cambios que hay sin commitear.

- git add _&lt;nombre\_archivo&gt;_:

Comienza a trackear el archivo &quot;nombre\_archivo&quot;.

- git checkout -b _&lt;nombre\_rama\_nueva&gt;_:

Crea una rama a partir de la que te encuentres parado con el nombre &quot;nombre\_rama\_nueva&quot;, y luego salta sobre la rama nueva, por lo que quedas parado en esta última.

- git checkout -t origin/_&lt;nombre\_rama&gt;_:

Si existe una rama remota de nombre &quot;nombre\_rama&quot;, al ejecutar este comando se crea una rama local con el nombre &quot;nombre\_rama&quot; para hacer un seguimiento de la rama remota con el mismo nombre.

- git branch:

Lista todas las ramas locales.

- git branch -a:

Lista todas las ramas locales y remotas.

- git branch -d _&lt;nombre\_rama&gt;_:

Elimina la rama local con el nombre &quot;nombre\_rama&quot;.

- git push origin _&lt;nombre\_rama&gt;_:

Commitea los cambios desde el branch local origin al branch &quot;nombre\_rama&quot;.

- git remote prune origin:

Actualiza tu repositorio remoto en caso de que algún otro desarrollador haya eliminado alguna rama remota.

- git reset --hard HEAD:

Elimina los cambios realizados que aún no se hayan hecho _commit_.

- git revert _&lt;hash\_commit&gt;_:

Revierte el _commit_ realizado, identificado por el &quot;hash\_commit&quot;.

## Buenas practicas

Cada desarrollador o equipo de desarrollo puede hacer uso de Git de la forma que le parezca conveniente. Sin embargo, una buena práctica es la siguiente:

Se deben utilizar 4 tipos de ramas: Master, Development, Features, y Hotfix.

- Master:

Es la rama principal. Contiene el repositorio que se encuentra publicado en producción, por lo que debe estar siempre estable.

- Development:

Es una rama sacada de master. Es la rama de integración, todas las nuevas funcionalidades se deben integrar en esta rama. Luego que se realice la integración y se corrijan los errores (en caso de haber alguno), es decir que la rama se encuentre estable, se puede hacer un merge de development sobre la rama master.

- Features:

Cada nueva funcionalidad se debe realizar en una rama nueva, específica para esa funcionalidad. Estas se deben sacar de development. Una vez que la funcionalidad esté desarrollada, se hace un merge de la rama sobre development, donde se integrará con las demás funcionalidades.

- Hotfix:

Son bugs que surgen en producción, por lo que se deben arreglar y publicar de forma urgente. Es por ello, que son ramas sacadas de master. Una vez corregido el error, se debe hacer un merge de la rama sobre master. Al final, para que no quede desactualizada, se debe realizar el merge de master sobre development.

## Opciones herramientas

- GitHub
- GitLab
- BitBucket
