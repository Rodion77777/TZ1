create table products_schema.country
(
	country_id bigint default nextval('products_schema.countries_country_id_seq'::regclass) not null
		constraint countries_pk
			primary key,
	country_name varchar not null
);

alter table products_schema.country owner to postgres;

create unique index country_country_name_uindex
	on products_schema.country (country_name);

