--liquibase formatted sql

--changeset nvoxland:2
create table player (
       id int8 not null,
        last_name varchar(255),
        first_name varchar(255),
        number int8,
        category_id int8,
        primary key (id)
    );