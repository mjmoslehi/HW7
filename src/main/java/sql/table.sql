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
