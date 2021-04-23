-- DROP TABLE PERSON;
--
-- CREATE TABLE PERSON (
--   ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
--   FIRST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
--   LAST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
--   MOBILE VARCHAR2(20) NOT NULL DEFAULT '',
--   BIRTHDAY DATE DEFAULT NULL,
--   PRIMARY KEY (ID));
--
-- DROP TABLE HOME;
--
-- CREATE TABLE HOME (
--   ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
--   ADDRESS VARCHAR2(255) not null default '',
--   HOME_NUMBER varchar2(255) NOT NULL DEFAULT '',
--   PRIMARY KEY (ID)
-- );
--
--
-- DROP TABLE CAR;
--
-- CREATE TABLE CAR (
--   ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
--   MAKE VARCHAR2(255) not null default '',
--   MODEL varchar2(255) NOT NULL DEFAULT '',
--   YEAR VARCHAR2(5) NOT NULL DEFAULT '01907',
--   PRIMARY KEY (ID)
-- );

DROP TABLE EMPLOYEE;

CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID LONG NOT NULL AUTO_INCREMENT,
    FIRST_NAME VARCHAR(255)  NOT NULL DEFAULT '',
    LAST_NAME VARCHAR(255)  NOT NULL DEFAULT '',
    TITLE VARCHAR(255)  NOT NULL DEFAULT '',
    PHONE_NUMBER VARCHAR(255)  NOT NULL DEFAULT '',
    EMAIL VARCHAR(255)  NOT NULL DEFAULT '',
    HIRE_DATE  NOT NULL DATE,
    DEPARTMENT_NUMBER  NOT NULL INTEGER,
    MANAGER_ID  NOT NULL LONG,
    PRIMARY KEY (EMPLOYEE_ID)
);

DROP TABLE DEPARTMENT;

CREATE TABLE DEPARTMENT (
    DEPARTMENT_NUMBER LONG NOT NULL AUTO_INCREMENT,
    DEPARTMENT_NAME VARCHAR(255) NOT NULL DEFAULT '',
    MANAGER_ID  NOT NULL NUMBER
    PRIMARY KEY (DEPARTMENT_NUMBER)
);

DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;