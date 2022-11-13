create schema if not exists crm;

create table crm.staff(
    id integer not null,
    uuid uuid not null,
    name varchar,
    hire_date date,
    constraint pk_staff primary key (id),
    constraint uuid_staff unique (uuid)
);

create table crm.client(
   id integer not null,
   uuid uuid not null,
   name varchar,
   phone_number varchar,
   constraint pk_client primary key (id),
   constraint uuid_client unique (uuid)
);

create table crm.qualification(
    id integer not null,
    uuid uuid not null,
    name varchar,
    salary_rate double precision,
    constraint pk_qualification primary key (id),
    constraint uuid_qualification unique (uuid)
);

create table crm.procedure(
    id integer not null,
    uuid uuid not null,
    name varchar,
    description varchar,
    duration integer
    constraint pk_qualification primary key (id),
    constraint uuid_qualification unique (uuid)
);

create table crm.staff_qualification(
    id integer not null,
    staff_id integer not null,
    qualification_id not null,
    constraint pk_sq primary key (id)
);

create table crm.procedure_price(
    id integer not null,
    procedure_id integer not null,
    qualification_id not null,
    price double precision,
    constraint pk_pp primary key (id)
);

create table crm.visit(
    id integer not null,
    staff_id integer not null,
    client_id integer,
    procedure_id integer not null,
    visit_time timestamp,
    constraint pk_visit primary key (id)
);
