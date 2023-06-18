-- changeset vodolazhsky:1
create table netology.user(
    id serial primary key,
    name varchar(255),
    city varchar(200)
);
-- rollback drop table netology.user;

-- changeset volodazhsky:2
alter table netology.user drop column city
