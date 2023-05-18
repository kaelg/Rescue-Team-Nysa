--liquibase formatted sql

--changeset nvoxland:1
create table category (
       id int8 not null,
        title varchar(255),
        primary key (id)
    );