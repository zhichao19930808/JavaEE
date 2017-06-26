DROP DATABASE IF EXISTS db_javaee;
CREATE DATABASE db_javaee;

DROP TABLE IF EXISTS db_javaee.user;
CREATE TABLE db_javaee.user (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'pk id',
  nick     VARCHAR(255) NOT NULL UNIQUE
  COMMENT '昵称',
  mobile   VARCHAR(255) NOT NULL UNIQUE
  COMMENT '手机号码',
  password VARCHAR(255) NOT NULL
  COMMENT '密码'
)
  COMMENT '用户表';

DROP TABLE IF EXISTS db_javaee.student;
CREATE TABLE db_javaee.studens (
  id     INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'pk id',
  name   VARCHAR(255) NOT NULL
  COMMENT '姓名',
  gender VARCHAR(255) NOT NULL
  COMMENT '性别',
  date   DATE         NOT NULL
  COMMENT '出生日期'
)
  COMMENT '学生表';


SELECT *
FROM db_javaee.user;
SELECT *
FROM db_javaee.studens;

SELECT *
FROM db_1702.ip
WHERE geo REGEXP '北京';

SELECT *
FROM db_1702.ip;

