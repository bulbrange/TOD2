
/* Testing relationship OK */
INSERT INTO Persona (Nombre,Email,Pass) VALUES ("Test", "test@test.com", "tetspass");
INSERT INTO Tarea (ID_persona,Titulo,Descripcion) VALUES (1,"TestTitulo", "TestDesc");

/* Test ON DELTE CASCADE OK */
DELETE FROM Persona WHERE ID=1;

/* Testing relationship KO */
INSERT INTO Tarea (ID_persona,Titulo,Descripcion) VALUES (99999,"TestTitulo2", "TestDesc2");