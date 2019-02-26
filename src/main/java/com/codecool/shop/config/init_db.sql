drop table if not exists _user


create table "_user"
(
  id       serial not null
    constraint "_user_pk"
      primary key,
  name     varchar,
  password varchar
);