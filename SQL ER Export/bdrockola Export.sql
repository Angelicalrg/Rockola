-- MySQL Script generated by MySQL Workbench
-- Fri Sep 17 20:42:00 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bdrockola
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdrockola
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdrockola` DEFAULT CHARACTER SET utf8 ;
USE `bdrockola` ;

-- -----------------------------------------------------
-- Table `bdrockola`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrockola`.`Usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `tipoUsuario` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `identificacion` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NULL,
  `fechaNacimiento` DATE NOT NULL,
  PRIMARY KEY (`idUsuarios`),
  UNIQUE INDEX `idUsuarios_UNIQUE` (`idUsuarios` ASC) VISIBLE,
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdrockola`.`ListaReproducción`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrockola`.`ListaReproducción` (
  `idListaReproduccion` INT NOT NULL AUTO_INCREMENT,
  `nombreLista` VARCHAR(45) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `idUsuarios` INT NOT NULL,
  PRIMARY KEY (`idListaReproduccion`),
  UNIQUE INDEX `idAdministrador_UNIQUE` (`idListaReproduccion` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_ListaReproduccion`
    FOREIGN KEY (`idUsuarios`)
    REFERENCES `bdrockola`.`Usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdrockola`.`Artistas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrockola`.`Artistas` (
  `idArtistas` INT NOT NULL AUTO_INCREMENT,
  `nombreArtista` VARCHAR(45) NOT NULL,
  `nacionalidad` VARCHAR(45) NULL,
  PRIMARY KEY (`idArtistas`),
  UNIQUE INDEX `idArtistas_UNIQUE` (`idArtistas` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdrockola`.`Album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrockola`.`Album` (
  `idAlbum` INT NOT NULL AUTO_INCREMENT,
  `agnio` VARCHAR(45) NOT NULL,
  `nombreAlbum` VARCHAR(45) NOT NULL,
  `idArtista` INT NOT NULL,
  PRIMARY KEY (`idAlbum`),
  INDEX `fk_Album_Artista1_idx` (`idArtista` ASC) VISIBLE,
  UNIQUE INDEX `idAlbum_UNIQUE` (`idAlbum` ASC) VISIBLE,
  CONSTRAINT `fk_Album_Artista`
    FOREIGN KEY (`idArtista`)
    REFERENCES `bdrockola`.`Artistas` (`idArtistas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdrockola`.`Canciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrockola`.`Canciones` (
  `idCanciones` INT NOT NULL AUTO_INCREMENT,
  `nombreCancion` VARCHAR(45) NOT NULL,
  `idAlbum` INT NOT NULL,
  `genero` VARCHAR(45) NULL,
  PRIMARY KEY (`idCanciones`),
  INDEX `fk_Canciones_Album_idx` (`idAlbum` ASC) VISIBLE,
  UNIQUE INDEX `idCanciones_UNIQUE` (`idCanciones` ASC) VISIBLE,
  CONSTRAINT `fk_Canciones_Album`
    FOREIGN KEY (`idAlbum`)
    REFERENCES `bdrockola`.`Album` (`idAlbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdrockola`.`ListaCanciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrockola`.`ListaCanciones` (
  `idListaCanciones` INT NOT NULL AUTO_INCREMENT,
  `idCancion` INT NOT NULL,
  `idListaReproduccion` INT NOT NULL,
  INDEX `fk_ListaCanciones_ListaReproducción1_idx` (`idListaReproduccion` ASC) VISIBLE,
  PRIMARY KEY (`idListaCanciones`),
  INDEX `fk_ListaReproduccion_Canciones_idx` (`idCancion` ASC) VISIBLE,
  UNIQUE INDEX `idListaCanciones_UNIQUE` (`idListaCanciones` ASC) VISIBLE,
  CONSTRAINT `fk_ListaReproducción_ListaCanciones`
    FOREIGN KEY (`idListaReproduccion`)
    REFERENCES `bdrockola`.`ListaReproducción` (`idListaReproduccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ListaReproduccion_Canciones`
    FOREIGN KEY (`idCancion`)
    REFERENCES `bdrockola`.`Canciones` (`idCanciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
