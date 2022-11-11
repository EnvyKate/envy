create schema if not exists crm;

create table crm.staff(
    id integer not null,
    name varchar,
    constraint pk_staff primary key (id)
)