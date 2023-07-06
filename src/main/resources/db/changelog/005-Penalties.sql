--liquibase formatted sql

--changeset nvoxland:5
create table penalties (
       id int8 not null,
        type int4 not null,
        marshall_id int8,
        players_lap_id int8,
        primary key (id)
    )