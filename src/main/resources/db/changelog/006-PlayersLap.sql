--liquibase formatted sql

--changeset nvoxland:6
create table players_lap (
       id int8 not null,
        lap_time varchar(255),
        player_id int8,
        race_id int8,
        primary key (id)
    )