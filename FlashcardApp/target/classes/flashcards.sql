drop table if exists italian_verbs;
drop table if exists italian_nouns;
drop table if exists italian_numbers;

create table italian_verbs (
    id int primary key auto_increment,
    front text not null,
    back text not null
);

create table italian_nouns (
    id int primary key auto_increment,
    front text not null,
    back text not null
);

create table italian_numbers (
    id int primary key auto_increment,
    front text not null,
    back text not null
);

insert into italian_verbs (front, back) values ('to have', 'avere');
insert into italian_nouns (front, back) values ('street', 'strada');
insert into italian_numbers (front, back) values ('19', 'diciannove');
