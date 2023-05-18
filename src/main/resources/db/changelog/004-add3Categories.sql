--liquibase formatted sql

--changeset nvoxland:2
    INSERT INTO category (id, title) VALUES (1, 'gp1');
    INSERT INTO category (id, title) VALUES (2, 'gp2');
    INSERT INTO category (id, title) VALUES (3, 'gp3');