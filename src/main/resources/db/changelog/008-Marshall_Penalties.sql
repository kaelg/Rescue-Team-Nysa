--liquibase formatted sql

--changeset nvoxland:8
alter table if exists penalties
       add constraint FK3ss5nucugx74gfkf4cdk4m715
       foreign key (marshall_id)
       references marshall