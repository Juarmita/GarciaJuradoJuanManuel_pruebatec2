-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 28-03-2024 a las 19:42:30
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `turnero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
CREATE TABLE IF NOT EXISTS `ciudadano` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `APELLIDO` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `DNI` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`ID`, `APELLIDO`, `DNI`, `NOMBRE`) VALUES
(1, 'Garcia Jurado', '25736356T', 'Juan Manuel'),
(2, 'Garcia Ocampo', '12654210T', 'Lucas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

DROP TABLE IF EXISTS `turno`;
CREATE TABLE IF NOT EXISTS `turno` (
  `NUMTURNO` bigint NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `DNI` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `ESTADO` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `id_ciudadano` bigint DEFAULT NULL,
  PRIMARY KEY (`NUMTURNO`),
  KEY `FK_TURNO_id_ciudadano` (`id_ciudadano`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`NUMTURNO`, `DESCRIPCION`, `DNI`, `ESTADO`, `FECHA`, `id_ciudadano`) VALUES
(1, 'padron', NULL, 'Ya atendido', '2024-03-07', 1),
(2, 'multas', NULL, 'Ya atendido', '2024-03-07', 1),
(3, 'multas', NULL, 'Ya atendido', '2024-03-30', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
