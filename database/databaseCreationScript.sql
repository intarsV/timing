SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `timing` DEFAULT CHARACTER SET utf8 ;
USE `timing` ;

DROP TABLE IF EXISTS `users`, `competitors`,`country`,`event`,`event_registry`,`groups`, `mcu_incoming`
,`single_race`,`race_config`, `sub_event`,`competition_event_format`, `boat_class` ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `competitors` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `competitor_name` varchar(100) NOT NULL,
  `birth_year` int(11) NOT NULL,
  `club` varchar(80) NOT NULL,
  `country` varchar(4) NOT NULL,
  `deleted` tinyint(4) DEFAULT "0",
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `country` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `single_boat_class` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `boat_class` varchar(100) NOT NULL,
  `deleted` tinyint(4) DEFAULT "0",
   PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `team_boat_class` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `boat_class` varchar(100) NOT NULL,
  `deleted` tinyint(4) DEFAULT "0",
   PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `groups` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `group` varchar(45) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT "0",
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `mcu_incoming` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bib` int(11) NOT NULL,
  `time_stamp` double NOT NULL,
  `unit_id` int(2) NOT NULL,
  `sub_event` int(2) NOT NULL,
  `done` tinyint(4) DEFAULT "0",
  `accepted` tinyint(4) DEFAULT "0",
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `competition_event_format` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `competition_event_format` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `sub_event` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `competition_event_format_id`BIGINT NOT NULL,
  `sub_event` varchar(50) DEFAULT NULL,
  FOREIGN KEY (`competition_event_format_id`) REFERENCES `competition_event_format`(`id`) ,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `event` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `event` varchar(100) NOT NULL,
  `competition_event_format_id` BIGINT NOT NULL,
  `place_date` varchar(100) NOT NULL,
  `deleted` tinyint(4) DEFAULT "0",
  PRIMARY KEY (`id`),
  FOREIGN KEY (`competition_event_format_id`) REFERENCES `competition_event_format`(`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `race_config` (
  `id`BIGINT NOT NULL AUTO_INCREMENT,
  `event_id` BIGINT DEFAULT NULL,
  `boat_class_id` BIGINT DEFAULT NULL,
  `heat_1` int(11) DEFAULT "0",
  `heat_2` int(11) DEFAULT "0",
  `semi_final` int(11) DEFAULT "0",
  PRIMARY KEY (`id`),
  FOREIGN KEY (`event_id`) REFERENCES `event`(`id`),
  FOREIGN KEY (`boat_class_id`) REFERENCES `single_boat_class`(`id`)
    )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `single_event_registry` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `event_id` BIGINT NOT NULL,
  `competitor_id` BIGINT NOT NULL,
  `group_id` BIGINT NOT NULL,
  `boat_class_id` BIGINT NOT NULL,
  `bib` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ,
  FOREIGN KEY (`competitor_id`) REFERENCES `competitors`(`id`),
  FOREIGN KEY (`group_id`) REFERENCES `groups`(`id`),
  FOREIGN KEY (`boat_class_id`) REFERENCES `single_boat_class`(`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `team_event_registry` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `event_id` BIGINT NOT NULL,
  `competitor_one_id` BIGINT NOT NULL,
  `competitor_two_id` BIGINT NOT NULL,
  `competitor_three_id` BIGINT NOT NULL,
  `boat_class_id` BIGINT NOT NULL,
  `bib` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ,
  FOREIGN KEY (`competitor_one_id`) REFERENCES `competitors`(`id`),
  FOREIGN KEY (`competitor_two_id`) REFERENCES `competitors`(`id`),
  FOREIGN KEY (`competitor_three_id`) REFERENCES `competitors`(`id`),
  FOREIGN KEY (`boat_class_id`) REFERENCES `team_boat_class`(`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `single_race` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `start_time` double DEFAULT NULL,
  `finish_time` double DEFAULT NULL,
  `g1` int(11) DEFAULT "0",
  `g2` int(11) DEFAULT "0",
  `g3` int(11) DEFAULT "0",
  `g4` int(11) DEFAULT "0",
  `g5` int(11) DEFAULT "0",
  `g6` int(11) DEFAULT "0",
  `g7` int(11) DEFAULT "0",
  `g8` int(11) DEFAULT "0",
  `g9` int(11) DEFAULT "0",
  `g10` int(11) DEFAULT "0",
  `g11` int(11) DEFAULT "0",
  `g12` int(11) DEFAULT "0",
  `g13` int(11) DEFAULT "0",
  `g14` int(11) DEFAULT "0",
  `g15` int(11) DEFAULT "0",
  `g16` int(11) DEFAULT "0",
  `g17` int(11) DEFAULT "0",
  `g18` int(11) DEFAULT "0",
  `g19` int(11) DEFAULT "0",
  `g20` int(11) DEFAULT "0",
  `g21` int(11) DEFAULT "0",
  `g22` int(11) DEFAULT "0",
  `g23` int(11) DEFAULT "0",
  `g24` int(11) DEFAULT "0",
  `event_registry_id` BIGINT DEFAULT NULL,
  `event_id` BIGINT DEFAULT NULL,
  `sub_event_id` BIGINT DEFAULT NULL,
  `dsqr` tinyint(4) DEFAULT "0",
  `done` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`event_registry_id`) REFERENCES `single_event_registry`(`id`) ,
  FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ,
  FOREIGN KEY (`sub_event_id`) REFERENCES `sub_event`(`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `team_race` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `start_time` double DEFAULT NULL,
  `finish_time` double DEFAULT NULL,
  `g1` int(11) DEFAULT "0",
  `g2` int(11) DEFAULT "0",
  `g3` int(11) DEFAULT "0",
  `g4` int(11) DEFAULT "0",
  `g5` int(11) DEFAULT "0",
  `g6` int(11) DEFAULT "0",
  `g7` int(11) DEFAULT "0",
  `g8` int(11) DEFAULT "0",
  `g9` int(11) DEFAULT "0",
  `g10` int(11) DEFAULT "0",
  `g11` int(11) DEFAULT "0",
  `g12` int(11) DEFAULT "0",
  `g13` int(11) DEFAULT "0",
  `g14` int(11) DEFAULT "0",
  `g15` int(11) DEFAULT "0",
  `g16` int(11) DEFAULT "0",
  `g17` int(11) DEFAULT "0",
  `g18` int(11) DEFAULT "0",
  `g19` int(11) DEFAULT "0",
  `g20` int(11) DEFAULT "0",
  `g21` int(11) DEFAULT "0",
  `g22` int(11) DEFAULT "0",
  `g23` int(11) DEFAULT "0",
  `g24` int(11) DEFAULT "0",
  `p15` int(11) DEFAULT "0",
  `event_registry_team_id` BIGINT DEFAULT NULL,
  `event_id` BIGINT DEFAULT NULL,
  `sub_event_id` BIGINT DEFAULT NULL,
  `dsqr` tinyint(4) DEFAULT "0",
  `done` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`event_registry_team_id`) REFERENCES `team_event_registry`(`id`) ,
  FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ,
  FOREIGN KEY (`sub_event_id`) REFERENCES `sub_event`(`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1;

INSERT INTO `users` (`id`, `login`, `password`, `created_date`) VALUES (NULL, 'ini', 'xxx', CURRENT_TIMESTAMP);

INSERT INTO `country` (`id`, `country`) VALUES (NULL, 'LVA'), (NULL, 'LTU'), (NULL, 'EST'), (NULL, 'BLR'),(NULL, 'UKR'), (NULL, 'RUS');

INSERT INTO `competition_event_format` (`id`, `competition_event_format`) VALUES (NULL, 'H1&&H2->best')
,(NULL, 'H1->H2->Final'),(NULL, 'H1->H2->SF->Final'),(NULL, 'Sum of H1&H2'),(NULL, 'H1&&H2->best->Final'),(NULL, 'H1->Final');

INSERT INTO `single_boat_class` (`id`, `boat_class`, `deleted`) VALUES (NULL, 'C1 Women', '0'), (NULL, 'C1 Men', '0'), (NULL, 'K1 Women', '0')
, (NULL, 'K1 Men', '0');

INSERT INTO `team_boat_class` (`id`, `boat_class`, `deleted`) VALUES (NULL, 'C1 Team Women', '0'), (NULL, 'C1 Team Men', '0'), (NULL, 'K1 Team Women', '0'), (NULL, 'K1 Team Men', '0')
, (NULL, 'Team MIX', '0');

INSERT INTO `sub_event` (`id`, `competition_event_format_id`, `sub_event`) VALUES (NULL, '1', 'Heat 1'),(NULL, '1', 'Heat 2');

INSERT INTO `sub_event` (`id`, `competition_event_format_id`, `sub_event`) VALUES (NULL, '2', 'Heat 1'),(NULL, '2', 'Heat 2'),(NULL, '2', 'Final');

INSERT INTO `sub_event` (`id`, `competition_event_format_id`, `sub_event`) VALUES (NULL, '3', 'Heat 1'),(NULL, '3', 'Heat 2'),(NULL, '3', 'Semi-Final'),(NULL, '3', 'Final');

INSERT INTO `sub_event` (`id`, `competition_event_format_id`, `sub_event`) VALUES (NULL, '4', 'Heat 1'),(NULL, '4', 'Heat 2');

INSERT INTO `sub_event` (`id`, `competition_event_format_id`, `sub_event`) VALUES (NULL, '5', 'Heat 1'),(NULL, '5', 'Heat 2'),(NULL, '5', 'Final');

INSERT INTO `sub_event` (`id`, `competition_event_format_id`, `sub_event`) VALUES (NULL, '6', 'Heat 1'),(NULL, '6', 'Final')

INSERT INTO `groups` (`id`, `group`, `deleted`) VALUES (NULL, 'U-8', '0'), (NULL, 'U-10', '0'),
(NULL, 'U-12', '0'), (NULL, 'U-14', '0'),(NULL, 'U-15', '0'), (NULL, 'U-16', '0'),(NULL, 'U-18', '0'), (NULL, 'U-23', '0'),
(NULL, 'open', '0'), (NULL, '35+', '0'), (NULL, '40+', '0'), (NULL, '45+', '0'),(NULL, '55+', '0'), (NULL, 'veteran', '0');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;