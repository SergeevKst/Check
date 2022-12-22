create schema store
create table product(
id           bigserial        primary key ,
product_name text             not null ,
price        integer          not null ,
discount     text             not null
)