create table products_schema.country
(
    country_id   bigint default nextval('products_schema.countries_country_id_seq'::regclass) not null
        constraint countries_pk
            primary key,
    country_name varchar                                                                      not null
);

alter table products_schema.country
    owner to postgres;

create unique index country_country_name_uindex
    on products_schema.country (country_name);

create table products_schema.manufacturer
(
    manufacturer_id         bigint default nextval('products_schema.manufacturers_manufacturer_id_seq'::regclass) not null
        constraint manufacturers_pk
            primary key,
    manufacturer_name       varchar                                                                               not null,
    manufacturer_country_id bigint
        constraint manufacturers_countries_country_id_fk
            references products_schema.country
            on update cascade on delete set null
);

alter table products_schema.manufacturer
    owner to postgres;

create unique index manufacturers_manufacturer_name_uindex
    on products_schema.manufacturer (manufacturer_name);

create table products_schema.product
(
    product_id                bigint default nextval('products_schema.products_product_id_seq'::regclass) not null
        constraint products_pk
            primary key,
    product_name              varchar                                                                     not null,
    product_manufacturer_id   bigint
        constraint products_manufacturers_manufacturer_id_fk
            references products_schema.manufacturer
            on update cascade on delete set null,
    product_manufacturer_date date                                                                        not null,
    product_category          varchar                                                                     not null,
    product_price             real                                                                        not null,
    product_count             bigint                                                                      not null
);

alter table products_schema.product
    owner to postgres;

create unique index products_product_name_uindex
    on products_schema.product (product_name);

