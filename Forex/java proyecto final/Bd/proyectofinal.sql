-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2019 a las 02:42:03
-- Versión del servidor: 10.1.39-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectofinal`
--
CREATE DATABASE IF NOT EXISTS `proyectofinal` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proyectofinal`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accion`
--

CREATE TABLE `accion` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `idoperacion` int(11) NOT NULL,
  `valoinicial` double NOT NULL,
  `token` text NOT NULL,
  `valorfinal` double NOT NULL,
  `cantidad` double NOT NULL,
  `beneficio` double NOT NULL,
  `divisa` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `usuario` text NOT NULL,
  `valorinicial` double NOT NULL,
  `valorfinal` double NOT NULL,
  `cantidad` double NOT NULL,
  `idoperacion` int(11) NOT NULL,
  `beneficio` double NOT NULL,
  `divisa` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`id`, `usuario`, `valorinicial`, `valorfinal`, `cantidad`, `idoperacion`, `beneficio`, `divisa`) VALUES
(1, 'q', 50001, 50004, 10, 1, 0, 'USD/JYP'),
(2, 'q', 50001, 49999, 10, 1, 0, 'USD/JYP'),
(3, 'q', 50001, 49995, 10, 1, 0, 'USD/JYP'),
(4, 'q', 50000, 50002, 1, 1, 0, 'USD/JYP'),
(5, 'q', 30000, 30000, 10, 1, 0, 'EUR/AUD'),
(6, 'q', 30000, 30000, 1, 2, 0, 'EUR/AUD'),
(7, 'q', 50000, 50001, 0.1, 1, 0, 'USD/JYP'),
(8, 'q', 50000, 49997, 1, 1, -30, 'USD/JYP'),
(9, 'q', 50000, 49998, 10, 1, -40, 'USD/JYP'),
(10, 'q', 30000, 29998, 0.1, 2, 0.2, 'EUR/AUD'),
(11, 'q', 50001, 50000, 10, 1, -10, 'USD/JYP'),
(12, 'q', 29997, 30004, 0.1, 2, -0.7, 'EUR/AUD'),
(13, 'q', 30001, 30004, 1, 1, 3, 'EUR/AUD'),
(14, 'q', 30002, 30004, 1, 1, 2, 'EUR/AUD'),
(15, 'q', 49996, 50000, 1, 1, -1, 'USD/JYP'),
(16, 'q', 49999, 50000, 0.1, 1, -1, 'USD/JYP'),
(17, 'q', 49999, 50000, 1, 2, -1, 'USD/JYP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL,
  `correo` text NOT NULL,
  `contrasena` text NOT NULL,
  `token` text NOT NULL,
  `dinero` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellido`, `correo`, `contrasena`, `token`, `dinero`) VALUES
(1, 'q', 'q', 'q@q', 'q', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJxIiwiaWF0IjoxNTU4ODI4OTU4LCJleHAiOjE1NTg4MzA3NTgsIkNvcnJlbyI6InFAcSJ9.LAXUyVGA0xyTWtvxE13phpURlTvJzEldzOIeCltz7Vw', 19922.498),
(5, 'o', 'o', 'o@o', 'o', '0', 1),
(6, 'm', 'm', 'm@m', 'm', '0', 1),
(7, 'n', 'n', 'n@n', 'n', '0', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accion`
--
ALTER TABLE `accion`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `accion`
--
ALTER TABLE `accion`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
