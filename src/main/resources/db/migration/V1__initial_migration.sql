create table contacts
(
    id    bigint auto_increment
        primary key,
    name  varchar(255) not null,
    email varchar(255) null,
    phone varchar(255) not null
);