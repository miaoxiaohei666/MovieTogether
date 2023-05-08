-- ----------------------
-- drop table
-- ----------------------
drop table if exists chat;
drop table if exists cinemas;
drop table if exists friends;
drop table if exists invites;
drop table if exists movies;
drop table if exists screenings;

-- ----------------------
-- create table
-- ----------------------

-- ----------------------
-- table chats
-- ----------------------
create table chats
(
    id       int auto_increment
        primary key,
    content  varchar(255) null,
    receiver varchar(255) null,
    sender   varchar(255) null
);

-- ----------------------
-- table cinemas
-- ----------------------
create table cinemas
(
    id      int auto_increment
        primary key,
    address varchar(255) null,
    name    varchar(255) null
);

-- ----------------------
-- table friends
-- ----------------------
create table friends
(
    id    int auto_increment
        primary key,
    user1 varchar(255) null,
    user2 varchar(255) null
);

-- ----------------------
-- table invites
-- ----------------------
create table invites
(
    id       int auto_increment
        primary key,
    inviter  varchar(255) null,
    receiver varchar(255) null,
    time     varchar(255) null
);

-- ----------------------
-- table movies
-- ----------------------
create table movies
(
    id           int auto_increment
        primary key,
    cover        varchar(255) null,
    introduction varchar(255) null,
    label        varchar(255) null,
    name         varchar(255) null,
    time         varchar(255) null
);

-- ----------------------
-- table screenings
-- ----------------------
create table screenings
(
    id        int auto_increment
        primary key,
    cinema_id int          null,
    movie_id  int          null,
    time      varchar(255) null
);

-- ----------------------
-- table invites
-- ----------------------
create table invites
(
    id       int auto_increment
        primary key,
    inviter  varchar(255) null,
    receiver varchar(255) null,
    time     varchar(255) null
);