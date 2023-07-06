--liquibase formatted sql

--changeset nvoxland:7
create table race (
       id int8 not null,
        category_id int8,
        primary key (id)
    )