drop table if not exists test_user


create table "test_user"
(
  id       serial not null
    constraint "user_pk"
      primary key,
  name     varchar,
  password varchar
);

create table test_supplier
(
	id serial not null
		constraint supplier_pk
			primary key,
	name varchar,
	description varchar
);

create table test_product_category
(	id serial not null
		constraint product_category_pk
			primary key,
	name varchar,
	department varchar,
	description varchar
);

create table test_product
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



INSERT INTO public.supplier (id, name, description) VALUES (1, 'Empire', 'A huge empire leading by the Emperor');
INSERT INTO public.supplier (id, name, description) VALUES (2, 'Republic', 'A senate leaded Republic');

INSERT INTO public.product_category (id, name, department, description) VALUES (1, 'Star', 'thermonuclear', 'Luminous and thermonuclear gas objects.');
INSERT INTO public.product_category (id, name, department, description) VALUES (2, 'Planet', 'habitable', 'All object you can live on.');
INSERT INTO public.product_category (id, name, department, description) VALUES (3, 'Black Hole', 'singularity', 'Gravity traps.');


INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (1, 'Sol', 398.8, 'USD', 'A really young and shiny star. Nice yellow color.', 1, 1);
INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (2, 'Rigel', 479, 'USD', 'The shiniest star of the Orion. Nice blue color', 1, 2);
INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (3, 'Arcturus', 689, 'USD', 'A huge red star. A little bit old.', 1, 1);
INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (4, 'Sirius B', 557, 'USD', 'This is a big binary star in the Canis Majoris. Shiny white color.', 1, 2);
INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (5, 'Earth', 199.9, 'USD', 'Fantastic price. A lot of inhabitors included. Great landscapes, and different seasons.', 2, 1);
INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (6, 'Mars', 179, 'USD', 'A little bit dusty, low water and oxigen. Nice red color. Has a lot of potential.', 2, 2);
INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (7, 'Saturn', 267.8, 'USD', 'A gas giant. Has a nice ring around itself.', 2, 2);
INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (8, 'Messier 32', 243, 'USD', 'It was a huge galaxy once, now its just a black hole, but the price is really low.', 3, 1);
INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (9, 'NGC 3377', 496.9, 'USD', 'Fantastic price. Supermassive black hole.', 3, 2);
INSERT INTO public.product (id, name, default_price, currency_string, description, product_category_id, supplier_id) VALUES (10, 'Sagittarius A', 479, 'USD', 'Its in the center of the Milky Way. Supermassive black hole.', 3, 1);
