-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 05, 2017 at 07:34 PM
-- Server version: 10.0.30-MariaDB
-- PHP Version: 7.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ihmProject`
--

-- --------------------------------------------------------

--
-- Table structure for table `CHEF_DE_PROJET`
--

CREATE TABLE IF NOT EXISTS `CHEF_DE_PROJET` (
  `NOM` varchar(25) NOT NULL,
  `PRENOM` varchar(25) NOT NULL,
  `USERNAME` varchar(25) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `CHEF_DE_PROJET`
--

INSERT INTO `CHEF_DE_PROJET` (`NOM`, `PRENOM`, `USERNAME`, `PASSWORD`) VALUES
('Mcguire ', 'Nicholas', 'Mnicolas', 'f277a12856803752a9e0e53e30925f3b');

-- --------------------------------------------------------

--
-- Table structure for table `COMMENTAIRE`
--

CREATE TABLE IF NOT EXISTS `COMMENTAIRE` (
  `TYPE` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `CONTENT` varchar(100) NOT NULL,
  `USERNAME` varchar(25) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `USERNAME_EMPLOYE` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CONTIENT_`
--

CREATE TABLE IF NOT EXISTS `CONTIENT_` (
  `NUMERO` int(11) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `DIRECTEUR`
--

CREATE TABLE IF NOT EXISTS `DIRECTEUR` (
  `NOM` varchar(25) NOT NULL,
  `PRENOM` varchar(25) NOT NULL,
  `USERNAME` varchar(25) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `NOM_ENTREPRISE` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `DIRECTEUR`
--

INSERT INTO `DIRECTEUR` (`NOM`, `PRENOM`, `USERNAME`, `PASSWORD`, `NOM_ENTREPRISE`) VALUES
('Williams ', 'Tammy', 'Twilliams', '23a6d02b1fe65bd2d919ebc5a2fd42fb', 'Entreprise');

-- --------------------------------------------------------

--
-- Table structure for table `EMPLOYE`
--

CREATE TABLE IF NOT EXISTS `EMPLOYE` (
  `NOM` varchar(25) NOT NULL,
  `PRENOM` varchar(25) NOT NULL,
  `USERNAME` varchar(25) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `NOM_SERVICE` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `EMPLOYE`
--

INSERT INTO `EMPLOYE` (`NOM`, `PRENOM`, `USERNAME`, `PASSWORD`, `NOM_SERVICE`) VALUES
('Edwards', 'Gregory', 'Egregory', '45a0aae31507f6ad67a7a385258d0cc0', 'Production'),
('Ramon', 'Patrick ', 'Rpatrick', '5b38d25649ade109d78d73eacb2ffeff', 'Production');

-- --------------------------------------------------------

--
-- Table structure for table `ENTREPRISE`
--

CREATE TABLE IF NOT EXISTS `ENTREPRISE` (
  `NOM` varchar(25) NOT NULL,
  `USERNAME` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ENTREPRISE`
--

INSERT INTO `ENTREPRISE` (`NOM`, `USERNAME`) VALUES
('Entreprise', 'Twilliams');

-- --------------------------------------------------------

--
-- Table structure for table `LICENSE`
--

CREATE TABLE IF NOT EXISTS `LICENSE` (
  `ID` int(11) NOT NULL,
  `NOM` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `MATERIEL`
--

CREATE TABLE IF NOT EXISTS `MATERIEL` (
  `ID` int(11) NOT NULL,
  `NOM` varchar(25) DEFAULT NULL,
  `ID_PROJET` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `POSSEDE`
--

CREATE TABLE IF NOT EXISTS `POSSEDE` (
  `ID` int(11) NOT NULL,
  `ID_LICENSE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `PRESTATAIRE`
--

CREATE TABLE IF NOT EXISTS `PRESTATAIRE` (
  `NOM` varchar(25) NOT NULL,
  `PRENOM` varchar(25) NOT NULL,
  `USERNAME` varchar(25) NOT NULL,
  `PASSWORD` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `PROJET`
--

CREATE TABLE IF NOT EXISTS `PROJET` (
  `OBJECTIF` varchar(1000) NOT NULL,
  `DUREE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `BUDGET_FINAL` decimal(15,3) NOT NULL,
  `ESTIMATION_BUDGET` decimal(15,3) NOT NULL,
  `ID` int(11) NOT NULL,
  `ETAT` tinyint(1) NOT NULL,
  `USERNAME` varchar(25) NOT NULL,
  `USERNAME_DIRECTEUR` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `SERVICE`
--

CREATE TABLE IF NOT EXISTS `SERVICE` (
  `NOM` varchar(25) NOT NULL,
  `NOM_ENTREPRISE` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `SIGNALE`
--

CREATE TABLE IF NOT EXISTS `SIGNALE` (
  `USERNAME` varchar(25) NOT NULL,
  `NUMERO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `TACHE`
--

CREATE TABLE IF NOT EXISTS `TACHE` (
  `NUMERO` int(11) NOT NULL,
  `DATE_FINALE` date NOT NULL,
  `DUREE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ETAT` int(11) NOT NULL,
  `USERNAME` varchar(25) NOT NULL,
  `USERNAME_CHEF_DE_PROJET` varchar(25) NOT NULL,
  `USERNAME_CHEF_DE_PROJET_1` varchar(25) NOT NULL,
  `ID` int(11) NOT NULL,
  `CONTENU` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `VALIDE`
--

CREATE TABLE IF NOT EXISTS `VALIDE` (
  `USERNAME` varchar(25) NOT NULL,
  `NUMERO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CHEF_DE_PROJET`
--
ALTER TABLE `CHEF_DE_PROJET`
  ADD PRIMARY KEY (`USERNAME`);

--
-- Indexes for table `COMMENTAIRE`
--
ALTER TABLE `COMMENTAIRE`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_COMMENTAIRE_USERNAME_EMPLOYE` (`USERNAME_EMPLOYE`);

--
-- Indexes for table `CONTIENT_`
--
ALTER TABLE `CONTIENT_`
  ADD PRIMARY KEY (`NUMERO`,`ID`),
  ADD KEY `FK_CONTIENT__ID` (`ID`);

--
-- Indexes for table `DIRECTEUR`
--
ALTER TABLE `DIRECTEUR`
  ADD PRIMARY KEY (`USERNAME`);

--
-- Indexes for table `EMPLOYE`
--
ALTER TABLE `EMPLOYE`
  ADD PRIMARY KEY (`USERNAME`);

--
-- Indexes for table `ENTREPRISE`
--
ALTER TABLE `ENTREPRISE`
  ADD PRIMARY KEY (`NOM`);

--
-- Indexes for table `LICENSE`
--
ALTER TABLE `LICENSE`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `MATERIEL`
--
ALTER TABLE `MATERIEL`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_MATERIEL_ID_PROJET` (`ID_PROJET`);

--
-- Indexes for table `POSSEDE`
--
ALTER TABLE `POSSEDE`
  ADD PRIMARY KEY (`ID`,`ID_LICENSE`),
  ADD KEY `FK_POSSEDE_ID_LICENSE` (`ID_LICENSE`);

--
-- Indexes for table `PRESTATAIRE`
--
ALTER TABLE `PRESTATAIRE`
  ADD PRIMARY KEY (`USERNAME`);

--
-- Indexes for table `PROJET`
--
ALTER TABLE `PROJET`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PROJET_USERNAME` (`USERNAME`),
  ADD KEY `FK_PROJET_USERNAME_DIRECTEUR` (`USERNAME_DIRECTEUR`);

--
-- Indexes for table `SERVICE`
--
ALTER TABLE `SERVICE`
  ADD PRIMARY KEY (`NOM`);

--
-- Indexes for table `SIGNALE`
--
ALTER TABLE `SIGNALE`
  ADD PRIMARY KEY (`USERNAME`,`NUMERO`),
  ADD KEY `FK_SIGNALE_NUMERO` (`NUMERO`);

--
-- Indexes for table `TACHE`
--
ALTER TABLE `TACHE`
  ADD PRIMARY KEY (`NUMERO`),
  ADD KEY `FK_TACHE_USERNAME` (`USERNAME`),
  ADD KEY `FK_TACHE_USERNAME_CHEF_DE_PROJET` (`USERNAME_CHEF_DE_PROJET`),
  ADD KEY `FK_TACHE_USERNAME_CHEF_DE_PROJET_1` (`USERNAME_CHEF_DE_PROJET_1`),
  ADD KEY `FK_TACHE_ID` (`ID`);

--
-- Indexes for table `VALIDE`
--
ALTER TABLE `VALIDE`
  ADD PRIMARY KEY (`USERNAME`,`NUMERO`),
  ADD KEY `FK_VALIDE_NUMERO` (`NUMERO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `COMMENTAIRE`
--
ALTER TABLE `COMMENTAIRE`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LICENSE`
--
ALTER TABLE `LICENSE`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `MATERIEL`
--
ALTER TABLE `MATERIEL`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `PROJET`
--
ALTER TABLE `PROJET`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `TACHE`
--
ALTER TABLE `TACHE`
  MODIFY `NUMERO` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `COMMENTAIRE`
--
ALTER TABLE `COMMENTAIRE`
  ADD CONSTRAINT `FK_COMMENTAIRE_USERNAME_EMPLOYE` FOREIGN KEY (`USERNAME_EMPLOYE`) REFERENCES `EMPLOYE` (`USERNAME`);

--
-- Constraints for table `CONTIENT_`
--
ALTER TABLE `CONTIENT_`
  ADD CONSTRAINT `FK_CONTIENT__ID` FOREIGN KEY (`ID`) REFERENCES `COMMENTAIRE` (`ID`),
  ADD CONSTRAINT `FK_CONTIENT__NUMERO` FOREIGN KEY (`NUMERO`) REFERENCES `TACHE` (`NUMERO`);

--
-- Constraints for table `MATERIEL`
--
ALTER TABLE `MATERIEL`
  ADD CONSTRAINT `FK_MATERIEL_ID_PROJET` FOREIGN KEY (`ID_PROJET`) REFERENCES `PROJET` (`ID`);

--
-- Constraints for table `POSSEDE`
--
ALTER TABLE `POSSEDE`
  ADD CONSTRAINT `FK_POSSEDE_ID` FOREIGN KEY (`ID`) REFERENCES `PROJET` (`ID`),
  ADD CONSTRAINT `FK_POSSEDE_ID_LICENSE` FOREIGN KEY (`ID_LICENSE`) REFERENCES `LICENSE` (`ID`);

--
-- Constraints for table `PROJET`
--
ALTER TABLE `PROJET`
  ADD CONSTRAINT `FK_PROJET_USERNAME` FOREIGN KEY (`USERNAME`) REFERENCES `EMPLOYE` (`USERNAME`),
  ADD CONSTRAINT `FK_PROJET_USERNAME_DIRECTEUR` FOREIGN KEY (`USERNAME_DIRECTEUR`) REFERENCES `DIRECTEUR` (`USERNAME`);

--
-- Constraints for table `SIGNALE`
--
ALTER TABLE `SIGNALE`
  ADD CONSTRAINT `FK_SIGNALE_NUMERO` FOREIGN KEY (`NUMERO`) REFERENCES `TACHE` (`NUMERO`),
  ADD CONSTRAINT `FK_SIGNALE_USERNAME` FOREIGN KEY (`USERNAME`) REFERENCES `EMPLOYE` (`USERNAME`);

--
-- Constraints for table `TACHE`
--
ALTER TABLE `TACHE`
  ADD CONSTRAINT `FK_TACHE_ID` FOREIGN KEY (`ID`) REFERENCES `PROJET` (`ID`),
  ADD CONSTRAINT `FK_TACHE_USERNAME` FOREIGN KEY (`USERNAME`) REFERENCES `PRESTATAIRE` (`USERNAME`),
  ADD CONSTRAINT `FK_TACHE_USERNAME_CHEF_DE_PROJET` FOREIGN KEY (`USERNAME_CHEF_DE_PROJET`) REFERENCES `CHEF_DE_PROJET` (`USERNAME`),
  ADD CONSTRAINT `FK_TACHE_USERNAME_CHEF_DE_PROJET_1` FOREIGN KEY (`USERNAME_CHEF_DE_PROJET_1`) REFERENCES `CHEF_DE_PROJET` (`USERNAME`);

--
-- Constraints for table `VALIDE`
--
ALTER TABLE `VALIDE`
  ADD CONSTRAINT `FK_VALIDE_NUMERO` FOREIGN KEY (`NUMERO`) REFERENCES `TACHE` (`NUMERO`),
  ADD CONSTRAINT `FK_VALIDE_USERNAME` FOREIGN KEY (`USERNAME`) REFERENCES `EMPLOYE` (`USERNAME`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
