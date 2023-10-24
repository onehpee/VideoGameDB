CREATE database videogamedb2;
use videogamedb2;

CREATE TABLE `user` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `UserName` varchar(20) NOT NULL UNIQUE,
  `Password` varchar(45) NOT NULL UNIQUE,
  `Console` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT Password FROM user as P WHERE EXISTS(SELECT Password FROM user where P.Password=619);
SELECT Password FROM user Where exists(SELECT Password from user where Password = 618);
select * From user;
DROP TABLE user;
SELECT UserName FROM User as U WHERE EXISTS(SELECT UserName FROM user WHERE U.UserName="Mysterio619");
Delete from user where UserName="Africanking";
CREATE TABLE `videogame2` (
  `VideoGamesID` int NOT NULL auto_increment,
  `UserID` int NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Rating` varchar(45) NOT NULL,
  `Price` double(3,2) NOT NULL,
  `ReleaseDate` date NOT NULL,
  `Console` varchar(45) NOT NULL,
  PRIMARY KEY (`VideoGamesID`),
  KEY `UserID_idx` (`UserID`),
  CONSTRAINT `UserID` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE videogames;
