CREATE TABLE IF NOT EXISTS shareholder
(
    id            serial primary key,
    name          varchar,
    phone_number  varchar(11),
    national_code varchar(10) unique
);

CREATE table if not exists brand
(
    id          serial primary key,
    name        varchar unique ,
    website     varchar,
    description varchar
);

create table if not exists shareholder_brand
(
    id_shareholder integer,
    id_brand       integer,
    foreign key (id_shareholder) references shareholder (id),
    foreign key (id_brand) references brand (id)
);

create table if not exists category
(
    id          serial primary key,
    name        varchar unique ,
    description varchar
);
