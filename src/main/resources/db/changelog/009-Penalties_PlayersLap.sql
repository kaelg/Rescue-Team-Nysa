--liquibase formatted sql

--changeset nvoxland:9
alter table if exists penalties
       add constraint FKq7eonrt93qjdkaj70k5unrsqa
       foreign key (players_lap_id)
       references players_lap