--liquibase formatted sql

--changeset nvoxland:11
alter table if exists race
       add constraint FKrwusads56vfoat7ndkfsi1rjv
       foreign key (category_id)
       references category