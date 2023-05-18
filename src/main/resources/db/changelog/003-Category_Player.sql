--liquibase formatted sql

--changeset nvoxland:3
alter table if exists player
       add constraint FKqf6gkagc2mfcoatnev1fq84m4
       foreign key (category_id)
       references category