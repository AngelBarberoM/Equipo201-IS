CREATE TABLE USUARIO_CURSO(
ID_USUARIO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
CORREO VARCHAR(40) NOT NULL,
NICK VARCHAR(40) NOT NULL,
PASSWORD VARCHAR( 40 ) NOT NULL,
NOMBRE VARCHAR(40) NOT NULL,
APELLIDOS VARCHAR(40) NOT NULL,
PERMISOS VARCHAR(40) NOT NULL,
DIRECCION VARCHAR(40) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE VALORACION_CURSO(
ID_VALORACION INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
ID_CURSO INT NOT NULL,
ID_USUARIO INT NOT NULL,
VALORACION INT NOT NULL,

CONSTRAINT FK_ID_USUARIO,
FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO_CURSO(ID_USUARIO)
ON UPDATE CASCADE
ON DELETE CASCADE,

CONSTRAINT FK_ID_CURSO,
FOREIGN KEY (ID_CURSO) REFERENCES CURSO(ID_CURSO)
ON UPDATE CASCADE
ON DELETE CASCADE

) ENGINE = InnoDB;


CREATE TABLE NUMERO_INSCRITOS(
ID_INSCRITOS INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
ID_CURSO INT NOT NULL,
ID_USUARIO INT NOT NULL,

CONSTRAINT FK_ID_USUARIO,
FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO_CURSO(ID_USUARIO)
ON UPDATE CASCADE
ON DELETE CASCADE,

CONSTRAINT FK_ID_CURSO,
FOREIGN KEY (ID_CURSO) REFERENCES CURSO(ID_CURSO)
ON UPDATE CASCADE
ON DELETE CASCADE

) ENGINE = InnoDB;



CREATE TABLE CURSO(
ID_CURSO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
NOMBRE VARCHAR(40) NOT NULL,
DESCRIPCION VARCHAR(100) NOT NULL,
ID_COORDINADOR_CURSO INT NOT NULL,
ID_COORDINADOR_RECURSO INT NOT NULL,
NOTA FLOAT(3,2) NOT NULL,

CONSTRAINT FK_ID_USUARIO,
FOREIGN KEY (ID_COORDINADOR_CURSO) REFERENCES USUARIO_CURSO(ID_USUARIO)
ON UPDATE CASCADE
ON DELETE CASCADE,

CONSTRAINT FK_ID_USUARIO,
FOREIGN KEY (ID_COORDINADOR_RECURSO) REFERENCES USUARIO_CURSO(ID_USUARIO)
ON UPDATE CASCADE
ON DELETE CASCADE

) ENGINE = InnoDB;

CREATE TABLE RECURSOS(
ID_RECURSOS INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
ID_CURSO INT NOT NULL,
RECRUSOS VARCHAR( 40 ) NOT NULL,


CONSTRAINT FK_ID_CURSO,
FOREIGN KEY (ID_CURSO) REFERENCES CURSO(ID_CURSO)
ON UPDATE CASCADE
ON DELETE CASCADE

) ENGINE = InnoDB;


CREATE TABLE PONENTES(
ID_PONENTES INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
ID_CURSO INT NOT NULL,
PONENTES VARCHAR( 40 ) NOT NULL,

CONSTRAINT FK_ID_CURSO,
FOREIGN KEY (ID_CURSO) REFERENCES CURSO(ID_CURSO)
ON UPDATE CASCADE
ON DELETE CASCADE

) ENGINE = InnoDB;