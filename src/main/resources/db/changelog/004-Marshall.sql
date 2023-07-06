--liquibase formatted sql

--changeset nvoxland:4
--    INSERT INTO category (id, title) VALUES (1, 'gp1');
--    INSERT INTO category (id, title) VALUES (2, 'gp2');
--    INSERT INTO category (id, title) VALUES (3, 'gp3');
create table marshall (
       id int8 not null,
        name varchar(255),
        primary key (id)
    )