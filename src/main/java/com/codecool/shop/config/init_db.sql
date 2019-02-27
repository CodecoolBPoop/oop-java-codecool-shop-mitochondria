drop table if not exists _user


create table "_user"
(
  id       serial not null
    constraint "_user_pk"
      primary key,
  name     varchar,
  password varchar
);

create table supplier
(
	id serial not null
		constraint supplier_pk
			primary key,
	name varchar,
	description varchar
);

create table product_category
(
	id serial not null
		constraint product_category_pk
			primary key,
	name varchar,
	department varchar,
	description varchar
);

create table product
(
	id serial not null
		constraint product_pk
			primary key,
	name varchar,
	default_price float,
	currency_string varchar,
	description varchar,
	product_category_id int,
	supplier_id int
);


