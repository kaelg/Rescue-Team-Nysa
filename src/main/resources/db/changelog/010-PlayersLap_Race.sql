--liquibase formatted sql

--changeset nvoxland:10
alter table if exists players_lap
       add constraint FKiqwt0sajmeori71rumyi84hph
       foreign key (race_id)
       references race