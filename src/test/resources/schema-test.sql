create sequence user_seq start with 1 increment by 1;

CREATE TABLE USERS (
    ID NUMBER(10) DEFAULT user_seq.nextval NOT NULL,
    username varchar(255) not null,
    password varchar(255) not null
);

create sequence employee_seq start with 1 increment by 1;

CREATE TABLE EMPLOYEE (
    ID NUMBER(10) DEFAULT user_seq.nextval NOT NULL,
    username varchar(255) not null,
    password varchar(255) not null
);