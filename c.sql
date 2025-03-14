-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 21-Out-2023 às 01:24
-- Versão do servidor: 5.6.13
-- versão do PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `c`
--
CREATE DATABASE IF NOT EXISTS `c` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `c`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contatos`
--

CREATE TABLE IF NOT EXISTS `contatos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Extraindo dados da tabela `contatos`
--

INSERT INTO `contatos` (`id`, `nome`, `email`, `telefone`) VALUES
(6, 'eduardo', 'aa@gmail.com', '123'),
(7, 'jaoo', 'dasj@gmail.com', '789'),
(8, 'renan', 'r@gmail.com', '456');

-- --------------------------------------------------------

--
-- Estrutura da tabela `mensagens`
--

CREATE TABLE IF NOT EXISTS `mensagens` (
  `idenvio` int(11) NOT NULL,
  `idreceb` int(11) NOT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `mensagens` varchar(255) NOT NULL,
  KEY `fk_idenvio` (`idenvio`),
  KEY `fk_idreceb` (`idreceb`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `mensagens`
--

INSERT INTO `mensagens` (`idenvio`, `idreceb`, `data`, `hora`, `mensagens`) VALUES
(6, 6, '2023-10-15', '19:25:47', 'a'),
(6, 7, '2023-10-20', '22:20:34', 'oi');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `mensagens`
--
ALTER TABLE `mensagens`
  ADD CONSTRAINT `fk_idenvio` FOREIGN KEY (`idenvio`) REFERENCES `contatos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idreceb` FOREIGN KEY (`idreceb`) REFERENCES `contatos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
