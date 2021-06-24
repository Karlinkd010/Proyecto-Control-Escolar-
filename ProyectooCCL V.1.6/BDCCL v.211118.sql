/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.9-log : Database - bdcontrolescola
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bdcontrolescola` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bdcontrolescola`;

/*Table structure for table `tblalumnos` */

DROP TABLE IF EXISTS `tblalumnos`;

CREATE TABLE `tblalumnos` (
  `vchMatricula` varchar(10) NOT NULL,
  `vchNombre` varchar(200) DEFAULT NULL,
  `vchCurp` varchar(12) DEFAULT NULL,
  `vchFechaNac` varchar(12) DEFAULT NULL,
  `vchTel` int(10) DEFAULT NULL,
  `vchCorreo` varchar(50) DEFAULT NULL,
  `dtFechaIngreso` date DEFAULT NULL,
  `vchimagen` longblob,
  PRIMARY KEY (`vchMatricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tblalumnos` */

LOCK TABLES `tblalumnos` WRITE;


UNLOCK TABLES;

/*Table structure for table `tblalumnosinscritos` */

DROP TABLE IF EXISTS `tblalumnosinscritos`;

CREATE TABLE `tblalumnosinscritos` (
  `intidinscritos` int(11) NOT NULL AUTO_INCREMENT,
  `vchMatricula` varchar(10) DEFAULT NULL,
  `intidperiodo` int(11) DEFAULT NULL,
  `chrgrupo` char(1) DEFAULT NULL,
  `intidGrado` int(11) DEFAULT NULL,
  `fechainscripcion` date DEFAULT NULL,
  PRIMARY KEY (`intidinscritos`),
  KEY `vchMatricula` (`vchMatricula`),
  KEY `intidGrado` (`intidGrado`),
  KEY `intidperiodo` (`intidperiodo`),
  CONSTRAINT `tblalumnosinscritos_ibfk_1` FOREIGN KEY (`vchMatricula`) REFERENCES `tblalumnos` (`vchMatricula`) ON DELETE CASCADE,
  CONSTRAINT `tblalumnosinscritos_ibfk_2` FOREIGN KEY (`intidGrado`) REFERENCES `tblgrados` (`intidgrado`) ON DELETE CASCADE,
  CONSTRAINT `tblalumnosinscritos_ibfk_3` FOREIGN KEY (`intidperiodo`) REFERENCES `tblperiodo` (`intidperiodo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tblalumnosinscritos` */

LOCK TABLES `tblalumnosinscritos` WRITE;

insert  into `tblalumnosinscritos`(`intidinscritos`,`vchMatricula`,`intidperiodo`,`chrgrupo`,`intidGrado`,`fechainscripcion`) values (7,'20171063',7,'A',2,'2018-12-06');

UNLOCK TABLES;

/*Table structure for table `tblasignaprofesores` */

DROP TABLE IF EXISTS `tblasignaprofesores`;

CREATE TABLE `tblasignaprofesores` (
  `intidasigna` int(11) NOT NULL AUTO_INCREMENT,
  `inidprofesor` int(11) DEFAULT NULL,
  `intidgrado` int(11) DEFAULT NULL,
  PRIMARY KEY (`intidasigna`),
  KEY `intidgrado` (`intidgrado`),
  KEY `inidprofesor` (`inidprofesor`),
  CONSTRAINT `tblasignaprofesores_ibfk_1` FOREIGN KEY (`intidgrado`) REFERENCES `tblgrados` (`intidgrado`),
  CONSTRAINT `tblasignaprofesores_ibfk_2` FOREIGN KEY (`inidprofesor`) REFERENCES `tblprofesor` (`intidprofesor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tblasignaprofesores` */

LOCK TABLES `tblasignaprofesores` WRITE;

UNLOCK TABLES;

/*Table structure for table `tblcalificaciones` */

DROP TABLE IF EXISTS `tblcalificaciones`;

CREATE TABLE `tblcalificaciones` (
  `intidcalificacion` int(11) NOT NULL AUTO_INCREMENT,
  `vchMatricula` varchar(10) DEFAULT NULL,
  `B1` float DEFAULT NULL,
  `B2` float DEFAULT NULL,
  `B3` float DEFAULT NULL,
  `B4` float DEFAULT NULL,
  `B5` float DEFAULT NULL,
  `B6` float DEFAULT NULL,
  PRIMARY KEY (`intidcalificacion`),
  KEY `vchMatricula` (`vchMatricula`),
  CONSTRAINT `tblcalificaciones_ibfk_1` FOREIGN KEY (`vchMatricula`) REFERENCES `tblalumnos` (`vchMatricula`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tblcalificaciones` */

LOCK TABLES `tblcalificaciones` WRITE;

insert  into `tblcalificaciones`(`intidcalificacion`,`vchMatricula`,`B1`,`B2`,`B3`,`B4`,`B5`,`B6`) values (2,'20171063',NULL,NULL,NULL,NULL,NULL,NULL),(5,'20171063',NULL,NULL,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `tblgrados` */

DROP TABLE IF EXISTS `tblgrados`;

CREATE TABLE `tblgrados` (
  `intidgrado` int(11) NOT NULL AUTO_INCREMENT,
  `vchGrado` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`intidgrado`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tblgrados` */

LOCK TABLES `tblgrados` WRITE;

insert  into `tblgrados`(`intidgrado`,`vchGrado`) values (1,'Primer'),(2,'Segundo'),(3,'Tercero');

UNLOCK TABLES;

/*Table structure for table `tblmaterias` */

DROP TABLE IF EXISTS `tblmaterias`;

CREATE TABLE `tblmaterias` (
  `intidmaterias` int(11) NOT NULL AUTO_INCREMENT,
  `Materia` varchar(30) DEFAULT NULL,
  `intidgrado` int(11) DEFAULT NULL,
  PRIMARY KEY (`intidmaterias`),
  KEY `intidgrado` (`intidgrado`),
  CONSTRAINT `tblmaterias_ibfk_1` FOREIGN KEY (`intidgrado`) REFERENCES `tblgrados` (`intidgrado`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `tblmaterias` */

LOCK TABLES `tblmaterias` WRITE;

insert  into `tblmaterias`(`intidmaterias`,`Materia`,`intidgrado`) values (1,'Ciencias Naturales I',1),(5,'Matematicas I',1),(6,'Ingles I',1),(7,'Ciencias Naturales II',2),(8,'Matematicas II',2),(9,'Ingles II',2),(10,'Geografia I',1),(11,'Español I',1),(12,'Informática',1),(13,'Desarrollo Web',3),(14,'Ingles III',3),(15,'Derivadas I',3),(16,'Informatica',3),(17,'Taller de Redacción',3),(18,'Educacion C y E',3),(19,'Historia de Mx',2),(20,'Educacion Fisica',1),(21,'Educacion Fisica',2),(22,'Educacion Fisica',3),(23,'Fisica',1),(24,'Fisica II',2),(25,'Fisica III',3);

UNLOCK TABLES;

/*Table structure for table `tblperiodo` */

DROP TABLE IF EXISTS `tblperiodo`;

CREATE TABLE `tblperiodo` (
  `intidperiodo` int(11) NOT NULL AUTO_INCREMENT,
  `periodo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`intidperiodo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `tblperiodo` */

LOCK TABLES `tblperiodo` WRITE;

insert  into `tblperiodo`(`intidperiodo`,`periodo`) values (6,'2015'),(7,'2016'),(8,'2017'),(10,'2018');

UNLOCK TABLES;

/*Table structure for table `tblprofesor` */

DROP TABLE IF EXISTS `tblprofesor`;

CREATE TABLE `tblprofesor` (
  `intidprofesor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `ruta` varchar(500) DEFAULT NULL,
  `Imagen` longtext,
  PRIMARY KEY (`intidprofesor`)
) ENGINE=InnoDB AUTO_INCREMENT=201803 DEFAULT CHARSET=utf8;

/*Data for the table `tblprofesor` */

LOCK TABLES `tblprofesor` WRITE;

insert  into `tblprofesor`(`intidprofesor`,`Nombre`,`Direccion`,`Telefono`,`email`,`ruta`,`Imagen`) values (201,'Martinez','Chiatipan','123456789','Huazalingo','C:\\Users\\user\\Pictures\\Ver.png','/9j/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAx\r\nNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAAUCAAgAB8EASIAAhEBAxEBBCIA/8QAHwAAAQUB\r\nAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEG\r\nE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVW\r\nV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLD\r\nxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAA\r\nAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKR\r\nobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hp\r\nanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU\r\n1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADgQBAAIRAxEEAAA/APn+iiigD13wd4O0vwdoVtYW\r\nNrEsyxjz7jaN8r45JPXr27Vxnij47+H/AA54gl0mOyur9rd/LuJYSoVGHUDP3iOh6DNeq18jeMvh\r\nnrsXjDUxpcUepWkly7rNBOh2ZYnbJz8jDODnFFFFFAH1RoWuWHiPRbXVtMm820uV3IxGCOxBHYgg\r\ng/Sue+IHw80vxxpDRSwRxagjK0N2qgOvIyCe4Izwab8KtAPhv4fWFi93BdSkvLI8EgeMMzElVYcH\r\nHT6g12lFFFFAHCfF7xPc+Ffh9d3VlIYry4dbWGQdULZyw9wobHvivjxmZ2LMSzE5JJySa+r7+20X\r\n44eCNOjg1j7K8cizzxRhWkjkCFSrKSMDLHB71zX/AAzTpv8A0Ml1/wCAy/40UUUUAcz+z34pu7Px\r\nW/h2SZmsb6J3jjJ4SVRuyPTKg59cD0r6arybwj8DbLwl4pstch1y4uHtSxETQKobcpXrn3rp/iB8\r\nQ9L8D6Q0ss8cuoOyiG0VgXbkZJHYAZ5Nf//Z');

UNLOCK TABLES;

/*Table structure for table `tblusuario` */

DROP TABLE IF EXISTS `tblusuario`;

CREATE TABLE `tblusuario` (
  `intIdusuario` int(11) NOT NULL AUTO_INCREMENT,
  `txtUsuario` varchar(22) DEFAULT NULL,
  `txtPassword` varchar(22) DEFAULT NULL,
  `enumTipo` enum('PROFESOR','ALUMNO','ADMINISTRADOR') DEFAULT NULL,
  PRIMARY KEY (`intIdusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `tblusuario` */

LOCK TABLES `tblusuario` WRITE;

insert  into `tblusuario`(`intIdusuario`,`txtUsuario`,`txtPassword`,`enumTipo`) values (13,'admin','admin','ADMINISTRADOR'),(16,'20171063','20171063','ALUMNO');

UNLOCK TABLES;

/* Trigger structure for table `tblalumnosinscritos` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Inserta_tblUsuarios` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'%' */ /*!50003 TRIGGER `Inserta_tblUsuarios` AFTER INSERT ON `tblalumnosinscritos` FOR EACH ROW BEGIN
     INSERT INTO tblusuario(txtUsuario,txtPassword,enumTipo)
    VALUES (new.vchMatricula,new.vchMatricula,'ALUMNO');
    END */$$


DELIMITER ;

/* Trigger structure for table `tblalumnosinscritos` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Inserta_tblCalificaciones` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'%' */ /*!50003 TRIGGER `Inserta_tblCalificaciones` AFTER INSERT ON `tblalumnosinscritos` FOR EACH ROW BEGIN
    INSERT INTO tblcalificaciones(`vchMatricula`)
    VALUES (new.vchMatricula);
    END */$$


DELIMITER ;

/* Trigger structure for table `tblalumnosinscritos` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Elimina_tblUser` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'%' */ /*!50003 TRIGGER `Elimina_tblUser` AFTER DELETE ON `tblalumnosinscritos` FOR EACH ROW BEGIN
    DELETE FROM tblusuario WHERE `txtUsuario`=OLD.`vchMatricula`;
    END */$$


DELIMITER ;

/* Trigger structure for table `tblalumnosinscritos` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Elimina_tblCalificaciones` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'%' */ /*!50003 TRIGGER `Elimina_tblCalificaciones` AFTER DELETE ON `tblalumnosinscritos` FOR EACH ROW BEGIN
    DELETE FROM `tblcalificaciones` WHERE `vchMatricula`=OLD.`vchMatricula`;
    END */$$


DELIMITER ;

/* Trigger structure for table `tblasignaprofesores` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Inserta_tblUsuario` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `Inserta_tblUsuario` AFTER INSERT ON `tblasignaprofesores` FOR EACH ROW BEGIN
    INSERT INTO tblusuario(txtUsuario,txtPassword,enumTipo)
    VALUES (new.inidprofesor,new.inidprofesor,'PROFESOR');
    END */$$


DELIMITER ;

/* Procedure structure for procedure `spEliminaCalificaciones` */

/*!50003 DROP PROCEDURE IF EXISTS  `spEliminaCalificaciones` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spEliminaCalificaciones`(in inidcalifi INT(10))
BEGIN
 delete from tblcalificaciones where intidcalificacion=inidcalifi;
END */$$
DELIMITER ;

/* Procedure structure for procedure `spEliminaralumnos` */

/*!50003 DROP PROCEDURE IF EXISTS  `spEliminaralumnos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`karlin`@`localhost` PROCEDURE `spEliminaralumnos`(IN matri VARCHAR(10))
BEGIN
	DELETE FROM tblalumnos WHERE `vchMatricula`=matri;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spEliminargrado` */

/*!50003 DROP PROCEDURE IF EXISTS  `spEliminargrado` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spEliminargrado`(IN idg INT(11))
BEGIN
	DELETE FROM tblgrados WHERE `intidgrado`=idg;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spEliminarMateria` */

/*!50003 DROP PROCEDURE IF EXISTS  `spEliminarMateria` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spEliminarMateria`(IN idm INT)
BEGIN
	DELETE FROM tblmaterias WHERE `intidmaterias`=idm;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spEliminarperiodo` */

/*!50003 DROP PROCEDURE IF EXISTS  `spEliminarperiodo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spEliminarperiodo`(IN idpe int)
BEGIN
	DELETE FROM tblperiodo WHERE `intidperiodo`=idpe;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spEliminarprofes` */

/*!50003 DROP PROCEDURE IF EXISTS  `spEliminarprofes` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`Gerass`@`%` PROCEDURE `spEliminarprofes`(IN id int)
BEGIN
	DELETE FROM tblprofesor WHERE `intidprofesor`=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spEliminarusuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `spEliminarusuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spEliminarusuario`(IN id INT)
BEGIN
	DELETE FROM tblusuario WHERE `intIdusuario`=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spinsertaalumnos` */

/*!50003 DROP PROCEDURE IF EXISTS  `spinsertaalumnos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spinsertaalumnos`(
in matri varchar(10),
IN Nombre VARCHAR(200),
IN cur VARCHAR(12),
IN fecha varchar(12),
IN tel int(11),
in correo varchar(15),
in fechaentrada date,
in img longblob
)
BEGIN
	INSERT INTO tblalumnos(`vchMatricula`,`vchNombre`,`vchCurp`,`vchFechaNac`,`vchTel`,`vchCorreo`,`dtFechaIngreso`,`vchimagen`)
	VALUES(matri,Nombre,cur,fecha,tel,correo,fechaentrada,img);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertaCalificaciones` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertaCalificaciones` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertaCalificaciones`(
IN inidcalifi int(11),
in matri varchar(10),
in b1 float,
in b2 float,
IN b3 FLOAT,
IN b4 FLOAT,
IN b5 FLOAT,
IN b6 FLOAT
)
begin 
	insert into `tblcalificaciones`(`intidcalificacion`,`vchMatricula`,`B1`,`B2`,`B3`,`B4`,`B5`,`B6`)
	values(inidcalifi,matri,b1,b2,b3,b4,b5,b6);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertaGrado` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertaGrado` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spInsertaGrado`(
IN grado VARCHAR(30)
)
BEGIN
	insert into tblgrados(vchGrado) values(grado);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertaMateria` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertaMateria` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spInsertaMateria`(
IN mat VARCHAR(30),
in idgrado int(11)
)
BEGIN
	insert into tblmaterias(Materia,intidgrado) values(mat,idgrado);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spinsertaperiodo` */

/*!50003 DROP PROCEDURE IF EXISTS  `spinsertaperiodo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spinsertaperiodo`(
IN periodoo VARCHAR(20)
)
BEGIN
	INSERT INTO tblperiodo(`periodo`)VALUES(periodoo);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spinsertaprof` */

/*!50003 DROP PROCEDURE IF EXISTS  `spinsertaprof` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spinsertaprof`(
in idprof int(11),
in nom varchar(100),
in direc varchar(100),
in tel varchar(100),
in correo varchar(100),
in dir varchar(100),
in img longtext
)
BEGIN
	INSERT INTO tblprofesor(`intidprofesor`,`Nombre`,`Direccion`,`Telefono`,`email`,`ruta`,`Imagen`)
	VALUES(idprof,nom,direc,tel,correo,dir,img);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spinsertarusuarios` */

/*!50003 DROP PROCEDURE IF EXISTS  `spinsertarusuarios` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`Gerass`@`%` PROCEDURE `spinsertarusuarios`(
	OUT mensaje VARCHAR(100),
	IN Usua VARCHAR(50),
	IN Pass VARCHAR(22),
	IN Tipo ENUM('PROFESOR','ALUMNO','ADMINISTRADOR')
)
BEGIN	
	IF! EXISTS(SELECT tblusuario.`txtUsuario`FROM tblusuario WHERE tblusuario.`txtUsuario`=Usua AND tblusuario.`enumTipo`=Tipo)
	 THEN
		INSERT INTO tblusuario(txtUsuario,txtPassword,enumTipo)
		VALUES (Usua,Pass,Tipo);
		SET mensaje="AGREGADO EXITOSAMENTE";
	ELSE
		SET mensaje="USUARIO REPETIDO";
		
	END IF;
		
END */$$
DELIMITER ;

/* Procedure structure for procedure `spinsertatblAsignaProf` */

/*!50003 DROP PROCEDURE IF EXISTS  `spinsertatblAsignaProf` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spinsertatblAsignaProf`(
IN idprofe int(11),
IN idgrado int(11)
)
BEGIN
	INSERT INTO tblasignaprofesores(inidprofesor,intidgrado)
	VALUES(idprofe,idgrado);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spinsertaUser` */

/*!50003 DROP PROCEDURE IF EXISTS  `spinsertaUser` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spinsertaUser`(
	IN Usua VARCHAR(50),
	IN Pass VARCHAR(22),
	IN Tipo ENUM('PROFESOR','ALUMNO','ADMINISTRADOR')
)
BEGIN	
	
		INSERT INTO tblusuario(txtUsuario,txtPassword,enumTipo)
		VALUES (Usua,Pass,Tipo);
	
		
END */$$
DELIMITER ;

/* Procedure structure for procedure `spListaalumnos` */

/*!50003 DROP PROCEDURE IF EXISTS  `spListaalumnos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`karlin`@`localhost` PROCEDURE `spListaalumnos`()
BEGIN
	SELECT `vchMatricula` AS MATRICULA,`vchNombre` AS NOMBRE_ALUMNO,`vchCurp` AS CURP,`vchFechaNac`AS FECHA_NACIMENTO,`vchTel` AS TELEFONO,`vchCorreo`AS CORREO,`dtFechaIngreso`AS FECHA_INGRESO FROM tblalumnos;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spListagrados` */

/*!50003 DROP PROCEDURE IF EXISTS  `spListagrados` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spListagrados`()
BEGIN
	SELECT `intidgrado` AS ID_GRADO,`vchGrado` AS GRADO FROM tblgrados;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spListaperiodo` */

/*!50003 DROP PROCEDURE IF EXISTS  `spListaperiodo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spListaperiodo`()
BEGIN
	SELECT `intidperiodo` AS ID_PERIODO,`periodo` AS PERIODO FROM tblperiodo;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spListaprofes` */

/*!50003 DROP PROCEDURE IF EXISTS  `spListaprofes` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`Gerass`@`%` PROCEDURE `spListaprofes`()
BEGIN
	SELECT `intidprofesor` as IDPROF,`Nombre` AS NOMBRE_PROF,`Direccion` AS DIRECCION,`Telefono` AS TELEFONO,`email` AS CORREO FROM tblprofesor;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spListausuarios` */

/*!50003 DROP PROCEDURE IF EXISTS  `spListausuarios` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spListausuarios`()
BEGIN	
	SELECT `intIdusuario` AS ID,`txtUsuario` AS USUARIO,`txtPassword` AS CONTRASEÑA,`enumTipo` AS TIPO
	FROM tblusuario;
END */$$
DELIMITER ;

/* Procedure structure for procedure `spLogin` */

/*!50003 DROP PROCEDURE IF EXISTS  `spLogin` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`Gerass`@`%` PROCEDURE `spLogin`(IN Nom VARCHAR(22),
IN Contra VARCHAR(22))
BEGIN
	SELECT * FROM tblusuario
	WHERE txtUsuario=Nom AND txtPassword=Contra;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spLogin_web` */

/*!50003 DROP PROCEDURE IF EXISTS  `spLogin_web` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`kar`@`localhost` PROCEDURE `spLogin_web`(IN Nom VARCHAR(50),IN Contra VARCHAR(200))
BEGIN
	SELECT txtUsuario,txtPassword,enumTipo FROM tblusuario
	WHERE txtUsuario=Nom AND txtPassword=Contra;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdatealumnos` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdatealumnos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spUpdatealumnos`(
IN matri VARCHAR(10),
IN Nombre VARCHAR(200),
IN cur VARCHAR(12),
IN fecha VARCHAR(12),
IN tel INT(11),
IN correo VARCHAR(15),
IN fechaentrada DATE,
IN img LONGBLOB
)
BEGIN
	UPDATE tblalumnos SET `vchNombre`=Nombre,`vchCurp`=cur,`vchFechaNac`=fecha,`vchTel`=tel,`vchCorreo`=correo,`dtFechaIngreso`=fechaentrada,`vchimagen`=img WHERE `vchMatricula`=matri;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdateCalificaciones` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdateCalificaciones` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spUpdateCalificaciones`(
IN inidcalifi INT(11),
IN matri VARCHAR(10),
IN b1 FLOAT,
IN b2 FLOAT,
IN b3 FLOAT,
IN b4 FLOAT,
IN b5 FLOAT,
IN b6 FLOAT,
IN inidmater INT(11)
)
BEGIN
	update `tblcalificaciones` set `vchMatricula`=matri,`B1`=b1,`B2`=b2,`B3`=b3,`B4`=b4,`B5`=b5,`B6`=b6 where `intidcalificacion`=inidcalifi;
END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdategrado` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdategrado` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spUpdategrado`(
in idg int,
IN grad VARCHAR(30)
)
BEGIN
	update tblgrados set `vchGrado`=grad where `intidgrado`=idg;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdateMateria` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdateMateria` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spUpdateMateria`(
IN idm INT(11),
IN mat VARCHAR(30),
in idmm int(11)
)
BEGIN
	UPDATE tblmaterias SET `Materia`=mat, `intidgrado`=idmm WHERE `intidmaterias`=idm;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdateperiodo` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdateperiodo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spUpdateperiodo`(
in idp int,
IN periodo VARCHAR(20)
)
BEGIN
	update tblperiodo set `periodo`=periodo where`intidperiodo`=idp;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdateprof` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdateprof` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`Gerass`@`%` PROCEDURE `spUpdateprof`(
in id int,
IN nom VARCHAR(100),
IN direc VARCHAR(100),
IN tel VARCHAR(100),
IN correo VARCHAR(100)
)
BEGIN
	update tblprofesor set `Nombre`=nom,`Direccion`=direc,`Telefono`=tel,`email`=correo where `intidprofesor`=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spupdateUser` */

/*!50003 DROP PROCEDURE IF EXISTS  `spupdateUser` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spupdateUser`(
	
	IN Usua VARCHAR(50),
	IN Pass VARCHAR(22),
	IN Tipo ENUM('PROFESOR','ALUMNO','ADMINISTRADOR')
)
BEGIN	
	UPDATE tblusuario SET txtUsuario=Usua,txtPassword=Pass,enumTipo=Tipo WHERE txtUsuario=Usua;
END */$$
DELIMITER ;

/* Procedure structure for procedure `spupdateUserPaswword` */

/*!50003 DROP PROCEDURE IF EXISTS  `spupdateUserPaswword` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `spupdateUserPaswword`(
	IN Iduser INT,
	IN Pass VARCHAR(22)
	
)
BEGIN	
	UPDATE tblusuario SET txtPassword=Pass WHERE `intIdusuario`=Iduser;
END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdateusuarios` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdateusuarios` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`Gerass`@`%` PROCEDURE `spUpdateusuarios`(
	in Iduser int,
	IN Usua VARCHAR(50),
	IN Pass VARCHAR(22),
	IN Tipo ENUM('PROFESOR','ALUMNO','ADMINISTRADOR')
)
BEGIN	
	update tblusuario set txtUsuario=Usua,txtPassword=Pass,enumTipo=Tipo where `intIdusuario`=Iduser;
END */$$
DELIMITER ;

/*Table structure for table `vw_asigna` */

DROP TABLE IF EXISTS `vw_asigna`;

/*!50001 DROP VIEW IF EXISTS `vw_asigna` */;
/*!50001 DROP TABLE IF EXISTS `vw_asigna` */;

/*!50001 CREATE TABLE  `vw_asigna`(
 `intidinscritos` int(11) ,
 `vchMatricula` varchar(10) ,
 `vchNombre` varchar(200) ,
 `vchCurp` varchar(12) ,
 `chrgrupo` char(1) ,
 `vchGrado` varchar(30) ,
 `periodo` varchar(20) ,
 `fechainscripcion` date 
)*/;

/*Table structure for table `vw_consultaalumno` */

DROP TABLE IF EXISTS `vw_consultaalumno`;

/*!50001 DROP VIEW IF EXISTS `vw_consultaalumno` */;
/*!50001 DROP TABLE IF EXISTS `vw_consultaalumno` */;

/*!50001 CREATE TABLE  `vw_consultaalumno`(
 `vchMatricula` varchar(10) ,
 `vchNombre` varchar(200) ,
 `vchGrado` varchar(30) ,
 `chrgrupo` char(1) ,
 `periodo` varchar(20) ,
 `vchimagen` longblob 
)*/;

/*Table structure for table `vw_datosalumno` */

DROP TABLE IF EXISTS `vw_datosalumno`;

/*!50001 DROP VIEW IF EXISTS `vw_datosalumno` */;
/*!50001 DROP TABLE IF EXISTS `vw_datosalumno` */;

/*!50001 CREATE TABLE  `vw_datosalumno`(
 `vchMatricula` varchar(10) ,
 `vchNombre` varchar(200) ,
 `vchFechaNac` varchar(12) ,
 `vchCurp` varchar(12) ,
 `chrgrupo` char(1) ,
 `periodo` varchar(20) ,
 `vchGrado` varchar(30) 
)*/;

/*Table structure for table `vw_datosprofe` */

DROP TABLE IF EXISTS `vw_datosprofe`;

/*!50001 DROP VIEW IF EXISTS `vw_datosprofe` */;
/*!50001 DROP TABLE IF EXISTS `vw_datosprofe` */;

/*!50001 CREATE TABLE  `vw_datosprofe`(
 `Nombre` varchar(100) ,
 `Direccion` varchar(100) ,
 `Telefono` varchar(10) ,
 `email` varchar(100) ,
 `Materia` varchar(30) ,
 `vchGrado` varchar(30) ,
 `periodo` varchar(20) 
)*/;

/*Table structure for table `vw_materia` */

DROP TABLE IF EXISTS `vw_materia`;

/*!50001 DROP VIEW IF EXISTS `vw_materia` */;
/*!50001 DROP TABLE IF EXISTS `vw_materia` */;

/*!50001 CREATE TABLE  `vw_materia`(
 `intidmaterias` int(11) ,
 `Materia` varchar(30) ,
 `vchGrado` varchar(30) 
)*/;

/*Table structure for table `vw_tblcalificaciones` */

DROP TABLE IF EXISTS `vw_tblcalificaciones`;

/*!50001 DROP VIEW IF EXISTS `vw_tblcalificaciones` */;
/*!50001 DROP TABLE IF EXISTS `vw_tblcalificaciones` */;

/*!50001 CREATE TABLE  `vw_tblcalificaciones`(
 `vchMatricula` varchar(10) ,
 `vchNombre` varchar(200) ,
 `vchGrado` varchar(30) ,
 `periodo` varchar(20) 
)*/;

/*View structure for view vw_asigna */

/*!50001 DROP TABLE IF EXISTS `vw_asigna` */;
/*!50001 DROP VIEW IF EXISTS `vw_asigna` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_asigna` AS (select `tblalumnosinscritos`.`intidinscritos` AS `intidinscritos`,`tblalumnos`.`vchMatricula` AS `vchMatricula`,`tblalumnos`.`vchNombre` AS `vchNombre`,`tblalumnos`.`vchCurp` AS `vchCurp`,`tblalumnosinscritos`.`chrgrupo` AS `chrgrupo`,`tblgrados`.`vchGrado` AS `vchGrado`,`tblperiodo`.`periodo` AS `periodo`,`tblalumnosinscritos`.`fechainscripcion` AS `fechainscripcion` from (((`tblalumnosinscritos` join `tblalumnos` on((`tblalumnosinscritos`.`vchMatricula` = `tblalumnos`.`vchMatricula`))) join `tblgrados` on((`tblalumnosinscritos`.`intidGrado` = `tblgrados`.`intidgrado`))) join `tblperiodo` on((`tblalumnosinscritos`.`intidperiodo` = `tblperiodo`.`intidperiodo`)))) */;

/*View structure for view vw_consultaalumno */

/*!50001 DROP TABLE IF EXISTS `vw_consultaalumno` */;
/*!50001 DROP VIEW IF EXISTS `vw_consultaalumno` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vw_consultaalumno` AS (select `tblalumnos`.`vchMatricula` AS `vchMatricula`,`tblalumnos`.`vchNombre` AS `vchNombre`,`tblgrados`.`vchGrado` AS `vchGrado`,`tblalumnosinscritos`.`chrgrupo` AS `chrgrupo`,`tblperiodo`.`periodo` AS `periodo`,`tblalumnos`.`vchimagen` AS `vchimagen` from (((`tblalumnosinscritos` join `tblalumnos` on((`tblalumnosinscritos`.`vchMatricula` = `tblalumnos`.`vchMatricula`))) join `tblgrados` on((`tblalumnosinscritos`.`intidGrado` = `tblgrados`.`intidgrado`))) join `tblperiodo` on((`tblalumnosinscritos`.`intidperiodo` = `tblperiodo`.`intidperiodo`)))) */;

/*View structure for view vw_datosalumno */

/*!50001 DROP TABLE IF EXISTS `vw_datosalumno` */;
/*!50001 DROP VIEW IF EXISTS `vw_datosalumno` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`Gerass`@`%` SQL SECURITY DEFINER VIEW `vw_datosalumno` AS (select `tblalumnos`.`vchMatricula` AS `vchMatricula`,`tblalumnos`.`vchNombre` AS `vchNombre`,`tblalumnos`.`vchFechaNac` AS `vchFechaNac`,`tblalumnos`.`vchCurp` AS `vchCurp`,`tblalumnosinscritos`.`chrgrupo` AS `chrgrupo`,`tblperiodo`.`periodo` AS `periodo`,`tblgrados`.`vchGrado` AS `vchGrado` from (((`tblalumnosinscritos` join `tblalumnos` on((`tblalumnosinscritos`.`vchMatricula` = `tblalumnos`.`vchMatricula`))) join `tblgrados` on((`tblalumnosinscritos`.`intidGrado` = `tblgrados`.`intidgrado`))) join `tblperiodo` on((`tblalumnosinscritos`.`intidperiodo` = `tblperiodo`.`intidperiodo`)))) */;

/*View structure for view vw_datosprofe */

/*!50001 DROP TABLE IF EXISTS `vw_datosprofe` */;
/*!50001 DROP VIEW IF EXISTS `vw_datosprofe` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`Gerass`@`%` SQL SECURITY DEFINER VIEW `vw_datosprofe` AS (select `tblprofesor`.`Nombre` AS `Nombre`,`tblprofesor`.`Direccion` AS `Direccion`,`tblprofesor`.`Telefono` AS `Telefono`,`tblprofesor`.`email` AS `email`,`tblmaterias`.`Materia` AS `Materia`,`tblgrados`.`vchGrado` AS `vchGrado`,`tblperiodo`.`periodo` AS `periodo` from (`tblperiodo` join (((`tblasignaprofesores` join `tblgrados` on((`tblasignaprofesores`.`intidgrado` = `tblgrados`.`intidgrado`))) join `tblmaterias` on((`tblmaterias`.`intidgrado` = `tblgrados`.`intidgrado`))) join `tblprofesor` on((`tblasignaprofesores`.`inidprofesor` = `tblprofesor`.`intidprofesor`))))) */;

/*View structure for view vw_materia */

/*!50001 DROP TABLE IF EXISTS `vw_materia` */;
/*!50001 DROP VIEW IF EXISTS `vw_materia` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vw_materia` AS (select `tblmaterias`.`intidmaterias` AS `intidmaterias`,`tblmaterias`.`Materia` AS `Materia`,`tblgrados`.`vchGrado` AS `vchGrado` from (`tblmaterias` join `tblgrados` on((`tblmaterias`.`intidgrado` = `tblgrados`.`intidgrado`)))) */;

/*View structure for view vw_tblcalificaciones */

/*!50001 DROP TABLE IF EXISTS `vw_tblcalificaciones` */;
/*!50001 DROP VIEW IF EXISTS `vw_tblcalificaciones` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vw_tblcalificaciones` AS (select `tblalumnos`.`vchMatricula` AS `vchMatricula`,`tblalumnos`.`vchNombre` AS `vchNombre`,`tblgrados`.`vchGrado` AS `vchGrado`,`tblperiodo`.`periodo` AS `periodo` from ((((`tblalumnosinscritos` join `tblalumnos` on((`tblalumnosinscritos`.`vchMatricula` = `tblalumnos`.`vchMatricula`))) join `tblcalificaciones` on((`tblcalificaciones`.`vchMatricula` = `tblalumnos`.`vchMatricula`))) join `tblgrados` on((`tblalumnosinscritos`.`intidGrado` = `tblgrados`.`intidgrado`))) join `tblperiodo` on((`tblalumnosinscritos`.`intidperiodo` = `tblperiodo`.`intidperiodo`)))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;