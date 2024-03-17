-- user_auth: 권한 테이블
CREATE TABLE `user_auth` (
    auth_no INT NOT NULL AUTO_INCREMENT
  , email   VARCHAR(200) NOT NULL
  , auth    VARCHAR(100) NOT NULL
  , PRIMARY KEY(auth_no)
);

INSERT INTO user_auth(email, auth)
VALUES ('user@example.com', 'ROLE_USER');

INSERT INTO user_auth(email, auth)
VALUES ('admin@example.com', 'ROLE_USER');
INSERT INTO user_auth(email, auth)
VALUES ('admin@example.com', 'ROLE_ADMIN');
