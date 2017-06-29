DROP DATABASE IF EXISTS library;
CREATE DATABASE library;

DROP TABLE IF EXISTS library.user;
CREATE TABLE library.user (
  id       INT                          AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID',
  userName VARCHAR(255) UNIQUE NOT NULL
  COMMENT '用户',
  password VARCHAR(255)        NOT NULL
  COMMENT '密码',
  role     VARCHAR(255)        NOT NULL DEFAULT '用户'
  COMMENT '角色：用户，管理员'
)
  COMMENT '用户界面';

INSERT INTO library.user (userName, password, role) VALUES ('admin', 'aaa', '管理员');

DROP TABLE IF EXISTS library.books;
CREATE TABLE library.books (
  id     INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID',
  title  VARCHAR(255) NOT NULL
  COMMENT '书名',
  author VARCHAR(255) NOT NULL
  COMMENT '作者',
  pub    VARCHAR(255) NOT NULL
  COMMENT '出版社',
  time   DATE         NOT NULL
  COMMENT '出版时间',
  price  DECIMAL(6,2) NOT NULL
  COMMENT '价格',
  amount INT          NOT NULL
  COMMENT '数量'
)
  COMMENT '图书表';
SELECT *
FROM library.user;
SELECT *
FROM library.books;

