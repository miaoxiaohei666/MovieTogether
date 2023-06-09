-- ----------------------
-- drop table
-- ----------------------
drop table if exists users;
drop table if exists movies;
drop table if exists screenings;
drop table if exists cinemas;
drop table if exists friends;
drop table if exists invites;
drop table if exists chats;

-- ----------------------
-- table users
-- ----------------------
create table users
(
    id       int auto_increment primary key,
    stunb    int          not null,
    password varchar(255) not null,
    nickname varchar(255) not null,
    sex      varchar(255) not null,
    age      int          not null,
    school   varchar(255) not null,
    label1   varchar(255) null,
    label2   varchar(255) null,
    label3   varchar(255) null
);

-- ----------------------
-- table movies
-- ----------------------
create table movies
(
    id          int auto_increment primary key,
    name        varchar(255) not null,
    time        varchar(255) null,
    sort        varchar(255) null,
    cover       varchar(255) null,
    description text null
);

-- ----------------------
-- table screenings
-- ----------------------
create table screenings
(
    id       int auto_increment primary key,
    cinemaid int not null,
    movieid  int not null,
    time     varchar(255) null
);

-- ----------------------
-- table cinemas
-- ----------------------
create table cinemas
(
    id      int auto_increment primary key,
    name    varchar(255) not null,
    address varchar(255) not null
);

-- ----------------------
-- table friends
-- ----------------------
create table friends
(
    id       int auto_increment primary key,
    userid   int not null,
    friendid int not null
);

-- ----------------------
-- table invites
-- ----------------------
create table invites
(
    id       int auto_increment primary key,
    inviter  int          not null,
    receiver int          not null,
    time     varchar(255) not null
);