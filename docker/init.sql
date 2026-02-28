
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cellrepair
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cellrepair` ;

-- -----------------------------------------------------
-- Schema cellrepair
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cellrepair` ;
USE `cellrepair` ;

-- -----------------------------------------------------
-- Table `cellrepair`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellrepair`.`cliente` ;

CREATE TABLE IF NOT EXISTS `cellrepair`.`cliente` (
                                                      `id_cliente` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                      `nome_completo` VARCHAR(150) NOT NULL,
    `cpf_cnpj` VARCHAR(14) NOT NULL,
    `data_nascimento` DATE NOT NULL,
    `telefone` VARCHAR(13) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `endereco` VARCHAR(200) NOT NULL,
    `cidade` VARCHAR(100) NOT NULL,
    `uf` CHAR(2) NOT NULL,
    PRIMARY KEY (`id_cliente`),
    UNIQUE INDEX `CPF_UNIQUE` (`cpf_cnpj` ASC) VISIBLE,
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cellrepair`.`aparelho`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellrepair`.`aparelho` ;

CREATE TABLE IF NOT EXISTS `cellrepair`.`aparelho` (
                                                       `id_aparelhos` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                       `marca` VARCHAR(25) NOT NULL,
    `modelo` VARCHAR(50) NOT NULL,
    `versao` VARCHAR(50) NULL,
    PRIMARY KEY (`id_aparelhos`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cellrepair`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellrepair`.`usuario` ;

CREATE TABLE IF NOT EXISTS `cellrepair`.`usuario` (
                                                      `id_usuario` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                      `nome_usuario` VARCHAR(50) NOT NULL,
    `senha` VARCHAR(255) NOT NULL,
    `ativo` TINYINT NOT NULL DEFAULT 1,
    `role` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id_usuario`),
    UNIQUE INDEX `nome_usuario_UNIQUE` (`nome_usuario` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cellrepair`.`tecnico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellrepair`.`tecnico` ;

CREATE TABLE IF NOT EXISTS `cellrepair`.`tecnico` (
                                                      `id_tecnico` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '	',
                                                      `nome_tecnico` VARCHAR(150) NOT NULL,
    `cpf_tecnico` VARCHAR(11) NULL,
    `dt_nasc` DATE NULL,
    `especialidade` VARCHAR(80) NULL,
    `comissao` DECIMAL(10,2) NULL,
    `status` TINYINT NOT NULL DEFAULT 1,
    `id_usuario` BIGINT UNSIGNED NULL,
    PRIMARY KEY (`id_tecnico`),
    UNIQUE INDEX `cpfTecnico_UNIQUE` (`cpf_tecnico` ASC) VISIBLE,
    INDEX `fk_tecnico_id_usuario_idx` (`id_usuario` ASC) VISIBLE,
    CONSTRAINT `fk_tecnico_id_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `cellrepair`.`usuario` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cellrepair`.`ordem_servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellrepair`.`ordem_servico` ;

CREATE TABLE IF NOT EXISTS `cellrepair`.`ordem_servico` (
                                                            `id_os` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                            `id_cliente` BIGINT UNSIGNED NOT NULL,
                                                            `id_aparelhos` BIGINT UNSIGNED NOT NULL,
                                                            `imei` VARCHAR(20) NULL,
    `cor` VARCHAR(30) NULL,
    `acessorios` VARCHAR(100) NULL,
    `senha` VARCHAR(50) NULL,
    `id_tecnico` BIGINT UNSIGNED NULL,
    `dt_entrada` TIMESTAMP NOT NULL,
    `defeito_relatado` VARCHAR(255) NULL,
    `laudo_tecnico` VARCHAR(255) NULL,
    `status` VARCHAR(50) NULL,
    `valor_total` DECIMAL(10,2) NULL,
    `dt_saida` TIMESTAMP NULL,
    `id_usuario_abertura` BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (`id_os`),
    INDEX `fk_os_id_cliente` (`id_cliente` ASC) VISIBLE,
    INDEX `fk_os_id_aparelho` (`id_aparelhos` ASC) VISIBLE,
    INDEX `fk_os_id_tecnivo` (`id_tecnico` ASC) VISIBLE,
    INDEX `fk_os_id_usuario` (`id_usuario_abertura` ASC) VISIBLE,
    CONSTRAINT `fk_os_id_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `cellrepair`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_os_id_aparelho`
    FOREIGN KEY (`id_aparelhos`)
    REFERENCES `cellrepair`.`aparelho` (`id_aparelhos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_os_id_tecnico`
    FOREIGN KEY (`id_tecnico`)
    REFERENCES `cellrepair`.`tecnico` (`id_tecnico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_os_id_usuario`
    FOREIGN KEY (`id_usuario_abertura`)
    REFERENCES `cellrepair`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cellrepair`.`peca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellrepair`.`peca` ;

CREATE TABLE IF NOT EXISTS `cellrepair`.`peca` (
                                                   `id_pecas` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                   `cod_barras` VARCHAR(45) NULL,
    `descricao` VARCHAR(200) NOT NULL,
    `num_serie` VARCHAR(50) NULL,
    `qtd_estoque` INT NULL DEFAULT 0,
    `est_minimo` INT NULL,
    `est_maximo` INT NULL,
    `preco_custo` DECIMAL(10,2) NULL,
    `preco_venda` DECIMAL(10,2) NULL,
    `fornecedor` VARCHAR(100) NULL,
    PRIMARY KEY (`id_pecas`),
    UNIQUE INDEX `cod_barras_UNIQUE` (`cod_barras` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cellrepair`.`item_os`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellrepair`.`item_os` ;

CREATE TABLE IF NOT EXISTS `cellrepair`.`item_os` (
                                                      `id_itens_os` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                      `id_os` BIGINT UNSIGNED NOT NULL,
                                                      `id_peca` BIGINT UNSIGNED NOT NULL,
                                                      `qtd` INT NOT NULL DEFAULT 0,
                                                      `valor_unitario` DECIMAL(10,2) NULL,
    PRIMARY KEY (`id_itens_os`),
    INDEX `fk_itens_id_os` (`id_os` ASC) VISIBLE,
    INDEX `fk_itens_id_peca` (`id_peca` ASC) VISIBLE,
    CONSTRAINT `fk_itens_id_os`
    FOREIGN KEY (`id_os`)
    REFERENCES `cellrepair`.`ordem_servico` (`id_os`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_itens_id_pecas`
    FOREIGN KEY (`id_peca`)
    REFERENCES `cellrepair`.`peca` (`id_pecas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cellrepair`.`anexo_os`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellrepair`.`anexo_os` ;

CREATE TABLE IF NOT EXISTS `cellrepair`.`anexo_os` (
                                                       `id_anexo_os` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                       `id_os` BIGINT UNSIGNED NOT NULL,
                                                       `nome_arquivo` VARCHAR(100) NOT NULL,
    `tipo_arquivo` VARCHAR(50) NULL,
    `cam_arquivo` VARCHAR(500) NOT NULL,
    `data_upload` TIMESTAMP NULL,
    `observacao` VARCHAR(255) NULL,
    `id_usuario` BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (`id_anexo_os`),
    INDEX `fk_anexo_id_os` (`id_os` ASC) INVISIBLE,
    INDEX `fk_anexo_os_id_usuario` (`id_usuario` ASC) VISIBLE,
    CONSTRAINT `fk_anexo_id_os`
    FOREIGN KEY (`id_os`)
    REFERENCES `cellrepair`.`ordem_servico` (`id_os`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_anexo_os_id_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `cellrepair`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
