-- Active: 1710279502779@@127.0.0.1@3306@board
CREATE TABLE `user` (
  `NO` int NOT NULL AUTO_INCREMENT,
  `EMAIL` VARCHAR(200) NOT NULL,
  `PASSWORD` VARCHAR(200) NOT NULL,
  `NAME` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`NO`)
) COMMENT='회원';


-- 암호화
INSERT INTO user (email, password, name)
VALUES ('user@example.com', '$2a$12$TrN..KcVjciCiz.SVj96YOB1jeVTTGJ9AUKmtfbGpgc9hmC78xQ92', '사용자');

-- 관리자
INSERT INTO user (email, password, name)
VALUES ('admin@example.com', '$2a$12$TrN..KcVjciCiz.SVj96YOB1jeVTTGJ9AUKmtfbGpgc9hmC78xQ92', '관리자')
