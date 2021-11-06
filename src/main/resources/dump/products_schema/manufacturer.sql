create table products_schema.manufacturer
(
	manufacturer_id bigint default nextval('products_schema.manufacturers_manufacturer_id_seq'::regclass) not null
		constraint manufacturers_pk
			primary key,
	manufacturer_name varchar not null,
	manufacturer_country_id bigint
		constraint manufacturers_countries_country_id_fk
			references products_schema.country
				on update cascade on delete set null
);

alter table products_schema.manufacturer owner to postgres;

create unique index manufacturers_manufacturer_name_uindex
	on products_schema.manufacturer (manufacturer_name);

