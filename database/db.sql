create database jarigui;
use jarigui;
create table cars (
    id int not null primary key auto_increment,
    plate varchar(50),
    brand varchar(50),
    cyear int,
    fuel varchar(50),
    price float,
    ccert int,
    klima boolean
);

grant all privileges
on jarigui.*
to 'jarigui'@'localhost'
identified by 'titok';