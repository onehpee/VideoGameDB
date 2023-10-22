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

SELECT * FROM user as P WHERE EXISTS(SELECT Password FROM user where P.Password=555);
select * From user;
DROP TABLE user;