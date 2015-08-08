-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: veterinaria
-- ------------------------------------------------------
-- Server version	5.5.45-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comuna`
--

DROP TABLE IF EXISTS `comuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comuna` (
  `comuna_id` int(11) NOT NULL,
  `comuna_nombre` varchar(100) DEFAULT NULL,
  `comuna_provincia_id` int(11) NOT NULL,
  PRIMARY KEY (`comuna_id`,`comuna_provincia_id`),
  KEY `fk_comuna_provincia1_idx` (`comuna_provincia_id`),
  CONSTRAINT `fk_comuna_provincia1` FOREIGN KEY (`comuna_provincia_id`) REFERENCES `provincia` (`provincia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comuna`
--

LOCK TABLES `comuna` WRITE;
/*!40000 ALTER TABLE `comuna` DISABLE KEYS */;
INSERT INTO `comuna` VALUES (1101,'Iquique',11),(1107,'Alto Hospicio',11),(1401,'Pozo Almonte',14),(1402,'Camiña',14),(1403,'Colchane',14),(1404,'Huara',14),(1405,'Pica',14),(2101,'Antofagasta',21),(2102,'Mejillones',21),(2103,'Sierra Gorda',21),(2104,'Taltal',21),(2201,'Calama',22),(2202,'Ollagüe',22),(2203,'San Pedro de Atacama',22),(2301,'Tocopilla',23),(2302,'María Elena',23),(3101,'Copiapó',31),(3102,'Caldera',31),(3103,'Tierra Amarilla',31),(3201,'Chañaral',32),(3202,'Diego de Almagro',32),(3301,'Vallenar',33),(3302,'Alto del Carmen',33),(3303,'Freirina',33),(3304,'Huasco',33),(4101,'La Serena',41),(4102,'Coquimbo',41),(4103,'Andacollo',41),(4104,'La Higuera',41),(4105,'Paiguano',41),(4106,'Vicuña',41),(4201,'Illapel',42),(4202,'Canela',42),(4203,'Los Vilos',42),(4204,'Salamanca',42),(4301,'Ovalle',43),(4302,'Combarbalá',43),(4303,'Monte Patria',43),(4304,'Punitaqui',43),(4305,'Río Hurtado',43),(5101,'Valparaíso',51),(5102,'Casablanca',51),(5103,'Concón',51),(5104,'Juan Fernández',51),(5105,'Puchuncaví',51),(5107,'Quintero',51),(5109,'Viña del Mar',51),(5201,'Isla de Pascua',52),(5301,'Los Andes',53),(5302,'Calle Larga',53),(5303,'Rinconada',53),(5304,'San Esteban',53),(5401,'La Ligua',54),(5402,'Cabildo',54),(5403,'Papudo',54),(5404,'Petorca',54),(5405,'Zapallar',54),(5501,'Quillota',55),(5502,'Calera',55),(5503,'Hijuelas',55),(5504,'La Cruz',55),(5506,'Nogales',55),(5601,'San Antonio',56),(5602,'Algarrobo',56),(5603,'Cartagena',56),(5604,'El Quisco',56),(5605,'El Tabo',56),(5606,'Santo Domingo',56),(5701,'San Felipe',57),(5702,'Catemu',57),(5703,'Llaillay',57),(5704,'Panquehue',57),(5705,'Putaendo',57),(5706,'Santa María',57),(5801,'Quilpué',58),(5802,'Limache',58),(5803,'Olmué',58),(5804,'Villa Alemana',58),(6101,'Rancagua',61),(6102,'Codegua',61),(6103,'Coinco',61),(6104,'Coltauco',61),(6105,'Doñihue',61),(6106,'Graneros',61),(6107,'Las Cabras',61),(6108,'Machalí',61),(6109,'Malloa',61),(6110,'Mostazal',61),(6111,'Olivar',61),(6112,'Peumo',61),(6113,'Pichidegua',61),(6114,'Quinta de Tilcoco',61),(6115,'Rengo',61),(6116,'Requínoa',61),(6117,'San Vicente',61),(6201,'Pichilemu',62),(6202,'La Estrella',62),(6203,'Litueche',62),(6204,'Marchihue',62),(6205,'Navidad',62),(6206,'Paredones',62),(6301,'San Fernando',63),(6302,'Chépica',63),(6303,'Chimbarongo',63),(6304,'Lolol',63),(6305,'Nancagua',63),(6306,'Palmilla',63),(6307,'Peralillo',63),(6308,'Placilla',63),(6309,'Pumanque',63),(6310,'Santa Cruz',63),(7101,'Talca',71),(7102,'Constitución',71),(7103,'Curepto',71),(7104,'Empedrado',71),(7105,'Maule',71),(7106,'Pelarco',71),(7107,'Pencahue',71),(7108,'Río Claro',71),(7109,'San Clemente',71),(7110,'San Rafael',71),(7201,'Cauquenes',72),(7202,'Chanco',72),(7203,'Pelluhue',72),(7301,'Curicó',73),(7302,'Hualañé',73),(7303,'Licantén',73),(7304,'Molina',73),(7305,'Rauco',73),(7306,'Romeral',73),(7307,'Sagrada Familia',73),(7308,'Teno',73),(7309,'Vichuquén',73),(7401,'Linares',74),(7402,'Colbún',74),(7403,'Longaví',74),(7404,'Parral',74),(7405,'Retiro',74),(7406,'San Javier',74),(7407,'Villa Alegre',74),(7408,'Yerbas Buenas',74),(8101,'Concepción',81),(8102,'Coronel',81),(8103,'Chiguayante',81),(8104,'Florida',81),(8105,'Hualqui',81),(8106,'Lota',81),(8107,'Penco',81),(8108,'San Pedro de la Paz',81),(8109,'Santa Juana',81),(8110,'Talcahuano',81),(8111,'Tomé',81),(8112,'Hualpén',81),(8201,'Lebu',82),(8202,'Arauco',82),(8203,'Cañete',82),(8204,'Contulmo',82),(8205,'Curanilahue',82),(8206,'Los Álamos',82),(8207,'Tirúa',82),(8301,'Los Ángeles',83),(8302,'Antuco',83),(8303,'Cabrero',83),(8304,'Laja',83),(8305,'Mulchén',83),(8306,'Nacimiento',83),(8307,'Negrete',83),(8308,'Quilaco',83),(8309,'Quilleco',83),(8310,'San Rosendo',83),(8311,'Santa Bárbara',83),(8312,'Tucapel',83),(8313,'Yumbel',83),(8314,'Alto Biobío',83),(8401,'Chillán',84),(8402,'Bulnes',84),(8403,'Cobquecura',84),(8404,'Coelemu',84),(8405,'Coihueco',84),(8406,'Chillán Viejo',84),(8407,'El Carmen',84),(8408,'Ninhue',84),(8409,'Ñiquén',84),(8410,'Pemuco',84),(8411,'Pinto',84),(8412,'Portezuelo',84),(8413,'Quillón',84),(8414,'Quirihue',84),(8415,'Ránquil',84),(8416,'San Carlos',84),(8417,'San Fabián',84),(8418,'San Ignacio',84),(8419,'San Nicolás',84),(8420,'Treguaco',84),(8421,'Yungay',84),(9101,'Temuco',91),(9102,'Carahue',91),(9103,'Cunco',91),(9104,'Curarrehue',91),(9105,'Freire',91),(9106,'Galvarino',91),(9107,'Gorbea',91),(9108,'Lautaro',91),(9109,'Loncoche',91),(9110,'Melipeuco',91),(9111,'Nueva Imperial',91),(9112,'Padre las Casas',91),(9113,'Perquenco',91),(9114,'Pitrufquén',91),(9115,'Pucón',91),(9116,'Saavedra',91),(9117,'Teodoro Schmidt',91),(9118,'Toltén',91),(9119,'Vilcún',91),(9120,'Villarrica',91),(9121,'Cholchol',91),(9201,'Angol',92),(9202,'Collipulli',92),(9203,'Curacautín',92),(9204,'Ercilla',92),(9205,'Lonquimay',92),(9206,'Los Sauces',92),(9207,'Lumaco',92),(9208,'Purén',92),(9209,'Renaico',92),(9210,'Traiguén',92),(9211,'Victoria',92),(10101,'Puerto Montt',101),(10102,'Calbuco',101),(10103,'Cochamó',101),(10104,'Fresia',101),(10105,'Frutillar',101),(10106,'Los Muermos',101),(10107,'Llanquihue',101),(10108,'Maullín',101),(10109,'Puerto Varas',101),(10201,'Castro',102),(10202,'Ancud',102),(10203,'Chonchi',102),(10204,'Curaco de Vélez',102),(10205,'Dalcahue',102),(10206,'Puqueldón',102),(10207,'Queilén',102),(10208,'Quellón',102),(10209,'Quemchi',102),(10210,'Quinchao',102),(10301,'Osorno',103),(10302,'Puerto Octay',103),(10303,'Purranque',103),(10304,'Puyehue',103),(10305,'Río Negro',103),(10306,'San Juan de la Costa',103),(10307,'San Pablo',103),(10401,'Chaitén',104),(10402,'Futaleufú',104),(10403,'Hualaihué',104),(10404,'Palena',104),(11101,'Coihaique',111),(11102,'Lago Verde',111),(11201,'Aisén',112),(11202,'Cisnes',112),(11203,'Guaitecas',112),(11301,'Cochrane',113),(11302,'O’Higgins',113),(11303,'Tortel',113),(11401,'Chile Chico',114),(11402,'Río Ibáñez',114),(12101,'Punta Arenas',121),(12102,'Laguna Blanca',121),(12103,'Río Verde',121),(12104,'San Gregorio',121),(12201,'Cabo de Hornos',122),(12202,'Antártica',122),(12301,'Porvenir',123),(12302,'Primavera',123),(12303,'Timaukel',123),(12401,'Natales',124),(12402,'Torres del Paine',124),(13101,'Santiago',131),(13102,'Cerrillos',131),(13103,'Cerro Navia',131),(13104,'Conchalí',131),(13105,'El Bosque',131),(13106,'Estación Central',131),(13107,'Huechuraba',131),(13108,'Independencia',131),(13109,'La Cisterna',131),(13110,'La Florida',131),(13111,'La Granja',131),(13112,'La Pintana',131),(13113,'La Reina',131),(13114,'Las Condes',131),(13115,'Lo Barnechea',131),(13116,'Lo Espejo',131),(13117,'Lo Prado',131),(13118,'Macul',131),(13119,'Maipú',131),(13120,'Ñuñoa',131),(13121,'Pedro Aguirre Cerda',131),(13122,'Peñalolén',131),(13123,'Providencia',131),(13124,'Pudahuel',131),(13125,'Quilicura',131),(13126,'Quinta Normal',131),(13127,'Recoleta',131),(13128,'Renca',131),(13129,'San Joaquín',131),(13130,'San Miguel',131),(13131,'San Ramón',131),(13132,'Vitacura',131),(13201,'Puente Alto',132),(13202,'Pirque',132),(13203,'San José de Maipo',132),(13301,'Colina',133),(13302,'Lampa',133),(13303,'Tiltil',133),(13401,'San Bernardo',134),(13402,'Buin',134),(13403,'Calera de Tango',134),(13404,'Paine',134),(13501,'Melipilla',135),(13502,'Alhué',135),(13503,'Curacaví',135),(13504,'María Pinto',135),(13505,'San Pedro',135),(13601,'Talagante',136),(13602,'El Monte',136),(13603,'Isla de Maipo',136),(13604,'Padre Hurtado',136),(13605,'Peñaflor',136),(14101,'Valdivia',141),(14102,'Corral',141),(14103,'Lanco',141),(14104,'Los Lagos',141),(14105,'Máfil',141),(14106,'Mariquina',141),(14107,'Paillaco',141),(14108,'Panguipulli',141),(14201,'La Unión',142),(14202,'Futrono',142),(14203,'Lago Ranco',142),(14204,'Río Bueno',142),(15101,'Arica',151),(15102,'Camarones',151),(15201,'Putre',152),(15202,'General Lagos',152);
/*!40000 ALTER TABLE `comuna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial` (
  `id_historial` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `observaciones` longtext,
  `tratamiento` longtext,
  PRIMARY KEY (`id_historial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_has_mascota`
--

DROP TABLE IF EXISTS `historial_has_mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_has_mascota` (
  `historial_id_historial` int(11) NOT NULL,
  `mascota_id_mascota` int(11) NOT NULL,
  PRIMARY KEY (`historial_id_historial`,`mascota_id_mascota`),
  KEY `fk_historial_has_mascota_mascota1_idx` (`mascota_id_mascota`),
  KEY `fk_historial_has_mascota_historial1_idx` (`historial_id_historial`),
  CONSTRAINT `fk_historial_has_mascota_historial1` FOREIGN KEY (`historial_id_historial`) REFERENCES `historial` (`id_historial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_historial_has_mascota_mascota1` FOREIGN KEY (`mascota_id_mascota`) REFERENCES `mascota` (`id_mascota`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_has_mascota`
--

LOCK TABLES `historial_has_mascota` WRITE;
/*!40000 ALTER TABLE `historial_has_mascota` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_has_mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mascota` (
  `id_mascota` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `especie` varchar(100) NOT NULL,
  `raza` varchar(100) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `inscripcion` varchar(100) NOT NULL,
  `color` varchar(45) NOT NULL,
  `propietario_id_propietario` int(11) NOT NULL,
  PRIMARY KEY (`id_mascota`,`propietario_id_propietario`),
  KEY `fk_mascota_propietario1_idx` (`propietario_id_propietario`),
  CONSTRAINT `fk_mascota_propietario1` FOREIGN KEY (`propietario_id_propietario`) REFERENCES `propietario` (`id_propietario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietario`
--

DROP TABLE IF EXISTS `propietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propietario` (
  `id_propietario` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `apellido_pat` varchar(45) NOT NULL,
  `apellido_mat` varchar(45) NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `comuna` varchar(45) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `region` varchar(100) NOT NULL,
  PRIMARY KEY (`id_propietario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietario`
--

LOCK TABLES `propietario` WRITE;
/*!40000 ALTER TABLE `propietario` DISABLE KEYS */;
/*!40000 ALTER TABLE `propietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `provincia_id` int(11) NOT NULL,
  `provincia_nombre` varchar(100) DEFAULT NULL,
  `provincia_region_id` int(11) NOT NULL,
  PRIMARY KEY (`provincia_id`,`provincia_region_id`),
  KEY `fk_provincia_region1_idx` (`provincia_region_id`),
  CONSTRAINT `fk_provincia_region1` FOREIGN KEY (`provincia_region_id`) REFERENCES `region` (`region_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (11,'Iquique',1),(14,'Tamarugal',1),(21,'Antofagasta',2),(22,'El Loa',2),(23,'Tocopilla',2),(31,'Copiapó',3),(32,'Chañaral',3),(33,'Huasco',3),(41,'Elqui',4),(42,'Choapa',4),(43,'Limarí',4),(51,'Valparaíso',5),(52,'Isla de Pascua',5),(53,'Los Andes',5),(54,'Petorca',5),(55,'Quillota',5),(56,'San Antonio',5),(57,'San Felipe de Aconcagua',5),(58,'Marga Marga',5),(61,'Cachapoal',6),(62,'Cardenal Caro',6),(63,'Colchagua',6),(71,'Talca',7),(72,'Cauquenes',7),(73,'Curicó',7),(74,'Linares',7),(81,'Concepción',8),(82,'Arauco',8),(83,'Biobío',8),(84,'Ñuble',8),(91,'Cautín',9),(92,'Malleco',9),(101,'Llanquihue',10),(102,'Chiloé',10),(103,'Osorno',10),(104,'Palena',10),(111,'Coihaique',11),(112,'Aisén',11),(113,'Capitán Prat',11),(114,'General Carrera',11),(121,'Magallanes',12),(122,'Antártica Chilena',12),(123,'Tierra del Fuego',12),(124,'Última Esperanza',12),(131,'Santiago',13),(132,'Cordillera',13),(133,'Chacabuco',13),(134,'Maipo',13),(135,'Melipilla',13),(136,'Talagante',13),(141,'Valdivia',14),(142,'Ranco',14),(151,'Arica',15),(152,'Parinacota',15);
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `region_id` int(11) NOT NULL,
  `region_nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Tarapacá'),(2,'Antofagasta'),(3,'Atacama'),(4,'Coquimbo'),(5,'Valparaíso'),(6,'Región del Libertador Gral. Bernardo O’Higgins'),(7,'Región del Maule'),(8,'Región del Biobío'),(9,'Región de la Araucanía'),(10,'Región de Los Lagos'),(11,'Región Aisén del Gral. Carlos Ibáñez del Campo'),(12,'Región de Magallanes y de la Antártica Chilena'),(13,'Región Metropolitana de Santiago'),(14,'Región de Los Ríos'),(15,'Arica y Parinacota');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_has_usuario`
--

DROP TABLE IF EXISTS `rol_has_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol_has_usuario` (
  `rol_id_rol` int(11) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`rol_id_rol`,`usuario_id_usuario`),
  KEY `fk_rol_has_usuario_usuario1_idx` (`usuario_id_usuario`),
  KEY `fk_rol_has_usuario_rol1_idx` (`rol_id_rol`),
  CONSTRAINT `fk_rol_has_usuario_rol1` FOREIGN KEY (`rol_id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_has_usuario_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_has_usuario`
--

LOCK TABLES `rol_has_usuario` WRITE;
/*!40000 ALTER TABLE `rol_has_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol_has_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-07 21:32:16
