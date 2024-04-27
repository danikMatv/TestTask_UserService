CREATE TABLE users
(
    id bigint generated always as identity,
    first_name varchar not null,
    last_name varchar not null,
    email varchar not null,
    date timestamp not null,
    address varchar,
    phone_number varchar,

    constraint users_pk primary key (id)
);
