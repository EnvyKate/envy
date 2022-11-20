create schema if not exists crm;

create table crm.staff(
    id integer not null,
    uuid uuid not null,
    name varchar,
    hire_date date,
    qualification_id integer not null,
    constraint pk_staff primary key (id),
    constraint uuid_staff unique (uuid)
    foreign key (qualification_id) references crm.qualification (id)
);

create table crm.customer(
   id integer not null,
   uuid uuid not null,
   name varchar,
   phone_number varchar,
   constraint pk_customer primary key (id),
   constraint uuid_customer unique (uuid)
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
    duration integer,
    constraint pk_procedure primary key (id),
    constraint uuid_procedure unique (uuid)
);


create table crm.procedure_price(
    id integer not null,
    uuid uuid not null,
    procedure_id integer not null,
    qualification_id integer not null,
    price double precision,
    discount_available bit not null,
    constraint pk_pp primary key (id),
    constraint uuid_procedure_price unique (uuid),
    foreign key (procedure_id) references crm.procedure (id),
    foreign key (qualification_id) references crm.qualification (id)
);

create table crm.visit(
    id integer not null,
    uuid uuid not null,
    staff_id integer not null,
    customer_id integer,
    procedure_id integer not null,
    visit_time timestamp,
    constraint pk_visit primary key (id),
    constraint uuid_visit unique (uuid),
    foreign key (staff_id) references crm.staff (id),
    foreign key (customer_id) references crm.customer (id),
    foreign key (procedure_id) references crm.procedure (id)
);

create table crm.discount(
    id integer not null,
    uuid uuid not null,
    payment_threshold double precision,
    discount_value double precision,
    constraint pk_discount primary key (id),
    constraint uuid_discount unique (uuid)
)
